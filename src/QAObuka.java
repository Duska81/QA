import java.util.ArrayList;
import java.util.List;

public class QAObuka {
    private String imeKursa;
    private List<Polaznik> listaPolaznika;
    private Mentor mentor;

    public String getImeKursa() {
        return imeKursa;
    }

    public void setImeKursa(String imeKursa) {
        this.imeKursa = imeKursa;
    }

    public List<Polaznik> getListaPolaznika() {
        return listaPolaznika;
    }

    public void setListaPolaznika(List<Polaznik> listaPolaznika) {
        this.listaPolaznika = listaPolaznika;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    public List<Polaznik> listaPolaznika(List<Polaznik>ulaznaLista,String grad) {
        List<Polaznik> polazniciIzGrada = new ArrayList<>();
        for (int y=0;y<ulaznaLista.size();y++) {
            if (ulaznaLista.get(y).getGrad().equals(grad)) {
               polazniciIzGrada.add(ulaznaLista.get(y));
            }
        }
        return polazniciIzGrada;
    }
}

