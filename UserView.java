import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SwingConstants;

public class UserView extends JPanel implements ActionListener{
	private JFrame frame;
    private JButton followUserButton;
    private JTextField followUserTextField;
    private JButton tweetMessageButton;
    private JTextField tweetMessageTextField;
    private JPanel panel;
   
    private List<SystemEntry> allUsers;
    private User user;
    private User followUser;
	private Admin adminInstance;
	private String currUser;
	
	private List<String> followers;
	private JPanel scrollPanel = new JPanel();
	
	UserView(String selectedUser){
		this.currUser = selectedUser;
//		this.followers = new ArrayList<String>();
		
		
		//Lay everything out.
		frame = new JFrame(this.currUser);
		
        //Follow user Text Field 
		followUserTextField = new JTextField();
		followUserTextField.setBounds(10,10,150,30);
		followUserTextField.setForeground(Color.gray);
		followUserTextField.setText("User Id");
		
		 //Follow user Button 
		followUserButton = new JButton("Follow User");
		followUserButton.setBounds(200, 10, 120, 30);
		followUserButton.addActionListener(this);
		
		//Tweet message Button
		tweetMessageButton = new JButton("Post Tweet");
		tweetMessageButton.setBounds(200, 260, 120, 30);
		tweetMessageButton.addActionListener(this);
		
		//Tweet message Text Field
		tweetMessageTextField = new JTextField();
		tweetMessageTextField.setBounds(10,260,150,30);
		tweetMessageTextField.setForeground(Color.gray);
		tweetMessageTextField.setText("Tweet Message");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(500, 550));
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setBackground(Color.white);
		
		panel= new JPanel();
		panel.setBounds(0, 50, 500, 200);
		panel.add(new JLabel("<html>Current Following<br/></html>", SwingConstants.CENTER));
		panel.setBackground(Color.white);
		
		
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(0, 300, 500, 200);
		panel2.add(new JLabel("News Feed", SwingConstants.CENTER));
		panel2.setBackground(Color.white);
		
		//Add components to frame
		frame.add(followUserTextField);
		frame.add(followUserButton);
		frame.add(tweetMessageTextField);
		frame.add(tweetMessageButton);
		frame.add(panel);
		frame.add(panel2);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == followUserButton) {
			scrollPanel.removeAll(); //remove to update
			
			this.adminInstance = Admin.getInstance();
			this.allUsers = this.adminInstance.getUser();
			
			//Cast current user 
			 for(SystemEntry user : allUsers) {				 
				 if(this.currUser.equals(user.toString())) {
					 this.user = (User) user;	//cast to User 
					 System.out.println("User is: " + user.toString());
				 }
			 }
			 
			//Get what is in entered in text field and make sure whoever the user wants to follow exists
			 for(SystemEntry user : allUsers) {				
				 //User to follow must exist and current user can't follow them self 
				 if(followUserTextField.getText().equals(user.toString()) && !this.currUser.equals(user.toString())) {
					 //Follow user 
					 this.followUser = (User) user;	//cast to User 
					 this.user.follow(this.followUser); 
					 
					//Get list of followers
					this.followers = this.user.getFollowers();
					 
					JScrollPane scroll = new JScrollPane(new JList(this.followers.toArray()));
					scroll.setPreferredSize(new Dimension(450, 150));
					scrollPanel.add(scroll);
					
					//Add scroll component 
					frame.setVisible(true);
					panel.add(scrollPanel);
					panel.revalidate();
					panel.repaint();
				 }
			 }
		}
		
	}
}
