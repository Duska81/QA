import java.time.chrono.MinguoDate;

public class DaniUNedelji {
    //da u nedelji koji ima najvise slova
    public static void main(String[] args) {
        String[] dani = {"ponedeljak", "utorak", "sreda", "cetvrtak", "petak", "subota", "nedelja"};
        int duzina = 0;//promenljiva
        String najduzi = dani[0];
        for (int i = 0; i < dani.length; i++) {
            if (dani[i].length() > duzina) {//ispituje se da li je trenutni clan duzi od duzina
                duzina = dani[i].length();//broj karaktera iz tog clana niza postaje duzina
                najduzi = dani[i];// ceo clan niza prepisujem u najduzi

            }
        }
        System.out.println(najduzi);

        String[] days = {"ponedeljak", "utooooooorak", "QA", "sreda"};
        String minDays = days[0];
        for (int i = 1; i < days.length; i++) {
            if (days[i].length() > minDays.length()) {
                minDays = days[i];
            }
        }
        System.out.println(minDays);


    }

}