
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task {

    public DailyTask(String title, Type type, LocalDateTime dataTime, String description) {
        super(title, type, dataTime, description);
    }

    @Override
    public boolean appearsIn(LocalDate checkDate) {
        return true;
    }


}
