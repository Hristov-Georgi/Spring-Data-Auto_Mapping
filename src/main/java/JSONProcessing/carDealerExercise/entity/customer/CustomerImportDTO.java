package JSONProcessing.carDealerExercise.entity.customer;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CustomerImportDTO implements Serializable {

    private String name;

    private LocalDateTime birthDate;

    private boolean isYoungDriver;

    public String getName() {
        return name;
    }

    public LocalDateTime getDateOfBirth() {
        return birthDate;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }
}
