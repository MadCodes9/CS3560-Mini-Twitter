import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
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
    private JPanel panel2; 
    private JPanel panel3;
    private JPanel panel4;
    private List<SystemEntry> allUsers;
    private User user;
    private User followUser;
	private Admin adminInstance;
	private String currUser;
	
	private List<String> followers;
	private List<String> messages;
	private String lastUpdateTime;
	private JPanel scrollPanel = new JPanel();
	private JPanel scrollPanel2 = new JPanel();
	
	private List<UserView> userViewList;
	
	private JButton refreshButton;
	  
	UserView(String selectedUser){
		this.userViewList = new ArrayList<UserView>();
		this.currUser = selectedUser;
		
		//Set curr user
		setCurrUser();
		
		//Lay everything out.
		frame = new JFrame(this.currUser);
		
		//Refresh button
		refreshButton = new JButton("Refresh");
		refreshButton.setBounds(400, 260, 80, 30);
		refreshButton.addActionListener(this);
				
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
		frame.setSize(new Dimension(500, 600));
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setBackground(Color.white);
		
		panel= new JPanel();
		panel.setBounds(0, 50, 500, 200);
		panel.add(new JLabel("<html>Current Following<br/></html>", SwingConstants.CENTER));
		panel.setBackground(Color.white);
		
		
		
		panel2 = new JPanel();
		panel2.setBounds(0, 340, 500, 200);
		panel2.add(new JLabel("News Feed", SwingConstants.CENTER));
		panel2.setBackground(Color.white);
		
		//Panel for creation time
        panel3 = new JPanel();
        panel3.setBounds(0, 290, 520, 20);
		panel3.add(new JLabel("Creation Time: " + getCreationTime(), SwingConstants.CENTER));
		
		
		//Panel for last update time
        panel4 = new JPanel();
        panel4.setBounds(0, 309, 520, 20);
        
		//Add components to frame
		frame.add(refreshButton);
		frame.add(followUserTextField);
		frame.add(followUserButton);
		frame.add(tweetMessageTextField);
		frame.add(tweetMessageButton);
		frame.add(panel);
		frame.add(panel2);
		frame.add(panel3);
		frame.add(panel4);
		
	}

	//Get the last creation time of user 
	String getCreationTime() {
		if(this.user == null) {
			return "Printed in console";
		}
		else {
			return this.user.getCreationTime().toString();
		}
	}
	
	//Get the last update time of user
	String getLastUpdateTime() {
		if(this.user == null) {
			return "Printed in console";
		}
		else if( this.user.getLastUpdateTime() == null) {
			return "N/A";
		}
		else {
			return this.user.getLastUpdateTime().toString();
		}
	}
	
	User getCurrUser() {
		return this.user;
	}
	
	public void setUserViewList(List<UserView> userViewList) {
		this.userViewList = userViewList;
	}
	
	void setCurrUser() {
		this.adminInstance = Admin.getInstance();
		this.allUsers = this.adminInstance.getUser();
		
		//Cast current user 
		 for(SystemEntry user : allUsers) {				 
			 if(this.currUser.equals(user.toString())) {
				 this.user = (User) user;	//cast to User 
				 System.out.println("User is: " + user.toString());
			 }
		 }
	}
	
	void refresh() {
		scrollPanel2.removeAll(); //remove to update
		panel4.removeAll(); //remove last update time to update panel
		
		//Get list of messages
		this.messages = this.user.getMessages();
		
		//Update the last update time 
		getLastUpdateTime();
		
		//Display on user's news feed
		JScrollPane scroll = new JScrollPane(new JList(this.messages.toArray()));
		scroll.setPreferredSize(new Dimension(450, 150));
		scrollPanel2.add(scroll);
		
		//Panel for last update time
		panel4.add(new JLabel("Last Update Time: " + getLastUpdateTime(), SwingConstants.CENTER));
		panel4.revalidate();
		panel4.repaint();
		
		//Add scroll component 
		frame.setVisible(true);
		panel2.add(scrollPanel2);
		panel2.revalidate();
		panel2.repaint();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == followUserButton) {
			scrollPanel.removeAll(); //remove to update
			
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
		else if (e.getSource() == tweetMessageButton) {
			scrollPanel2.removeAll(); //remove to update
			panel4.removeAll(); //remove last update time to update panel
			
			//User posts a message
			this.user.postMessage(tweetMessageTextField.getText());
			
			//Get list of messages
			this.messages = this.user.getMessages();
			
			//Display on user's news feed
			JScrollPane scroll = new JScrollPane(new JList(this.messages.toArray()));
			scroll.setPreferredSize(new Dimension(450, 150));
			scrollPanel2.add(scroll);
			
		
			panel4.add(new JLabel("Last Update Time: " + getLastUpdateTime(), SwingConstants.CENTER));
			panel4.revalidate();
			panel4.repaint();
			
			
			//Add scroll component 
			frame.setVisible(true);
			panel2.add(scrollPanel2);
			panel2.revalidate();
			panel2.repaint();
			
			for(UserView u: userViewList) {
				if(this.currUser.equals(u.getCurrUser().toString())) {
					//do nothing
				}
				else {
					this.followers = this.getCurrUser().getFollowers();
					for(int i = 0; i < this.followers.size(); i++) {
						System.out.println("Update followers news feed: " + this.followers.get(i));
						
						//If any users equals to the current's users followers, than update the followers
						if(u.getCurrUser().toString().equals(this.followers.get(i))) {
							
							u.refresh();
						}
					}
				}
			}
			
		}
		else if (e.getSource() == refreshButton) {
			refresh();
		}
	}
}
