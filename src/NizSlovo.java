import java.util.ArrayList;
import java.util.List;
//Domaci 2-1
public class NizSlovo {
    //Napraviti funkciju/metodu koja za niz stringova vrace stringove cija se duzina poklapa sa zadatim brojem.
    //U main metodi pozivati prethodno kreiranu metodu.
    //domaci 1-1

    public List<String> returnString(String[] array, int duzina1) {
        List<String> toReturn = new ArrayList<>();// kreira se prazna lista Stringova
        for (String string : array) {
            //for(int i=0;i<array.length;i++)
            if (string.length() == duzina1) {
                toReturn.add(string);
            }
        }
        return toReturn;

        //redovna for petlja
        /*public List<String> returnString(String[] arrays, int ceoBroj){
        List<String> toReturn= new ArrayList<>();
        for(int i=0; i< arrays.length; i++){
            if(arrays[i].length()==ceoBroj){
                toReturn.add(arrays[i]);

            }
        }

        return toReturn;
        }
         */
    }
}




