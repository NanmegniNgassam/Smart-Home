// package Playerpack;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
// import MaisonPack.*;
// package Playerpack;

public class GUI 
{
    // JFrame Frame;
    // JPanel 
    JLabel Electric;
    JLabel Famine;
    JLabel Money;
    JLabel NbOfLampeturnedOn;
    Maison maison;
    JLabel Level;

    JLabel locationBed;
    JLabel locationBath;
    JLabel locationKit;
    JLabel locationLiving;
    JLabel LaverieLevel;
    JLabel TVLevel;
    JLabel FactureTemps;


    // JFrame frame;
    ImagePanel BathPanel;
    ImagePanel LivingPanel;
    ImagePanel KitchenPanel;
    ImagePanel BedroomPanel;

    JButton buttonBath;
    JButton buttonLiv;
    JButton buttonKit;
    JButton buttonBed;


    // JPanel Bed;

    public void setlocation(String roomname)
    {
        locationBath.setText("");
        locationBed.setText("");
        locationKit.setText("");
        locationLiving.setText("");
        if (roomname=="Bathroom")
        {
            locationBath.setText("Here");
        }
        if (roomname=="Bedroom")
        {
            locationBed.setText("Here");
        }
        if (roomname=="Kitchen")
        {
            locationKit.setText("Here");
        }
        if (roomname=="LivingRoom")
        {
            locationLiving.setText("Here");
        }

        


    }

    public void setTextlectriclabel(int elecvalue)
    {

        Electric.setText("Electricity:"+Integer.toString(elecvalue));
        // System.out.println(elecvalue+"!!!!!!!!");
    }
    public void setTextFaminelabel(int famine)
    {

        Famine.setText("Famine:"+Integer.toString(famine));
        // System.out.println(elecvalue+"!!!!!!!!");
    }
    public void setTextMoneyLabel(int money)
    {
        Money.setText("Money:"+Integer.toString(money));
    }
    public void setTextLevel(int level)
    {
        Level.setText("Level:"+Integer.toString(level));
    }
    public void setLaverieLevel(int level)
    {
        LaverieLevel.setText("Laverie Level:"+Integer.toString(level));
    }
    public void setTVLevel(int level)
    {
        TVLevel.setText("TV Level:"+Integer.toString(level));
    }
    public void setTextLampesOn(int number)
    {
        NbOfLampeturnedOn.setText("LampsTurnedOn:"+Integer.toString(number));
    }
    public void setTempsFacture(int temps)
    {
        FactureTemps.setText("Facture echeance:"+Integer.toString(temps));
    }
    public void setMaison(Maison maison){this.maison=maison;}



    protected  void createAndShowGUI()
     
