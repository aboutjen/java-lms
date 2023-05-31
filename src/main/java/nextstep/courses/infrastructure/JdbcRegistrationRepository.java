package nextstep.courses.infrastructure;

import nextstep.courses.domain.Registration;
import nextstep.courses.domain.RegistrationRepository;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Repository("registrationRepository")
public class JdbcRegistrationRepository implements RegistrationRepository {

    private JdbcOperations jdbcTemplate;

    public JdbcRegistrationRepository(JdbcOperations jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int save(Registration registration) {
        String sql = "insert into registration (user_id, session_id, created_at) values(?, ?, ?)";
        return jdbcTemplate.update(sql, registration.getUserId(), registration.getSessionId(), LocalDateTime.now());
    }

    @Override
    public Registration findById(Long id) {
        String sql = "select id, user_id, session_id, created_at from registration where id = ?";
        RowMapper<Registration> rowMapper = (rs, rowNum) -> new Registration(
                rs.getLong(1),
                rs.getLong(2),
                rs.getLong(3),
                toLocalDateTime(rs.getTimestamp(4)));
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    private LocalDateTime toLocalDateTime(Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        }
        return timestamp.toLocalDateTime();
    }
}
