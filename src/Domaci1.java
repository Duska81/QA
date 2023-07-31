public class Domaci1 {

    //Napraviti funkciju koja za brojeve od 1-100 stampa prvi broj koji
    // kada se sabere sa samim sobom daje zbir veci od 150.

    public static void main(String[] args) {
        int i;
        int z;
        for (i = 1; i < 150; i++) {
            z = i + i;
            if (z > 150) {


                System.out.println(z);
                break;// stavljamo da bi nam stampalo samo prvi broj
            }

        }
    }
}

