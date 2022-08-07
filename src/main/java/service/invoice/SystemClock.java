package service.invoice;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SystemClock implements Clock {
    @Override
    public LocalDate today() {
        return LocalDate.now();
    }
}
