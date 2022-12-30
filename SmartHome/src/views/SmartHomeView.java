package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SmartHomeView extends JFrame
{
	private static final long serialVersionUID = 2606105172319908909L;
	private JButton start = new JButton("Lancer une partie");
	private JButton load = new JButton("Charger une partie");
	private JButton quit = new JButton("Quitter une partie");
	
	public SmartHomeView()
	{
		//frame configuration
		super("Smart Home");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(1000,600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		
		//Content frame configuration
		JPanel content = (JPanel) this.getContentPane();
		content.setBackground(Color.gray);
		content.setLayout(new BorderLayout());
		
		//Adding of differents components
		content.add(createWelcomeBar(), BorderLayout.NORTH);
		content.add(createCredits(), BorderLayout.SOUTH);
		content.add(options());
		content.add(background(), BorderLayout.EAST);
		
		
		
	}
	
	public JPanel createWelcomeBar()
	{
		JPanel panel = new JPanel();
		panel.setBackground(Color.gray);
		
		JLabel welcomeLabel = new JLabel("Bienvenu dans l'univers de SMART HOME");
		welcomeLabel.setForeground(new Color(255, 255, 255));
		welcomeLabel.setFont(new Font("Franklin Gothic Demi Cond", Font.ITALIC, 34));
		
		panel.add(welcomeLabel);
		
		return panel;
	}
	
	public JPanel createCredits()
	{
		JPanel panel = new JPanel();
		panel.setBackground(Color.gray);
		
		JLabel creditLabel = new JLabel("Powered by BlacKoder");
		creditLabel.setForeground(new Color(255,255,255));
		
		panel.add(creditLabel);
		
		return panel;
	}
	
	public JPanel options()
	{
		JPanel panel = new JPanel(new GridLayout(3,1));
		panel.setBackground(Color.gray);
		panel.setSize(new Dimension(800, 300));
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		start.setBackground(new Color(212,175,7));
		start.setForeground(Color.white);
		start.setSize(400,50);
		start.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 18));
		
		load.setBackground(new Color(212,175,7));
		load.setForeground(Color.white);
		load.setSize(400,20);
		load.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 18));
		
		quit.setBackground(new Color(212,175,7));
		quit.setForeground(Color.white);
		quit.setSize(400,20);
		quit.setFont(new Font("Franklin Gothic Demi Cond", Font.BOLD, 18));
		
		panel.add(start);
		panel.add(load);
		panel.add(quit);
		
		
		return panel;
	}
	 public JPanel background()
	 {
		JPanel background = new JPanel();
		background.setBackground(Color.gray);
		
		JLabel image = new JLabel();
		image.setIcon(new ImageIcon("C:\\Users\\nanme\\eclipse-workspace\\SmartHome\\src\\images\\landing.png"));
		
		background.add(image);
		
		return background;
	 }
	
	

}
