import java.util.ArrayList;
import java.util.List;

public class MinElem {
    //Napraviti funkciju/metodu koja za listu celih brojeva vraca najmanji element.
    //U main metodi pozivati prethodno kreiranu metodu.
    public static int minimum(int[] arrayOfInt2){
        int minimum = arrayOfInt2[0]; //deklarisemo promenljivu koju vracamo iz metode
        for(int i=1; i<arrayOfInt2.length;i++){
            if(minimum>arrayOfInt2[i]){//poredimo max sa elementima niza, kojima pristupamao []
                minimum=arrayOfInt2[i];
                
            }

        }

        return minimum;

    }
}
