public class HvitRute extends Rute {
    public HvitRute(Labyrint labyrint, int radnummer, int kolnummer){
        super(labyrint, radnummer,kolnummer );
    }
    @Override
    public String toString(){
        return ".";
    }

    @Override
    public String hentTegn(){
        return ".";
    }

    public void finn(Rute fra){
        
        for (Rute nabo : naboer){
            if (nabo != fra){
                nabo.finn(this);
            }
        }
        
    }
}
