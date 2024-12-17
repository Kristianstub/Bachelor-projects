public class SortRute extends Rute {
    
    public SortRute(Labyrint labyrint, int radnummer, int kolnummer){
        super(labyrint, radnummer,kolnummer);
    }

    @Override
    public String toString(){
        return "#";
    }
    @Override
    public String hentTegn(){
        return "#";
    }

    @Override
    public void finn(Rute rute){
        if (rute == null){
            System.out.println("Dette er en sortrute, ingen utvei herfra");
        }
        return;
    }
}
