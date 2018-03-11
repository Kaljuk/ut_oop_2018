public class Elektriauto {
    private String automark;
    private double elektrikulu;
    private int laadimisaeg;
    private double soiduulatus;
    private Elektrijaam eJaam;

    public Elektriauto(String inAutomark, double inElektrikulu, int inLaadimisaeg, double inSoiduulatus, Elektrijaam inEJaam) {
        this.automark = inAutomark;
        this.elektrikulu = inElektrikulu;
        setLaadimisaeg(inLaadimisaeg);       
        this.soiduulatus = inSoiduulatus;
        this.eJaam = inEJaam;
    }

    private void setLaadimisaeg (int inLaadmisaeg){
        if (inLaadmisaeg > 0) {
            this.laadimisaeg = inLaadmisaeg;
        }
    }

    public int getLaadimisaeg () {
        return this.laadimisaeg;
    }

    public String toString() {
        return String.format("100 km reisi maksumus on %d",laadimisaeg);
    }

}



