abstract class Lenkeliste<E> implements Liste<E>{
    Node start;
    Node slutt;
    int stoerrelse = 0;
   
    class Node<E>{
        E data;
        Node neste;


        public Node(E data){
            this.data = data;
            neste = null;

        }

    }
    public Lenkeliste(){
        start = null;
        slutt = null;
    }

    @Override
    public void leggTil(E x){
        if (start == null){
            start = new Node(x);
        }

        else{

            Node peker = start;
            
            while (peker.neste != null){
                peker = peker.neste;
            }
            peker.neste = new Node(x);
            slutt = peker.neste;
        }
    }


    @Override
    public int stoerrelse(){
        int teller = 0;
        Node peker = start;

        while (peker != null){
            peker = peker.neste;
            teller ++;
        }
        return teller;

    }


    @Override
    public E hent(){
        if (start == null){
            throw new UgyldigListeindeks(1);
        }

        else{
            E dataen = (E) start.data;
            return dataen;
        }
    }


    @Override
    public E fjern(){
        if (start == null){
            throw new UgyldigListeindeks(1);
        }

        E temp = (E) start.data;
        start = start.neste;
        stoerrelse--;
        return temp;
    }


    @Override
    public String toString(){
        String streng = "Listen har "  + this.stoerrelse() + " elementer, elementene er: ";
        Node peker = start;
        if (peker == null){
            return "Listen har ingen elementer";
        }

        while (peker != null){
            streng = streng + peker.data + " ";
            peker = peker.neste;
        }
        return streng;
     
    }
}