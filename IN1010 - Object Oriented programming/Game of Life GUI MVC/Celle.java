public class Celle{
    public boolean levende;
    public Celle[] naboer;
    public int antNaboer = 0;
    public int antLevendeNaboer;
    
    public Celle(){
        this.levende = false;
        this.naboer = new Celle [8];
        this.antNaboer = 0;
        this.antLevendeNaboer = 0;
     }
    public void settDoed(){
        this.levende = false;
    }
    public void settLevende(){
        this.levende = true;
    }

    public boolean erLevende(){
        return this.levende;
    }

    public String hentStatusTegn(){
        String tegn;
        if (this.levende){
            tegn = "O";
        }
        else{
            tegn = ".";
        }
        return tegn;
    }

    public void leggTilNabo(Celle celle){
        this.naboer[this.antNaboer] = celle;
        this.antNaboer ++;
    }

    public void endreStatus(){
        if (levende = true){
            levende = false;
        }

        else if (levende = false){
            levende = true;
        }
    }

    public void tellLevendeNaboer(){
        this.antLevendeNaboer = 0;
        for (int i = 0; i < antNaboer; i++){
            if (naboer[i].erLevende()){
                this.antLevendeNaboer ++;
            }
        }
    }
    public void oppdaterStatus(){
        if (this.levende){
            if ((this.antLevendeNaboer > 3) || (this.antLevendeNaboer < 2)) {
                this.levende = false;
            }
        }else{
            if (this.antLevendeNaboer == 3){
                this.levende = true;
            }
        }
    }
}