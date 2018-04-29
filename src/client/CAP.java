package client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

// Client Manager Add Players, or CAP for short - My cheat way to cut the code needed by about a quarter

public class CAP {
	
	public boolean enabled = false;
	
	public JProgressBar	playerStaminaBar		= new JProgressBar();
	public JLabel		playerImage				= new JLabel("");
	public boolean		playerCompanion1enabled	= false;
	public JProgressBar	playerCompanion1		= new JProgressBar();
	public boolean		playerCompanion2enabled	= false;
	public JProgressBar	playerCompanion2		= new JProgressBar();
	public boolean		playerCompanion3enabled	= false;
	public JProgressBar	playerCompanion3		= new JProgressBar();
	public final JLabel	playerGold				= new JLabel("");
	public final JLabel	playerGoldlbl			= new JLabel("0");
	public JButton		playerAction1			= new JButton("");
	public JLabel		slotPlayerAction1		= new JLabel("");
	public JButton		playerAction2			= new JButton("");
	public JLabel		slotPlayerAction2		= new JLabel("");
	public JButton		playerAction3			= new JButton("");
	public JLabel		slotPlayerAction3		= new JLabel("");
	public JButton		playerAction4			= new JButton("");
	public JLabel		slotPlayerAction4		= new JLabel("");
	public JButton		playerAction5			= new JButton("");
	public JLabel		slotPlayerAction5		= new JLabel("");
	boolean				playeraction6			= false, playeraction7 = false;
	public JButton		playerAction6			= new JButton("");
	public JLabel		slotPlayerAction6		= new JLabel("");
	public JButton		playerAction7			= new JButton("");
	public JLabel		slotPlayerAction7		= new JLabel("");
	
	private int XOne = 0, XTwo = 0, XOffset = 40, YOne = 0, YOffset = 90;
	
