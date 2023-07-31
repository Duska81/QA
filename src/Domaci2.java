import java.util.ArrayList;
import java.util.List;

public class Domaci2 {
    //Napraviti funkciju koja za niz stringova vraca one cije ime pocinje sa zadatim slovom
    // (slovo i niz stringova proslediti kao argument metode).
    //   U main metodi pozivati prethodno kreiranu metodu.
    public String []returnString2(String[]arrays, String slovo){
        String []nizStringova=new String[5];//nizovi imaju vec odredjenu velicinu
        //i mi moramo da definisemo [10] velicinu
        for(int i=0; i< arrays.length;i++){
            if(arrays[i].substring(0,1).equals(slovo)){
                nizStringova[i]=arrays[i];
                i++;
            }
        }
        return nizStringova;
    }

    /*public String<String> returnString(String[]arrays, int slovo){
        String toReturn;
        toReturn = new ArrayList<>();
        for(int i=0; i< arrays.length;i++){
            if(arrays[i].length()==slovo){
                arrays[i].add(toReturn);

            }
        }

        return toReturn;
    }*/
}


