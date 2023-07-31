import java.util.ArrayList;
import java.util.List;

public class Duplikati {


    //Napraviti funkciju/metodu koja za listu stringova uklanja duplikate i
    // vraca novu listu stringova bez duplikata.
    //U main metodi pozivati prethodno kreiranu metodu.

    //domaci9
    public static List<String> removeDuplicates(List<String> lista) {
        List<String> listaBezDuplikata = new ArrayList<>();
        listaBezDuplikata.add(lista.get(0)); //posto nam je prazna lista, dodajemo prvi element

        for (int i = 0; i < lista.size(); i++) {


            if(listaBezDuplikata.contains(lista.get(i))) {     //da li nova lista gde smo dodali novi element
                // proveravamo da li lista sadrzi drugi element niza
                // posto ne sadrzi dodajemo drugi elemnt
                //da li contains vrati true ili false od toga zavisi da li dodajemo elemente


            }else{
                listaBezDuplikata.add(lista.get(i));

            }

        }
        return listaBezDuplikata;
    }

}



