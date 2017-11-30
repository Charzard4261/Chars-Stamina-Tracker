package client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.Font;

public class UI {

	@SuppressWarnings("unused")
	private JFrame oldframe;
	private JFrame frame;
	private JPanel contentPane;

	public JProgressBar player1StaminaBar = new JProgressBar();
	private JLabel p1Image = new JLabel("");
	public JProgressBar player1Companion1 = new JProgressBar();
	public JProgressBar player1Companion2 = new JProgressBar();
	public JProgressBar player1Companion3 = new JProgressBar();
	private final JLabel p1Gold = new JLabel("");
	private final JLabel p1Goldlbl = new JLabel("0");
	private JButton player1Action1 = new JButton("");
	private JLabel slotPlayer1Action1 = new JLabel("");
	private JButton player1Action2 = new JButton("");
	private JLabel slotPlayer1Action2 = new JLabel("");
	private JButton player1Action3 = new JButton("");
	private JLabel slotPlayer1Action3 = new JLabel("");
	private JButton player1Action4 = new JButton("");
	private JLabel slotPlayer1Action4 = new JLabel("");
	private JButton player1Action5 = new JButton("");
	private JLabel slotPlayer1Action5 = new JLabel("");

	public JProgressBar player2StaminaBar = new JProgressBar();
	private JLabel p2Image = new JLabel("");
	public JProgressBar player2Companion1 = new JProgressBar();
	public JProgressBar player2Companion2 = new JProgressBar();
	public JProgressBar player2Companion3 = new JProgressBar();
	private final JLabel p2Gold = new JLabel("");
	private final JLabel p2Goldlbl = new JLabel("0");
	private JButton player2Action1 = new JButton("");
	private JLabel slotPlayer2Action1 = new JLabel("");
	private JButton player2Action2 = new JButton("");
	private JLabel slotPlayer2Action2 = new JLabel("");
	private JButton player2Action3 = new JButton("");
	private JLabel slotPlayer2Action3 = new JLabel("");
	private JButton player2Action4 = new JButton("");
	private JLabel slotPlayer2Action4 = new JLabel("");
	private JButton player2Action5 = new JButton("");
	private JLabel slotPlayer2Action5 = new JLabel("");

	public JProgressBar player3StaminaBar = new JProgressBar();
	private JLabel p3Image = new JLabel("");
	public JProgressBar player3Companion1 = new JProgressBar();
	public JProgressBar player3Companion2 = new JProgressBar();
	public JProgressBar player3Companion3 = new JProgressBar();
	private final JLabel p3Gold = new JLabel("");
	private final JLabel p3Goldlbl = new JLabel("0");
	private JButton player3Action1 = new JButton("");
	private JLabel slotPlayer3Action1 = new JLabel("");
	private JButton player3Action2 = new JButton("");
	private JLabel slotPlayer3Action2 = new JLabel("");
	private JButton player3Action3 = new JButton("");
	private JLabel slotPlayer3Action3 = new JLabel("");
	private JButton player3Action4 = new JButton("");
	private JLabel slotPlayer3Action4 = new JLabel("");
	private JButton player3Action5 = new JButton("");
	private JLabel slotPlayer3Action5 = new JLabel("");

	public JProgressBar player4StaminaBar = new JProgressBar();
	private JLabel p4Image = new JLabel("");
	public JProgressBar player4Companion1 = new JProgressBar();
	public JProgressBar player4Companion2 = new JProgressBar();
	public JProgressBar player4Companion3 = new JProgressBar();
	private final JLabel p4Gold = new JLabel("");
	private final JLabel p4Goldlbl = new JLabel("0");
	private JButton player4Action1 = new JButton("");
	private JLabel slotPlayer4Action1 = new JLabel("");
	private JButton player4Action2 = new JButton("");
	private JLabel slotPlayer4Action2 = new JLabel("");
	private JButton player4Action3 = new JButton("");
	private JLabel slotPlayer4Action3 = new JLabel("");
	private JButton player4Action4 = new JButton("");
	private JLabel slotPlayer4Action4 = new JLabel("");
	private JButton player4Action5 = new JButton("");
	private JLabel slotPlayer4Action5 = new JLabel("");

	Client c;

