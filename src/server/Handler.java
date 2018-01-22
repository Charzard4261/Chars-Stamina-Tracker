package server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

public class Handler extends Thread {

	private Server server;
	protected Socket socket;

	public Handler(Server server, Socket clientSocket)
	{
		this.server = server;
		this.socket = clientSocket;
	}

	public void run()
	{
		InputStream inp = null;
		BufferedReader brinp = null;
		DataOutputStream out = null;
		try
		{
			inp = socket.getInputStream();
			brinp = new BufferedReader(new InputStreamReader(inp));
			out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e)
		{
			return;
		}

		String ip = socket.getRemoteSocketAddress().toString();

		final PrintWriter pr = new PrintWriter(out, true);
		server.writers.add(pr);
		server.log(ip + " has connected.");
		pr.println("StartUI");
		new Timer().schedule(new TimerTask() {

			@Override
			public void run()
			{
				if (server.p1)
					pr.println("EnablePlayer1");
				pr.println("SetPlayer1Stam " + server.player1Stam);
				pr.println("SetPlayer1CStam " + server.player1CStam);
				pr.println("AddPlayer1Gold " + server.player1Gold);
				pr.println("SetPlayer1Action1 " + server.gmui.actionTypes.get("p1a1"));
				pr.println("SetPlayer1Action2 " + server.gmui.actionTypes.get("p1a2"));
				pr.println("SetPlayer1Action3 " + server.gmui.actionTypes.get("p1a3"));
				pr.println("SetPlayer1Action4 " + server.gmui.actionTypes.get("p1a4"));
				pr.println("SetPlayer1Action5 " + server.gmui.actionTypes.get("p1a5"));
				pr.println("SetPlayer1Action6 " + server.gmui.actionTypes.get("p1a6"));
				pr.println("SetPlayer1Action7 " + server.gmui.actionTypes.get("p1a7"));
				pr.println("SetPlayer1Action8 " + server.gmui.actionTypes.get("p1a8"));
				if (server.player1Action1 == false)
					pr.println("RemovePlayer1Action1");
				if (server.player1Action2 == false)
					pr.println("RemovePlayer1Action2");
				if (server.player1Action3 == false)
					pr.println("RemovePlayer1Action3");
				if (server.player1Action4 == false)
					pr.println("RemovePlayer1Action4");
				if (server.player1Action5 == false)
					pr.println("RemovePlayer1Action5");
				if (server.player1Action6 == false)
					pr.println("RemovePlayer1Action5");
				if (server.player1Action7 == false)
					pr.println("RemovePlayer1Action5");
				if (server.player1Action8 == false)
					pr.println("RemovePlayer1Action5");

				if (server.p2)
					pr.println("EnablePlayer2");
				pr.println("SetPlayer2Stam " + server.player2Stam);
				pr.println("SetPlayer2CStam " + server.player2CStam);
				pr.println("AddPlayer2Gold " + server.player2Gold);
				pr.println("SetPlayer2Action1 " + server.gmui.actionTypes.get("p2a1"));
				pr.println("SetPlayer2Action2 " + server.gmui.actionTypes.get("p2a2"));
				pr.println("SetPlayer2Action3 " + server.gmui.actionTypes.get("p2a3"));
				pr.println("SetPlayer2Action4 " + server.gmui.actionTypes.get("p2a4"));
				pr.println("SetPlayer2Action5 " + server.gmui.actionTypes.get("p2a5"));
				pr.println("SetPlayer2Action6 " + server.gmui.actionTypes.get("p2a6"));
				pr.println("SetPlayer2Action7 " + server.gmui.actionTypes.get("p2a7"));
				pr.println("SetPlayer2Action8 " + server.gmui.actionTypes.get("p2a8"));
				if (server.player2Action1 == false)
					pr.println("RemovePlayer2Action1");
				if (server.player2Action2 == false)
					pr.println("RemovePlayer2Action2");
				if (server.player2Action3 == false)
					pr.println("RemovePlayer2Action3");
				if (server.player2Action4 == false)
					pr.println("RemovePlayer2Action4");
				if (server.player2Action5 == false)
					pr.println("RemovePlayer2Action5");
				if (server.player2Action6 == false)
					pr.println("RemovePlayer2Action5");
				if (server.player2Action7 == false)
					pr.println("RemovePlayer2Action5");
				if (server.player2Action8 == false)
					pr.println("RemovePlayer2Action5");

				if (server.p3)
					pr.println("EnablePlayer3");
				pr.println("SetPlayer3Stam " + server.player3Stam);
				pr.println("SetPlayer3CStam " + server.player3CStam);
				pr.println("AddPlayer3Gold " + server.player3Gold);
				pr.println("SetPlayer3Action1 " + server.gmui.actionTypes.get("p3a1"));
				pr.println("SetPlayer3Action2 " + server.gmui.actionTypes.get("p3a2"));
				pr.println("SetPlayer3Action3 " + server.gmui.actionTypes.get("p3a3"));
				pr.println("SetPlayer3Action4 " + server.gmui.actionTypes.get("p3a4"));
				pr.println("SetPlayer3Action5 " + server.gmui.actionTypes.get("p3a5"));
				pr.println("SetPlayer3Action6 " + server.gmui.actionTypes.get("p3a6"));
				pr.println("SetPlayer3Action7 " + server.gmui.actionTypes.get("p3a7"));
				pr.println("SetPlayer3Action8 " + server.gmui.actionTypes.get("p3a8"));
				if (server.player3Action1 == false)
					pr.println("RemovePlayer3Action1");
				if (server.player3Action2 == false)
					pr.println("RemovePlayer3Action2");
				if (server.player3Action3 == false)
					pr.println("RemovePlayer3Action3");
				if (server.player3Action4 == false)
					pr.println("RemovePlayer3Action4");
				if (server.player3Action5 == false)
					pr.println("RemovePlayer3Action5");
				if (server.player3Action6 == false)
					pr.println("RemovePlayer3Action5");
				if (server.player3Action7 == false)
					pr.println("RemovePlayer3Action5");
				if (server.player3Action8 == false)
					pr.println("RemovePlayer3Action5");

				if (server.p4)
					pr.println("EnablePlayer4");
				pr.println("SetPlayer4Stam " + server.player4Stam);
				pr.println("SetPlayer4CStam " + server.player4CStam);
				pr.println("AddPlayer4Gold " + server.player4Gold);
				pr.println("SetPlayer4Action1 " + server.gmui.actionTypes.get("p4a1"));
				pr.println("SetPlayer4Action2 " + server.gmui.actionTypes.get("p4a2"));
				pr.println("SetPlayer4Action3 " + server.gmui.actionTypes.get("p4a3"));
				pr.println("SetPlayer4Action4 " + server.gmui.actionTypes.get("p4a4"));
				pr.println("SetPlayer4Action5 " + server.gmui.actionTypes.get("p4a5"));
				pr.println("SetPlayer4Action6 " + server.gmui.actionTypes.get("p4a6"));
				pr.println("SetPlayer4Action7 " + server.gmui.actionTypes.get("p4a7"));
				pr.println("SetPlayer4Action8 " + server.gmui.actionTypes.get("p4a8"));
				if (server.player4Action1 == false)
					pr.println("RemovePlayer4Action1");
				if (server.player4Action2 == false)
					pr.println("RemovePlayer4Action2");
				if (server.player4Action3 == false)
					pr.println("RemovePlayer4Action3");
				if (server.player4Action4 == false)
					pr.println("RemovePlayer4Action4");
				if (server.player4Action5 == false)
					pr.println("RemovePlayer4Action5");
				if (server.player4Action5 == false)
					pr.println("RemovePlayer4Action6");
				if (server.player4Action5 == false)
					pr.println("RemovePlayer4Action7");
				if (server.player4Action5 == false)
					pr.println("RemovePlayer4Action8");
			}
		}, 350);
		// Stamina hasn't been set from the GMUI class - TODO Old note - What does it mean

		String line;
		while (true)
		{
			try
			{
				line = brinp.readLine();
				if ((line == null))
					continue;

				String[] inputs = line.split(" ");

				switch (inputs[0])
				{
				case "Quit":
				{
					socket.close();
					return;
				}

				}
			} catch (IOException e)
			{
				server.log(ip + " has disconnected");
				return;
			}
		}
	}
}
