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

	protected Socket socket;

	public Handler(Socket clientSocket)
	{
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
		Server.writers.add(pr);
		Server.log(ip + " has connected.");
		pr.println("StartUI");
		new Timer().schedule(new TimerTask() {

			@Override
			public void run()
			{
				if (Server.p1)
					pr.println("EnablePlayer1");
				pr.println("SetPlayer1Stam " + Server.player1Stam);
				pr.println("SetPlayer1CStam " + Server.player1CStam);
				pr.println("AddPlayer1Gold " + Server.player1Gold);
				if (Server.player1Action1 == false)
					pr.println("RemovePlayer1Action1");
				if (Server.player1Action2 == false)
					pr.println("RemovePlayer1Action2");
				if (Server.player1Action3 == false)
					pr.println("RemovePlayer1Action3");
				if (Server.player1Action4 == false)
					pr.println("RemovePlayer1Action4");
				if (Server.player1Action5 == false)
					pr.println("RemovePlayer1Action5");

				if (Server.p2)
					pr.println("EnablePlayer2");
				pr.println("SetPlayer2Stam " + Server.player2Stam);
				pr.println("SetPlayer2CStam " + Server.player2CStam);
				pr.println("AddPlayer2Gold " + Server.player2Gold);
				if (Server.player2Action1 == false)
					pr.println("RemovePlayer2Action1");
				if (Server.player2Action2 == false)
					pr.println("RemovePlayer2Action2");
				if (Server.player2Action3 == false)
					pr.println("RemovePlayer2Action3");
				if (Server.player2Action4 == false)
					pr.println("RemovePlayer2Action4");
				if (Server.player2Action5 == false)
					pr.println("RemovePlayer2Action5");

				if (Server.p3)
					pr.println("EnablePlayer3");
				pr.println("SetPlayer3Stam " + Server.player3Stam);
				pr.println("SetPlayer3CStam " + Server.player3CStam);
				pr.println("AddPlayer3Gold " + Server.player3Gold);
				if (Server.player3Action1 == false)
					pr.println("RemovePlayer3Action1");
				if (Server.player3Action2 == false)
					pr.println("RemovePlayer3Action2");
				if (Server.player3Action3 == false)
					pr.println("RemovePlayer3Action3");
				if (Server.player3Action4 == false)
					pr.println("RemovePlayer3Action4");
				if (Server.player3Action5 == false)
					pr.println("RemovePlayer3Action5");

				if (Server.p4)
					pr.println("EnablePlayer4");
				pr.println("SetPlayer4Stam " + Server.player4Stam);
				pr.println("SetPlayer4CStam " + Server.player4CStam);
				pr.println("AddPlayer4Gold " + Server.player4Gold);
				if (Server.player4Action1 == false)
					pr.println("RemovePlayer4Action1");
				if (Server.player4Action2 == false)
					pr.println("RemovePlayer4Action2");
				if (Server.player4Action3 == false)
					pr.println("RemovePlayer4Action3");
				if (Server.player4Action4 == false)
					pr.println("RemovePlayer4Action4");
				if (Server.player4Action5 == false)
					pr.println("RemovePlayer4Action5");
			}
		}, 350);
		// Stamina hasn't been set from the GMUI class

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
				Server.log(ip + " has disconnected");
				return;
			}
		}
	}
}
