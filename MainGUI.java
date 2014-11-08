
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;


public class MainGUI extends JFrame{

   public MainGUI(){
         this.initFrameGUI();
         this.initMenuGUI();
         this.initButtonGUI();
         this.game = new Game();
         
         
   }
     private Border border;
     private Game game;
     private Dimension dimFrame, dimTxf, dimTxa;
     private JPanel land1, land2, land3, land4, optPnl, statPnl;
     private JLabel lblPlayerBank, lblNbrOfUnits; 
     private JTextField txfPlayerBank, txfNbrOfUnit, txfNbrOfUnit2,
             txfNbrOfUnit3, txfNbrOfUnit4;
     private JMenuBar menu;
     private JMenu archive, about;
     private JMenuItem terminate, aboutItem, aboutProg, startNew;
     private JButton landSelected1, landSelected2, landSelected3, landSelected4;
     private JButton attack1, attack2, attack3, attack4;
     private JButton addMusk, addMusk2, addMusk3, addMusk4;
     private JButton addPike, addPike2, addPike3, addPike4;
     private JButton addCav, addCav2, addCav3, addCav4;
     private JButton btnEndBuyRound, btnEndAttackRound;
     private JTextArea txaFight;
     
     
     private void initFrameGUI(){
         /*
            Standard storlekar i klassen
         */
         this.dimFrame = new Dimension(1500,500);
         this.dimTxf = new Dimension(60, 30);
         this.dimTxa = new Dimension(400, 100);
         this.border = BorderFactory.createLineBorder(Color.BLACK);
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
         this.optPnl = new JPanel();
         this.statPnl = new JPanel();
         this.lblNbrOfUnits = new JLabel("Units:");
         this.txaFight = new JTextArea();
         
       
         this.add(land1);
         this.add(land2);
         this.add(statPnl);
         this.add(land3);
         this.add(land4);
         this.add(optPnl);
         
         this.land1.setBackground(Color.white);
         this.land2.setBackground(Color.white);
         this.land3.setBackground(Color.cyan);
         this.land4.setBackground(Color.cyan);
         this.landSelected1 = new JButton("Use");
         this.landSelected2 = new JButton("Use");
         this.landSelected3 = new JButton("Use");
         this.landSelected4 = new JButton("Use");
         this.attack1 = new JButton("Attack");
         this.attack2 = new JButton("Attack");
         this.attack3 = new JButton("Attack");
         this.attack4 = new JButton("Attack");
         
         /*
         * Land 1 
         */        
         this.addCav = new JButton("Buy Cavalry");
         this.addMusk = new JButton("Buy Musketeer");
         this.addPike = new JButton("Buy Pikeman");
         this.land1.add(addCav);
         this.land1.add(addMusk);
         this.land1.add(addPike);
         this.txfNbrOfUnit = new JTextField("");
         this.land1.add(lblNbrOfUnits);
         this.land1.add(txfNbrOfUnit);
         this.txfNbrOfUnit.setPreferredSize(dimTxf);
         this.txfNbrOfUnit.setEditable(false);
         this.land1.add(landSelected1);
         this.land1.add(attack1);
         
         
         
         /*
         * Land 2 
         */                  
         this.addCav2 = new JButton("Buy Cavalry");
         this.addMusk2= new JButton("Buy Musketeer");
         this.addPike2= new JButton("Buy Pikeman");
         this.land2.add(addCav2);
         this.land2.add(addMusk2);
         this.land2.add(addPike2);
         this.lblNbrOfUnits = new JLabel("Units:");
         this.txfNbrOfUnit2 = new JTextField("");
         this.land2.add(lblNbrOfUnits);
         this.land2.add(txfNbrOfUnit2);
         this.txfNbrOfUnit2.setPreferredSize(dimTxf);
         this.txfNbrOfUnit2.setEditable(false);
         this.land2.add(landSelected2);
         this.land2.add(attack2);
         
         /*
         * stat-panel
         */
         this.lblPlayerBank = new JLabel("Player bank:");
         
         this.txfPlayerBank = new JTextField("");
         this.txfPlayerBank.setPreferredSize(dimTxf);
         this.txfPlayerBank.setEditable(false);
         this.statPnl.add(lblPlayerBank);
         this.statPnl.add(txfPlayerBank);
         this.statPnl.add(txaFight);
         this.txaFight.setPreferredSize(dimTxa);
         this.txaFight.setEditable(false);
         this.txaFight.setBorder(border);
         
         
         /*
         * Land 3 
         */
         this.addCav3 = new JButton("Buy Cavalry");
         this.addMusk3= new JButton("Buy Musketeer");
         this.addPike3= new JButton("Buy Pikeman");
         this.land3.add(addCav3);
         this.land3.add(addMusk3);
         this.land3.add(addPike3);
         this.lblNbrOfUnits = new JLabel("Units:");
         this.txfNbrOfUnit3 = new JTextField("");
         this.land3.add(lblNbrOfUnits);
         this.land3.add(txfNbrOfUnit3);
         this.txfNbrOfUnit3.setPreferredSize(dimTxf);
         this.txfNbrOfUnit3.setEditable(false);
         this.land3.add(landSelected3);
         this.land3.add(attack3);
         
         /*
         * Land 4 
         */
         this.addCav4 = new JButton("Buy Cavalry");
         this.addMusk4= new JButton("Buy Musketeer");
         this.addPike4= new JButton("Buy Pikeman");
         this.land4.add(addCav4);
         this.land4.add(addMusk4);
         this.land4.add(addPike4);
         this.lblNbrOfUnits = new JLabel("Units:");
         this.txfNbrOfUnit4 = new JTextField("");
         this.land4.add(lblNbrOfUnits);
         this.land4.add(txfNbrOfUnit4);
         this.txfNbrOfUnit4.setPreferredSize(dimTxf);
         this.txfNbrOfUnit4.setEditable(false);
         this.land4.add(landSelected4);
         this.land4.add(attack4);
         
         /*
         * Opt-panel
         */
         this.btnEndBuyRound = new JButton("End buy round");
         this.btnEndAttackRound = new JButton("End attack round");
         this.btnEndBuyRound.setEnabled(false);
         this.btnEndAttackRound.setEnabled(false);
         this.optPnl.add(btnEndBuyRound);
         this.optPnl.add(btnEndAttackRound);
         
         
         
         this.addCav.setVisible(false);
         this.addCav2.setVisible(false);
         this.addMusk.setVisible(false);
         this.addMusk2.setVisible(false);
         this.addPike.setVisible(false);
         this.addPike2.setVisible(false);
         this.addCav3.setVisible(false);
         this.addCav4.setVisible(false);
         this.addMusk4.setVisible(false);
         this.addMusk3.setVisible(false);
         this.addPike4.setVisible(false);
         this.addPike3.setVisible(false);
         this.attack1.setVisible(false);
         this.attack2.setVisible(false);
         this.attack3.setVisible(false);
         this.attack4.setVisible(false);
         
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
                game.runGame(land1,land2,land3,land4);
                btnEndBuyRound.setEnabled(true);
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
     private void initButtonGUI(){
          /*
          * Actionevent för knappar (Cavalry)
          */
         this.addCav.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                game.addCavalry(1);
                game.getArmy(1);
                
                txfNbrOfUnit.setText(Integer.toString(game.getArmy(1)));
                txfPlayerBank.setText(Integer.toString(game.getPlayerBank()));
            }
         });
         this.addCav2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                game.addCavalry(2);
                game.getArmy(2);
                txfNbrOfUnit2.setText(Integer.toString(game.getArmy(2)));
                txfPlayerBank.setText(Integer.toString(game.getPlayerBank()));
            }
         });
         this.addCav3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                game.addCavalry(3);
                game.getArmy(3);
                txfNbrOfUnit3.setText(Integer.toString(game.getArmy(3)));
                txfPlayerBank.setText(Integer.toString(game.getPlayerBank()));
            }
         });
         this.addCav4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                game.addCavalry(4);
                game.getArmy(4);
                txfNbrOfUnit4.setText(Integer.toString(game.getArmy(4)));
                txfPlayerBank.setText(Integer.toString(game.getPlayerBank()));
            }
         });
         /*
          * Actionevent för knappar (Musketeer)
          */
         this.addMusk.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                game.addMusketeer(1);
                game.getArmy(1);
                txfNbrOfUnit.setText(Integer.toString(game.getArmy(1)));
                txfPlayerBank.setText(Integer.toString(game.getPlayerBank()));
            }
         });
         this.addMusk2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                game.addMusketeer(2);
                game.getArmy(2);
                txfNbrOfUnit2.setText(Integer.toString(game.getArmy(2)));
                txfPlayerBank.setText(Integer.toString(game.getPlayerBank()));
            }
         });
         this.addMusk3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                game.addMusketeer(3);
                game.getArmy(3);
                txfNbrOfUnit3.setText(Integer.toString(game.getArmy(3)));
                txfPlayerBank.setText(Integer.toString(game.getPlayerBank()));
            }
         });
         this.addMusk4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                game.addMusketeer(4);
                game.getArmy(4);
                txfNbrOfUnit4.setText(Integer.toString(game.getArmy(4)));
                txfPlayerBank.setText(Integer.toString(game.getPlayerBank()));
            }
         });
         /*
          * Actionevent för knappar (Pikeman)
          */
         this.addPike.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                game.addPikeman(1);
                game.getArmy(1);
                txfNbrOfUnit.setText(Integer.toString(game.getArmy(1)));
                txfPlayerBank.setText(Integer.toString(game.getPlayerBank()));
            }
         });
         this.addPike2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                game.addPikeman(2);
                game.getArmy(2);
                txfNbrOfUnit2.setText(Integer.toString(game.getArmy(2)));
                txfPlayerBank.setText(Integer.toString(game.getPlayerBank()));
            }
         });
         this.addPike3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                game.addPikeman(3);
                game.getArmy(3);
                txfNbrOfUnit3.setText(Integer.toString(game.getArmy(3)));
                txfPlayerBank.setText(Integer.toString(game.getPlayerBank()));
            }
         });
         this.addPike4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                game.addPikeman(4);
                game.getArmy(4);
                txfNbrOfUnit4.setText(Integer.toString(game.getArmy(4)));
                txfPlayerBank.setText(Integer.toString(game.getPlayerBank()));
            }
         });
         /*
         * Actionevent för use-knappar 
         */
         this.landSelected1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
                game.selectLand(1);
                if(landSelected1.getText() == "Use"){
                    landSelected1.setText("Selected");
                    
                }else{
                    landSelected1.setText("Use");
                }
                landSelected2.setText("Use");
                landSelected3.setText("Use");
                landSelected4.setText("Use");
            }
         });
         this.landSelected2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                game.selectLand(2);
                if(landSelected2.getText() == "Use"){
                    landSelected2.setText("Selected");
                }else{
                    landSelected2.setText("Use");
                }
                landSelected1.setText("Use");
                landSelected3.setText("Use");
                landSelected4.setText("Use");
            }
         });
         this.landSelected3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                game.selectLand(3);
                if(landSelected3.getText() == "Use"){
                    landSelected3.setText("Selected");
                    
                }else{
                    landSelected3.setText("Use");
                }
                landSelected2.setText("Use");
                landSelected1.setText("Use");
                landSelected4.setText("Use");
            }
         });
         this.landSelected4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                game.selectLand(4);
                if(landSelected4.getText() == "Use"){
                    landSelected4.setText("Selected");
                    
                }else{
                    landSelected4.setText("Use");
                }
                landSelected2.setText("Use");
                landSelected3.setText("Use");
                landSelected1.setText("Use");               
            }
         }); 
         this.attack1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //game.attack(1);
            }
         });
         this.attack2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //game.attack(2);
            }
         });
         this.attack3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //game.attack(3);
            }
         });
         this.attack4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //game.attack(4);
            }
         });
         this.btnEndBuyRound.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                btnEndBuyRound.setEnabled(false);
                btnEndAttackRound.setEnabled(true);
                game.setBuyRound(false);
                game.setAttackRound(true);
            }
         });
         this.btnEndAttackRound.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                btnEndAttackRound.setEnabled(false);
                btnEndBuyRound.setEnabled(true);
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




