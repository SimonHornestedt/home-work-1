
import javax.swing.*;

public class MainGUI extends JFrame{

    public MainGUI(){
        initGUI();
    }
    
    
    private void initGUI(){

    }
    
    public static void main (String[]args){
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                new MainGUI().setVisible(true);
            }
        });
    }
}




