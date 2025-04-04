package RecursieDivConc.Toernooien;

public class MijnToernooiPlanner implements ToernooiPlanner {
    @Override
    public int[][] plan(int k) {
        int n = (int) Math.pow(2, k);
        int[][] schedule = new int[n - 1][n];

        // Basisgeval: k=1 (2 gladiatoren)
        if (k == 1) {
            schedule[0][0] = 1;
            schedule[0][1] = 0;
            return schedule;
        }

        // Recursieve stap: verdeel het probleem in kleinere subproblemen
        int halfSize = n / 2;
        int[][] smallerSchedule = plan(k - 1);

        // Vul de bovenste helft van het schema
        for (int day = 0; day < halfSize - 1; day++) {
            for (int gladiator = 0; gladiator < halfSize; gladiator++) {
                // Linker bovenkant
                schedule[day][gladiator] = smallerSchedule[day][gladiator];
                // Rechter bovenkant
                schedule[day][gladiator + halfSize] = smallerSchedule[day][gladiator] + halfSize;
            }
        }

        // Vul de onderste helft van het schema
        for (int day = 0; day < halfSize - 1; day++) {
            for (int gladiator = 0; gladiator < halfSize; gladiator++) {
                // Linker onderkant
                schedule[day + halfSize][gladiator] = smallerSchedule[day][gladiator] + halfSize;
                // Rechter onderkant
                schedule[day + halfSize][gladiator + halfSize] = smallerSchedule[day][gladiator];
            }
        }

        // Voeg de laatste dagen toe waar de eerste helft tegen de tweede helft speelt
        for (int gladiator = 0; gladiator < halfSize; gladiator++) {
            int opponent = gladiator + halfSize;
            schedule[halfSize - 1][gladiator] = opponent;
            schedule[halfSize - 1][opponent] = gladiator;
        }

        return schedule;
    }
}
