import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //StringDuzina
        String[] test = {"Ub", "Beograd", "Subotica", "Despotovac", "Pancevo", "Kikinda"};


        StringDuzina stringDuzina = new StringDuzina();
        String[] result2 = new String[6];

        int ceoBroj = 7;

        result2 = stringDuzina.returnString(test, ceoBroj).toArray(new String[0]);

        for (String s : result2) {
            System.out.println(result2);


            //MaxNum

            MaxNum maxNum = new MaxNum(); //defaultni konstruktor, kljucna rec new
            int[] arrayOfInt = {12, 34, 5, 78, 9, 140, 4, 9, 8};


            int max = maxNum.maximum(arrayOfInt);
            System.out.println(max);

            int[] arrayOfInt1 = {1, 3, 5, 7, 9, 1, 40, 99, 81};
            int max1 = maxNum.maximum(arrayOfInt1);
            System.out.println(max1);


            //minElem
            int[] arrayOfInt2 = {91, 81, 44, 1, 3, 578};
            MinElem minElem = new MinElem();
            int minimum = minElem.minimum(arrayOfInt2);

            System.out.println(minimum);

            //NizSlovo

            String[] result = {"Ub", "Beograd", "Subotica", "Despotovac", "Pancevo", "Kikinda"};

            //int duzina1 = 7;

            NizSlovo nizSlovo = new NizSlovo();
            String[] arrays = new String[0];
            List<String> rezultat1 = nizSlovo.returnString(arrays, 7);

            for (String string : rezultat1) {
                System.out.println(string);
            }
        }
    }
}

