public class MaxNum {

    //vratiti max broj od zadatog niza celih brojeva
    public static int maximum(int[] arrayOfInt){
       int max = arrayOfInt[0]; //deklarisemo promenljivu koju vracamo iz metode
        for(int i=1; i<arrayOfInt.length;i++){
            if(max>arrayOfInt[i]){//poredimo max sa elementima niza, kojima pristupamao []
               // max=arrayOfInt[i];//ili red 8 ili redovi 10 i 11

            }else{
                max=arrayOfInt[i];
            }

        }

        return max;

    }
}
