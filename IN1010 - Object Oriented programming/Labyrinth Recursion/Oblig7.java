import java.util.Scanner;

public class Oblig7 {
    public static void main(String[] args){
        Labyrint labyrint = new Labyrint(args[0]);
        System.out.println(labyrint);

        Scanner inputscanner = new Scanner(System.in);

        String input;

        while (true){
            System.out.println("Skriv inn koordinater <rad> <kolonne> eller avslutt for å avslutte");

            input = inputscanner.nextLine();

            if (input == "avslutt"){
                break;
            }

            else{
                String[] linje = input.split(" ");
                labyrint.finnUtveiFra(Integer.parseInt(linje[0]), Integer.parseInt(linje[1]));
            }
            
        }
    }
}
