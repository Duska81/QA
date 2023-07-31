import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NElem {
    //Napraviti funkciju/metodu koja za listu celih brojeva vraca prvih n elemenata, n zadati kao drugi argument funkcije.
    //U main metodi pozivati prethodno kreiranu metodu.
    public static void main(String []args){

        List<List> lista=new ArrayList<>();
      //  lista.add(1);
     //   lista.add(2);
        //    lista.add(3);
        int i = 1;
        List<List> rezultat = elementi(lista, i);
        for (List broj : rezultat) {
            System.out.println(broj);
        }
    }





    private static List<List> elementi(List<List> lista, int i) {
        return lista;
    }
}
