package saobracaj;

public class Vozilo {
    private String tip;
    private String marka;
    private int godiste;

    public Vozilo(String tip, String marka, int godiste) {//od 8 do 13 linije to je sve konstruktor
        this.tip=tip;
        this.marka=marka;
        this.godiste=godiste;

    }



    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public int getGodiste() {
        return godiste;
    }



}
