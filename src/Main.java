import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Здравствуйте!");
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            if (userInput == 1) {
                int monthNumber = getMonthNumber();
                int dayNumber = getDayNumber();
                System.out.println("Введите количество пройденных за указанный день шагов");
                int steps = scanner.nextInt();
                stepTracker.monthToData[monthNumber - 1].saveSteps(dayNumber, steps);
            } else if (userInput == 2) {
                System.out.println("За какой месяц вы хотите получить статистику?");
                int monthNumber = getMonthNumber();
                printStatistic();
                int userStatisticInput = scanner.nextInt();
                while (userStatisticInput != 0) {
                    if (userStatisticInput == 1) {
                        stepTracker.monthToData[monthNumber - 1].getEachDaySummary();
                    } else if (userStatisticInput == 2) {
                        System.out.print("Общее количество шагов за месяц " + monthNumber + ": ");
                        System.out.println(stepTracker.monthToData[monthNumber - 1].getOverallSteps() + ".");
                    } else if (userStatisticInput == 3) {
                        System.out.print("Максимальное пройденное количество шагов в месяце " + monthNumber + ": ");
                        System.out.println(stepTracker.monthToData[monthNumber - 1].getMaxSteps() + ".");
                    } else if (userStatisticInput == 4) {
                        System.out.print("Среднее количество шагов в месяце " + monthNumber + ": ");
                        System.out.println(stepTracker.monthToData[monthNumber - 1].getAverageSteps() + ".");
                    } else if (userStatisticInput == 5) {
                        System.out.print("Пройденная дистанция (в км) за месяц " + monthNumber + ": ");
                        System.out.println(stepTracker.monthToData[monthNumber - 1].getDistance() + " км.");
                    } else if (userStatisticInput == 6) {
                        System.out.print("Количество сожжённых килокалорий за месяц " + monthNumber + ": ");
                        System.out.println(stepTracker.monthToData[monthNumber - 1].getCalories() + " кк.");
                    } else if (userStatisticInput == 7) {
                        System.out.print("Лучшая серия за месяц " + monthNumber + ": ");
                        System.out.println(stepTracker.monthToData[monthNumber - 1].getStreak() + ".");
                    } else {
                        System.out.println("Извините, такой команды пока нет.");
                    }
                    printStatistic();
                    userStatisticInput = scanner.nextInt();
                }
            } else if (userInput == 3) {
                System.out.println("Введите новую цель по количеству шагов.");
                int stepTarget = scanner.nextInt();
                stepTracker.setStepTarget(stepTarget);
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
            printMenu();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена. До свидания!");
    }

    private static void printMenu() {

        System.out.println("Что вы хотите сделать? Введите номер команды:");
        System.out.println("1. Ввести количество шагов за день.");
        System.out.println("2. Напечатать статистику за месяц.");
        System.out.println("3. Изменить цель по количеству шагов.");
        System.out.println("0. Выйти из программы.");
    }

    private static void printStatistic() {

        System.out.println("Какую статистику вы хотите увидеть: ");
        System.out.println("1. Количество пройденных шагов по дням.");
        System.out.println("2. Общее количество шагов за месяц.");
        System.out.println("3. Максимальное пройденное количество шагов в месяце.");
        System.out.println("4. Среднее количество шагов.");
        System.out.println("5. Пройденная дистанция (в км).");
        System.out.println("6. Количество сожжённых килокалорий.");
        System.out.println("7. Лучшая серия.");
        System.out.println("0. Вернуться в главное меню.");
    }

    private static int getMonthNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер месяца от 1 до 12:");
        int monthNumber = 0;
        int userMonthInput = scanner.nextInt();
        if (userMonthInput > 0 && userMonthInput <= 12) {
            monthNumber = userMonthInput;
        } else {
            System.out.println("Вы ввели некорректное значение!");
            System.out.println("Попробуйте еще раз.");
            getMonthNumber();
        }
        return monthNumber;
    }

    private static int getDayNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер дня месяца от 1 до 30:");
        int dayNumber = 0;
        int userDayInput = scanner.nextInt();
        if (userDayInput > 0 && userDayInput <= 30) {
            dayNumber = userDayInput;
        } else {
            System.out.println("Вы ввели некорректное значение!");
            System.out.println("Попробуйте еще раз.");
            getDayNumber();
        }
        return dayNumber;
    }
}
