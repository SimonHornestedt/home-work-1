
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class MainGUI extends JFrame{

   public MainGUI(){
         this.initFrameGUI();
         this.initMenuGUI();
         this.game = new Game();
   }
     private Game game;
     private Dimension dimFrame;
     private JPanel land1, land2, land3, land4;
     private JMenuBar menu;
     private JMenu archive, about;
     private JMenuItem terminate, aboutItem, aboutProg, startNew;
     private JButton addMusk, addMusk2, addMusk3, addMusk4;
     private JButton addPike, addPike2, addPike3, addPike4;
     private JButton addCav, addCav2, addCav3, addCav4;
     
     
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
         this.setLayout(new GridLayout(2, 2));
         this.land1 = new JPanel();
         this.land2 = new JPanel();
         this.land3 = new JPanel();
         this.land4 = new JPanel();
         
         this.add(land1);
         this.add(land2);
         this.add(land3);
         this.add(land4);
         this.land1.setBackground(Color.white);
         this.land2.setBackground(Color.white);
         this.land3.setBackground(Color.black);
         this.land4.setBackground(Color.black);
         this.addCav = new JButton("Buy Cavalry");
         this.addMusk = new JButton("Buy Musketeer");
         this.addPike = new JButton("Buy Pikeman");
         this.land1.add(addCav);
         this.land1.add(addMusk);
         this.land1.add(addPike);
         this.addCav2 = new JButton("Buy Cavalry");
         this.addMusk2= new JButton("Buy Musketeer");
         this.addPike2= new JButton("Buy Pikeman");
         this.land2.add(addCav2);
         this.land2.add(addMusk2);
         this.land2.add(addPike2);
         this.addCav3 = new JButton("Buy Cavalry");
         this.addMusk3= new JButton("Buy Musketeer");
         this.addPike3= new JButton("Buy Pikeman");
         this.land3.add(addCav3);
         this.land3.add(addMusk3);
         this.land3.add(addPike3);
         this.addCav4 = new JButton("Buy Cavalry");
         this.addMusk4= new JButton("Buy Musketeer");
         this.addPike4= new JButton("Buy Pikeman");
         this.land4.add(addCav4);
         this.land4.add(addMusk4);
         this.land4.add(addPike4);
         this.addCav3.setVisible(false);
         this.addCav4.setVisible(false);
         this.addMusk4.setVisible(false);
         this.addMusk3.setVisible(false);
         this.addPike4.setVisible(false);
         this.addPike3.setVisible(false);
         
     }
     
             
     
     private void initMenuGUI(){
         /*
            Skapar menyn
         */
         this.menu = new JMenuBar();
         this.archive = new JMenu("Arkiv");
         this.about = new JMenu("Om");
         this.startNew = new JMenuItem("Starta nytt spel");
         this.terminate = new JMenuItem("Avsluta programmet");
         this.aboutItem = new JMenuItem("Om..");
         this.aboutProg = new JMenuItem("Om programmet");
         
         this.setJMenuBar(menu);
         this.menu.add(archive);
         this.menu.add(about);
         this.archive.add(startNew);
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
         this.startNew.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                game = new Game();
                game.runGame();
                
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
         /*
          * Actionevent för knappar (Cavalry)
          */
         this.addCav.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                game.addCavalry(1);
            }
         });
         this.addCav2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                game.addCavalry(2);
            }
         });
         this.addCav3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                game.addCavalry(3);
            }
         });
         this.addCav4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                game.addCavalry(4);
            }
         });
         /*
          * Actionevent för knappar (Musketeer)
          */
         this.addMusk.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                game.addMusketeer(1);
            }
         });
         this.addMusk2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                game.addMusketeer(2);
            }
         });
         this.addMusk3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                game.addMusketeer(3);
            }
         });
         this.addMusk4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                game.addMusketeer(4);
            }
         });
         /*
          * Actionevent för knappar (Pikeman)
          */
         this.addPike.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                game.addPikeman(1);
            }
         });
         this.addPike2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                game.addPikeman(2);
            }
         });
         this.addPike3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                game.addPikeman(3);
            }
         });
         this.addPike4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                game.addPikeman(4);
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




