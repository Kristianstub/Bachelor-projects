import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Gui {
    Celleknapp[][] celleknappliste;  
    private Controller kontroll;
    private JPanel panelRutenett;
    private int antKolonner, antRader;
    JFrame vindu;
    Rutenett rutenett;
    Thread looptraad;
    JLabel antalllevende;

    
    public void oppdaterGui(){
        kontroll.oppdater();
        antalllevende.setText("Antall levende = " + kontroll.hentAntallLevende());
        for (int rad = 0; rad < antRader; rad++){
            for (int kol = 0; kol < antKolonner; kol++){
                celleknappliste[rad][kol].endreTekst();
                
            }
        }
    }

    public Gui(Controller kontroll, int antKolonner, int antRader){
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            
        }
        catch (Exception e ){
            System.exit(1);
        }
        this.antKolonner = antKolonner;
        this.antRader= antRader;

        this.kontroll = kontroll;
        
        vindu = new JFrame("Game of life");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        leggTilKnapper();
        leggTilKontrollKnapper();
        


        vindu.pack();
        vindu.setLocationRelativeTo(null);
        vindu.setVisible(true);
        
    }

    public void leggTilKontrollKnapper(){
        JPanel kontrollPanel = new JPanel();
        JButton startknapp = new JButton("Start");
        JButton avsluttknapp = new JButton("Avslutt");

        Startoppdatering startactionevent = new Startoppdatering();
        startknapp.addActionListener(startactionevent);

        Avsluttoppdatering avsluttactionevent = new Avsluttoppdatering();
        avsluttknapp.addActionListener(avsluttactionevent);
        kontrollPanel.setLayout(new GridLayout(1, 3));
        antalllevende = new JLabel("Antall levende = " + kontroll.hentAntallLevende());
        kontrollPanel.add(antalllevende);
        kontrollPanel.add(startknapp);
        kontrollPanel.add(avsluttknapp);
        vindu.add(kontrollPanel, BorderLayout.NORTH);
    }



    public void leggTilKnapper(){
        celleknappliste = new Celleknapp[antRader][antKolonner];
        panelRutenett = new JPanel();
        panelRutenett.setLayout(new GridLayout(antRader, antKolonner));
        rutenett = kontroll.hentRutenett();
        

        for (int rad = 0; rad < antRader; rad++){
            for (int kol = 0; kol < antKolonner; kol++){
                Celle celle = rutenett.hentCelle(rad,kol);
                Celleknapp rutenettKnapp = new Celleknapp(celle);
                Endrestatus actionlistener = new Endrestatus(rutenett.hentCelle(rad, kol));
                rutenettKnapp.addActionListener(actionlistener);
                panelRutenett.add(rutenettKnapp);
                celleknappliste[rad][kol] = rutenettKnapp;
            }
        }
        vindu.add(panelRutenett, BorderLayout.SOUTH);
    }

    public class Celleknapp extends JButton{
        Celle celle;

        public Celleknapp(Celle celle){
            super();
            this.celle = celle;
            this.setText(celle.hentStatusTegn());
        }

        public void endreTekst(){
            this.setText(celle.hentStatusTegn());
        }

    }

    public class Avsluttoppdatering implements ActionListener{
        

        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }

    public class Startoppdatering implements ActionListener{

        public class Oppdateringstraad implements Runnable{
            public void run(){
                while (true){
                    try {
                        System.out.println(kontroll.hentAntallLevende());
                        oppdaterGui();
                        Thread.sleep(2000);
                    }
                    catch (InterruptedException e){
                        System.out.println("Interrupted exception i run metoden til Oppdateringstraad.");
                    }

                }
            }
        }

        public void actionPerformed(ActionEvent e){
            Oppdateringstraad opptateringstraad = new Oppdateringstraad();
            looptraad = new Thread(opptateringstraad);
            looptraad.start();
            
        }
    }    
}
