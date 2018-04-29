package server;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.cert.PKIXRevocationChecker.Option;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicComboBoxUI;

import util.JTextFieldLimit;

public class Options {
	
	private ServerGMUI	su;
	private JLabel		stamCount, c1stamCount, c2stamCount, c3stamCount;
	private JTextField	stamCountSet, c1stamCountSet, c2stamCountSet, c3stamCountSet;
	
	public Options(ServerGMUI su)
	{
		this.su = su;
	}
	
	public void decorate(JPanel panel, final int number)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		panel.setLayout(null);
		
		// int width = 488, height = 542;
		
		// ----------------------------------------------------------------------------------------
		
		// Centre = 141
		
		stamCount = new JLabel("Max Stamina");
		stamCount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		stamCountSet = new JTextField();
		stamCountSet.setDocument(new JTextFieldLimit(4, true));
		stamCountSet.setColumns(2);
		stamCountSet.setText("" + su.server.getClass().getField("player" + number + "Stam").getInt(su.server));
		stamCountSet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				stamCountSet.setText(stamCountSet.getText().replaceAll("[^0-9]", ""));
				
				try
				{
					su.server.getClass().getField("player" + number + "Stam").setInt(su.server, Integer.valueOf(stamCountSet.getText()));
				} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1)
				{
					e1.printStackTrace();
				}
				
				su.server.input("Player " + number + " maxstamina " + stamCountSet.getText());
			}
		});
		
		// ----------------------------------------------------------------------------------------
		
		c1stamCount = new JLabel("C1 Max Stamina");
		c1stamCount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		c1stamCountSet = new JTextField();
		c1stamCountSet.setDocument(new JTextFieldLimit(4, true));
		c1stamCountSet.setColumns(2);
		c1stamCountSet.setText("" + su.server.getClass().getField("player" + number + "c1Stam").getInt(su.server));
		c1stamCountSet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				c1stamCountSet.setText(c1stamCountSet.getText().replaceAll("[^0-9]", ""));
				
				try
				{
					su.server.getClass().getField("player" + number + "c1Stam").setInt(su.server, Integer.valueOf(c1stamCountSet.getText()));
				} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1)
				{
					e1.printStackTrace();
				}
				
				su.server.input("Companion " + number + " 1 maxstamina " + c1stamCountSet.getText());
			}
		});
		
		// ----------------------------------------------------------------------------------------
		
		c2stamCount = new JLabel("C2 Max Stamina");
		c2stamCount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		c2stamCountSet = new JTextField();
		c2stamCountSet.setDocument(new JTextFieldLimit(4, true));
		c2stamCountSet.setColumns(2);
		c2stamCountSet.setText("" + su.server.getClass().getField("player" + number + "c2Stam").getInt(su.server));
		c2stamCountSet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				c2stamCountSet.setText(c2stamCountSet.getText().replaceAll("[^0-9]", ""));
				
				try
				{
					su.server.getClass().getField("player" + number + "c2Stam").setInt(su.server, Integer.valueOf(c2stamCountSet.getText()));
				} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1)
				{
					e1.printStackTrace();
				}
				
				su.server.input("Companion " + number + " 2 maxstamina " + c2stamCountSet.getText());
			}
		});
		
		// ----------------------------------------------------------------------------------------
		
		c3stamCount = new JLabel("C3 Max Stamina");
		c3stamCount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		c3stamCountSet = new JTextField();
		c3stamCountSet.setDocument(new JTextFieldLimit(4, true));
		c3stamCountSet.setColumns(2);
		c3stamCountSet.setText("" + su.server.getClass().getField("player" + number + "c3Stam").getInt(su.server));
		c3stamCountSet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				c3stamCountSet.setText(c3stamCountSet.getText().replaceAll("[^0-9]", ""));
				
				try
				{
					su.server.getClass().getField("player" + number + "c3Stam").setInt(su.server, Integer.valueOf(c3stamCountSet.getText()));
				} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1)
				{
					e1.printStackTrace();
				}
				
				su.server.input("Companion " + number + " 3 maxstamina " + c3stamCountSet.getText());
			}
		});
		
		// ----------------------------------------------------------------------------------------
		
		final JComboBox<ImageIcon> action1 = new ButtonlessComboBox<ImageIcon>(new ImageIcon[] {
				new ImageIcon(
						new ImageIcon(Option.class.getResource("/resources/UI/move.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)),
				new ImageIcon(
						new ImageIcon(Option.class.getResource("/resources/UI/action.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)),
				new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/anytime.png")).getImage().getScaledInstance(60, 60,
						Image.SCALE_SMOOTH)),
				new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/companion.png")).getImage().getScaledInstance(60, 60,
						Image.SCALE_SMOOTH)),
				new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/dual.png")).getImage().getScaledInstance(60, 60,
						Image.SCALE_SMOOTH)) });
		action1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (action1.getSelectedIndex() == 0)
				{
					su.server.input("Player " + number + " actiontype 1 MOVE");
					su.server.actionTypes.put("p" + number + "a1", "MOVE");
					try
					{
						;
						((JButton) GMAP.class.getDeclaredField("playerAction1").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/move.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action1.getSelectedIndex() == 1)
				{
					su.server.input("Player " + number + " actiontype 1 ACTION");
					su.server.actionTypes.put("p" + number + "a1", "ACTION");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction1").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/action.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action1.getSelectedIndex() == 2)
				{
					su.server.input("Player " + number + " actiontype 1 ANYTIME");
					su.server.actionTypes.put("p" + number + "a1", "ANYTIME");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction1").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/anytime.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action1.getSelectedIndex() == 3)
				{
					su.server.input("Player " + number + " actiontype 1 COMPANION");
					su.server.actionTypes.put("p" + number + "a1", "COMPANION");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction1").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/companion.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action1.getSelectedIndex() == 4)
				{
					su.server.input("Player " + number + " actiontype 1 DUAL");
					su.server.actionTypes.put("p" + number + "a1", "DUAL");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction1").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/dual.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				}
			}
		});
		
		final JComboBox<ImageIcon> action2 = new ButtonlessComboBox<ImageIcon>(new ImageIcon[] {
				new ImageIcon(
						new ImageIcon(Option.class.getResource("/resources/UI/move.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)),
				new ImageIcon(
						new ImageIcon(Option.class.getResource("/resources/UI/action.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)),
				new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/anytime.png")).getImage().getScaledInstance(60, 60,
						Image.SCALE_SMOOTH)),
				new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/companion.png")).getImage().getScaledInstance(60, 60,
						Image.SCALE_SMOOTH)),
				new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/dual.png")).getImage().getScaledInstance(60, 60,
						Image.SCALE_SMOOTH)) });
		action2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (action2.getSelectedIndex() == 0)
				{
					su.server.input("Player " + number + " actiontype 2 MOVE");
					su.server.actionTypes.put("p" + number + "a2", "MOVE");
					try
					{
						;
						((JButton) GMAP.class.getDeclaredField("playerAction2").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/move.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action2.getSelectedIndex() == 1)
				{
					su.server.input("Player " + number + " actiontype 2 ACTION");
					su.server.actionTypes.put("p" + number + "a2", "ACTION");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction2").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/action.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action2.getSelectedIndex() == 2)
				{
					su.server.input("Player " + number + " actiontype 2 ANYTIME");
					su.server.actionTypes.put("p" + number + "a2", "ANYTIME");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction2").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/anytime.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action2.getSelectedIndex() == 3)
				{
					su.server.input("Player " + number + " actiontype 2 COMPANION");
					su.server.actionTypes.put("p" + number + "a2", "COMPANION");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction2").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/companion.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action2.getSelectedIndex() == 4)
				{
					su.server.input("Player " + number + " actiontype 2 DUAL");
					su.server.actionTypes.put("p" + number + "a2", "DUAL");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction2").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/dual.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				}
			}
		});
		
		final JComboBox<ImageIcon> action3 = new ButtonlessComboBox<ImageIcon>(new ImageIcon[] {
				new ImageIcon(
						new ImageIcon(Option.class.getResource("/resources/UI/move.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)),
				new ImageIcon(
						new ImageIcon(Option.class.getResource("/resources/UI/action.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)),
				new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/anytime.png")).getImage().getScaledInstance(60, 60,
						Image.SCALE_SMOOTH)),
				new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/companion.png")).getImage().getScaledInstance(60, 60,
						Image.SCALE_SMOOTH)),
				new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/dual.png")).getImage().getScaledInstance(60, 60,
						Image.SCALE_SMOOTH)) });
		action3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (action3.getSelectedIndex() == 0)
				{
					su.server.input("Player " + number + " actiontype 3 MOVE");
					su.server.actionTypes.put("p" + number + "a3", "MOVE");
					try
					{
						;
						((JButton) GMAP.class.getDeclaredField("playerAction3").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/move.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action3.getSelectedIndex() == 1)
				{
					su.server.input("Player " + number + " actiontype 3 ACTION");
					su.server.actionTypes.put("p" + number + "a3", "ACTION");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction3").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/action.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action3.getSelectedIndex() == 2)
				{
					su.server.input("Player " + number + " actiontype 3 ANYTIME");
					su.server.actionTypes.put("p" + number + "a3", "ANYTIME");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction3").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/anytime.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action3.getSelectedIndex() == 3)
				{
					su.server.input("Player " + number + " actiontype 3 COMPANION");
					su.server.actionTypes.put("p" + number + "a3", "COMPANION");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction3").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/companion.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action3.getSelectedIndex() == 4)
				{
					su.server.input("Player " + number + " actiontype 3 DUAL");
					su.server.actionTypes.put("p" + number + "a3", "DUAL");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction3").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/dual.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				}
			}
		});
		
		final JComboBox<ImageIcon> action4 = new ButtonlessComboBox<ImageIcon>(new ImageIcon[] {
				new ImageIcon(
						new ImageIcon(Option.class.getResource("/resources/UI/move.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)),
				new ImageIcon(
						new ImageIcon(Option.class.getResource("/resources/UI/action.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)),
				new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/anytime.png")).getImage().getScaledInstance(60, 60,
						Image.SCALE_SMOOTH)),
				new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/companion.png")).getImage().getScaledInstance(60, 60,
						Image.SCALE_SMOOTH)),
				new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/dual.png")).getImage().getScaledInstance(60, 60,
						Image.SCALE_SMOOTH)) });
		action4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (action4.getSelectedIndex() == 0)
				{
					su.server.input("Player " + number + " actiontype 4 MOVE");
					su.server.actionTypes.put("p" + number + "a4", "MOVE");
					try
					{
						;
						((JButton) GMAP.class.getDeclaredField("playerAction4").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/move.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action4.getSelectedIndex() == 1)
				{
					su.server.input("Player " + number + " actiontype 4 ACTION");
					su.server.actionTypes.put("p" + number + "a4", "ACTION");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction4").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/action.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action4.getSelectedIndex() == 2)
				{
					su.server.input("Player " + number + " actiontype 4 ANYTIME");
					su.server.actionTypes.put("p" + number + "a4", "ANYTIME");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction4").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/anytime.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action4.getSelectedIndex() == 3)
				{
					su.server.input("Player " + number + " actiontype 4 COMPANION");
					su.server.actionTypes.put("p" + number + "a4", "COMPANION");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction4").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/companion.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action4.getSelectedIndex() == 4)
				{
					su.server.input("Player " + number + " actiontype 4 DUAL");
					su.server.actionTypes.put("p" + number + "a4", "DUAL");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction4").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/dual.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				}
			}
		});
		
		final JComboBox<ImageIcon> action5 = new ButtonlessComboBox<ImageIcon>(new ImageIcon[] {
				new ImageIcon(
						new ImageIcon(Option.class.getResource("/resources/UI/move.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)),
				new ImageIcon(
						new ImageIcon(Option.class.getResource("/resources/UI/action.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)),
				new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/anytime.png")).getImage().getScaledInstance(60, 60,
						Image.SCALE_SMOOTH)),
				new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/companion.png")).getImage().getScaledInstance(60, 60,
						Image.SCALE_SMOOTH)),
				new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/dual.png")).getImage().getScaledInstance(60, 60,
						Image.SCALE_SMOOTH)) });
		action5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (action5.getSelectedIndex() == 0)
				{
					su.server.input("Player " + number + " actiontype 5 MOVE");
					su.server.actionTypes.put("p" + number + "a5", "MOVE");
					try
					{
						;
						((JButton) GMAP.class.getDeclaredField("playerAction5").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/move.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action5.getSelectedIndex() == 1)
				{
					su.server.input("Player " + number + " actiontype 5 ACTION");
					su.server.actionTypes.put("p" + number + "a5", "ACTION");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction5").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/action.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action5.getSelectedIndex() == 2)
				{
					su.server.input("Player " + number + " actiontype 5 ANYTIME");
					su.server.actionTypes.put("p" + number + "a5", "ANYTIME");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction5").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/anytime.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action5.getSelectedIndex() == 3)
				{
					su.server.input("Player " + number + " actiontype 5 COMPANION");
					su.server.actionTypes.put("p" + number + "a5", "COMPANION");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction5").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/companion.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action5.getSelectedIndex() == 4)
				{
					su.server.input("Player " + number + " actiontype 5 DUAL");
					su.server.actionTypes.put("p" + number + "a5", "DUAL");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction5").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/dual.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				}
			}
		});
		
		final JComboBox<ImageIcon> action6 = new ButtonlessComboBox<ImageIcon>(new ImageIcon[] {
				new ImageIcon(
						new ImageIcon(Option.class.getResource("/resources/UI/move.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)),
				new ImageIcon(
						new ImageIcon(Option.class.getResource("/resources/UI/action.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)),
				new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/anytime.png")).getImage().getScaledInstance(60, 60,
						Image.SCALE_SMOOTH)),
				new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/companion.png")).getImage().getScaledInstance(60, 60,
						Image.SCALE_SMOOTH)),
				new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/dual.png")).getImage().getScaledInstance(60, 60,
						Image.SCALE_SMOOTH)) });
		action6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (action6.getSelectedIndex() == 0)
				{
					su.server.input("Player " + number + " actiontype 6 MOVE");
					su.server.actionTypes.put("p" + number + "a6", "MOVE");
					try
					{
						;
						((JButton) GMAP.class.getDeclaredField("playerAction6").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/move.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action6.getSelectedIndex() == 1)
				{
					su.server.input("Player " + number + " actiontype 6 ACTION");
					su.server.actionTypes.put("p" + number + "a6", "ACTION");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction6").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/action.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action6.getSelectedIndex() == 2)
				{
					su.server.input("Player " + number + " actiontype 6 ANYTIME");
					su.server.actionTypes.put("p" + number + "a6", "ANYTIME");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction6").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/anytime.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action6.getSelectedIndex() == 3)
				{
					su.server.input("Player " + number + " actiontype 6 COMPANION");
					su.server.actionTypes.put("p" + number + "a6", "COMPANION");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction6").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/companion.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action6.getSelectedIndex() == 4)
				{
					su.server.input("Player " + number + " actiontype 6 DUAL");
					su.server.actionTypes.put("p" + number + "a6", "DUAL");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction6").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/dual.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				}
			}
		});
		
		final JComboBox<ImageIcon> action7 = new ButtonlessComboBox<ImageIcon>(new ImageIcon[] {
				new ImageIcon(
						new ImageIcon(Option.class.getResource("/resources/UI/move.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)),
				new ImageIcon(
						new ImageIcon(Option.class.getResource("/resources/UI/action.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)),
				new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/anytime.png")).getImage().getScaledInstance(60, 60,
						Image.SCALE_SMOOTH)),
				new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/companion.png")).getImage().getScaledInstance(60, 60,
						Image.SCALE_SMOOTH)),
				new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/dual.png")).getImage().getScaledInstance(60, 60,
						Image.SCALE_SMOOTH)) });
		action7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if (action7.getSelectedIndex() == 0)
				{
					su.server.input("Player " + number + " actiontype 7 MOVE");
					su.server.actionTypes.put("p" + number + "a7", "MOVE");
					try
					{
						;
						((JButton) GMAP.class.getDeclaredField("playerAction7").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/move.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action7.getSelectedIndex() == 1)
				{
					su.server.input("Player " + number + " actiontype 7 ACTION");
					su.server.actionTypes.put("p" + number + "a7", "ACTION");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction7").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/action.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action7.getSelectedIndex() == 2)
				{
					su.server.input("Player " + number + " actiontype 7 ANYTIME");
					su.server.actionTypes.put("p" + number + "a7", "ANYTIME");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction7").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/anytime.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action7.getSelectedIndex() == 3)
				{
					su.server.input("Player " + number + " actiontype 7 COMPANION");
					su.server.actionTypes.put("p" + number + "a7", "COMPANION");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction7").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/companion.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				} else if (action7.getSelectedIndex() == 4)
				{
					su.server.input("Player " + number + " actiontype 7 DUAL");
					su.server.actionTypes.put("p" + number + "a7", "DUAL");
					try
					{
						((JButton) GMAP.class.getDeclaredField("playerAction1").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
								.setIcon(new ImageIcon(new ImageIcon(Option.class.getResource("/resources/UI/dual.png")).getImage()
										.getScaledInstance(36, 36, Image.SCALE_SMOOTH)));
					} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
					{
						e.printStackTrace();
					}
				}
			}
		});
		
		// ----------------------------------------------------------------------------------------
		
		switch (su.server.actionTypes.get("p" + number + "a1"))
		{
			case "MOVE":
				action1.setSelectedIndex(0);
				break;
			case "ACTION":
				action1.setSelectedIndex(1);
				break;
			case "ANYTIME":
				action1.setSelectedIndex(2);
				break;
			case "COMPANION":
				action1.setSelectedIndex(3);
				break;
			case "DUAL":
				action1.setSelectedIndex(4);
				break;
		}
		
		switch (su.server.actionTypes.get("p" + number + "a2"))
		{
			case "MOVE":
				action2.setSelectedIndex(0);
				break;
			case "ACTION":
				action2.setSelectedIndex(1);
				break;
			case "ANYTIME":
				action2.setSelectedIndex(2);
				break;
			case "COMPANION":
				action1.setSelectedIndex(3);
				break;
			case "DUAL":
				action1.setSelectedIndex(4);
				break;
		}
		
		switch (su.server.actionTypes.get("p" + number + "a3"))
		{
			case "MOVE":
				action3.setSelectedIndex(0);
				break;
			case "ACTION":
				action3.setSelectedIndex(1);
				break;
			case "ANYTIME":
				action3.setSelectedIndex(2);
				break;
			case "COMPANION":
				action1.setSelectedIndex(3);
				break;
			case "DUAL":
				action1.setSelectedIndex(4);
				break;
		}
		
		switch (su.server.actionTypes.get("p" + number + "a4"))
		{
			case "MOVE":
				action4.setSelectedIndex(0);
				break;
			case "ACTION":
				action4.setSelectedIndex(1);
				break;
			case "ANYTIME":
				action4.setSelectedIndex(2);
				break;
			case "COMPANION":
				action1.setSelectedIndex(3);
				break;
			case "DUAL":
				action1.setSelectedIndex(4);
				break;
		}
		
		switch (su.server.actionTypes.get("p" + number + "a5"))
		{
			case "MOVE":
				action5.setSelectedIndex(0);
				break;
			case "ACTION":
				action5.setSelectedIndex(1);
				break;
			case "ANYTIME":
				action5.setSelectedIndex(2);
				break;
			case "COMPANION":
				action1.setSelectedIndex(3);
				break;
			case "DUAL":
				action1.setSelectedIndex(4);
				break;
		}
		
		switch (su.server.actionTypes.get("p" + number + "a6"))
		{
			case "MOVE":
				action6.setSelectedIndex(0);
				break;
			case "ACTION":
				action6.setSelectedIndex(1);
				break;
			case "ANYTIME":
				action6.setSelectedIndex(2);
				break;
			case "COMPANION":
				action1.setSelectedIndex(3);
				break;
			case "DUAL":
				action1.setSelectedIndex(4);
				break;
		}
		
		switch (su.server.actionTypes.get("p" + number + "a7"))
		{
			case "MOVE":
				action7.setSelectedIndex(0);
				break;
			case "ACTION":
				action7.setSelectedIndex(1);
				break;
			case "ANYTIME":
				action7.setSelectedIndex(2);
				break;
			case "COMPANION":
				action1.setSelectedIndex(3);
				break;
			case "DUAL":
				action1.setSelectedIndex(4);
				break;
		}
		
		// ----------------------------------------------------------------------------------------
		
		final JCheckBox action6enabled = new JCheckBox();
		action6enabled.setOpaque(false);
		if ((Server.class.getDeclaredField("player" + number + "Action6e").getBoolean(su.server)))
			action6enabled.setSelected(true);
		action6enabled.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				su.server.input("Player " + number + " actionenable 6 " + action6enabled.isSelected());
				try
				{
					Server.class.getDeclaredField("player" + number + "Action6e").setBoolean(su.server, action6enabled.isSelected());
					((JButton) GMAP.class.getDeclaredField("playerAction6").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
							.setEnabled(action6enabled.isSelected());
				} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
				{
					e.printStackTrace();
				}
			}
		});
		
		final JCheckBox action7enabled = new JCheckBox();
		action7enabled.setOpaque(false);
		if ((Server.class.getDeclaredField("player" + number + "Action7e").getBoolean(su.server)))
			action7enabled.setSelected(true);
		action7enabled.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				su.server.input("Player " + number + " actionenable 7 " + action7enabled.isSelected());
				try
				{
					Server.class.getDeclaredField("player" + number + "Action7e").setBoolean(su.server, action7enabled.isSelected());
					((JButton) GMAP.class.getDeclaredField("playerAction7").get(ServerGMUI.class.getDeclaredField("g" + number).get(su)))
							.setEnabled(action7enabled.isSelected());
				} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
				{
					e.printStackTrace();
				}
			}
		});
		
		// ----------------------------------------------------------------------------------------
		
		/**
		 * BOUNDS
		 **/
		
		stamCount.setBounds(30 + 98, 30, 100, 20);
		stamCountSet.setBounds(150 + 98, 30, 100, 20);
		
		c1stamCount.setBounds(30 + 98, 60, 100, 20);
		c1stamCountSet.setBounds(150 + 98, 60, 100, 20);
		
		c2stamCount.setBounds(30 + 98, 90, 100, 20);
		c2stamCountSet.setBounds(150 + 98, 90, 100, 20);
		
		c3stamCount.setBounds(30 + 98, 120, 100, 20);
		c3stamCountSet.setBounds(150 + 98, 120, 100, 20);
		
		action1.setBounds(212 - 210, 200, 64, 64);
		action2.setBounds(212 - 140, 200, 64, 64);
		action3.setBounds(212 - 70, 200, 64, 64);
		action4.setBounds(212, 200, 64, 64);
		action5.setBounds(212 + 70, 200, 64, 64);
		action6.setBounds(212 + 140, 200, 64, 64);
		action6enabled.setBounds((212 + 140 + 32) - 11, 175, 30, 30);
		action7.setBounds(212 + 210, 200, 64, 64);
		action7enabled.setBounds((212 + 210 + 32) - 11, 175, 30, 30);
		
		/**
		 * ADDING
		 **/
		
		panel.add(stamCount);
		panel.add(stamCountSet);
		
		panel.add(c1stamCount);
		panel.add(c1stamCountSet);
		
		panel.add(c2stamCount);
		panel.add(c2stamCountSet);
		
		panel.add(c3stamCount);
		panel.add(c3stamCountSet);
		
		panel.add(action1);
		panel.add(action2);
		panel.add(action3);
		panel.add(action4);
		panel.add(action5);
		panel.add(action6);
		panel.add(action6enabled);
		panel.add(action7);
		panel.add(action7enabled);
	}
	
	class ButtonlessComboBox<E> extends JComboBox<E> {
		/**
		 * Taken from
		 * http://www.java2s.com/Tutorials/Java/Swing_How_to/JComboBox/Hide_arrow_button_from_JComboBox.htm
		 */
		private static final long serialVersionUID = -3963843217388449591L;
		
		public ButtonlessComboBox(E[] list)
		{
			super(list);
		}
		
		@Override
		public void updateUI()
		{
			super.updateUI();
			UIManager.put("ComboBox.squareButton", Boolean.FALSE);
			setUI(new BasicComboBoxUI() {
				@Override
				protected JButton createArrowButton()
				{
					JButton b = new JButton();
					b.setBorder(BorderFactory.createEmptyBorder());
					b.setVisible(false);
					return b;
				}
			});
			setBorder(BorderFactory.createLineBorder(Color.GRAY));
		}
	}
}
