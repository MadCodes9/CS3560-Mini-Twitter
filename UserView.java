import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class UserView extends JPanel implements ActionListener{
	private JFrame frame;
	private JLabel label;
	
    private JButton followUserButton;
    private JTextField followUserTextField;
    private JButton tweetMessageButton;
    private JTextField tweetMessageTextField;
	
	UserView(String selectedUser){
		//Lay everything out.
		frame = new JFrame(selectedUser);
		
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
		
		JPanel panel= new JPanel();
		panel.setBounds(0, 50, 500, 200);
		panel.add(new JLabel("Current Following", SwingConstants.CENTER));
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
		// TODO Auto-generated method stub
		
		
	}
}
