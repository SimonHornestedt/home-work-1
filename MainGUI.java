
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainGUI extends JFrame{

   public MainGUI(){
         this.initFrameGUI();
         this.initMenuGUI();
     }
     
     private Dimension dimFrame;
     private JMenuBar menu;
     private JMenu archive, about;
     private JMenuItem terminate, aboutItem, aboutProg;
     
     
     private void initFrameGUI(){
         /*
            Standard storlekar i klassen
         */
         this.dimFrame = new Dimension(800,500);
         /*
            Inställningar för JFrame
         */
         this.setTitle("MyGUI");
         this.setSize(dimFrame);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
     private void initMenuGUI(){
         /*
            Skapar menyn
         */
         this.menu = new JMenuBar();
         this.archive = new JMenu("Arkiv");
         this.about = new JMenu("Om");
         this.terminate = new JMenuItem("Avsluta programmet");
         this.aboutItem = new JMenuItem("Om..");
         this.aboutProg = new JMenuItem("Om programmet");
         
         this.setJMenuBar(menu);
         this.menu.add(about);
         this.menu.add(archive);
         this.archive.add(terminate);
         this.about.add(aboutItem);
         this.about.add(aboutProg);
         
         /*
            Inställningar för klickevent i menyerna
          */
         this.terminate.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
         this.aboutItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String author = "Simon Hornestedt\n";
                String date = "\u00a9 2014";
                JOptionPane.showMessageDialog(null, author + date);
            }
         });
         this.aboutProg.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String about = "Programmet är en mall för ett GUI\n";
                String version = "Version: 0.1.0";
                JOptionPane.showMessageDialog(null, about + version);
            }
         });
     }
    
    public static void main (String[]args){
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                new MainGUI().setVisible(true);
            }
        });
    }
}