    {
        JFrame frame = new JFrame("SmartHome");
        // this.frame=frame;
        frame.repaint();
        JPanel InfoPanel=new JPanel();
        InfoPanel.setBounds(0, 0,800,100);        
        InfoPanel.setBackground(new java.awt.Color(25,25, 25));
        // InfoPanel.setBounds(0, 0,700,100);        
        
        ImagePanel LivingPanel=new  ImagePanel(
            new ImageIcon("images/LivingNoLight.jpg").getImage());
        this.LivingPanel=LivingPanel;
        // JPanel LivingPanel=new JPanel();
        LivingPanel.setBounds(0,100,400,300);
        LivingPanel.setBackground(new java.awt.Color(50,50,50));
        JButton buttonLiv=new JButton("off");
        this.buttonLiv=buttonLiv;
        buttonLiv.setBounds(0,100,100,50);
        buttonLiv.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(maison.living.lightState==true)
                { maison.living.switchLight(false);
                    maison.update();
                    
                }
            }
        });
        JLabel Livingname=new JLabel("Living");
        Livingname.setForeground(new java.awt.Color(255,0,0));
        Livingname.setBounds(200, 0, 100, 20);


        
        ImagePanel KitchenPanel=new  ImagePanel(
            new ImageIcon("images/Kitchen.jpeg").getImage());
        this.KitchenPanel=KitchenPanel;
        KitchenPanel.setBounds(400,100,400,300);
        // KitchenPanel.setBackground(new java.awt.Color(56,120,50));
        JButton buttonKit=new JButton("off");
        this.buttonKit=buttonKit;
        buttonKit.setEnabled(false);
        buttonKit.setBounds(0,100,100,50);
        buttonKit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(maison.kit.lightState==true)
                { maison.kit.switchLight(false);
                    maison.update();
                    
                }
            }
        });
        JLabel Kitchenname=new JLabel("Kitchen");
        Kitchenname.setForeground(new java.awt.Color(255,0,0));
        Kitchenname.setBounds(200, 0, 100, 20);


        ImagePanel BathPanel=new  ImagePanel(
            new ImageIcon("images/Bathroomnolight.jpg").getImage());  
        this.BathPanel=BathPanel;
        // this.BathPanel.
        BathPanel.setBounds(0,400,400,300);
        // BathPanel.setBackground(new java.awt.Color(120,120,0));      
        JButton buttonBath=new JButton("off");
        this.buttonBath=buttonBath;
        buttonBath.setBounds(0,100,100,50);
        buttonBath.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(maison.bath.lightState==true)
                { maison.bath.switchLight(false);
                    maison.update();
                    
                }
            }
        });
        JLabel Bathroomname=new JLabel("Bathroom");
        Bathroomname.setForeground(new java.awt.Color(255,0,0));
        Bathroomname.setBounds(200, 0, 100, 20);
        // BathPanel


        // JPanel BedroomPanel=new JPanel();
        ImagePanel BedroomPanel=new  ImagePanel(
            new ImageIcon("images/BedroomNoLight.jpg").getImage());  
        this.BedroomPanel=BedroomPanel;
        // BedroomPanel.setImage("images/Bathroom.jpg");
        BedroomPanel.setBounds(400,400,400,300);
        BedroomPanel.setBackground(new java.awt.Color(46,120,80));
        JButton buttonBed=new JButton("off");
        this.buttonBed=buttonBed;
        buttonBed.setBounds(0,100,100,50);
        buttonBed.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(maison.bed.lightState==true)
                { maison.bed.switchLight(false);
                    maison.update();
                    
                }
            }
        });
        JLabel Bedroomname=new JLabel("Bedroom");
        Bedroomname.setForeground(new java.awt.Color(255,0,0));
        Bedroomname.setBounds(200, 0, 100, 20);



        JLabel electricLabel=new JLabel();
        electricLabel.setBounds(20,0,140,20);
        electricLabel.setForeground(new java.awt.Color(255,0,0));
        this.Electric=electricLabel;

        JLabel Famine=new JLabel();
        Famine.setBounds(20,20,140,20);
        Famine.setForeground(new java.awt.Color(255,0,0));
        this.Famine=Famine;
        
        JLabel Money=new JLabel();
        Money.setBounds(20,40,140,20);
        Money.setForeground(new java.awt.Color(255,0,0));
        this.Money=Money;

        JLabel NbOfLampeturnedOn=new JLabel();
        NbOfLampeturnedOn.setBounds(20,60,140,20);
        NbOfLampeturnedOn.setForeground(new java.awt.Color(255,0,0));
        this.NbOfLampeturnedOn=NbOfLampeturnedOn;

        JLabel Level=new JLabel();
        Level.setBounds(180,0,140,20);
        Level.setForeground(new java.awt.Color(255,0,0));
        this.Level=Level;

        JLabel LaverieLevel=new JLabel();
        LaverieLevel.setBounds(180,20 ,140,20);
        LaverieLevel.setForeground(new java.awt.Color(255,0,0));
        this.LaverieLevel=LaverieLevel;

        JLabel TVLevel=new JLabel();
        TVLevel.setBounds(180,40 ,140,20);
        TVLevel.setForeground(new java.awt.Color(255,0,0));
        this.TVLevel=TVLevel;

        JLabel FactureTemps=new JLabel();
        FactureTemps.setBounds(180,60 ,160,20);
        FactureTemps.setForeground(new java.awt.Color(255,0,0));
        this.FactureTemps=FactureTemps;
        
        JButton buttonFacture=new JButton("Payer Facture");
        buttonFacture.setBounds(360,0,150,30);
        buttonFacture.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                maison.player.payerFacture();
            }
        });
        JButton UpdateLaverie=new JButton("Ugrade Laverie");
        UpdateLaverie.setBounds(360,30,150,30);
        UpdateLaverie.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                maison.player.upgrade(maison.bath.laverie);
            }
        });
        JButton UpdateTv=new JButton("Ugrade TV");
        UpdateTv.setBounds(360,60,150,30);
        UpdateTv.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                maison.player.upgrade(maison.living.TV);
            }
        });






        //label location
        JLabel locationbed=new JLabel();
        locationbed.setBounds(0, 0, 70, 30);
        this.locationBed=locationbed;
        locationbed.setForeground(new java.awt.Color(255,0,0));

        JLabel locationKit=new JLabel("Here");
        locationKit.setBounds(0, 0, 70, 30);
        this.locationKit=locationKit;
        locationKit.setForeground(new java.awt.Color(255,0,0));


        JLabel locationBath=new JLabel();
        locationBath.setBounds(0, 0, 70, 30);
        this.locationBath=locationBath;
        locationBath.setForeground(new java.awt.Color(255,0,0));


        JLabel locationLiving=new JLabel();
        locationLiving.setBounds(0, 0, 70, 30);
        this.locationLiving=locationLiving;
        locationLiving.setForeground(new java.awt.Color(255,0,0));

        

        // frame.setVisible(true);
        InfoPanel.add(electricLabel);
        InfoPanel.add(Famine);
        InfoPanel.add(Money);
        InfoPanel.add(NbOfLampeturnedOn);
        InfoPanel.add(Level);
        InfoPanel.add(LaverieLevel);
        InfoPanel.add(TVLevel);
        InfoPanel.add(FactureTemps);
        InfoPanel.add(buttonFacture);
        InfoPanel.add(UpdateLaverie);
        InfoPanel.add(UpdateTv);
        KitchenPanel.add(buttonKit);
        BedroomPanel.add(buttonBed);
        BathPanel.add(buttonBath);
        LivingPanel.add(buttonLiv);
        BedroomPanel.add(Bedroomname);
        LivingPanel.add(Livingname);
        KitchenPanel.add(Kitchenname);
        BathPanel.add(Bathroomname);

        BathPanel.add(locationBath);
        KitchenPanel.add(locationKit);
        LivingPanel.add(locationLiving);
        BedroomPanel.add(locationBed);







        InfoPanel.setLayout(null);
        BathPanel.setLayout(null);
        BedroomPanel.setLayout(null);
        LivingPanel.setLayout(null);
        KitchenPanel.setLayout(null);

        frame.add(InfoPanel);


        frame.add(LivingPanel);
        frame.add(KitchenPanel);
        frame.add(BathPanel);
        frame.add(BedroomPanel);

        frame.setSize(800,700);
        frame.setLayout(null);
        // frame.pack();
        frame.setVisible(true);
    }




}
class ImagePanel extends JPanel {

    private Image img;
  
    public ImagePanel(String img) {
      this(new ImageIcon(img).getImage());
    }
  
    public ImagePanel(Image img) {
      this.img = img;
      Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
      setPreferredSize(size);
      setMinimumSize(size);
      setMaximumSize(size);
      setSize(size);
      setLayout(null);
    }
  
    public void setImage(String img)
    {
        // this.removeAll();
        this.img=new ImageIcon(img).getImage();
        Dimension size = new Dimension(this.img.getWidth(null), this.img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        // setLayout(null);
        // setVisible(true);
        this.repaint();
        setLayout(null);


    }
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawImage(img, 0, 0, null);
      System.out.println("HEEEEEEEEEEEEEEEe");
    }
  
  }