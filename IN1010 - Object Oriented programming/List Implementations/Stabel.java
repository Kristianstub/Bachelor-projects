class Stabel<E> extends Lenkeliste<E>{
    public Stabel(){
        super();
    }


    @Override
    public void leggTil(E x){
        Node node = new Node(x);
        if (start == null){
            start = node;
        }

        else{
            Node temp = start;
            start = node;
            node.neste = temp;
        }

    }
}