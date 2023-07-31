import saobracaj.Vozilo;

import java.util.ArrayList;
import java.util.List;

public class MainOOP {
    public static void main(String[] args) {
        Encapsulation encapsulation = new Encapsulation();
        encapsulation.setName("Dusanka");
        encapsulation.setLastName("Mirkovic");
        encapsulation.address = ("Novi Sad");
        encapsulation.getName();
        encapsulation.getLastName();
        encapsulation.position = "DEV";


        NasledjivanjeChild nasledjivanjeChild = new NasledjivanjeChild("Dada", "Acimovic", "Sixsentix");
        //nasledjivanjeChild.setName("dadada"); ili ovako ili u klasi koristimo super
        //nasledjivanjeChild.setLastName("nanan");
        //nasledjivanjeChild.setCompany("IBM");
        nasledjivanjeChild.printDetails();
        nasledjivanjeChild.printCompany();
        System.out.println();


        NasledjivanjeChild2 nasledjivanjeChild2 = new NasledjivanjeChild2();
        nasledjivanjeChild2.setName("Duska");
        nasledjivanjeChild2.setLastName("Mirkovic");
        nasledjivanjeChild2.printDetails();
        System.out.println();

        ApstrakcijaPig pig = new ApstrakcijaPig();//metode se kreiraju se preko klasa koje su nasledjivale
        pig.animalSound();

        System.out.println();
        //domaci

        Polaznik polaznik = new Polaznik();

        polaznik.setIme("Dusanka");
        polaznik.setPrezime("Mirkovic");
        polaznik.setGodine(40);
        polaznik.setGrad("Novi Sad");

        Polaznik polaznik1 = new Polaznik();
        polaznik1.setIme("Ana");
        polaznik1.setPrezime("Markovic");
        polaznik1.setGodine(43);
        polaznik1.setGrad("Novi Sad");

        Polaznik polaznik2 = new Polaznik();
        polaznik2.setIme("Dragana");
        polaznik2.setPrezime("Acimovic");
        polaznik2.setGodine(22);
        polaznik2.setGrad("Beograd");


        Polaznik polaznik3 = new Polaznik();
        polaznik3.setIme("Gaga");
        polaznik3.setPrezime("Mirkovic");
        polaznik3.setGodine(38);
        polaznik3.setGrad("Loznica");

        List<Polaznik> vracenaListaPolaznika = new ArrayList<>();
        vracenaListaPolaznika.add(polaznik);
        vracenaListaPolaznika.add(polaznik1);
        vracenaListaPolaznika.add(polaznik2);
        vracenaListaPolaznika.add(polaznik3);


        QAObuka qaObuka = new QAObuka();
        List<Polaznik> polazniciIzGrada = qaObuka.listaPolaznika(vracenaListaPolaznika, "Loznica");
        for (int i = 0; i < polazniciIzGrada.size(); i++) {
            Polaznik polaznici = polazniciIzGrada.get(i);
            System.out.println(polaznici.getIme());
            System.out.println(polaznici.getPrezime());
            System.out.println(polaznici.getGodine());
            System.out.println();
        }




    }
}






