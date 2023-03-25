import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task {


    public WeeklyTask(String title, Type type, LocalDateTime dataTime, String description) {
        super(title, type, dataTime, description);
    }

    @Override
    public boolean appearsIn(LocalDate checkDate) {
        return (getDataTime().getDayOfWeek() == checkDate.getDayOfWeek());
    }

}