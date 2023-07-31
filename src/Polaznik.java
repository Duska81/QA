public class Polaznik extends People {

    //Kreirati klasu Polaznik sa atributima : ime, prezime, grad, godine.
    //Kreirati klasu Mentor sa atributima : ime, prezime, rola (QA, DEV...).
    //Kreirati klasu QaObuka koja ima atribute listu Polaznik, Mentor i ime kursa i pored toga sadrzi metodu koja vraca listu polzanika iz
    //zadatog grada.
    //U main metodi kreirati klasu QaObuka i pozivati kreiranu metodu



    private String grad;
    private int godine;


    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public int getGodine() {
        return godine;
    }

    public void setGodine(int godine) {
        this.godine = godine;
    }
}