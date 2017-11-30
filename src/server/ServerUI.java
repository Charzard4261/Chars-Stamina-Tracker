//Made by the guy who made marionette mates. Used for debug purposes.
package server;

/**
 * Imports
 */
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

public class ServerUI extends JFrame {
	/**
	 * Variables
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea logStatusPane = new JTextArea();
    private JScrollPane logScrollPane = new JScrollPane(logStatusPane);
    private JTextArea userStatusPane = new JTextArea();
    private JScrollPane userScrollPane = new JScrollPane(userStatusPane);
    private JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,logScrollPane, userScrollPane);
    
    Dimension minimumLogSize = new Dimension(650,410);
    Dimension minimumUserSize = new Dimension(150,410);
    /**
     * ServerGUI Constructor
     */
    public ServerUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("URealms");					// Title of Server Window
        this.setSize(1000, 450);
        
        splitPane.setDividerLocation(800);

        logStatusPane.setEditable(false);
        logStatusPane.setAutoscrolls(true);
        logScrollPane.setAutoscrolls(true);
        
        userStatusPane.setEditable(false);
        userStatusPane.setAutoscrolls(true);
        userScrollPane.setAutoscrolls(true);
        
        logScrollPane.setMinimumSize(minimumLogSize);
        userScrollPane.setMinimumSize(minimumUserSize);
        
//        this.add(logScrollPane, BorderLayout.CENTER);
        this.add(splitPane, BorderLayout.CENTER);

        setVisible(true);
    }
    /**
     * Logs
     */
    public void log(String line) {
    	if(logStatusPane.getText().length()>2000){
    		logStatusPane.setText(logStatusPane.getText().substring(500));
    	}
        logStatusPane.setText(logStatusPane.getText() + "\n" + line);
        logStatusPane.setCaretPosition(logStatusPane.getDocument().getLength());
    }
    /**
     * Users
     */
    public void addUser(String line) {
    	userStatusPane.setText(userStatusPane.getText() + "\n" + line);
        userStatusPane.setCaretPosition(userStatusPane.getDocument().getLength());
    }
    public void clearUsers() {
    	userStatusPane.setText(null);
    	userStatusPane.setCaretPosition(userStatusPane.getDocument().getLength());
    }


}
