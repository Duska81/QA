package saobracaj;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        //Vozilo vozilo1 = new Automobil();


        Automobil automobil1 = new Automobil("putnicko", "Ford", 2014);
        Automobil automobil2 = new Automobil("putnicko", "Fiat", 2020);
        Automobil automobil3 = new Automobil("putnicko", "Opel", 2022);
        Kamion kamion1 = new Kamion("teretno", "Opel", 2010);
        Motor motor1 = new Motor("putnicko", "Citroen", 2015);

        List<Vozilo> vracenaListaVozila = new ArrayList<>();
        vracenaListaVozila.add(automobil1);
        vracenaListaVozila.add(automobil2);
        vracenaListaVozila.add(automobil3);
        vracenaListaVozila.add(kamion1);
        vracenaListaVozila.add(motor1);

        Raskrsnica raskrsnica = new Raskrsnica();


        //System.out.println(raskrsnica.listaVozila(vracenaListaVozila,"Opel"));
        //System.out.println(raskrsnica.lista(vracenaListaVozila,"2010"));


        List<Vozilo> vozilaPoMarki = raskrsnica.listaVozila(vracenaListaVozila, "Ford");

        for (int i = 0; i < vozilaPoMarki.size(); i++) {
            Vozilo vozilo = vozilaPoMarki.get(i);
            System.out.println("Tip: " + vozilo.getTip());
            System.out.println("Marka: " + vozilo.getMarka());
            System.out.println("Godiste: " + vozilo.getGodiste());
            System.out.println();
        }
        List<Vozilo> godisteVozila = raskrsnica.lista(vracenaListaVozila, 2014);
        System.out.println("Vozila koja su starija od zadatog godista:");
        for (int i = 0; i < godisteVozila.size(); i++) {
            Vozilo vozilo = godisteVozila.get(i);
            System.out.println("Tip: " + vozilo.getTip());
            System.out.println("Marka: " + vozilo.getMarka());
            System.out.println("Godiste: " + vozilo.getGodiste());
            System.out.println();



        }
    }
}

