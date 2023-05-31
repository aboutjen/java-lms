package nextstep.courses.domain;

import java.util.List;

public interface SessionRepository {
    List<Session> findByCourseId(Long courseId);

    Session findById(Long id);

    int save(Session session);
}
