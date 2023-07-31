package saobracaj;

import java.util.ArrayList;
import java.util.List;
//Kreirati klasu Vozilo sa atributima : tip (putnicko ili teretno vozilo), marka, godiste.
//Kreirati klase Automobil, Kamion, Motor koje nasledjuju klasu Vozilo.
//Kreirati klasu Raskrsnica koja ima atribut listu Vozila, koja sadrzi metodu koja vraca Listu vozila odredjene marke i metodu
// koja vraca listu vozila odredjene marke i da bude mladje od zadatog godista.
//U main metodi kreirati klasu Raskrsnica i pozivati kreirane metode.
public class Raskrsnica {
    private List<Vozilo> listaVozila;

    public Raskrsnica() {
        listaVozila = new ArrayList<>();
    }

    public List<Vozilo> getListaVozila() {
        return listaVozila;
    }

    public void setListaVozila(List<Vozilo> listaVozila) {
        this.listaVozila = listaVozila;
    }

    public List<Vozilo> listaVozila(List<Vozilo> ulaznaLista, String marka) {
        List<Vozilo> markaVozila = new ArrayList<>();
        for (int y = 0; y < ulaznaLista.size(); y++) {
            if (ulaznaLista.get(y).getMarka().equals(marka)) {
                markaVozila.add(ulaznaLista.get(y));

            }
        }
        return markaVozila;
    }

    public List<Vozilo> lista(List<Vozilo> ulaznaLista, int godiste) {
        List<Vozilo> godisteVozila = new ArrayList<>();
        for (int y = 0; y < ulaznaLista.size(); y++) {
            if (ulaznaLista.get(y).getGodiste()<godiste) {
                godisteVozila.add(ulaznaLista.get(y));
            }
        }


        return godisteVozila;
    }


    }