	public void add(JPanel panel, int number, int xstart, int ystart)
	{
		XOne = xstart; // 285
		XTwo = xstart - 6;
		YOne = ystart; // 20
		
		playerStaminaBar.setBorder(new CompoundBorder(new MatteBorder(2, 1, 2, 1, (Color) new Color(64, 64, 64)),
				new EtchedBorder(EtchedBorder.LOWERED, new Color(128, 128, 128), null)));
		playerStaminaBar.setVisible(false);
		playerStaminaBar.setForeground(Color.GREEN);
		playerStaminaBar.setMaximum(10);
		playerStaminaBar.setValue(10);
		panel.add(playerStaminaBar);
		
		playerImage.setVisible(false);
		panel.add(playerImage);
		
		playerCompanion1.setFont(new Font("Tahoma", Font.PLAIN, 99));
		playerCompanion1.setStringPainted(true);
		playerCompanion1.setString("");
		playerCompanion1.setForeground(new Color(25, 255, 0));
		playerCompanion1.setBorder(new CompoundBorder(new MatteBorder(2, 1, 2, 1, (Color) new Color(64, 64, 64)),
				new EtchedBorder(EtchedBorder.LOWERED, new Color(128, 128, 128), null)));
		playerCompanion1.setMaximum(10);
		playerCompanion1.setValue(10);
		playerCompanion1.setVisible(false);
		panel.add(playerCompanion1);
		
		playerCompanion2.setFont(new Font("Tahoma", Font.PLAIN, 99));
		playerCompanion2.setStringPainted(true);
		playerCompanion2.setString("");
		playerCompanion2.setForeground(new Color(25, 255, 0));
		playerCompanion2.setBorder(new CompoundBorder(new MatteBorder(2, 1, 2, 1, (Color) new Color(64, 64, 64)),
				new EtchedBorder(EtchedBorder.LOWERED, new Color(128, 128, 128), null)));
		playerCompanion2.setMaximum(10);
		playerCompanion2.setValue(10);
		playerCompanion2.setVisible(false);
		panel.add(playerCompanion2);
		
		playerCompanion3 = new JProgressBar();
		playerCompanion3.setFont(new Font("Tahoma", Font.PLAIN, 99));
		playerCompanion3.setStringPainted(true);
		playerCompanion3.setString("");
		playerCompanion3.setForeground(new Color(25, 255, 0));
		playerCompanion3.setBorder(new CompoundBorder(new MatteBorder(2, 1, 2, 1, (Color) new Color(64, 64, 64)),
				new EtchedBorder(EtchedBorder.LOWERED, new Color(128, 128, 128), null)));
		playerCompanion3.setMaximum(10);
		playerCompanion3.setValue(10);
		playerCompanion3.setVisible(false);
		panel.add(playerCompanion3);
		
		playerGoldlbl.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		playerGoldlbl.setOpaque(true);
		playerGoldlbl.setBackground(Color.DARK_GRAY);
		playerGoldlbl.setForeground(Color.ORANGE);
		playerGoldlbl.setHorizontalAlignment(SwingConstants.TRAILING);
		playerGoldlbl.setVisible(false);
		panel.add(playerGoldlbl);
		
		playerGold.setIcon(new ImageIcon(
				new ImageIcon(CAP.class.getResource("/resources/UI/gold.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
		playerGold.setVisible(false);
		panel.add(playerGold);
		
		// -------------------------------------------------------------------------------------------------------------------------------------------------------
		
		playerAction1.setBorderPainted(false);
		playerAction1.setContentAreaFilled(false);
		playerAction1.setVisible(false);
		playerAction1.setIcon(new ImageIcon(
				new ImageIcon(CAP.class.getResource("/resources/UI/move.png")).getImage().getScaledInstance(34, 34, Image.SCALE_SMOOTH)));
		playerAction1.setSelectedIcon(new ImageIcon(CAP.class.getResource("/resources/UI/null.png")));
		panel.add(playerAction1);
		
		slotPlayerAction1.setVisible(false);
		slotPlayerAction1.setIcon(new ImageIcon(
				new ImageIcon(CAP.class.getResource("/resources/UI/slot.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
		panel.add(slotPlayerAction1);
		
		playerAction2.setBorderPainted(false);
		playerAction2.setContentAreaFilled(false);
		playerAction2.setVisible(false);
		playerAction2.setIcon(new ImageIcon(
				new ImageIcon(CAP.class.getResource("/resources/UI/action.png")).getImage().getScaledInstance(34, 34, Image.SCALE_SMOOTH)));
		playerAction2.setSelectedIcon(new ImageIcon(CAP.class.getResource("/resources/UI/null.png")));
		panel.add(playerAction2);
		
		slotPlayerAction2.setVisible(false);
		slotPlayerAction2.setIcon(new ImageIcon(
				new ImageIcon(CAP.class.getResource("/resources/UI/slot.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
		panel.add(slotPlayerAction2);
		
		playerAction3.setBorderPainted(false);
		playerAction3.setContentAreaFilled(false);
		playerAction3.setVisible(false);
		playerAction3.setIcon(new ImageIcon(
				new ImageIcon(CAP.class.getResource("/resources/UI/anytime.png")).getImage().getScaledInstance(34, 34, Image.SCALE_SMOOTH)));
		playerAction3.setSelectedIcon(new ImageIcon(CAP.class.getResource("/resources/UI/null.png")));
		panel.add(playerAction3);
		
		slotPlayerAction3.setVisible(false);
		slotPlayerAction3.setIcon(new ImageIcon(
				new ImageIcon(CAP.class.getResource("/resources/UI/slot.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
		panel.add(slotPlayerAction3);
		
		playerAction4.setContentAreaFilled(false);
		playerAction4.setBorderPainted(false);
		playerAction4.setVisible(false);
		playerAction4.setIcon(new ImageIcon(
				new ImageIcon(CAP.class.getResource("/resources/UI/anytime.png")).getImage().getScaledInstance(34, 34, Image.SCALE_SMOOTH)));
		playerAction4.setSelectedIcon(new ImageIcon(CAP.class.getResource("/resources/UI/null.png")));
		panel.add(playerAction4);
		
		slotPlayerAction4.setVisible(false);
		slotPlayerAction4.setIcon(new ImageIcon(
				new ImageIcon(CAP.class.getResource("/resources/UI/slot.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
		panel.add(slotPlayerAction4);
		
		playerAction5.setContentAreaFilled(false);
		playerAction5.setBorderPainted(false);
		playerAction5.setVisible(false);
		playerAction5.setIcon(new ImageIcon(
				new ImageIcon(CAP.class.getResource("/resources/UI/anytime.png")).getImage().getScaledInstance(34, 34, Image.SCALE_SMOOTH)));
		playerAction5.setSelectedIcon(new ImageIcon(CAP.class.getResource("/resources/UI/null.png")));
		panel.add(playerAction5);
		
		slotPlayerAction5.setVisible(false);
		slotPlayerAction5.setIcon(new ImageIcon(
				new ImageIcon(CAP.class.getResource("/resources/UI/slot.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
		panel.add(slotPlayerAction5);
		
		playerAction6.setContentAreaFilled(false);
		playerAction6.setBorderPainted(false);
		playerAction6.setVisible(false);
		playerAction6.setIcon(new ImageIcon(
				new ImageIcon(CAP.class.getResource("/resources/UI/anytime.png")).getImage().getScaledInstance(34, 34, Image.SCALE_SMOOTH)));
		playerAction6.setSelectedIcon(new ImageIcon(CAP.class.getResource("/resources/UI/null.png")));
		panel.add(playerAction6);
		
		slotPlayerAction6.setVisible(false);
		slotPlayerAction6.setIcon(new ImageIcon(
				new ImageIcon(CAP.class.getResource("/resources/UI/slot.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
		panel.add(slotPlayerAction6);
		
		playerAction7.setContentAreaFilled(false);
		playerAction7.setBorderPainted(false);
		playerAction7.setVisible(false);
		playerAction7.setIcon(new ImageIcon(
				new ImageIcon(CAP.class.getResource("/resources/UI/anytime.png")).getImage().getScaledInstance(34, 34, Image.SCALE_SMOOTH)));
		playerAction7.setSelectedIcon(new ImageIcon(CAP.class.getResource("/resources/UI/null.png")));
		panel.add(playerAction7);
		
		slotPlayerAction7.setVisible(false);
		slotPlayerAction7.setIcon(new ImageIcon(
				new ImageIcon(CAP.class.getResource("/resources/UI/slot.png")).getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
		panel.add(slotPlayerAction7);
		
		// --------------------------------------------------------------------------------------------------------------------------------------
		// LOCATIONS 285 20
		// --------------------------------------------------------------------------------------------------------------------------------------
		
		playerStaminaBar.setBounds(XOne, YOne, 130, 15);
		playerImage.setBounds(XOne, YOne + 13, 130, 93);
		
		playerCompanion1.setBounds(XOne + 125, YOne + 25, 100, 15);
		playerCompanion2.setBounds(XOne + 125, YOne + 40, 100, 15);
		playerCompanion3.setBounds(XOne + 125, YOne + 55, 100, 15);
		
		playerGoldlbl.setBounds(XOne - 50, YOne + 75, 40, 12);
		playerGold.setBounds(XOne - 45, YOne + 50, 30, 30);
		
		playerAction1.setBounds(XTwo - XOffset - 12, YOne + YOffset, 60, 60);
		slotPlayerAction1.setBounds(XTwo - XOffset, YOne + YOffset, 60, 60);
		
		playerAction2.setBounds(XTwo - 12, YOne + YOffset, 60, 60);
		slotPlayerAction2.setBounds(XTwo, YOne + YOffset, 60, 60);
		
		playerAction3.setBounds(XTwo + XOffset - 12, YOne + YOffset, 60, 60);
		slotPlayerAction3.setBounds(XTwo + XOffset, YOne + YOffset, 60, 60);
		
		playerAction4.setBounds(XTwo + (XOffset * 2) - 12, YOne + YOffset, 60, 60);
		slotPlayerAction4.setBounds(XTwo + (XOffset * 2), YOne + YOffset, 60, 60);
		
		playerAction5.setBounds(XTwo + (XOffset * 3) - 12, YOne + YOffset, 60, 60);
		slotPlayerAction5.setBounds(XTwo + (XOffset * 3), YOne + YOffset, 60, 60);
		
		playerAction6.setBounds(XTwo + (XOffset * 4) - 12, YOne + YOffset, 60, 60);
		slotPlayerAction6.setBounds(XTwo + (XOffset * 4), YOne + YOffset, 60, 60);
		
		playerAction7.setBounds(XTwo + (XOffset * 5) - 12, YOne + YOffset, 60, 60);
		slotPlayerAction7.setBounds(XTwo + (XOffset * 5), YOne + YOffset, 60, 60);
	}
	
	public void enable()
	{
		enabled = true;
		
		playerStaminaBar.setVisible(true);
		playerImage.setVisible(true);
		if (playerCompanion1enabled)
			playerCompanion1.setVisible(true);
		if (playerCompanion2enabled)
			playerCompanion2.setVisible(true);
		if (playerCompanion3enabled)
			playerCompanion3.setVisible(true);
		playerGoldlbl.setVisible(true);
		playerGold.setVisible(true);
		slotPlayerAction1.setVisible(true);
		slotPlayerAction2.setVisible(true);
		slotPlayerAction3.setVisible(true);
		slotPlayerAction4.setVisible(true);
		slotPlayerAction5.setVisible(true);
		if (playeraction6)
		{
			playerAction6.setVisible(true);
			slotPlayerAction6.setVisible(true);
		}
		if (playeraction7)
		{
			playerAction7.setVisible(true);
			slotPlayerAction7.setVisible(true);
		}
		playerAction1.setVisible(true);
		playerAction2.setVisible(true);
		playerAction3.setVisible(true);
		playerAction4.setVisible(true);
		playerAction5.setVisible(true);
	}
	
	public void disable()
	{
		enabled = false;
		
		playerStaminaBar.setVisible(false);
		playerImage.setVisible(false);
		playerCompanion1.setVisible(false);
		playerCompanion2.setVisible(false);
		playerCompanion3.setVisible(false);
		playerGoldlbl.setVisible(false);
		playerGold.setVisible(false);
		slotPlayerAction1.setVisible(false);
		slotPlayerAction2.setVisible(false);
		slotPlayerAction3.setVisible(false);
		slotPlayerAction4.setVisible(false);
		slotPlayerAction5.setVisible(false);
		slotPlayerAction6.setVisible(false);
		slotPlayerAction7.setVisible(false);
		playerAction1.setVisible(false);
		playerAction2.setVisible(false);
		playerAction3.setVisible(false);
		playerAction4.setVisible(false);
		playerAction5.setVisible(false);
		playerAction6.setVisible(false);
		playerAction7.setVisible(false);
	}
	
	public void heal()
	{
		playerStaminaBar.setValue(playerStaminaBar.getMaximum());
	}
	
	public void newRound()
	{
		playerAction1.setSelected(false);
		playerAction2.setSelected(false);
		playerAction3.setSelected(false);
		playerAction4.setSelected(false);
		playerAction5.setSelected(false);
		playerAction6.setSelected(false);
		playerAction7.setSelected(false);
	}
	
	public void enableAction(String action, String bool)
	{
		boolean b = Boolean.valueOf(bool);
		switch (action)
		{
			case "6":
				playeraction6 = b;
				if (enabled)
				{
					playerAction6.setVisible(b);
					slotPlayerAction6.setVisible(b);
				}
				break;
			case "7":
				playeraction7 = b;
				if (enabled)
				{
					playerAction7.setVisible(b);
					slotPlayerAction7.setVisible(b);
				}
				break;
		}
	}
	
}