	public UI()
	{
		frame = new JFrame();
		frame.setUndecorated(true);
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run()
			{
				init();
			}
		});
	}

	public void print(String s)
	{
		System.out.println(s);
	}

	public void init()
	{
		frame.setSize(new Dimension(1920, 200));
		frame.setAlwaysOnTop(true);
		frame.setTitle("URealms");
		frame.setAlwaysOnTop(true);
		frame.setSize(1920, 200);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(new ImageIcon(UI.class
				.getResource("/resources/UI/URLogo.png")).getImage());
		GraphicsEnvironment ge = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
		Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
		int x = 0;
		int y = (int) rect.getMaxY() - frame.getHeight() - 40;
		frame.setLocation(x, y);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		/**
		 * PLAYER 1
		 **/
		{
			player1StaminaBar.setBorder(new CompoundBorder(new MatteBorder(2,
					1, 2, 1, (Color) new Color(64, 64, 64)), new EtchedBorder(
					EtchedBorder.LOWERED, new Color(128, 128, 128), null)));
			player1StaminaBar.setVisible(false);
			player1StaminaBar.setForeground(Color.GREEN);
			player1StaminaBar.setBounds(285, 20, 130, 15);
			player1StaminaBar.setMaximum(10);
			player1StaminaBar.setValue(10);
			contentPane.add(player1StaminaBar);

			p1Image.setBounds(285, 33, 130, 93);
			p1Image.setVisible(false);
			contentPane.add(p1Image);

			player1Companion1.setFont(new Font("Tahoma", Font.PLAIN, 99));
			player1Companion1.setStringPainted(true);
			player1Companion1.setString("");
			player1Companion1.setForeground(new Color(255, 255, 0));
			player1Companion1.setBorder(new CompoundBorder(new MatteBorder(2,
					1, 2, 1, (Color) new Color(64, 64, 64)), new EtchedBorder(
					EtchedBorder.LOWERED, new Color(128, 128, 128), null)));
			player1Companion1.setMaximum(10);
			player1Companion1.setValue(10);
			player1Companion1.setVisible(false);
			player1Companion1.setBounds(410, 45, 100, 15);
			contentPane.add(player1Companion1);

			player1Companion2.setFont(new Font("Tahoma", Font.PLAIN, 99));
			player1Companion2.setStringPainted(true);
			player1Companion2.setString("");
			player1Companion2.setForeground(new Color(255, 165, 0));
			player1Companion2.setBorder(new CompoundBorder(new MatteBorder(2,
					1, 2, 1, (Color) new Color(64, 64, 64)), new EtchedBorder(
					EtchedBorder.LOWERED, new Color(128, 128, 128), null)));
			player1Companion2.setMaximum(10);
			player1Companion2.setValue(10);
			player1Companion2.setVisible(false);
			player1Companion2.setBounds(410, 60, 100, 15);
			contentPane.add(player1Companion2);

			JProgressBar player1Companion3 = new JProgressBar();
			player1Companion3.setFont(new Font("Tahoma", Font.PLAIN, 99));
			player1Companion3.setStringPainted(true);
			player1Companion3.setString("");
			player1Companion3.setForeground(new Color(255, 0, 0));
			player1Companion3.setBorder(new CompoundBorder(new MatteBorder(2,
					1, 2, 1, (Color) new Color(64, 64, 64)), new EtchedBorder(
					EtchedBorder.LOWERED, new Color(128, 128, 128), null)));
			player1Companion3.setMaximum(10);
			player1Companion3.setValue(10);
			player1Companion3.setVisible(false);
			player1Companion3.setBounds(410, 75, 100, 15);
			contentPane.add(player1Companion3);

			p1Goldlbl.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			p1Goldlbl.setOpaque(true);
			p1Goldlbl.setBackground(Color.DARK_GRAY);
			p1Goldlbl.setForeground(Color.ORANGE);
			p1Goldlbl.setHorizontalAlignment(SwingConstants.TRAILING);
			p1Goldlbl.setBounds(235, 95, 40, 12);
			p1Goldlbl.setVisible(false);
			contentPane.add(p1Goldlbl);

			p1Gold.setIcon(new ImageIcon(new ImageIcon(UI.class
					.getResource("/resources/UI/gold.png")).getImage()
					.getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
			p1Gold.setBounds(240, 70, 30, 30);
			p1Gold.setVisible(false);
			contentPane.add(p1Gold);
		}
		player1Action1.setBorderPainted(false);
		player1Action1.setContentAreaFilled(false);
		player1Action1.setVisible(false);
		player1Action1.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/move.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		player1Action1.setSelectedIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/null.png")));
		player1Action1.setBounds(240, 110, 60, 60);
		contentPane.add(player1Action1);

		slotPlayer1Action1.setVisible(false);
		slotPlayer1Action1.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/slot.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		slotPlayer1Action1.setBounds(240, 110, 60, 60);
		contentPane.add(slotPlayer1Action1);

		player1Action2.setBorderPainted(false);
		player1Action2.setContentAreaFilled(false);
		player1Action2.setVisible(false);
		player1Action2.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/action.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		player1Action2.setSelectedIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/null.png")));
		player1Action2.setBounds(280, 110, 60, 60);
		contentPane.add(player1Action2);

		slotPlayer1Action2.setVisible(false);
		slotPlayer1Action2.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/slot.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		slotPlayer1Action2.setBounds(280, 110, 60, 60);
		contentPane.add(slotPlayer1Action2);

		player1Action3.setBorderPainted(false);
		player1Action3.setContentAreaFilled(false);
		player1Action3.setVisible(false);
		player1Action3.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/anytime.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		player1Action3.setSelectedIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/null.png")));
		player1Action3.setBounds(320, 110, 60, 60);
		contentPane.add(player1Action3);

		slotPlayer1Action3.setVisible(false);
		slotPlayer1Action3.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/slot.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		slotPlayer1Action3.setBounds(320, 110, 60, 60);
		contentPane.add(slotPlayer1Action3);

		player1Action4.setContentAreaFilled(false);
		player1Action4.setBorderPainted(false);
		player1Action4.setVisible(false);
		player1Action4.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/anytime.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		player1Action4.setSelectedIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/null.png")));
		player1Action4.setBounds(360, 110, 60, 60);
		contentPane.add(player1Action4);

		slotPlayer1Action4.setVisible(false);
		slotPlayer1Action4.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/slot.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		slotPlayer1Action4.setBounds(360, 110, 60, 60);
		contentPane.add(slotPlayer1Action4);

		player1Action5.setContentAreaFilled(false);
		player1Action5.setBorderPainted(false);
		player1Action5.setVisible(false);
		player1Action5.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/anytime.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		player1Action5.setSelectedIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/null.png")));
		player1Action5.setBounds(400, 110, 60, 60);
		contentPane.add(player1Action5);

		slotPlayer1Action5.setVisible(false);
		slotPlayer1Action5.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/slot.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		slotPlayer1Action5.setBounds(400, 110, 60, 60);
		contentPane.add(slotPlayer1Action5);
		/**
		 * PLAYER 2
		 **/
		{
			player2StaminaBar.setBorder(new CompoundBorder(new MatteBorder(2,
					1, 2, 1, (Color) new Color(64, 64, 64)), new EtchedBorder(
					EtchedBorder.LOWERED, new Color(128, 128, 128), null)));
			player2StaminaBar.setVisible(false);
			player2StaminaBar.setForeground(Color.GREEN);
			player2StaminaBar.setBounds(585, 20, 130, 15);
			player2StaminaBar.setMaximum(10);
			player2StaminaBar.setValue(10);
			contentPane.add(player2StaminaBar);

			p2Image.setBounds(585, 33, 130, 93);
			p2Image.setVisible(false);
			contentPane.add(p2Image);
			p2Goldlbl.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			p2Goldlbl.setOpaque(true);

			player2Companion1.setFont(new Font("Tahoma", Font.PLAIN, 99));
			player2Companion1.setStringPainted(true);
			player2Companion1.setString("");
			player2Companion1.setForeground(new Color(255, 255, 0));
			player2Companion1.setBorder(new CompoundBorder(new MatteBorder(2,
					1, 2, 1, (Color) new Color(64, 64, 64)), new EtchedBorder(
					EtchedBorder.LOWERED, new Color(128, 128, 128), null)));
			player2Companion1.setMaximum(10);
			player2Companion1.setValue(10);
			player2Companion1.setVisible(false);
			player2Companion1.setBounds(710, 45, 100, 15);
			contentPane.add(player2Companion1);

			player2Companion2.setFont(new Font("Tahoma", Font.PLAIN, 99));
			player2Companion2.setStringPainted(true);
			player2Companion2.setString("");
			player2Companion2.setForeground(new Color(255, 165, 0));
			player2Companion2.setBorder(new CompoundBorder(new MatteBorder(2,
					1, 2, 1, (Color) new Color(64, 64, 64)), new EtchedBorder(
					EtchedBorder.LOWERED, new Color(128, 128, 128), null)));
			player2Companion2.setMaximum(10);
			player2Companion2.setValue(10);
			player2Companion2.setVisible(false);
			player2Companion2.setBounds(710, 60, 100, 15);
			contentPane.add(player2Companion2);

			JProgressBar player2Companion3 = new JProgressBar();
			player2Companion3.setFont(new Font("Tahoma", Font.PLAIN, 99));
			player2Companion3.setStringPainted(true);
			player2Companion3.setString("");
			player2Companion3.setForeground(new Color(255, 0, 0));
			player2Companion3.setBorder(new CompoundBorder(new MatteBorder(2,
					1, 2, 1, (Color) new Color(64, 64, 64)), new EtchedBorder(
					EtchedBorder.LOWERED, new Color(128, 128, 128), null)));
			player2Companion3.setMaximum(10);
			player2Companion3.setValue(10);
			player2Companion3.setVisible(false);
			player2Companion3.setBounds(710, 75, 100, 15);
			contentPane.add(player2Companion3);

			p2Goldlbl.setBackground(Color.DARK_GRAY);
			p2Goldlbl.setForeground(Color.ORANGE);
			p2Goldlbl.setHorizontalAlignment(SwingConstants.TRAILING);
			p2Goldlbl.setBounds(535, 95, 40, 12);
			p2Goldlbl.setVisible(false);
			contentPane.add(p2Goldlbl);

			p2Gold.setIcon(new ImageIcon(new ImageIcon(UI.class
					.getResource("/resources/UI/gold.png")).getImage()
					.getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
			p2Gold.setBounds(540, 70, 30, 30);
			p2Gold.setVisible(false);
			contentPane.add(p2Gold);
		}
		player2Action1.setBorderPainted(false);
		player2Action1.setContentAreaFilled(false);
		player2Action1.setVisible(false);
		player2Action1.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/move.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		player2Action1.setSelectedIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/null.png")));
		player2Action1.setBounds(540, 110, 60, 60);
		contentPane.add(player2Action1);

		slotPlayer2Action1.setVisible(false);
		slotPlayer2Action1.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/slot.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		slotPlayer2Action1.setBounds(540, 110, 60, 60);
		contentPane.add(slotPlayer2Action1);

		player2Action2.setBorderPainted(false);
		player2Action2.setContentAreaFilled(false);
		player2Action2.setVisible(false);
		player2Action2.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/action.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		player2Action2.setSelectedIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/null.png")));
		player2Action2.setBounds(580, 110, 60, 60);
		contentPane.add(player2Action2);

		slotPlayer2Action2.setVisible(false);
		slotPlayer2Action2.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/slot.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		slotPlayer2Action2.setBounds(580, 110, 60, 60);
		contentPane.add(slotPlayer2Action2);

		player2Action3.setBorderPainted(false);
		player2Action3.setContentAreaFilled(false);
		player2Action3.setVisible(false);
		player2Action3.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/anytime.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		player2Action3.setSelectedIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/null.png")));
		player2Action3.setBounds(620, 110, 60, 60);
		contentPane.add(player2Action3);

		slotPlayer2Action3.setVisible(false);
		slotPlayer2Action3.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/slot.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		slotPlayer2Action3.setBounds(620, 110, 60, 60);
		contentPane.add(slotPlayer2Action3);

		player2Action4.setBorderPainted(false);
		player2Action4.setContentAreaFilled(false);
		player2Action4.setVisible(false);
		player2Action4.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/anytime.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		player2Action4.setSelectedIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/null.png")));
		player2Action4.setBounds(660, 110, 60, 60);
		contentPane.add(player2Action4);

		slotPlayer2Action4.setVisible(false);
		slotPlayer2Action4.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/slot.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		slotPlayer2Action4.setBounds(660, 110, 60, 60);
		contentPane.add(slotPlayer2Action4);

		player2Action5.setBorderPainted(false);
		player2Action5.setContentAreaFilled(false);
		player2Action5.setVisible(false);
		player2Action5.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/anytime.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		player2Action5.setSelectedIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/null.png")));
		player2Action5.setBounds(700, 110, 60, 60);
		contentPane.add(player2Action5);

		slotPlayer2Action5.setVisible(false);
		slotPlayer2Action5.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/slot.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		slotPlayer2Action5.setBounds(700, 110, 60, 60);
		contentPane.add(slotPlayer2Action5);

		/**
		 * PLAYER 3
		 **/
		{
			player3StaminaBar.setBorder(new CompoundBorder(new MatteBorder(2,
					1, 2, 1, (Color) new Color(64, 64, 64)), new EtchedBorder(
					EtchedBorder.LOWERED, new Color(128, 128, 128), null)));
			player3StaminaBar.setVisible(false);
			player3StaminaBar.setForeground(Color.GREEN);
			player3StaminaBar.setBounds(885, 20, 130, 15);
			player3StaminaBar.setMaximum(10);
			player3StaminaBar.setValue(10);
			contentPane.add(player3StaminaBar);

			p3Image.setBounds(885, 33, 130, 93);
			p3Image.setVisible(false);
			contentPane.add(p3Image);
			p3Goldlbl.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			p3Goldlbl.setOpaque(true);

			player3Companion1.setFont(new Font("Tahoma", Font.PLAIN, 99));
			player3Companion1.setStringPainted(true);
			player3Companion1.setString("");
			player3Companion1.setForeground(new Color(255, 255, 0));
			player3Companion1.setBorder(new CompoundBorder(new MatteBorder(2,
					1, 2, 1, (Color) new Color(64, 64, 64)), new EtchedBorder(
					EtchedBorder.LOWERED, new Color(128, 128, 128), null)));
			player3Companion1.setMaximum(10);
			player3Companion1.setValue(10);
			player3Companion1.setVisible(false);
			player3Companion1.setBounds(1010, 45, 100, 15);
			contentPane.add(player3Companion1);

			player3Companion2.setFont(new Font("Tahoma", Font.PLAIN, 99));
			player3Companion2.setStringPainted(true);
			player3Companion2.setString("");
			player3Companion2.setForeground(new Color(255, 165, 0));
			player3Companion2.setBorder(new CompoundBorder(new MatteBorder(2,
					1, 2, 1, (Color) new Color(64, 64, 64)), new EtchedBorder(
					EtchedBorder.LOWERED, new Color(128, 128, 128), null)));
			player3Companion2.setMaximum(10);
			player3Companion2.setValue(10);
			player3Companion2.setVisible(false);
			player3Companion2.setBounds(1010, 60, 100, 15);
			contentPane.add(player3Companion2);

			JProgressBar player3Companion3 = new JProgressBar();
			player3Companion3.setFont(new Font("Tahoma", Font.PLAIN, 99));
			player3Companion3.setStringPainted(true);
			player3Companion3.setString("");
			player3Companion3.setForeground(new Color(255, 0, 0));
			player3Companion3.setBorder(new CompoundBorder(new MatteBorder(2,
					1, 2, 1, (Color) new Color(64, 64, 64)), new EtchedBorder(
					EtchedBorder.LOWERED, new Color(128, 128, 128), null)));
			player3Companion3.setMaximum(10);
			player3Companion3.setValue(10);
			player3Companion3.setVisible(false);
			player3Companion3.setBounds(1010, 75, 100, 15);
			contentPane.add(player3Companion3);

			p3Goldlbl.setBackground(Color.DARK_GRAY);
			p3Goldlbl.setForeground(Color.ORANGE);
			p3Goldlbl.setHorizontalAlignment(SwingConstants.TRAILING);
			p3Goldlbl.setBounds(835, 95, 40, 12);
			p3Goldlbl.setVisible(false);
			contentPane.add(p3Goldlbl);

			p3Gold.setIcon(new ImageIcon(new ImageIcon(UI.class
					.getResource("/resources/UI/gold.png")).getImage()
					.getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
			p3Gold.setBounds(840, 70, 30, 30);
			p3Gold.setVisible(false);
			contentPane.add(p3Gold);
		}
		player3Action1.setBorderPainted(false);
		player3Action1.setContentAreaFilled(false);
		player3Action1.setVisible(false);
		player3Action1.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/move.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		player3Action1.setSelectedIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/null.png")));
		player3Action1.setBounds(840, 110, 60, 60);
		contentPane.add(player3Action1);

		slotPlayer3Action1.setVisible(false);
		slotPlayer3Action1.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/slot.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		slotPlayer3Action1.setBounds(840, 110, 60, 60);
		contentPane.add(slotPlayer3Action1);

		player3Action2.setBorderPainted(false);
		player3Action2.setContentAreaFilled(false);
		player3Action2.setVisible(false);
		player3Action2.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/action.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		player3Action2.setSelectedIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/null.png")));
		player3Action2.setBounds(880, 110, 60, 60);
		contentPane.add(player3Action2);

		slotPlayer3Action2.setVisible(false);
		slotPlayer3Action2.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/slot.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		slotPlayer3Action2.setBounds(880, 110, 60, 60);
		contentPane.add(slotPlayer3Action2);

		player3Action3.setBorderPainted(false);
		player3Action3.setContentAreaFilled(false);
		player3Action3.setVisible(false);
		player3Action3.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/anytime.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		player3Action3.setSelectedIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/null.png")));
		player3Action3.setBounds(920, 110, 60, 60);
		contentPane.add(player3Action3);

		slotPlayer3Action3.setVisible(false);
		slotPlayer3Action3.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/slot.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		slotPlayer3Action3.setBounds(920, 110, 60, 60);
		contentPane.add(slotPlayer3Action3);

		player3Action4.setBorderPainted(false);
		player3Action4.setContentAreaFilled(false);
		player3Action4.setVisible(false);
		player3Action4.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/anytime.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		player3Action4.setSelectedIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/null.png")));
		player3Action4.setBounds(960, 110, 60, 60);
		contentPane.add(player3Action4);

		slotPlayer3Action4.setVisible(false);
		slotPlayer3Action4.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/slot.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		slotPlayer3Action4.setBounds(960, 110, 60, 60);
		contentPane.add(slotPlayer3Action4);

		player3Action5.setBorderPainted(false);
		player3Action5.setContentAreaFilled(false);
		player3Action5.setVisible(false);
		player3Action5.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/anytime.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		player3Action5.setSelectedIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/null.png")));
		player3Action5.setBounds(1000, 110, 60, 60);
		contentPane.add(player3Action5);

		slotPlayer3Action5.setVisible(false);
		slotPlayer3Action5.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/slot.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		slotPlayer3Action5.setBounds(1000, 110, 60, 60);
		contentPane.add(slotPlayer3Action5);

		/**
		 * PLAYER 4
		 **/
		{
			player4StaminaBar.setBorder(new CompoundBorder(new MatteBorder(2,
					1, 2, 1, (Color) new Color(64, 64, 64)), new EtchedBorder(
					EtchedBorder.LOWERED, new Color(128, 128, 128), null)));
			player4StaminaBar.setVisible(false);
			player4StaminaBar.setForeground(Color.GREEN);
			player4StaminaBar.setBounds(1185, 20, 130, 15);
			player4StaminaBar.setMaximum(10);
			player4StaminaBar.setValue(10);
			contentPane.add(player4StaminaBar);

			p4Image.setBounds(1185, 33, 130, 93);
			p4Image.setVisible(false);
			contentPane.add(p4Image);
			p4Goldlbl.setOpaque(true);
			p4Goldlbl.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));

			player4Companion1.setFont(new Font("Tahoma", Font.PLAIN, 99));
			player4Companion1.setStringPainted(true);
			player4Companion1.setString("");
			player4Companion1.setForeground(new Color(255, 255, 0));
			player4Companion1.setBorder(new CompoundBorder(new MatteBorder(2,
					1, 2, 1, (Color) new Color(64, 64, 64)), new EtchedBorder(
					EtchedBorder.LOWERED, new Color(128, 128, 128), null)));
			player4Companion1.setMaximum(10);
			player4Companion1.setValue(10);
			player4Companion1.setVisible(false);
			player4Companion1.setBounds(1310, 45, 100, 15);
			contentPane.add(player4Companion1);

			player4Companion2.setFont(new Font("Tahoma", Font.PLAIN, 99));
			player4Companion2.setStringPainted(true);
			player4Companion2.setString("");
			player4Companion2.setForeground(new Color(255, 165, 0));
			player4Companion2.setBorder(new CompoundBorder(new MatteBorder(2,
					1, 2, 1, (Color) new Color(64, 64, 64)), new EtchedBorder(
					EtchedBorder.LOWERED, new Color(128, 128, 128), null)));
			player4Companion2.setMaximum(10);
			player4Companion2.setValue(10);
			player4Companion2.setVisible(false);
			player4Companion2.setBounds(1310, 60, 100, 15);
			contentPane.add(player4Companion2);

			JProgressBar player4Companion3 = new JProgressBar();
			player4Companion3.setFont(new Font("Tahoma", Font.PLAIN, 99));
			player4Companion3.setStringPainted(true);
			player4Companion3.setString("");
			player4Companion3.setForeground(new Color(255, 0, 0));
			player4Companion3.setBorder(new CompoundBorder(new MatteBorder(2,
					1, 2, 1, (Color) new Color(64, 64, 64)), new EtchedBorder(
					EtchedBorder.LOWERED, new Color(128, 128, 128), null)));
			player4Companion3.setMaximum(10);
			player4Companion3.setValue(10);
			player4Companion3.setVisible(false);
			player4Companion3.setBounds(1310, 75, 100, 15);
			contentPane.add(player4Companion3);

			p4Goldlbl.setBackground(Color.DARK_GRAY);
			p4Goldlbl.setForeground(Color.ORANGE);
			p4Goldlbl.setHorizontalAlignment(SwingConstants.TRAILING);
			p4Goldlbl.setBounds(1135, 95, 40, 12);
			p4Goldlbl.setVisible(false);
			contentPane.add(p4Goldlbl);

			p4Gold.setIcon(new ImageIcon(new ImageIcon(UI.class
					.getResource("/resources/UI/gold.png")).getImage()
					.getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
			p4Gold.setBounds(1140, 70, 30, 30);
			p4Gold.setVisible(false);
			contentPane.add(p4Gold);
		}

		player4Action1.setBorderPainted(false);
		player4Action1.setContentAreaFilled(false);
		player4Action1.setVisible(false);
		player4Action1.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/move.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		player4Action1.setSelectedIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/null.png")));
		player4Action1.setBounds(1140, 110, 60, 60);
		contentPane.add(player4Action1);

		slotPlayer4Action1.setVisible(false);
		slotPlayer4Action1.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/slot.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		slotPlayer4Action1.setBounds(1140, 110, 60, 60);
		contentPane.add(slotPlayer4Action1);

		player4Action2.setBorderPainted(false);
		player4Action2.setContentAreaFilled(false);
		player4Action2.setVisible(false);
		player4Action2.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/action.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		player4Action2.setSelectedIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/null.png")));
		player4Action2.setBounds(1180, 110, 60, 60);
		contentPane.add(player4Action2);

		slotPlayer4Action2.setVisible(false);
		slotPlayer4Action2.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/slot.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		slotPlayer4Action2.setBounds(1180, 110, 60, 60);
		contentPane.add(slotPlayer4Action2);

		player4Action3.setBorderPainted(false);
		player4Action3.setContentAreaFilled(false);
		player4Action3.setVisible(false);
		player4Action3.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/anytime.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		player4Action3.setSelectedIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/null.png")));
		player4Action3.setBounds(1220, 110, 60, 60);
		contentPane.add(player4Action3);

		slotPlayer4Action3.setVisible(false);
		slotPlayer4Action3.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/slot.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		slotPlayer4Action3.setBounds(1220, 110, 60, 60);
		contentPane.add(slotPlayer4Action3);

		player4Action4.setBorderPainted(false);
		player4Action4.setContentAreaFilled(false);
		player4Action4.setVisible(false);
		player4Action4.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/anytime.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		player4Action4.setSelectedIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/null.png")));
		player4Action4.setBounds(1260, 110, 60, 60);
		contentPane.add(player4Action4);

		slotPlayer4Action4.setVisible(false);
		slotPlayer4Action4.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/slot.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		slotPlayer4Action4.setBounds(1260, 110, 60, 60);
		contentPane.add(slotPlayer4Action4);

		player4Action5.setBorderPainted(false);
		player4Action5.setContentAreaFilled(false);
		player4Action5.setVisible(false);
		player4Action5.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/anytime.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		player4Action5.setSelectedIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/null.png")));
		player4Action5.setBounds(1300, 110, 60, 60);
		contentPane.add(player4Action5);

		slotPlayer4Action5.setVisible(false);
		slotPlayer4Action5.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/slot.png")).getImage()
				.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		slotPlayer4Action5.setBounds(1300, 110, 60, 60);
		contentPane.add(slotPlayer4Action5);

		/**
		 * MISC
		 **/

		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(new ImageIcon(UI.class
				.getResource("/resources/UI/background.png")).getImage()
				.getScaledInstance(1920, 200, Image.SCALE_SMOOTH)));
		background.setBounds(0, 0, 1920, 200);
		contentPane.add(background);

		frame.setVisible(true);
	}

	/**
	 * Enabling Player Sections
	 **/

	public void enablePlayer1()
	{
		player1StaminaBar.setVisible(true);
		p1Image.setVisible(true);
		// player1Companion1.setVisible(true);
		// player1Companion2.setVisible(true);
		// player1Companion3.setVisible(true);
		p1Goldlbl.setVisible(true);
		p1Gold.setVisible(true);
		slotPlayer1Action1.setVisible(true);
		slotPlayer1Action2.setVisible(true);
		slotPlayer1Action3.setVisible(true);
		slotPlayer1Action4.setVisible(true);
		slotPlayer1Action5.setVisible(true);
		player1Action1.setVisible(true);
		player1Action2.setVisible(true);
		player1Action3.setVisible(true);
		player1Action4.setVisible(true);
		player1Action5.setVisible(true);
	}

	public void enablePlayer2()
	{
		player2StaminaBar.setVisible(true);
		p2Image.setVisible(true);
		// player2Companion1.setVisible(true);
		// player2Companion2.setVisible(true);
		// player2Companion3.setVisible(true);
		p2Goldlbl.setVisible(true);
		p2Gold.setVisible(true);
		slotPlayer2Action1.setVisible(true);
		slotPlayer2Action2.setVisible(true);
		slotPlayer2Action3.setVisible(true);
		slotPlayer2Action4.setVisible(true);
		slotPlayer2Action5.setVisible(true);
		player2Action1.setVisible(true);
		player2Action2.setVisible(true);
		player2Action3.setVisible(true);
		player2Action4.setVisible(true);
		player2Action5.setVisible(true);
	}

	public void enablePlayer3()
	{
		player3StaminaBar.setVisible(true);
		p3Image.setVisible(true);
		// player3Companion1.setVisible(true);
		// player3Companion2.setVisible(true);
		// player3Companion3.setVisible(true);
		p3Goldlbl.setVisible(true);
		p3Gold.setVisible(true);
		slotPlayer3Action1.setVisible(true);
		slotPlayer3Action2.setVisible(true);
		slotPlayer3Action3.setVisible(true);
		slotPlayer3Action4.setVisible(true);
		slotPlayer3Action5.setVisible(true);
		player3Action1.setVisible(true);
		player3Action2.setVisible(true);
		player3Action3.setVisible(true);
		player3Action4.setVisible(true);
		player3Action5.setVisible(true);
	}

	public void enablePlayer4()
	{
		player4StaminaBar.setVisible(true);
		p4Image.setVisible(true);
		// player4Companion1.setVisible(true);
		// player4Companion2.setVisible(true);
		// player4Companion3.setVisible(true);
		p4Goldlbl.setVisible(true);
		p4Gold.setVisible(true);
		slotPlayer4Action1.setVisible(true);
		slotPlayer4Action2.setVisible(true);
		slotPlayer4Action3.setVisible(true);
		slotPlayer4Action4.setVisible(true);
		slotPlayer4Action5.setVisible(true);
		player4Action1.setVisible(true);
		player4Action2.setVisible(true);
		player4Action3.setVisible(true);
		player4Action4.setVisible(true);
		player4Action5.setVisible(true);
	}

	/**
	 * Disabling Player Sections
	 **/

	public void disablePlayer1()
	{
		player1StaminaBar.setVisible(false);
		p1Image.setVisible(false);
		// player4Companion1.setVisible(false);
		// player4Companion2.setVisible(false);
		// player4Companion3.setVisible(false);
		p1Goldlbl.setVisible(false);
		p1Gold.setVisible(false);
		slotPlayer1Action1.setVisible(false);
		slotPlayer1Action2.setVisible(false);
		slotPlayer1Action3.setVisible(false);
		slotPlayer1Action4.setVisible(false);
		slotPlayer1Action5.setVisible(false);
		player1Action1.setVisible(false);
		player1Action2.setVisible(false);
		player1Action3.setVisible(false);
		player1Action4.setVisible(false);
		player1Action5.setVisible(false);
	}

	public void disablePlayer2()
	{
		player2StaminaBar.setVisible(false);
		p2Image.setVisible(false);
		// player2Companion1.setVisible(false);
		// player2Companion2.setVisible(false);
		// player2Companion3.setVisible(false);
		p2Goldlbl.setVisible(false);
		p2Gold.setVisible(false);
		slotPlayer2Action1.setVisible(false);
		slotPlayer2Action2.setVisible(false);
		slotPlayer2Action3.setVisible(false);
		slotPlayer2Action4.setVisible(false);
		slotPlayer2Action5.setVisible(false);
		player2Action1.setVisible(false);
		player2Action2.setVisible(false);
		player2Action3.setVisible(false);
		player2Action4.setVisible(false);
		player2Action5.setVisible(false);
	}

	public void disablePlayer3()
	{
		player3StaminaBar.setVisible(false);
		p3Image.setVisible(false);
		// player3Companion1.setVisible(false);
		// player3Companion2.setVisible(false);
		// player3Companion3.setVisible(false);
		p3Goldlbl.setVisible(false);
		p3Gold.setVisible(false);
		slotPlayer3Action1.setVisible(false);
		slotPlayer3Action2.setVisible(false);
		slotPlayer3Action3.setVisible(false);
		slotPlayer3Action4.setVisible(false);
		slotPlayer3Action5.setVisible(false);
		player3Action1.setVisible(false);
		player3Action2.setVisible(false);
		player3Action3.setVisible(false);
		player3Action4.setVisible(false);
		player3Action5.setVisible(false);
	}

	public void disablePlayer4()
	{
		player4StaminaBar.setVisible(false);
		p4Image.setVisible(false);
		// player4Companion1.setVisible(false);
		// player4Companion2.setVisible(false);
		// player4Companion3.setVisible(false);
		p4Goldlbl.setVisible(false);
		p4Gold.setVisible(false);
		slotPlayer4Action1.setVisible(false);
		slotPlayer4Action2.setVisible(false);
		slotPlayer4Action3.setVisible(false);
		slotPlayer4Action4.setVisible(false);
		slotPlayer4Action5.setVisible(false);
		player4Action1.setVisible(false);
		player4Action2.setVisible(false);
		player4Action3.setVisible(false);
		player4Action4.setVisible(false);
		player4Action5.setVisible(false);
	}

	/**
	 * Enabling Companions
	 **/

	public void companion(int player, int companion, boolean b)
	{
		if (player == 1)
		{
			if (companion == 1)
			{
			} else if (companion == 2)
			{
			} else if (companion == 3)
			{
			}
		} else if (player == 2)
		{
		} else if (player == 3)
		{
		} else if (player == 4)
		{
		}
	}

	/**
	 * Setting Player Total Stamina
	 **/

	public void setPlayer1Stam(int i)
	{
		player1StaminaBar.setMaximum(i);
	}

	public void setPlayer2Stam(int i)
	{
		player2StaminaBar.setMaximum(i);
	}

	public void setPlayer3Stam(int i)
	{
		player3StaminaBar.setMaximum(i);
	}

	public void setPlayer4Stam(int i)
	{
		player4StaminaBar.setMaximum(i);
	}

	/**
	 * Setting Player Current Stamina
	 **/

	public void healAll()
	{
		player1StaminaBar.setValue(player1StaminaBar.getMaximum());
		player2StaminaBar.setValue(player2StaminaBar.getMaximum());
		player3StaminaBar.setValue(player3StaminaBar.getMaximum());
		player4StaminaBar.setValue(player4StaminaBar.getMaximum());
	}

	public void setPlayer1CStam(int i)
	{
		player1StaminaBar.setValue(i);
	}

	public void setPlayer2CStam(int i)
	{
		player2StaminaBar.setValue(i);
	}

	public void setPlayer3CStam(int i)
	{
		player3StaminaBar.setValue(i);
	}

	public void setPlayer4CStam(int i)
	{
		player4StaminaBar.setValue(i);
	}

	/**
	 * Setting Player Images
	 **/

	public void setPlayer1Image(String img)
	{
		try
		{
			p1Image.setIcon(new ImageIcon(ImageIO.read(new URL(img))));
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	public void setPlayer2Image(String img)
	{
		try
		{
			p2Image.setIcon(new ImageIcon(ImageIO.read(new URL(img))));
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	public void setPlayer3Image(String img)
	{
		try
		{
			p3Image.setIcon(new ImageIcon(ImageIO.read(new URL(img))));
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	public void setPlayer4Image(String img)
	{
		try
		{
			p4Image.setIcon(new ImageIcon(ImageIO.read(new URL(img))));
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	/**
	 * Setting Player Gold
	 **/

	boolean gAS1;

	public void setPlayer1Gold(int gold, boolean b)
	{
		if (b)
		{
			int i = Integer.valueOf(p1Goldlbl.getText());
			p1Goldlbl.setText("" + (i + gold));
			if (gAS1)
			{
				goldAddSound();
			} else
			{
				gAS1 = true;
				return;
			}
		} else
		{
			int i = Integer.valueOf(p1Goldlbl.getText());
			p1Goldlbl.setText("" + (i - gold));
			goldRemoveSound();
		}
	}

	boolean gAS2;

	public void setPlayer2Gold(int gold, boolean b)
	{
		if (b)
		{
			int i = Integer.valueOf(p2Goldlbl.getText());
			p2Goldlbl.setText("" + (i + gold));
			if (gAS2)
			{
				goldAddSound();
			} else
			{
				gAS2 = true;
				return;
			}
		} else
		{
			int i = Integer.valueOf(p2Goldlbl.getText());
			p2Goldlbl.setText("" + (i - gold));
			goldRemoveSound();
		}
	}

	boolean gAS3;

	public void setPlayer3Gold(int gold, boolean b)
	{
		if (b)
		{
			int i = Integer.valueOf(p3Goldlbl.getText());
			p3Goldlbl.setText("" + (i + gold));
			if (gAS3)
			{
				goldAddSound();
			} else
			{
				gAS3 = true;
				return;
			}
		} else
		{
			int i = Integer.valueOf(p3Goldlbl.getText());
			p3Goldlbl.setText("" + (i - gold));
			goldRemoveSound();
		}
	}

	boolean gAS4;

	public void setPlayer4Gold(int gold, boolean b)
	{
		if (b)
		{
			int i = Integer.valueOf(p4Goldlbl.getText());
			p4Goldlbl.setText("" + (i + gold));
			if (gAS4)
			{
				goldAddSound();
			} else
			{
				gAS4 = true;
				return;
			}
		} else
		{
			int i = Integer.valueOf(p4Goldlbl.getText());
			p4Goldlbl.setText("" + (i - gold));
			goldRemoveSound();
		}
	}

	/**
	 * Setting Player Actions
	 **/

	public void player1Action1(boolean b)
	{
		player1Action1.setSelected(b);
	}

	public void player1Action2(boolean b)
	{
		player1Action2.setSelected(b);
	}

	public void player1Action3(boolean b)
	{
		player1Action3.setSelected(b);
	}

	public void player1Action4(boolean b)
	{
		player1Action4.setSelected(b);
	}

	public void player1Action5(boolean b)
	{
		player1Action5.setSelected(b);
	}

	public void player2Action1(boolean b)
	{
		player2Action1.setSelected(b);
	}

	public void player2Action2(boolean b)
	{
		player2Action2.setSelected(b);
	}

	public void player2Action3(boolean b)
	{
		player2Action3.setSelected(b);
	}

	public void player2Action4(boolean b)
	{
		player2Action4.setSelected(b);
	}

	public void player2Action5(boolean b)
	{
		player2Action5.setSelected(b);
	}

	public void player3Action1(boolean b)
	{
		player3Action1.setSelected(b);
	}

	public void player3Action2(boolean b)
	{
		player3Action2.setSelected(b);
	}

	public void player3Action3(boolean b)
	{
		player3Action3.setSelected(b);
	}

	public void player3Action4(boolean b)
	{
		player3Action4.setSelected(b);
	}

	public void player3Action5(boolean b)
	{
		player3Action5.setSelected(b);
	}

	public void player4Action1(boolean b)
	{
		player4Action1.setSelected(b);
	}

	public void player4Action2(boolean b)
	{
		player4Action2.setSelected(b);
	}

	public void player4Action3(boolean b)
	{
		player4Action3.setSelected(b);
	}

	public void player4Action4(boolean b)
	{
		player4Action4.setSelected(b);
	}

	public void player4Action5(boolean b)
	{
		player4Action5.setSelected(b);
	}

	public void healSound()
	{
		Random rand = new Random();
		int randomNum = rand.nextInt((3 - 1) + 1) + 1;
		try
		{
			Clip clip = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem
					.getAudioInputStream(UI.class
							.getResource("/resources/Sounds/Heal " + randomNum
									+ ".wav"));
			clip.open(inputStream);
			FloatControl volume = (FloatControl) clip
					.getControl(FloatControl.Type.MASTER_GAIN);
			volume.setValue(-20.0f);
			clip.start();
		} catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
	}

	public void hurtSound()
	{
		Random rand = new Random();
		int randomNum = rand.nextInt((3 - 1) + 1) + 1;
		try
		{
			Clip clip = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem
					.getAudioInputStream(UI.class
							.getResource("/resources/Sounds/Damage "
									+ randomNum + ".wav"));
			clip.open(inputStream);
			FloatControl volume = (FloatControl) clip
					.getControl(FloatControl.Type.MASTER_GAIN);
			volume.setValue(-20.0f);
			clip.start();
		} catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
	}

	public void goldAddSound()
	{
		Random rand = new Random();
		int randomNum = rand.nextInt((3 - 1) + 1) + 1;
		try
		{
			Clip clip = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem
					.getAudioInputStream(UI.class
							.getResource("/resources/Sounds/Gold Increase "
									+ randomNum + ".wav"));
			clip.open(inputStream);
			FloatControl volume = (FloatControl) clip
					.getControl(FloatControl.Type.MASTER_GAIN);
			volume.setValue(-20.0f);
			clip.start();
		} catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
	}

	public void goldRemoveSound()
	{
		Random rand = new Random();
		int randomNum = rand.nextInt((3 - 1) + 1) + 1;
		try
		{
			Clip clip = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem
					.getAudioInputStream(UI.class
							.getResource("/resources/Sounds/Gold Decrease "
									+ randomNum + ".wav"));
			clip.open(inputStream);
			FloatControl volume = (FloatControl) clip
					.getControl(FloatControl.Type.MASTER_GAIN);
			volume.setValue(-20.0f);
			clip.start();
		} catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
}

// JFrame f = new JFrame("URealms");
// f.getContentPane().add(new JPanel() {
//
// @Override // placeholder for actual content
// public Dimension getPreferredSize() {
// return new Dimension(320, 240);
// }
//
// });
// f.pack();
// f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
// GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
// Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
// int x = 0;
// int y = (int) rect.getMaxY() - f.getHeight();
// f.setLocation(x, y);
// f.setVisible(true);