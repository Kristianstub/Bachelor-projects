public class Aapning extends HvitRute {
    public Aapning(Labyrint labyrint, int radnummer, int kolnummer){
        super(labyrint, radnummer,kolnummer );
    }

    @Override
    public void finn(Rute fra){
        if (fra == null){
            System.out.println("Du started på en aapning");
        }
        
        System.out.println("Utgangen er ved" + radnummer + " " + kolnummer);
    }
}
