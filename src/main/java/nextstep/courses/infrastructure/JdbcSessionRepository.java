package nextstep.courses.infrastructure;

import nextstep.courses.domain.*;
import org.springframework.boot.json.JsonParser;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository("sessionRepository")
public class JdbcSessionRepository implements SessionRepository {
    private JdbcOperations jdbcTemplate;

    public JdbcSessionRepository(JdbcOperations jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Session> findByCourseId(Long courseId) {
        return null;
    }

    @Override
    public Session findById(Long id) {
        String sql = "select id, start_at, end_at, image_url, is_free, session_status," +
                "max_students, students, creator_id, created_at, updated_at from course where id = ?";
        RowMapper<Session> rowMapper = (rs, rowNum) -> new Course(
                rs.getLong(1),
                rs.getString(2),
                rs.getLong(3),
                toLocalDateTime(rs.getTimestamp(4)),
                toLocalDateTime(rs.getTimestamp(5)));
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    @Override
    public int save(Session session) {
        String sql = "insert into session (start_at, end_at, image_url, is_free, session_status, " +
                "max_students, students, creator_id, created_at, updated_at) " +
                "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        //todo. json 형태로 저장하고 꺼내고 싶은디/.//
        return jdbcTemplate.update(sql,
                session.getPeriod().getStartAt(), session.getPeriod().getEndAt(), session.getImageUrl(),
                session.getIsFree(), session.getSessionRegistrationStatus().getSessionStatus(),
                session.getSessionRegistrationStatus().getMaxStudents(), session.getSessionRegistrationStatus().getStudents(),
                session.getCreatorId(), session.getCreatedAt(), session.getUpdatedAt());
    }

    private LocalDateTime toLocalDateTime(Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        }
        return timestamp.toLocalDateTime();
    }

    private Period toPeriod(Timestamp startAt, Timestamp endAt) {
        if (startAt == null || endAt == null) {
            return null;
        }

        return new Period(startAt.toLocalDateTime(), endAt.toLocalDateTime());
    }

    private SessionRegistrationStatus toSessionRegistrationStatus(String sessionStatus, int maxStudents, String students) {
        if (sessionStatus == null || students == null) {
            return null;
        }
        JsonMapper
        return new SessionRegistrationStatus(SessionStatus.getByName(sessionStatus), maxStudents, );
    }
}
