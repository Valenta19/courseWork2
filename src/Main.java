import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDate localDate = LocalDate.now();
        LocalDateTime localTime = LocalDateTime.now();
        TaskService taskService = new TaskService();


        while (true) {
            System.out.println("Меню:");
            System.out.println("1 - создать задачу");
            System.out.println("2 - Удалить задачу");
            System.out.println("3 - получить задачи на сегодня");
            System.out.println("4 - остановить программу");

            int x = scanner.nextInt();
            if (x == 1) {
                System.out.println("Название задачи");
                scanner.nextLine();
                String title = scanner.nextLine();
                System.out.println(title);

                System.out.println("Тип задачи: 1 - личная, 2 - рабочая");
                int a = scanner.nextInt();
                Type type = Type.DEFAULT;
                if (a == 1) {
                    type = Type.PERSONAL;
                    System.out.println(type);
                } else if (a == 2) {
                    type = Type.WORK;
                    System.out.println(type);
                }
                scanner.nextLine();
                System.out.println("Описание");
                String description = scanner.nextLine();
                System.out.println(description);

                System.out.println("переодичность задачи");
                System.out.println("1 - разовая ");
                System.out.println("2 - ежедневная ");
                System.out.println("3 - еженедельная ");
                System.out.println("4 - ежемесячная ");
                System.out.println("5 - ежегодная ");

                int r = scanner.nextInt();
                if (r == 1) {
                    OneTimeTask oneTimeTask = new OneTimeTask(title, type, localDate.atTime(localTime.getHour(), localTime.getMinute()), description);
                    taskService.add(oneTimeTask);
                } else if (r == 2) {
                    DailyTask task = new DailyTask(title, type, localDate.atTime(localTime.getHour(), localTime.getMinute()), description);
                    taskService.add(task);
                } else if (r == 3) {
                    WeeklyTask weeklyTask = new WeeklyTask(title, type, localDate.atTime(localTime.getHour(), localTime.getMinute()), description);
                    taskService.add(weeklyTask);
                } else if (r == 4) {
                    MonthlyTask monthlyTask = new MonthlyTask(title, type, localDate.atTime(localTime.getHour(), localTime.getMinute()), description);
                    taskService.add(monthlyTask);
                } else if (r == 5) {
                    YearlyTask yearlyTask = new YearlyTask(title, type, localDate.atTime(localTime.getHour(), localTime.getMinute()), description);
                    taskService.add(yearlyTask);
                }
            } else if (x == 2) {
                System.out.println("Введите id задачи, которую нужно удалить.");
                int f = scanner.nextInt();
                taskService.remove(f);
                System.out.println("Задача " + f + " удалена.");

            } else if (x == 3) {
                taskService.getAllByDate(localDate);
            } else if (x == 4) {
                break;
            }
        }

    }
}