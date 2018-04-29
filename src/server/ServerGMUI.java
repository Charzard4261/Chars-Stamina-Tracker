package server;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ServerGMUI {
	
	public Server		server;
	private ServerGMUI	sgmui	= this;
	
	private JFrame	frame;
	private JPanel	contentPane;
	public Timer	timer	= new Timer();
	
	private JLabel	halllbl;
	private JButton	hall1, hall3, hall5;
	
	private JLabel	dalllbl;
	private JButton	dall1, dall3, dall5;
	
	private int XOne = 10, XTwo = 420, YOne = 130, YTwo = 500;
	
	public GMAP g1, g2, g3, g4;
	
	public ServerGMUI(Server server)
	{
		this.server = server;
		EventQueue.invokeLater(new Runnable() {
			public void run()
			{
				initUI();
			}
		});
	}
	
	private void initUI()
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 775, 820);
		frame.setLocation(
				(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth() / 2) - (frame.getWidth() / 2),
				(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight() / 2)
						- (frame.getHeight() / 2));
		frame.setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JButton settingsTab = new JButton("Settings");
		settingsTab.setForeground(Color.BLACK);
		settingsTab.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				JFrame optionsFrame = new JFrame();
				optionsFrame.setSize(500, 600);
				optionsFrame.setResizable(false);
				optionsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				JTabbedPane jtp = new JTabbedPane();
				optionsFrame.setContentPane(jtp);
				
				JPanel p1 = new JPanel();
				JPanel p2 = new JPanel();
				JPanel p3 = new JPanel();
				JPanel p4 = new JPanel();
				
				try
				{
					new Options(sgmui).decorate(p1, 1);
					new Options(sgmui).decorate(p2, 2);
					new Options(sgmui).decorate(p3, 3);
					new Options(sgmui).decorate(p4, 4);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
				
				jtp.addTab("Player 1", p1);
				jtp.addTab("Player 2", p2);
				jtp.addTab("Player 3", p3);
				jtp.addTab("Player 4", p4);
				
				optionsFrame.setVisible(true);
				optionsFrame.repaint();
			}
		});
		menuBar.add(settingsTab);
		
		/*
		 * BODY
		 */
		
		final JToggleButton p1 = new JToggleButton("");
		p1.setSelectedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/EnablePlayers/P1E.png")));
		p1.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/EnablePlayers/P1D.png")));
		p1.setContentAreaFilled(false);
		p1.setBorderPainted(false);
		p1.setBounds(10, 10, 30, 30);
		p1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (p1.isSelected())
				{
					server.input("Player 1 enable");
					server.player1 = true;
				} else
				{
					server.input("Player 1 disable");
					server.player1 = false;
				}
			}
		});
		
		final JToggleButton p2 = new JToggleButton("");
		p2.setSelectedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/EnablePlayers/P2E.png")));
		p2.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/EnablePlayers/P2D.png")));
		p2.setContentAreaFilled(false);
		p2.setBorderPainted(false);
		p2.setBounds(50, 10, 30, 30);
		p2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (p2.isSelected())
				{
					server.input("Player 2 enable");
					server.player2 = true;
				} else
				{
					server.input("Player 2 disable");
					server.player2 = false;
				}
			}
		});
		
		final JToggleButton p3 = new JToggleButton("");
		p3.setSelectedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/EnablePlayers/P3E.png")));
		p3.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/EnablePlayers/P3D.png")));
		p3.setContentAreaFilled(false);
		p3.setBorderPainted(false);
		p3.setBounds(90, 10, 30, 30);
		p3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (p3.isSelected())
				{
					server.input("Player 3 enable");
					server.player3 = true;
				} else
				{
					server.input("Player 3 disable");
					server.player3 = false;
				}
			}
		});
		
		final JToggleButton p4 = new JToggleButton("");
		p4.setSelectedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/EnablePlayers/P4E.png")));
		p4.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/EnablePlayers/P4D.png")));
		p4.setContentAreaFilled(false);
		p4.setBorderPainted(false);
		p4.setBounds(130, 10, 30, 30);
		p4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (p4.isSelected())
				{
					server.input("Player 4 enable");
					server.player4 = true;
				} else
				{
					server.input("Player 4 disable");
					server.player4 = false;
				}
			}
		});
		
		JLabel lblEP = new JLabel("Enable Players");
		lblEP.setHorizontalAlignment(SwingConstants.CENTER);
		lblEP.setFont(new Font("Arial Unicode MS", Font.PLAIN, 14));
		lblEP.setBounds(10, 45, 100, 30);
		
		JButton ha = new JButton("Heal All");
		ha.setFont(new Font("Arial Unicode MS", Font.PLAIN, 11));
		ha.setBounds(180, 10, 100, 30);
		ha.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent paramActionEvent)
			{
				server.player1CStam = server.player1Stam;
				server.player2CStam = server.player2Stam;
				server.player3CStam = server.player3Stam;
				server.player4CStam = server.player4Stam;
				server.input("HealAll");
			}
		});
		
		JButton nr = new JButton("New Round");
		nr.setFont(new Font("Arial Unicode MS", Font.PLAIN, 11));
		nr.setBounds(180, 40, 100, 32);
		nr.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				server.player1Action1 = true;
				server.player1Action2 = true;
				server.player2Action1 = true;
				server.player2Action2 = true;
				server.player3Action1 = true;
				server.player3Action2 = true;
				server.player4Action1 = true;
				server.player4Action2 = true;
				
				server.input("NewRound");
				g1.newround();
				g2.newround();
				g3.newround();
				g4.newround();
			}
		});
		
		halllbl = new JLabel("Heal All For");
		halllbl.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		halllbl.setHorizontalAlignment(SwingConstants.CENTER);
		halllbl.setBounds(290, 5, 100, 30);
		
		dalllbl = new JLabel("Damage All For");
		dalllbl.setFont(new Font("Arial Unicode MS", Font.PLAIN, 12));
		dalllbl.setHorizontalAlignment(SwingConstants.CENTER);
		dalllbl.setBounds(290, 40, 100, 30);
		
		hall1 = new JButton("");
		hall1.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/1+.jpg")));
		hall1.setPressedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/1+p.jpg")));
		hall1.setContentAreaFilled(false);
		hall1.setBorderPainted(false);
		hall1.setBounds(400, 10, 40, 20);
		hall1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				hall1.setSelected(true);
				timer.schedule(new TimerTask() {
					
					@Override
					public void run()
					{
						hall1.setSelected(false);
					}
				}, 100L);
				
				server.player1CStam = server.player1CStam + 1;
				server.player2CStam = server.player2CStam + 1;
				server.player3CStam = server.player3CStam + 1;
				server.player4CStam = server.player4CStam + 1;
				
				server.input("Player1Add 1");
				server.input("Player2Add 1");
				server.input("Player3Add 1");
				server.input("Player4Add 1");
			}
		});
		
		hall3 = new JButton("");
		hall3.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/5+.jpg")));
		hall3.setPressedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/5+p.jpg")));
		hall3.setContentAreaFilled(false);
		hall3.setBorderPainted(false);
		hall3.setBounds(440, 10, 40, 20);
		hall3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				hall3.setSelected(true);
				timer.schedule(new TimerTask() {
					
					@Override
					public void run()
					{
						hall3.setSelected(false);
					}
				}, 100L);
				
				server.player1CStam = server.player1CStam + 5;
				server.player2CStam = server.player2CStam + 5;
				server.player3CStam = server.player3CStam + 5;
				server.player4CStam = server.player4CStam + 5;
				
				server.input("Player1Add 5");
				server.input("Player2Add 5");
				server.input("Player3Add 5");
				server.input("Player4Add 5");
			}
		});
		
		hall5 = new JButton("");
		hall5.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/10+.jpg")));
		hall5.setPressedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/10+p.jpg")));
		hall5.setContentAreaFilled(false);
		hall5.setBorderPainted(false);
		hall5.setBounds(480, 10, 40, 20);
		hall5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				hall5.setSelected(true);
				timer.schedule(new TimerTask() {
					
					@Override
					public void run()
					{
						hall5.setSelected(false);
					}
				}, 100L);
				
				server.player1CStam = server.player1CStam + 10;
				server.player2CStam = server.player2CStam + 10;
				server.player3CStam = server.player3CStam + 10;
				server.player4CStam = server.player4CStam + 10;
				
				server.input("Player1Add 10");
				server.input("Player2Add 10");
				server.input("Player3Add 10");
				server.input("Player4Add 10");
			}
		});
		
		dall1 = new JButton("");
		dall1.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/1-.jpg")));
		dall1.setPressedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/1-p.jpg")));
		dall1.setContentAreaFilled(false);
		dall1.setBorderPainted(false);
		dall1.setBounds(400, 45, 40, 20);
		dall1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				dall1.setSelected(true);
				timer.schedule(new TimerTask() {
					
					@Override
					public void run()
					{
						dall1.setSelected(false);
					}
				}, 100L);
				
				server.player1CStam = server.player1CStam - 1;
				server.player2CStam = server.player2CStam - 1;
				server.player3CStam = server.player3CStam - 1;
				server.player4CStam = server.player4CStam - 1;
				
				server.input("Player1Subtract 1");
				server.input("Player2Subtract 1");
				server.input("Player3Subtract 1");
				server.input("Player4Subtract 1");
			}
		});
		
		dall3 = new JButton("");
		dall3.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/5-.jpg")));
		dall3.setPressedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/5-p.jpg")));
		dall3.setContentAreaFilled(false);
		dall3.setBorderPainted(false);
		dall3.setBounds(440, 45, 40, 20);
		dall3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				dall3.setSelected(true);
				timer.schedule(new TimerTask() {
					
					@Override
					public void run()
					{
						dall3.setSelected(false);
					}
				}, 100L);
				
				server.player1CStam = server.player1CStam - 5;
				server.player2CStam = server.player2CStam - 5;
				server.player3CStam = server.player3CStam - 5;
				server.player4CStam = server.player4CStam - 5;
				
				server.input("Player1Subtract 5");
				server.input("Player2Subtract 5");
				server.input("Player3Subtract 5");
				server.input("Player4Subtract 5");
			}
		});
		
		dall5 = new JButton("");
		dall5.setIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/10-.jpg")));
		dall5.setPressedIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/Stamina/10-p.jpg")));
		dall5.setContentAreaFilled(false);
		dall5.setBorderPainted(false);
		dall5.setBounds(480, 45, 40, 20);
		dall5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				dall5.setSelected(true);
				timer.schedule(new TimerTask() {
					
					@Override
					public void run()
					{
						dall5.setSelected(false);
					}
				}, 100L);
				
				server.player1CStam = server.player1CStam - 10;
				server.player2CStam = server.player2CStam - 10;
				server.player3CStam = server.player3CStam - 10;
				server.player4CStam = server.player4CStam - 10;
				
				server.input("Player1Subtract 10");
				server.input("Player2Subtract 10");
				server.input("Player3Subtract 10");
				server.input("Player4Subtract 10");
			}
		});
		
		g1 = new GMAP();
		g1.add(this, contentPane, 1, XOne, YOne);
		
		g2 = new GMAP();
		g2.add(this, contentPane, 2, XTwo, YOne);
		
		g3 = new GMAP();
		g3.add(this, contentPane, 3, XOne, YTwo);
		
		g4 = new GMAP();
		g4.add(this, contentPane, 4, XTwo, YTwo);
		
		contentPane.add(lblEP);
		contentPane.add(p1);
		contentPane.add(p2);
		contentPane.add(p3);
		contentPane.add(p4);
		contentPane.add(ha);
		contentPane.add(nr);
		contentPane.add(halllbl);
		contentPane.add(dalllbl);
		contentPane.add(hall1);
		contentPane.add(hall3);
		contentPane.add(hall5);
		contentPane.add(dall1);
		contentPane.add(dall3);
		contentPane.add(dall5);
		
		frame.setVisible(true);
		
		JLabel background = new JLabel();
		background.setBounds(0, 0, contentPane.getWidth(), contentPane.getHeight());
		background.setIcon(new ImageIcon(new ImageIcon(ServerGMUI.class.getResource("/resources/GMUI/GMUIBackground.jpg")).getImage()
				.getScaledInstance(background.getWidth(), background.getHeight(), Image.SCALE_SMOOTH)));
		contentPane.add(background);
	}
	
	/*
	 * public void actionsTab(JMenu menu, int player) { JMenu a1 = new
	 * JMenu("Action 1"); for (JButton button : actionSwapper(player, 1))
	 * a1.add(button); menu.add(a1); }
	 * 
	 * public JButton[] actionSwapper(final int player, final int number) { JButton
	 * move = new JButton(); move.setIcon(new ImageIcon(new
	 * ImageIcon(UI.class.getResource("/resources/UI/move.png")).getImage()
	 * .getScaledInstance(40, 40, Image.SCALE_SMOOTH))); move.setSize(40, 40);
	 * move.setBorderPainted(false); move.setContentAreaFilled(false);
	 * move.addActionListener(new ActionListener() {
	 * 
	 * @Override public void actionPerformed(ActionEvent arg0) {
	 * server.input("SetPlayer" + player + "Action" + number + " MOVE");
	 * actionTypes.replace("p" + player + "a" + number, "MOVE"); swap(player,
	 * number, "move"); } });
	 * 
	 * JButton normal = new JButton(); normal.setIcon(new ImageIcon(new
	 * ImageIcon(UI.class.getResource("/resources/UI/action.png")).getImage()
	 * .getScaledInstance(40, 40, Image.SCALE_SMOOTH))); normal.setSize(40, 40);
	 * normal.setBorderPainted(false); normal.setContentAreaFilled(false);
	 * normal.addActionListener(new ActionListener() {
	 * 
	 * @Override public void actionPerformed(ActionEvent arg0) {
	 * server.input("SetPlayer" + player + "Action" + number + " NORMAL");
	 * actionTypes.replace("p" + player + "a" + number, "NORMAL"); swap(player,
	 * number, "action"); } });
	 * 
	 * JButton anytime = new JButton(); anytime.setIcon(new ImageIcon(new
	 * ImageIcon(UI.class.getResource("/resources/UI/action.png")).getImage()
	 * .getScaledInstance(40, 40, Image.SCALE_SMOOTH))); anytime.setSize(40, 40);
	 * anytime.setBorderPainted(false); anytime.setContentAreaFilled(false);
	 * anytime.addActionListener(new ActionListener() {
	 * 
	 * @Override public void actionPerformed(ActionEvent arg0) {
	 * server.input("SetPlayer" + player + "Action" + number + " ANYTIME");
	 * actionTypes.replace("p" + player + "a" + number, "ANYTIME"); swap(player,
	 * number, "anytime"); } });
	 * 
	 * return new JButton[] { move, normal, anytime }; }
	 * 
	 * public void swap(int player, int number, String type) { if (player == 1) { if
	 * (number == 1) player1Action1 .setIcon(new ImageIcon(new
	 * ImageIcon(UI.class.getResource("/resources/UI/" + type + ".png"))
	 * .getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH))); else if (number
	 * == 2) player1Action2 .setIcon(new ImageIcon(new
	 * ImageIcon(UI.class.getResource("/resources/UI/" + type + ".png"))
	 * .getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH))); else if (number
	 * == 3) player1Action3 .setIcon(new ImageIcon(new
	 * ImageIcon(UI.class.getResource("/resources/UI/" + type + ".png"))
	 * .getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH))); else if (number
	 * == 4) player1Action4 .setIcon(new ImageIcon(new
	 * ImageIcon(UI.class.getResource("/resources/UI/" + type + ".png"))
	 * .getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH))); else if (number
	 * == 5) player1Action5 .setIcon(new ImageIcon(new
	 * ImageIcon(UI.class.getResource("/resources/UI/" + type + ".png"))
	 * .getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH))); else if (number
	 * == 6) player1Action6 .setIcon(new ImageIcon(new
	 * ImageIcon(UI.class.getResource("/resources/UI/" + type + ".png"))
	 * .getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH))); else if (number
	 * == 7) player1Action7 .setIcon(new ImageIcon(new
	 * ImageIcon(UI.class.getResource("/resources/UI/" + type + ".png"))
	 * .getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH))); else if (number
	 * == 8) player1Action8 .setIcon(new ImageIcon(new
	 * ImageIcon(UI.class.getResource("/resources/UI/" + type + ".png"))
	 * .getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH))); } else if
	 * (player == 2) { if (number == 1) player2Action1 .setIcon(new ImageIcon(new
	 * ImageIcon(UI.class.getResource("/resources/UI/" + type + ".png"))
	 * .getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH))); else if (number
	 * == 2) player2Action2 .setIcon(new ImageIcon(new
	 * ImageIcon(UI.class.getResource("/resources/UI/" + type + ".png"))
	 * .getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH))); else if (number
	 * == 3) player2Action3 .setIcon(new ImageIcon(new
	 * ImageIcon(UI.class.getResource("/resources/UI/" + type + ".png"))
	 * .getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH))); else if (number
	 * == 4) player2Action4 .setIcon(new ImageIcon(new
	 * ImageIcon(UI.class.getResource("/resources/UI/" + type + ".png"))
	 * .getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH))); else if (number
	 * == 5) player2Action5 .setIcon(new ImageIcon(new
	 * ImageIcon(UI.class.getResource("/resources/UI/" + type + ".png"))
	 * .getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH))); else if (number
	 * == 6) player2Action6 .setIcon(new ImageIcon(new
	 * ImageIcon(UI.class.getResource("/resources/UI/" + type + ".png"))
	 * .getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH))); else if (number
	 * == 7) player2Action7 .setIcon(new ImageIcon(new
	 * ImageIcon(UI.class.getResource("/resources/UI/" + type + ".png"))
	 * .getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH))); else if (number
	 * == 8) player2Action8 .setIcon(new ImageIcon(new
	 * ImageIcon(UI.class.getResource("/resources/UI/" + type + ".png"))
	 * .getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH))); } else if
	 * (player == 3) { if (number == 1) player3Action1 .setIcon(new ImageIcon(new
	 * ImageIcon(UI.class.getResource("/resources/UI/" + type + ".png"))
	 * .getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH))); else if (number
	 * == 2) player3Action2 .setIcon(new ImageIcon(new
	 * ImageIcon(UI.class.getResource("/resources/UI/" + type + ".png"))
	 * .getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH))); else if (number
	 * == 3) player3Action3 .setIcon(new ImageIcon(new
	 * ImageIcon(UI.class.getResource("/resources/UI/" + type + ".png"))
	 * .getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH))); else if (number
	 * == 4) player3Action4 .setIcon(new ImageIcon(new
	 * ImageIcon(UI.class.getResource("/resources/UI/" + type + ".png"))
	 * .getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH))); else if (number
	 * == 5) player3Action5 .setIcon(new ImageIcon(new
	 * ImageIcon(UI.class.getResource("/resources/UI/" + type + ".png"))
	 * .getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH))); else if (number
	 * == 6) player3Action6 .setIcon(new ImageIcon(new
	 * ImageIcon(UI.class.getResource("/resources/UI/" + type + ".png"))
	 * .getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH))); else if (number
	 * == 7) player3Action7 .setIcon(new ImageIcon(new
	 * ImageIcon(UI.class.getResource("/resources/UI/" + type + ".png"))
	 * .getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH))); else if (number
	 * == 8) player3Action8 .setIcon(new ImageIcon(new
	 * ImageIcon(UI.class.getResource("/resources/UI/" + type + ".png"))
	 * .getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH))); } else if
	 * (player == 2) { if (number == 1) player4Action1 .setIcon(new ImageIcon(new
	 * ImageIcon(UI.class.getResource("/resources/UI/" + type + ".png"))
	 * .getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH))); else if (number
	 * == 2) player4Action2 .setIcon(new ImageIcon(new
	 * ImageIcon(UI.class.getResource("/resources/UI/" + type + ".png"))
	 * .getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH))); else if (number
	 * == 3) player4Action3 .setIcon(new ImageIcon(new
	 * ImageIcon(UI.class.getResource("/resources/UI/" + type + ".png"))
	 * .getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH))); else if (number
	 * == 4) player4Action4 .setIcon(new ImageIcon(new
	 * ImageIcon(UI.class.getResource("/resources/UI/" + type + ".png"))
	 * .getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH))); else if (number
	 * == 5) player4Action5 .setIcon(new ImageIcon(new
	 * ImageIcon(UI.class.getResource("/resources/UI/" + type + ".png"))
	 * .getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH))); else if (number
	 * == 6) player4Action6 .setIcon(new ImageIcon(new
	 * ImageIcon(UI.class.getResource("/resources/UI/" + type + ".png"))
	 * .getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH))); else if (number
	 * == 7) player4Action7 .setIcon(new ImageIcon(new
	 * ImageIcon(UI.class.getResource("/resources/UI/" + type + ".png"))
	 * .getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH))); else if (number
	 * == 8) player4Action8 .setIcon(new ImageIcon(new
	 * ImageIcon(UI.class.getResource("/resources/UI/" + type + ".png"))
	 * .getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH))); } }
	 */
	
}
