class Prioritetskoe<E extends Comparable<E>> extends Lenkeliste<E>{
    
    public Prioritetskoe(){
        super();
    }

    @Override
    public void leggTil(E x){
        Node nyNode = new Node(x);
        if (this.stoerrelse() == 0){
            start = nyNode;
            return;
        }

    
        

        Node peker = start;
        Node foerpeker = null;
        
        while (peker.neste != null && x.compareTo((E) peker.data) > 0){
            System.out.println("Sammenligner " + x + " med " + peker.data + " dette ga compare verdien " + x.compareTo((E) peker.data));
            foerpeker = peker;
            peker = peker.neste;

            }
        
        
        if (foerpeker == null){
            if (x.compareTo((E) peker.data) <0){
                start = nyNode;
                nyNode.neste = peker;
            }

            else{
                start.neste = nyNode;
            }
    
        }
        else{
            if (x.compareTo((E) peker.data) <0){ 
                System.out.println("Inserting " + x + " between " + foerpeker.data + " and " + peker.data);
                foerpeker.neste = nyNode;
                nyNode.neste = peker;
                }

            else{
                peker.neste = nyNode;
            }
        }
    }
       
    

}
