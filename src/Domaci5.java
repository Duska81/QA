public class Domaci5 {


    public static int[] prikaziNiz5;

    //Napraviti funkciju/metodu koja za listu celih brojeva
    // vraca najmanji element.
    //U main metodi pozivati prethodno kreiranu metodu.
    //public static pronadjiMin(int[]niz){
    public static int pronadjiMinimum(int[] niz) {
        int minimum = niz[0];
        for (int i = 1; i < niz.length; i++) {
            if (niz[i] < minimum) {
                minimum = niz[i];
            }
        }
        return minimum;
    }
}