import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Labyrint{
    Rute[][] ruter;
    int rader, kolonner;

    public Labyrint(String filnavn){
        lesFraFil(filnavn);
        leggTilNaboer();
    }

    public void lesFraFil(String filnavn){
        try {
            File fil = new File(filnavn);
            Scanner filScanner = new Scanner(fil);
            int linjeteller = 0;
            int radteller = 0;
            

            while (filScanner.hasNextLine()){
                
                String linje = filScanner.nextLine().trim();
                
                if (linjeteller == 0){
                    String[] tallene = linje.split(" ");
                    rader = Integer.parseInt(tallene[0]);
                    kolonner = Integer.parseInt(tallene[1]);
                    ruter = new Rute[rader][kolonner];
                    linjeteller++;
                }

                else{
                    String[] rutene = linje.split("");

                    
                     for (int kol = 0; kol < kolonner; kol++){
                        
                        String rute =  rutene[kol];
                        
                        
                        if (rute.equals("#")){
                            
                            ruter[radteller][kol] = new SortRute(this, radteller, kol);
                        }

                        else if (rute.equals(".")){
        
                            if (radteller == 0 || radteller == rader - 1 || kol == 0 || kol == kolonner - 1){
                                ruter[radteller][kol] = new Aapning(this, radteller, kol);
                            }

                            else {
                                HvitRute  hvitrute = new HvitRute(this, radteller, kol);
                                
                                ruter[radteller][kol] = hvitrute;
                                
    
                            }
                        }
                        
                        }
                        radteller++;
                    
                }

                

            }

            filScanner.close();
        }
        catch (FileNotFoundException e){
            System.out.println("feil i lesfrafil i labyrint");
        }
    }

    public void finnUtveiFra(int rad, int kol){
        ruter[rad][kol].finn(null);
    }

    public void leggTilNaboer(){
        for (int rad = 0; rad < rader; rad++){
            for (int kol = 0; kol < kolonner; kol++){
                if (rad == 0){
                    ruter[rad][kol].settSoerNabo(ruter[rad + 1][kol]);
                }

                else if (rad == rader-1){
                    ruter[rad][kol].settNordnabo(ruter[rad-1][kol]);
                }

                else{
                    ruter[rad][kol].settSoerNabo(ruter[rad + 1][kol]);
                    ruter[rad][kol].settNordnabo(ruter[rad-1][kol]);
                }

                if (kol == 0){
                    ruter[rad][kol].settOestnabo(ruter[rad][kol +1]);
                
                }

                else if (kol == kolonner-1){
                    ruter[rad][kol].settVestnabo(ruter[rad][kol-1]);
                }

                else{
                    ruter[rad][kol].settOestnabo(ruter[rad][kol +1]);
                    ruter[rad][kol].settVestnabo(ruter[rad][kol-1]);
                }
            }
        }
    }

    @Override
    // Legger på en new line for hver kolonne og så legger inn hver kolonne etter new linen.
    public String toString(){
        String labyrint = "";
        for (int rad = 0; rad < rader; rad++ ){
            labyrint += "\n";
            for (int kol = 0; kol < kolonner; kol++){
                labyrint += ruter[rad][kol];
            }
            
        }

        return labyrint;
    }
}