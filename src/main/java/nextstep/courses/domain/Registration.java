package nextstep.courses.domain;

import java.time.LocalDateTime;

public class Registration {
    private Long id;
    private Long userId;
    private Long sessionId;
    private LocalDateTime createdAt;

    public Registration() {

    }

    public Registration(Long id, Long userId, Long sessionId, LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.sessionId = sessionId;
        this.createdAt = createdAt;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getSessionId() {
        return sessionId;
    }
}
