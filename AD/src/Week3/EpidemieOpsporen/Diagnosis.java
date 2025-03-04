package Week3.EpidemieOpsporen;

public class Diagnosis {

    private final Disease disease;
    private final int day;

    public Diagnosis(Disease disease, int day) {
        this.disease = disease;
        this.day = day;
    }

    public Disease getDisease() {
        return disease;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return "{" + disease + ", " + day + "}";
    }
}
