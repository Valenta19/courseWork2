
import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task {
    public YearlyTask(String title
            , Type type
            , LocalDateTime dataTime
            , String description) {
        super(title, type, dataTime, description);
    }

    @Override
    public boolean appearsIn(LocalDate checkDate) {
        return getDataTime().getMonth() == checkDate.getMonth()
                && getDataTime().getDayOfYear() == checkDate.getDayOfYear();
    }
}
