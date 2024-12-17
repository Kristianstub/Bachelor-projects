class IndeksertListe <E> extends Lenkeliste<E> {


    public void leggTil (int pos, E x) {

        if (pos > (this.stoerrelse())|| (pos < 0) ){
            throw new UgyldigListeindeks(pos);
        }

        else if (pos == 0 && this.stoerrelse() > 0){

            Node foerste = new Node(x);
            foerste.neste = start;
            start = foerste;

        }

        else if (pos == this.stoerrelse()  ){
            super.leggTil(x);
        }

        else if (pos < this.stoerrelse()  && this.stoerrelse() > 0 ){

            int teller = 0;
            Node peker = start;
            while (teller < pos - 1){
                peker = peker.neste;
                teller ++;
            }

            // """Lagrer elementet før posisjonen og elementet etter posisjonen, deretter
            // setter jeg elementet før posisjonen sin neste til x noden og x noden sin neste til den som var på
            // posisjonen"""

            Node nyNode = new Node(x);
            nyNode.neste = peker.neste;
            peker.neste = nyNode;
            }
        
        



    }


    public void sett (int pos, E x) {
        if (pos > (this.stoerrelse() - 1 )|| (pos < 0) && (pos != 0) ){
            throw new UgyldigListeindeks(pos);
        }

        int teller = 0;
        Node peker = start;

        while (teller < pos - 1){
            peker = peker.neste;
            teller ++;

        }

        // Lagrer elementet før posisjonen og elementet etter posisjonen, deretter
        // setter jeg elementet før sin neste som x noden og x noden sin neste som den etter.

        Node tempfoer = peker;
        Node tempetter = peker.neste.neste;
        tempfoer.neste = new Node(x);
        tempfoer.neste.neste = tempetter;
    }

    public E hent (int pos) {
        if (pos > (this.stoerrelse()) || pos < 0 ){
            throw new UgyldigListeindeks(pos);
        }

        Node peker = start;
        int teller = 0;

        while (teller < pos){
            System.out.println(peker.data);
            peker = peker.neste;
            teller++;
        }

        E dataen = (E) peker.data;
        return dataen;
    }

    public E fjern (int pos) {

        if (pos > (this.stoerrelse() - 1 )|| (pos < 0) && (pos != 0) ){
            throw new UgyldigListeindeks(pos);
        }

        if (pos == 0){
            start = start.neste;
        }

        Node peker = start;
        int teller = 0;

        while (teller < pos-1){
            peker = peker.neste;
            teller ++;
        }

        // """Setter elementet før posisjonen sin neste lik den etter posisjonen."""

        E temp = (E) peker.neste.data;
        peker.neste = peker.neste.neste;
        return temp;
        

    }
}