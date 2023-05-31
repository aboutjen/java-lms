package nextstep.courses.domain;

import java.time.LocalDateTime;

public class Period {
    private LocalDateTime startAt;
    private LocalDateTime endAt;

    public Period(LocalDateTime startAt, LocalDateTime endAt) {
        validate(startAt, endAt);
        this.startAt = startAt;
        this.endAt = endAt;
    }

    private void validate(LocalDateTime startAt, LocalDateTime endAt) {
        if (endAt.isBefore(startAt)) {
            throw new IllegalArgumentException("종료일은 시작일을 앞설 수 없습니다.");
        }
    }

    public LocalDateTime getStartAt(){
        return startAt;
    }

    public LocalDateTime getEndAt(){
        return endAt;
    }
}
