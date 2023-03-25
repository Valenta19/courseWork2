
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TaskService {
    private final HashMap<Integer, Task> taskMap = new HashMap<>();
    private final List<Task> removedTasks = new LinkedList<>();


    public void add(Task task) {
        taskMap.put(task.getId(), task);
    }

    public void remove(int id) {
        try {
            checkRemove(id);
        } catch (TaskNotFoundException e) {
            System.out.println("Задачи по номеру " + id + " не найдена");
        }

    }

    public void checkRemove(int id) throws TaskNotFoundException {
        if (!taskMap.containsKey(id)) {
            throw new TaskNotFoundException("Задачи под номером " + id + " не найдена");
        }
        removedTasks.add(getTaskMap().get(id));
        taskMap.remove(id);
    }

    public void getAllByDate(LocalDate localDate) {
        Map<Integer, Task> list = taskMap.entrySet().stream()
                .filter(x -> x.getValue().appearsIn(localDate))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        for (Map.Entry<Integer, Task> list1 :
                list.entrySet()) {
            System.out.println("Задача N: " + list1.getKey() + ", " + list1.getValue());
        }

    }

    public HashMap<Integer, Task> getTaskMap() {
        return taskMap;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskService that = (TaskService) o;
        return Objects.equals(taskMap, that.taskMap) && Objects.equals(removedTasks, that.removedTasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskMap, removedTasks);
    }
}