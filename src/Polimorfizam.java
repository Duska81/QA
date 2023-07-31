public class Polimorfizam extends Nasledjivanje {
    private String company;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    public void printCompany() {
        System.out.println(company);
    }

    public Polimorfizam(){

    }

    public Polimorfizam(String ime, String prezime, String kompanija){
        super.setName(ime);
        super.setLastName(prezime);
        this.company=kompanija;

    }
    public void printDetails(){
        System.out.println("NasledjivanjeChild" + super.getName() +" "+ super.getLastName());//primer overridovanja

    }

}

