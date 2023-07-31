public class NasledjivanjeChild extends Nasledjivanje {
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

    public NasledjivanjeChild(){

    }

        public NasledjivanjeChild(String ime, String prezime, String kompanija){
            super.setName(ime);
            super.setLastName(prezime);
            this.company=kompanija;

        }

    }

