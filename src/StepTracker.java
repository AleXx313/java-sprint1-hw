public class StepTracker {

    private static int stepTarget = 10000;
    MonthData[] monthToData;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    //Устанавливаем цель шагов.
    public void setStepTarget(int stepTarget) {
        if (stepTarget > 0) {
            StepTracker.stepTarget = stepTarget;
            System.out.println("Целевое количество шагов установлено в размере: " + StepTracker.stepTarget + " шагов.");
        } else {
            System.out.println("Целевое количество шагов не может равняться или быть меньше нуля!");
            System.out.println("Попробуйте еще раз и введите корректное число!");
        }
    }

    class MonthData {
        int[] daySteps;
        Converter converter = new Converter();

        //Создаем массив дней, исходя из условия - 30 дней в каждом месяце.
        public MonthData() {
            daySteps = new int[30];
        }

        //Устанавливаем количество шагов за день.
        public void saveSteps(int day, int steps) {
            daySteps[day - 1] = steps;
        }

        //Получаем ежедневную сводку по количеству шагов.
        public void getEachDaySummary() {
            String result = "";
            for (int i = 0; i < daySteps.length; i++) {
                result += i + 1 + " день: " + daySteps[i] + ", ";
            }
            System.out.println(result.substring(0, result.length() - 2) + ".");
        }

        //Получем колчичество шагов за месяц.
        public int getOverallSteps() {
            int overallSteps = 0;
            for (int i = 0; i < daySteps.length; i++) {
                overallSteps += daySteps[i];
            }
            return overallSteps;
        }

        //Получаем максимальное количество шагов за месяц.
        public int getMaxSteps() {
            int maxSteps = 0;
            for (int i = 0; i < daySteps.length; i++) {
                if (daySteps[i] > maxSteps) {
                    maxSteps = daySteps[i];
                }
            }
            return maxSteps;
        }

        //Получаем среднее количество шагов.
        public int getAverageSteps() {
            return getOverallSteps() / daySteps.length;
        }

        //Получаем пройденную дистацнию.
        public double getDistance() {

            return converter.convertDistance(getOverallSteps());
        }

        //Получаем сожженные калории.
        public double getCalories() {

            return converter.convertCalories(getOverallSteps());
        }

        //Получаем лучшую серию.
        public int getStreak() {
            int maxStreak = 0;
            int currentStreak = 0;
            for (int i = 0; i < daySteps.length; i++) {
                if (daySteps[i] >= stepTarget) {
                    currentStreak++;
                } else {
                    if (currentStreak > maxStreak) {
                        maxStreak = currentStreak;
                        currentStreak = 0;
                    }
                    currentStreak = 0;
                }
            }
            return maxStreak >= currentStreak ? maxStreak : currentStreak;
        }
    }
}
