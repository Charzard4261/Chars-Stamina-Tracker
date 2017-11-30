package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

public class Server {

	public static ServerUI gui;

	public static HashSet<Handler> handlers = new HashSet<Handler>();

	public static HashSet<String> names = new HashSet<String>();

	public static HashSet<PrintWriter> writers = new HashSet<PrintWriter>();

	public static boolean p1 = false;
	public static int player1Stam = 10;
	public static int player1CStam = 10;
	public static int player1Gold = 0;
	public static int player1c1Stam = 10;
	public static int player1c1CStam = 10;
	public static int player1c2Stam = 10;
	public static int player1c2CStam = 10;
	public static boolean player1Action1 = true;
	public static boolean player1Action2 = true;
	public static boolean player1Action3 = true;
	public static boolean player1Action4 = true;
	public static boolean player1Action5 = true;

	public static boolean p2 = false;
	public static int player2Stam = 10;
	public static int player2CStam = 10;
	public static int player2Gold = 0;
	public static int player2c1Stam = 10;
	public static int player2c1CStam = 10;
	public static int player2c2Stam = 10;
	public static int player2c2CStam = 10;
	public static boolean player2Action1 = true;
	public static boolean player2Action2 = true;
	public static boolean player2Action3 = true;
	public static boolean player2Action4 = true;
	public static boolean player2Action5 = true;

	public static boolean p3 = false;
	public static int player3Stam = 10;
	public static int player3CStam = 10;
	public static int player3Gold = 0;
	public static int player3c1Stam = 10;
	public static int player3c1CStam = 10;
	public static int player3c2Stam = 10;
	public static int player3c2CStam = 10;
	public static boolean player3Action1 = true;
	public static boolean player3Action2 = true;
	public static boolean player3Action3 = true;
	public static boolean player3Action4 = true;
	public static boolean player3Action5 = true;

	public static boolean p4 = false;
	public static int player4Stam = 10;
	public static int player4CStam = 10;
	public static int player4Gold = 0;
	public static int player4c1Stam = 10;
	public static int player4c1CStam = 10;
	public static int player4c2Stam = 10;
	public static int player4c2CStam = 10;
	public static boolean player4Action1 = true;
	public static boolean player4Action2 = true;
	public static boolean player4Action3 = true;
	public static boolean player4Action4 = true;
	public static boolean player4Action5 = true;

	private static ServerUI ui = new ServerUI();

	public void main(int port)
	{
		ServerSocket serverSocket = null;
		Socket socket = null;

		try
		{
			serverSocket = new ServerSocket(port);
		} catch (IOException e)
		{
			ui.log("Couldn't bind port " + port + ".");
			ui.log("Check if another application is using it and try again.");
			return;
		}

		@SuppressWarnings("unused")
		ServerGMUI gmui = new ServerGMUI();

		ui.log("Successfully created URealms Manager server.");

		while (true)
		{
			try
			{
				socket = serverSocket.accept();
			} catch (IOException e)
			{
				ui.log("I/O error: " + e);
				break;
			}
			new Handler(socket).start();
		}

		try
		{
			socket.close();
			serverSocket.close();
		} catch (IOException e)
		{

		}

	}

	public static void stamcheck()
	{
		if (player1CStam > player1Stam)
		{
			player1CStam = player1Stam;
		}

		if (player2CStam > player2Stam)
		{
			player2CStam = player2Stam;
		}

		if (player3CStam > player3Stam)
		{
			player3CStam = player3Stam;
		}

		if (player4CStam > player4Stam)
		{
			player4CStam = player4Stam;
		}

		if (player1CStam < 0)
		{
			player1CStam = 0;
		}

		if (player2CStam < 0)
		{
			player2CStam = 0;
		}

		if (player3CStam < 0)
		{
			player3CStam = 0;
		}

		if (player4CStam < 0)
		{
			player4CStam = 0;
		}

		// Companions

		if (player1c1CStam > player1c1Stam)
		{
			player1c1CStam = player1c1Stam;
		}

		if (player1c1CStam < 0)
		{
			player1c1CStam = 0;
		}

		if (player1c2CStam > player1c2Stam)
		{
			player1c2CStam = player1c2Stam;
		}

		if (player1c2CStam < 0)
		{
			player1c2CStam = 0;
		}

		if (player2c1CStam > player2c1Stam)
		{
			player2c1CStam = player2c1Stam;
		}

		if (player2c1CStam < 0)
		{
			player2c1CStam = 0;
		}

		if (player2c2CStam > player2c2Stam)
		{
			player2c2CStam = player2c2Stam;
		}

		if (player2c2CStam < 0)
		{
			player2c2CStam = 0;
		}

		if (player3c1CStam > player3c1Stam)
		{
			player3c1CStam = player3c1Stam;
		}

		if (player3c1CStam < 0)
		{
			player3c1CStam = 0;
		}

		if (player3c2CStam > player3c2Stam)
		{
			player3c2CStam = player3c2Stam;
		}

		if (player3c2CStam < 0)
		{
			player3c2CStam = 0;
		}
	}

	public static void input(String s)
	{
		for (PrintWriter out : writers)
		{
			out.println(s);
		}

		stamcheck();

		ServerGMUI.p1Stam.setText(player1CStam + "/" + player1Stam);
		ServerGMUI.p1Gold.setText("" + player1Gold + "");
		ServerGMUI.p1c1Stam.setText(player1c1CStam + "/" + player1c1Stam);
		ServerGMUI.p1c2Stam.setText(player1c2CStam + "/" + player1c2Stam);

		ServerGMUI.p2Stam.setText(player2CStam + "/" + player2Stam);
		ServerGMUI.p2Gold.setText("" + player2Gold + "");
		ServerGMUI.p2c1Stam.setText(player2c1CStam + "/" + player2c1Stam);
		ServerGMUI.p2c2Stam.setText(player2c2CStam + "/" + player2c2Stam);

		ServerGMUI.p3Stam.setText(player3CStam + "/" + player3Stam);
		ServerGMUI.p3Gold.setText("" + player3Gold + "");
		ServerGMUI.p3c1Stam.setText(player3c1CStam + "/" + player3c1Stam);
		ServerGMUI.p3c2Stam.setText(player3c2CStam + "/" + player3c2Stam);

		ServerGMUI.p4Stam.setText(player4CStam + "/" + player4Stam);
		ServerGMUI.p4Gold.setText("" + player4Gold + "");
		ServerGMUI.p4c1Stam.setText(player4c1CStam + "/" + player4c1Stam);
		ServerGMUI.p4c2Stam.setText(player4c2CStam + "/" + player4c2Stam);
	}

	public static void log(String s)
	{
		ui.log(s);
	}
}
