

public class Zbir {
    public static void main(String []args) {
        //Napraviti funkciju koja za brojeve od 1-100 stampa prvi broj koji kada se sabere
        // sa samim sobom daje zbir veci od 150.
        //domaci 1
        int i;
        int z = 0;
        int y = 150;
        for (i = 1; i < y; i++) {
            z = i + i;
            if (z > y) {
                System.out.println(i);
                //ako se stavi da stampa z, stampa 152
                break;// stavljamo da bi nam stampalo samo prvi broj

            }

        }

    }
        }



