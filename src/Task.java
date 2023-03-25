
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task {
    private static int idGenerator = 1;
    private String title;
    private Type type;
    private int id;
    private final LocalDateTime dataTime;
    private String description;

    public Task(String title, Type type, LocalDateTime dataTime, String description) {
        setTitle(title);
        this.type = type;
        this.dataTime = dataTime;
        setDescription(description);
        this.id = idGenerator++;
    }

    public abstract boolean appearsIn(LocalDate dateForCheck);

    public String getTitle() {
        return title;
    }

    public Type getType() {
        return type;
    }

    public LocalDateTime getDataTime() {
        return dataTime;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        try {
            checkSetTitle(title);
        } catch (IncorrectArgumentException e) {
            this.title = "Название задачи заданное некоректно. Измените название через меню!";
        }
    }

    public void checkSetTitle(String title) throws IncorrectArgumentException {
        if (title == null || title.isEmpty() || title.isBlank()) {
            throw new IncorrectArgumentException(title);
        }
        this.title = title;
    }

    public void setDescription(String description) {
        try {
            checkSetDescription(description);
        } catch (IncorrectArgumentException e) {
            this.description = "Описание задачи небыло заданно. Измените описание через меню!";
        }
    }
    public void checkSetDescription(String description) throws IncorrectArgumentException {
        if (description == null || description.isEmpty() || description.isBlank()) {
            throw new IncorrectArgumentException(description);
        }
        this.description = description;
    }

    @Override
    public String toString() {
        return " Задача: " + title + ". Описание задачи: " + description +
                ". Тип задачи: " + type +
                ". Дата создания: " + dataTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(title, task.title) && type == task.type && Objects.equals(dataTime, task.dataTime) && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, dataTime, description);
    }
}