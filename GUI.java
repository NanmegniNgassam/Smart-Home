import java.awt.*; 
import javax.swing.*; 
public class GUI 
{
    // JFrame Frame;
    // JPanel 
    JLabel Electric;
    JLabel Famine;
    JLabel Money;
    JLabel NbOfLampeturnedOn;

    // JPanel Bed;



    void setTextlectriclabel(int elecvalue)
    {

        Electric.setText("Electricity:"+Integer.toString(elecvalue));
        // System.out.println(elecvalue+"!!!!!!!!");
    }
    void setTextFaminelabel(int famine)
    {

        Famine.setText("Famine:"+Integer.toString(famine));
        // System.out.println(elecvalue+"!!!!!!!!");
    }
    void setTextMoneyLabel(int money)
    {
        Money.setText("Money:"+Integer.toString(money));
    }

    void setTextLampesOn(int number)
    {
        NbOfLampeturnedOn.setText("LampsTurnedOn:"+Integer.toString(number));
    }


    protected  void createAndShowGUI()
     
    {
        JFrame frame = new JFrame("SmartHome");
        
        JPanel InfoPanel=new JPanel();
        InfoPanel.setBounds(0, 0,800,100);        
        InfoPanel.setBackground(new java.awt.Color(25,25, 25));
        // InfoPanel.setBounds(0, 0,700,100);        
        
        JPanel LivingPanel=new JPanel();
        LivingPanel.setBounds(0,100,400,300);
        LivingPanel.setBackground(new java.awt.Color(50,50,50));

        JPanel KitchenPanel=new JPanel();
        KitchenPanel.setBounds(400,100,400,300);
        KitchenPanel.setBackground(new java.awt.Color(56,120,50));

        JPanel BathPanel=new JPanel();
        BathPanel.setBounds(0,400,400,300);
        BathPanel.setBackground(new java.awt.Color(120,120,0));      

        JPanel BedroomPanel=new JPanel();
        BedroomPanel.setBounds(400,400,400,300);
        BedroomPanel.setBackground(new java.awt.Color(46,120,80)); 

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

        

        // frame.setVisible(true);
        InfoPanel.add(electricLabel);
        InfoPanel.add(Famine);
        InfoPanel.add(Money);
        InfoPanel.add(NbOfLampeturnedOn);



        InfoPanel.setLayout(null);

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
