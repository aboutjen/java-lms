package nextstep.courses.domain;

import java.time.LocalDateTime;

public class Session {
    private Long id;
    private Period period;
    private String imageUrl;
    private boolean isFree;
    private SessionRegistrationStatus sessionRegistrationStatus;
    private Long creatorId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Session(Long id, Period period, String imageUrl,
                   boolean isFree, SessionRegistrationStatus sessionRegistrationStatus,
                   Long creatorId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.period = period;
        this.imageUrl = imageUrl;
        this.isFree = isFree;
        this.sessionRegistrationStatus = sessionRegistrationStatus;
        this.creatorId = creatorId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public Period getPeriod() {
        return period;
    }

    public String getImageUrl(){
        return imageUrl;
    }

    public boolean getIsFree(){
        return isFree;
    }

    public SessionRegistrationStatus getSessionRegistrationStatus(){
        return sessionRegistrationStatus;
    }

    public Long getCreatorId(){
        return creatorId;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public LocalDateTime getUpdatedAt(){
        return updatedAt;
    }

    public boolean canRegisteringStatus() {
        return sessionRegistrationStatus.canRegisteringStatus();
    }

    public boolean overMaxStudents(int numberOfStudents) {
        return sessionRegistrationStatus.overMaxStudents(numberOfStudents);
    }
}
