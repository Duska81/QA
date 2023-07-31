import java.util.ArrayList;
import java.util.List;
//Napraviti funkciju koja za niz stringova vraca one cije ime pocinje sa zadatim slovom (slovo i niz stringova proslediti kao argument metode).
       // U main metodi pozivati prethodno kreiranu metodu.

//domaci2
public class StringDuzina {


        public String[] returnString (String[]array2, String letter1){// drugi argument je pocetno slovo
            String[] nizStringova = new String[10];
            //int i = 0;
            for (int x = 0; x < array2.length; x++) {
                if (array2[x].substring(0, 1).equals(letter1)) {
                    nizStringova[x] = array2[x];
                    x++;
                }
            }
            return nizStringova;

        }
        public List<String>returnString(String[]array, int ceoBroj){
            List<String>toReturn= new ArrayList<>();//kreira se prazna lista stringova koja se vraca

            return toReturn;
        }
    }



