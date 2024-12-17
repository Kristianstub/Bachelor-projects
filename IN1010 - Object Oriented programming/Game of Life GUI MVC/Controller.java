public class Controller {
    private Verden model;
    private Gui view;

    public Controller(int antRader,int  antKolonner){
        model = new Verden(antRader, antKolonner);

        view = new Gui(this, antRader, antKolonner);
        
    }

    public Rutenett hentRutenett(){
        return model.hentRutenett();
    }

    public void oppdater(){
        model.oppdatering();
    }

    public int hentAntallLevende(){
        return model.hentAntallLevende();
    }
}
