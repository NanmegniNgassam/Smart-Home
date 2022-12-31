import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

public class GuiStartGame 
{
    // private JFrame frame;
    public static void createAndShowGUI()
    {
        JFrame frame=new JFrame();
        // this.frame=frame;
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        ImagePanel2 panel = new ImagePanel2("images/landing.png");
        // JPanel panel =new JPanel();

        panel.setBounds(150,50,800,700);
        
        JButton start=new JButton("Start Game");
        start.setBounds(200,550,150,30);
        start.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                // i have created another thread to avoid that 1 thread are running to frames in the same time
                MainplayThread main=new MainplayThread();
                main.start();//
                // System.exit(0);
                // dispose();
            }
        });
        panel.add(start);
        frame.add(panel);

        frame.setSize(800,700);
        frame.setLayout(null);
        // frame.pack();
        frame.setVisible(true);
    }    
    
}
class ImagePanel2 extends JPanel {

    private Image img;
  
    public ImagePanel2(String img) {
      this(new ImageIcon(img).getImage());
    }
  
    public ImagePanel2(Image img) {
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