import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Endrestatus implements ActionListener {
    private Celle celle;

    public Endrestatus(Celle celle){
        this.celle = celle;
    }

    public void actionPerformed(ActionEvent e){
        
        if (celle.erLevende()){
            celle.settDoed();
        }

        else if (celle.erLevende() == false){
            celle.settLevende();
        }
        
        JButton button = (JButton) e.getSource();
        button.setText(celle.hentStatusTegn());
        System.out.println(celle.hentStatusTegn());
    }
    


}
