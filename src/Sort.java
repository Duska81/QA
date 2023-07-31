public class Sort {
    //Napisati metodu koja za zadati niz Integer-a uredjuje u rastuci redosled.

    //Domaci3

        public static void main(String[] args) {
            Integer[] niz = {9, 8, 1, 3, 5};

            sortirajNiz(niz);


            for (Integer broj : niz) {
                System.out.println(broj);
            }
        }

        public static void sortirajNiz(Integer[] niz) {
            int n = niz.length;

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (niz[j] > niz[j + 1]) {
                        Integer temp = niz[j];
                        niz[j] = niz[j + 1];
                        niz[j + 1] = temp;
                    }
                }
            }
        }
}



