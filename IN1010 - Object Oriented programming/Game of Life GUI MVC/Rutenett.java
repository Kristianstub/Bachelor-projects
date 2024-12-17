import java.lang.Math;

public class Rutenett{
    
    public int antRader;
    public int antKolonner;
    public Celle[][] rutene;

    public Rutenett(int rader, int kolonner){
        this.antRader = rader;
        this.antKolonner = kolonner;
        this.rutene = new Celle[rader][kolonner];
    }


    public void lagCelle(int rad,int kol){
        this.rutene[rad][kol] = new Celle();
        if (Math.random()<=0.3333){
            this.rutene[rad][kol].settLevende();
        }
    }
    public void fyllMedTilfeldigeCeller(){
        for(int i=0; i<this.antRader; i++){
            for(int j=0; j<this.antKolonner; j++){
                lagCelle(i,j);
            }
        }
    }

    public Celle hentCelle(int rad,int kol){
        if ((rad >= antRader) ||(rad < 0)){
            return null;
        }
        if ((kol >= antKolonner) || (kol < 0)){
            return null;
        }
        return this.rutene[rad][kol];
    }

    public void tegnRutenett(){
        for(int i=0; i<this.antRader; i++){
            for(int j=0; j<this.antKolonner; j++){
                System.out.print(this.rutene[i][j].hentStatusTegn());
            }
            System.out.println();
        }
    }
    
    public void settNaboer(int rad,int kol){
        Celle celle = this.rutene[rad][kol];
                int[] range = new int[] {1,-1};
                for (int i : range){
                    if (this.hentCelle(rad+i, kol) != null){
                        celle.leggTilNabo(this.hentCelle(rad+i,kol));
                    }

                    if (this.hentCelle(rad+i,kol+i) != null){
                        
                        celle.leggTilNabo(this.hentCelle(rad+i,kol+i));
                    }

                    if (this.hentCelle(rad,kol+i) != null){
                        celle.leggTilNabo(this.hentCelle(rad,kol+i));
                        }
                    

                    if (this.hentCelle(rad+i,kol-i) != null){
                        celle.leggTilNabo(this.hentCelle(rad+i,kol-i));
                        }
                    }
                }
    
    public void kobleAlleceller(){
        for(int i=0; i<this.antRader; i++){
            for(int j=0; j<this.antKolonner; j++){
                this.settNaboer(i,j);
            }
    }
    }
    //private int teller = 0;
    public int antallLevende(){
        int teller = 0;
        for(int i=0; i<this.antRader; i++){
            for(int j=0; j<this.antKolonner; j++){
                if (this.rutene[i][j].erLevende()){
                    teller ++;               
                }
                }
            }
        return teller;
    }
    public void oppdaterCeller(){
        for(int i=0; i<this.antRader; i++){
            for(int j=0; j<this.antKolonner; j++){
                this.rutene[i][j].tellLevendeNaboer();
            }
        }
        for(int i=0; i<this.antRader; i++){
            for(int j=0; j<this.antKolonner; j++){
                this.rutene[i][j].oppdaterStatus();
            }
            }
    }
    
    }

