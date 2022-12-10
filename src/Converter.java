public class Converter {
    double rateDistance = 0.00075;
    double rateCalories = 0.050;

    public double convertDistance(int steps){
        return steps * rateDistance;
    }
    public double convertCalories(int steps){
        return steps * rateCalories;
    }


}
