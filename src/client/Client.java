package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Client {

	private UI UI;

	public void main(String hostName, int portNumber)
	{

		try (Socket socket = new Socket(hostName, portNumber);
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));)
		{
			String fromServer;
			while (true)
			{
				fromServer = in.readLine();

				if (fromServer.equals("StartUI"))
				{
					UI = new UI();
					continue;
				} else if (fromServer.equals("EnablePlayer1"))
				{
					UI.enablePlayer1();
					continue;

				} else if (fromServer.equals("EnablePlayer2"))
				{
					UI.enablePlayer2();
					continue;

				} else if (fromServer.equals("EnablePlayer3"))
				{
					UI.enablePlayer3();
					continue;

				} else if (fromServer.equals("EnablePlayer4"))
				{
					UI.enablePlayer4();
					continue;

				}
				// Disabling Players
				else if (fromServer.equals("DisablePlayer1"))
				{
					UI.disablePlayer1();
					continue;

				} else if (fromServer.equals("DisablePlayer2"))
				{
					UI.disablePlayer2();
					continue;

				} else if (fromServer.equals("DisablePlayer3"))
				{
					UI.disablePlayer3();
					continue;

				} else if (fromServer.equals("DisablePlayer4"))
				{
					UI.disablePlayer4();
					continue;

				} else if (fromServer.equals("AddPlayer1Action1"))
				{
					UI.player1Action1(false);
					continue;

				} else if (fromServer.equals("RemovePlayer1Action1"))
				{
					UI.player1Action1(true);
					continue;

				} else if (fromServer.equals("AddPlayer2Action1"))
				{
					UI.player2Action1(false);
					continue;

				} else if (fromServer.equals("RemovePlayer2Action1"))
				{
					UI.player2Action1(true);
					continue;

				} else if (fromServer.equals("AddPlayer3Action1"))
				{
					UI.player3Action1(false);
					continue;

				} else if (fromServer.equals("RemovePlayer3Action1"))
				{
					UI.player3Action1(true);
					continue;

				} else if (fromServer.equals("AddPlayer4Action1"))
				{
					UI.player4Action1(false);
					continue;

				} else if (fromServer.equals("RemovePlayer4Action1"))
				{
					UI.player4Action1(true);
					continue;

				} else if (fromServer.equals("AddPlayer1Action2"))
				{
					UI.player1Action2(false);
					continue;

				} else if (fromServer.equals("RemovePlayer1Action2"))
				{
					UI.player1Action2(true);
					continue;

				} else if (fromServer.equals("AddPlayer2Action2"))
				{
					UI.player2Action2(false);
					continue;

				} else if (fromServer.equals("RemovePlayer2Action2"))
				{
					UI.player2Action2(true);
					continue;

				} else if (fromServer.equals("AddPlayer3Action2"))
				{
					UI.player3Action2(false);
					continue;

				} else if (fromServer.equals("RemovePlayer3Action2"))
				{
					UI.player3Action2(true);
					continue;

				} else if (fromServer.equals("AddPlayer4Action2"))
				{
					UI.player4Action2(false);
					continue;

				} else if (fromServer.equals("RemovePlayer4Action2"))
				{
					UI.player4Action2(true);
					continue;

				} else if (fromServer.equals("AddPlayer1Action3"))
				{
					UI.player1Action3(false);
					continue;

				} else if (fromServer.equals("RemovePlayer1Action3"))
				{
					UI.player1Action3(true);
					continue;

				} else if (fromServer.equals("AddPlayer2Action3"))
				{
					UI.player2Action3(false);
					continue;

				} else if (fromServer.equals("RemovePlayer2Action3"))
				{
					UI.player2Action3(true);
					continue;

				} else if (fromServer.equals("AddPlayer3Action3"))
				{
					UI.player3Action3(false);
					continue;

				} else if (fromServer.equals("RemovePlayer3Action3"))
				{
					UI.player3Action3(true);
					continue;

				} else if (fromServer.equals("AddPlayer4Action3"))
				{
					UI.player4Action3(false);
					continue;

				} else if (fromServer.equals("RemovePlayer4Action3"))
				{
					UI.player4Action3(true);
					continue;

				}

				else if (fromServer.equals("AddPlayer1Action4"))
				{
					UI.player1Action4(false);
					continue;

				} else if (fromServer.equals("RemovePlayer1Action4"))
				{
					UI.player1Action4(true);
					continue;

				} else if (fromServer.equals("AddPlayer2Action4"))
				{
					UI.player2Action4(false);
					continue;

				} else if (fromServer.equals("RemovePlayer2Action4"))
				{
					UI.player2Action4(true);
					continue;

				} else if (fromServer.equals("AddPlayer3Action4"))
				{
					UI.player3Action4(false);
					continue;

				} else if (fromServer.equals("RemovePlayer3Action4"))
				{
					UI.player3Action4(true);
					continue;

				} else if (fromServer.equals("AddPlayer4Action4"))
				{
					UI.player4Action4(false);
					continue;

				} else if (fromServer.equals("RemovePlayer4Action4"))
				{
					UI.player4Action4(true);
					continue;

				}

				else if (fromServer.equals("AddPlayer1Action5"))
				{
					UI.player1Action5(false);
					continue;

				} else if (fromServer.equals("RemovePlayer1Action5"))
				{
					UI.player1Action5(true);
					continue;

				} else if (fromServer.equals("AddPlayer2Action5"))
				{
					UI.player2Action5(false);
					continue;

				} else if (fromServer.equals("RemovePlayer2Action5"))
				{
					UI.player2Action5(true);
					continue;

				} else if (fromServer.equals("AddPlayer3Action5"))
				{
					UI.player3Action5(false);
					continue;

				} else if (fromServer.equals("RemovePlayer3Action5"))
				{
					UI.player3Action5(true);
					continue;

				} else if (fromServer.equals("AddPlayer4Action5"))
				{
					UI.player4Action5(false);
					continue;

				} else if (fromServer.equals("RemovePlayer4Action5"))
				{
					UI.player4Action5(true);
					continue;

				}

				else if (fromServer.equals("NewRound"))
				{
					UI.player1Action1(false);
					UI.player1Action2(false);
					UI.player2Action1(false);
					UI.player2Action2(false);
					UI.player3Action1(false);
					UI.player3Action2(false);
					UI.player4Action1(false);
					UI.player4Action2(false);
					continue;
				} else if (fromServer.equals("HealAll"))
				{
					UI.healAll();
					continue;
				}

				String[] inputs = fromServer.split(" ");
				if (inputs.length > 1)
				{
					if (inputs[0].equals("SetPlayer1Stam"))
					{
						if (Integer.valueOf(inputs[1]) != null)
							UI.setPlayer1Stam(Integer.valueOf(inputs[1]));
						continue;
					} else if (inputs[0].equals("SetPlayer2Stam"))
					{
						if (Integer.valueOf(inputs[1]) != null)
							UI.setPlayer2Stam(Integer.valueOf(inputs[1]));

					} else if (inputs[0].equals("SetPlayer3Stam"))
					{
						if (Integer.valueOf(inputs[1]) != null)
							UI.setPlayer3Stam(Integer.valueOf(inputs[1]));

					} else if (inputs[0].equals("SetPlayer4Stam"))
					{
						if (Integer.valueOf(inputs[1]) != null)
							UI.setPlayer4Stam(Integer.valueOf(inputs[1]));
						continue;
					} else if (inputs[0].equals("SetPlayer1CStam"))
					{
						if (Integer.valueOf(inputs[1]) != null)
							UI.setPlayer1CStam(Integer.valueOf(inputs[1]));
						continue;
					} else if (inputs[0].equals("SetPlayer2CStam"))
					{
						if (Integer.valueOf(inputs[1]) != null)
							UI.setPlayer2CStam(Integer.valueOf(inputs[1]));
						continue;
					} else if (inputs[0].equals("SetPlayer3CStam"))
					{
						if (Integer.valueOf(inputs[1]) != null)
							UI.setPlayer3CStam(Integer.valueOf(inputs[1]));
						continue;
					} else if (inputs[0].equals("SetPlayer4CStam"))
					{
						if (Integer.valueOf(inputs[1]) != null)
							UI.setPlayer4CStam(Integer.valueOf(inputs[1]));
						continue;
					} else if (inputs[0].equals("Player1Add"))
					{
						if (Integer.valueOf(inputs[1]) != null)
							UI.setPlayer1CStam(UI.player1StaminaBar.getValue()
									+ Integer.valueOf(inputs[1]));
						UI.healSound();
						continue;
					} else if (inputs[0].equals("Player2Add"))
					{
						if (Integer.valueOf(inputs[1]) != null)
							UI.setPlayer2CStam(UI.player2StaminaBar.getValue()
									+ Integer.valueOf(inputs[1]));
						UI.healSound();
						continue;
					} else if (inputs[0].equals("Player3Add"))
					{
						if (Integer.valueOf(inputs[1]) != null)
							UI.setPlayer3CStam(UI.player3StaminaBar.getValue()
									+ Integer.valueOf(inputs[1]));
						UI.healSound();
						continue;
					} else if (inputs[0].equals("Player4Add"))
					{
						if (Integer.valueOf(inputs[1]) != null)
							UI.setPlayer4CStam(UI.player4StaminaBar.getValue()
									+ Integer.valueOf(inputs[1]));
						UI.healSound();
						continue;
					} else if (inputs[0].equals("Player1Subtract"))
					{
						if (Integer.valueOf(inputs[1]) != null)
							UI.setPlayer1CStam(UI.player1StaminaBar.getValue()
									- Integer.valueOf(inputs[1]));
						UI.hurtSound();
						continue;
					} else if (inputs[0].equals("Player2Subtract"))
					{
						if (Integer.valueOf(inputs[1]) != null)
							UI.setPlayer2CStam(UI.player2StaminaBar.getValue()
									- Integer.valueOf(inputs[1]));
						UI.hurtSound();
						continue;
					} else if (inputs[0].equals("Player3Subtract"))
					{
						if (Integer.valueOf(inputs[1]) != null)
							UI.setPlayer3CStam(UI.player3StaminaBar.getValue()
									- Integer.valueOf(inputs[1]));
						UI.hurtSound();
						continue;
					} else if (inputs[0].equals("Player4Subtract"))
					{
						if (Integer.valueOf(inputs[1]) != null)
							UI.setPlayer4CStam(UI.player4StaminaBar.getValue()
									- Integer.valueOf(inputs[1]));
						UI.hurtSound();
						continue;
					} else if (inputs[0].equals("AddPlayer1Gold"))
					{
						if (Integer.valueOf(inputs[1]) != null)
							UI.setPlayer1Gold(Integer.valueOf(inputs[1]), true);
						continue;
					} else if (inputs[0].equals("AddPlayer2Gold"))
					{
						if (Integer.valueOf(inputs[1]) != null)
							UI.setPlayer2Gold(Integer.valueOf(inputs[1]), true);
						continue;
					} else if (inputs[0].equals("AddPlayer3Gold"))
					{
						if (Integer.valueOf(inputs[1]) != null)
							UI.setPlayer3Gold(Integer.valueOf(inputs[1]), true);
						continue;
					} else if (inputs[0].equals("AddPlayer4Gold"))
					{
						if (Integer.valueOf(inputs[1]) != null)
							UI.setPlayer4Gold(Integer.valueOf(inputs[1]), true);
						continue;
					} else if (inputs[0].equals("SubtractPlayer1Gold"))
					{
						if (Integer.valueOf(inputs[1]) != null)
							UI.setPlayer1Gold(Integer.valueOf(inputs[1]), false);
						continue;
					} else if (inputs[0].equals("SubtractPlayer2Gold"))
					{
						if (Integer.valueOf(inputs[1]) != null)
							UI.setPlayer2Gold(Integer.valueOf(inputs[1]), false);
						continue;
					} else if (inputs[0].equals("SubtractPlayer3Gold"))
					{
						if (Integer.valueOf(inputs[1]) != null)
							UI.setPlayer3Gold(Integer.valueOf(inputs[1]), false);
						continue;
					} else if (inputs[0].equals("SubtractPlayer4Gold"))
					{
						if (Integer.valueOf(inputs[1]) != null)
							UI.setPlayer4Gold(Integer.valueOf(inputs[1]), false);
						continue;
					} else if (inputs[0].equals("Player1Image"))
					{
						if (Integer.valueOf(inputs[1]) != null)
							UI.setPlayer1Image(inputs[1]);
						continue;
					} else if (inputs[0].equals("Player2Image"))
					{
						if (Integer.valueOf(inputs[1]) != null)
							UI.setPlayer2Image(inputs[1]);
						continue;
					} else if (inputs[0].equals("Player3Image"))
					{
						if (Integer.valueOf(inputs[1]) != null)
							UI.setPlayer3Image(inputs[1]);
						continue;
					} else if (inputs[0].equals("Player4Image"))
					{
						if (Integer.valueOf(inputs[1]) != null)
							UI.setPlayer4Image(inputs[1]);
						continue;
					}
				}
			}
		} catch (UnknownHostException e)
		{
			// System.err.println("Can't find host " + hostName);
			JOptionPane.showMessageDialog(new JFrame(), "Can't find host " + hostName, "Error",
					JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		} catch (IOException e)
		{
			// System.err.println("Couldn't get I/O for the connection to "
			// + hostName);
			JOptionPane.showMessageDialog(new JFrame(), "Couldn't get I/O for the connection to "
					+ hostName, "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
	}
}