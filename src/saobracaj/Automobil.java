package saobracaj;

public class Automobil extends Vozilo {


    public Automobil(String tip,String marka, int godiste) {//super kljucna rec
        super(tip,marka,godiste);

        //na taj nacin se poziva konstruktor iz parent klase

        //drugi nacin za super
        //public Automobil(String marka,int godiste){
       // super("putnicko", marka godiste);
        //na drugi nacin mi unapred odredjujemo da je automobil putnicko i ne moramo posle u main to definisati


    }

}