package client;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import server.Server;

public class InitUI {

	Server server = null;
	Client client = null;

	public JFrame frame;
	private JPanel contentPane;
	private JButton Server;
	private JButton Client;

	private Timer timer = new Timer();
	private JTextField ipField;
	private JTextField portField;
	private JButton connect;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		new InitUI();
	}

	public InitUI()
	{
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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				InitUI.class.getResource("/resources/Client/URLogo.png")));
		frame.setTitle("URealmsUI");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(500, 200);
		frame.setBounds(100, 100, 587, 434);
		frame.getContentPane().setLayout(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 583, 406);
		contentPane.setLayout(null);
		frame.setContentPane(contentPane);

		Client = new JButton("");
		Client.setSelectedIcon(new ImageIcon(InitUI.class
				.getResource("/resources/Client/ClientP.png")));
		Client.setIcon(new ImageIcon(InitUI.class
				.getResource("/resources/Client/Client.png")));
		Client.setContentAreaFilled(false);
		Client.setBounds(new Rectangle(87, 285, 100, 50));
		Client.setBorderPainted(false);
		Client.setBorder(null);
		Client.setBackground(Color.WHITE);
		Client.setBounds(430, 290, 100, 50);
		contentPane.add(Client);
		Client.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				Client.setSelected(true);
				timer.schedule(new TimerTask() {

					@Override
					public void run()
					{
						Client.setSelected(false);

						client();
					}
				}, 100L);
			}
		});

		Server = new JButton("");
		Server.setIcon(new ImageIcon(InitUI.class
				.getResource("/resources/Client/Server.png")));
		Server.setSelectedIcon(new ImageIcon(InitUI.class
				.getResource("/resources/Client/ServerP.png")));
		Server.setContentAreaFilled(false);
		Server.setBorder(null);
		Server.setBorderPainted(false);
		Server.setBackground(Color.WHITE);
		Server.setBounds(new Rectangle(50, 290, 100, 50));
		contentPane.add(Server);
		Server.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				Server.setSelected(true);
				timer.schedule(new TimerTask() {

					@Override
					public void run()
					{
						Server.setSelected(false);

						frame.setVisible(false);
						frame.dispose();

						server = new Server();
						server.main(9002);
					}
				}, 100L);
			}
		});

		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(InitUI.class
				.getResource("/resources/Client/Generic Cardback.png")));
		background.setBounds(0, 0, 583, 406);
		contentPane.add(background);

		frame.setVisible(true);
	}

	public void client()
	{
		contentPane.removeAll();

		ipField = new JTextField();
		ipField.setBounds(250, 80, 100, 20);
		ipField.setText("127.0.0.1");
		ipField.setBorder(null);
		contentPane.add(ipField);

		portField = new JTextField();
		portField.setBounds(250, 100, 100, 20);
		portField.setColumns(13);
		portField.setText("9002");
		portField.setBorder(null);
		contentPane.add(portField);

		connect = new JButton("Connect");
		connect.setBounds(250, 300, 100, 20);
		contentPane.add(connect);
		connect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0)
			{

				connect();

			}

		});

		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(InitUI.class
				.getResource("/resources/Client/Generic Cardback.png")));
		background.setBounds(0, 0, 583, 406);
		contentPane.add(background);

		contentPane.repaint();

	}

	public void connect()
	{

		new Timer().schedule(new TimerTask() {

			@Override
			public void run()
			{
				frame.setVisible(false);
				frame.dispose();
				String ip = "127.0.0.1";
				int port = 9002;

				if (ipField.getText() != null)
				{

					String[] t = ipField.getText().split("\\.");

					if (t.length == 4)
					{
						boolean f = false;
						try
						{
							@SuppressWarnings("unused")
							int i = Integer.valueOf(t[0]);
							i = Integer.valueOf(t[1]);
							i = Integer.valueOf(t[2]);
							i = Integer.valueOf(t[3]);
							f = true;
						} catch (Exception e)
						{

						}

						if (f)
						{
							ip = ipField.getText();
						}

					}
				}

				if (portField.getText() != null)
				{
					try
					{
						port = Integer.valueOf(portField.getText());
					} catch (Exception e)
					{
						port = 9002;
					}

				}
				client = new Client();
				client.main(ip, port);

			}
		}, 100);

	}
}
