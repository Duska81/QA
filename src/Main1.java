import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {

        //Domaci4
        String[] test = {"Ub", "Beograd", "Subotica", "Despotovac", "Pancevo", "Kikinda"};


        Domaci4 stringovi = new Domaci4();

        List<String> result4 = stringovi.returnString(test, 7);


        for (String str1 : result4) {
            System.out.println(str1);
        }

        //Domaci2


        String[] test1 = {"Mladenovac", "Lazarevac", "Kovacica", "Kursumlija", "Kraljevo"};
        Domaci2 stringovi2 = new Domaci2();


        String[] result = new String[5];
        result = stringovi2.returnString2(test1, "K");
        for (String str : result) {
            if (str != null) {
                System.out.print("Navedeni gradovi pocinju na zadato slovo: ");


                System.out.println(str);
            }
        }

        //domaci3
        int[] niz = {1, 300, 122, 2, 4, 7, 8, 12, 16, 77};
        System.out.print("sortirani niz");

        Arrays.sort(niz);
        Domaci3.prikaziNiz(niz);
        //domaci5


        int[] min = {2, 3, 5, 88, 76, 5, 12, 34, 57};



        int minimum = Domaci5.pronadjiMinimum(min);
        System.out.println("Minimum niza je:");
        System.out.println(minimum);


        //sabiranje domaci 7
        int i;
        int y;

        Sabiranje sabiranje = new Sabiranje();
        int rezultat = sabiranje.saberi(5, 3);
        System.out.println("Rezultat sabiranja: ");
        System.out.println(rezultat);




        //parniBoolean domaci8

        ParniBoolean parniBoolean = new ParniBoolean();

        i = 2;

        boolean ispitivanje = ParniBoolean.parniBoolean(i);
        System.out.println(ispitivanje);

        //Duplikati domaci 9
        List<String> lista = new ArrayList<>();
        lista.add("Novi Sad");
        lista.add("Novi Sad");
        lista.add("Nis");
        lista.add("Novi Sad");
        lista.add("Negotin");

        List<String> listaBezDuplikata = Duplikati.removeDuplicates(lista);
        System.out.println("Lista bez duplikata: " );
    System.out.println(listaBezDuplikata);


    //neparan broj
        NeparanBroj neparan =new NeparanBroj();
        System.out.println(NeparanBroj.neparan(3));


    }


    }





