
import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task {
    public OneTimeTask(String title, Type type, LocalDateTime dataTime, String description) {
        super(title, type, dataTime, description);
    }

    @Override
    public boolean appearsIn(LocalDate checkDate) {
        return getDataTime().getYear() == checkDate.getYear()
                && getDataTime().getMonth() == checkDate.getMonth()
                && getDataTime().getDayOfYear() == checkDate.getDayOfYear();
    }
}
