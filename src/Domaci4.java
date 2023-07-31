import java.util.ArrayList;
import java.util.List;

public class Domaci4 {
    //Napraviti funkciju/metodu koja za niz stringova vrace stringove
    // cija se duzina poklapa sa zadatim brojem.
    //U main metodi pozivati prethodno kreiranu metodu.

    public String []returnString(String[]arrays, String letter){
        String []nizStringova=new String[6];//nizovi imaju vec odredjenu velicinu
        //i mi moramo da definisemo [10] velicinu
        for(int i=0; i< arrays.length;i++){
            if(arrays[i].substring(0,1).equals(letter)){
                nizStringova[i]=arrays[i];
                i++;
            }
        }
        return nizStringova;
    }

    public List<String>returnString(String[]arrays,int ceoBroj){
        List<String>toReturn=new ArrayList<>();
        for(int i=0; i< arrays.length;i++){
            if(arrays[i].length()==ceoBroj){
                toReturn.add(arrays[i]);

            }
        }

        return toReturn;
    }
}
