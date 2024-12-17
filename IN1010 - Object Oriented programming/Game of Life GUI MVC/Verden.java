class Verden{
    Rutenett rutenett;
    int genNr;
    public Verden(int rader, int kolonner){
        rutenett = new Rutenett(rader, kolonner);
        genNr = 0; 
        rutenett.fyllMedTilfeldigeCeller();
        rutenett.kobleAlleceller();
    }

    public void tegn(){
        rutenett.tegnRutenett();
        System.out.println("Generasjons nummer:" + this.genNr);
        System.out.println("Antall levende celler:"+rutenett.antallLevende());
    }

    public  Rutenett hentRutenett(){
        return rutenett;
    }

    public int hentAntallLevende(){
        return rutenett.antallLevende();
    }

    public void oppdatering(){
        rutenett.oppdaterCeller();
        genNr ++;

    }
}