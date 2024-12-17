import java.util.ArrayList;

public abstract class Rute {
    public int radnummer, kolnummer;
    private Labyrint labyrint;
    public Rute nordrute, sydrute, vestrute, oestrute;
    public ArrayList<Rute> naboer = new ArrayList<Rute>();
    
    public Rute(Labyrint labyrint, int radnummer, int kolnummer){
        this.labyrint = labyrint;
        this.radnummer = radnummer;
        this.kolnummer = kolnummer;
    }

    public abstract void finn(Rute fra);

    public void settNordnabo(Rute rute){
        nordrute = rute;
        naboer.add(rute);
    }

    public void settSoerNabo(Rute rute){
        sydrute = rute;
        naboer.add(rute);
    }

    public void settVestnabo(Rute rute){
        vestrute = rute;
        naboer.add(rute);
    }

    public void settOestnabo(Rute rute){
        oestrute = rute;
        naboer.add(rute);
    }

    public abstract String hentTegn();
}
