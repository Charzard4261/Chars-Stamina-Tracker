package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Client {
	
	private ClientUI UI;
	
	public void main(String hostName, int portNumber)
	{
		
		try (Socket socket = new Socket(hostName, portNumber);
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));)
		{
			String fromServer;
			while (true)
			{
				fromServer = in.readLine();
				
				if (fromServer.equals("StartUI"))
				{
					UI = new ClientUI();
					continue;
				}
				
				else if (fromServer.equals("NewRound"))
				{
					UI.newRound();
					continue;
				} else if (fromServer.equals("HealAll"))
				{
					UI.healAll();
					continue;
				}
				
				String[] inputs = fromServer.split(" ");
				if (inputs.length > 1)
				{
					// -------------------------------------------------------------------------
					if (inputs[0].equals("Player")) // Player [Number] [Command] <args>
					{
						switch (inputs[2])
						{
							case "enable":
								UI.playerEnable(inputs[1]);
								break;
							case "disable":
								UI.playerDisable(inputs[1]);
								break;
							case "stamina":
								UI.playerStamina(inputs[1], inputs[3]);
								break;
							case "maxstamina":
								UI.playerMaxStamina(inputs[1], inputs[3]);
								break;
							case "damage":
								UI.playerDamage(inputs[1], inputs[3]);
								break;
							case "gold":
								UI.playerGold(inputs[1], inputs[3]);
								break;
							case "modifygold":
								UI.playerModifyGold(inputs[1], inputs[3]);
								break;
							case "action":
								UI.playerAction(inputs[1], inputs[3], inputs[4]);
								break;
							case "actiontype":
								UI.playerActionType(inputs[1], inputs[3], inputs[4]);
								break;
							case "actionenable":
								((CAP) ClientUI.class.getDeclaredField("c" + inputs[1]).get(UI)).enableAction(inputs[3], inputs[4]);
								break;
							case "":
								break;
						}
					} else if (inputs[0].equals("Companion")) // Companion [Player] [Number] [Command] <args> e.g.
																// Companion 4 1 enable
					{
						if (inputs.length == 4)
						{
							UI.companion(inputs[1], inputs[2], inputs[3], null);
						}
						if (inputs.length > 4)
						{
							ArrayList<String> args = new ArrayList<String>();
							for (int i = 0; i < inputs.length; i++)
							{
								if (i == 0 || i == 1 || i == 2 || i == 3) // Ignore Companion [Player] [Number] [Command]
									continue;
								else
									args.add(inputs[i]); // Only add <args>
							}
							UI.companion(inputs[1], inputs[2], inputs[3], args);
						}
						continue;
					}
					// -------------------------------------------------------------------------
				}
			}
		} catch (UnknownHostException e)
		{
			// System.err.println("Can't find host " + hostName);
			JOptionPane.showMessageDialog(new JFrame(), "Can't find host " + hostName, "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		} catch (IOException e)
		{
			// System.err.println("Couldn't get I/O for the connection to "
			// + hostName);
			JOptionPane.showMessageDialog(new JFrame(), "Couldn't get I/O for the connection to " + hostName, "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		} catch (IllegalArgumentException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}