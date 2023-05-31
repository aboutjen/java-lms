package nextstep.courses.domain;

public interface RegistrationRepository {
    int save(Registration registration);

    Registration findById(Long id);
}
