class GameOfLife1{
    public static void main(String[] args){
        Verden verden = new Verden(8,12);
        for (int i = 0; i<3; i++){
            verden.tegn();
            verden.oppdatering();
        }
    }
}