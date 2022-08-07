package service.invoice;

import java.time.LocalDate;

public interface Clock {
    LocalDate today();
}
