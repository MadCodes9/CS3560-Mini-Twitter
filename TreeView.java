import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
 
//Implements singleton pattern
public class TreeView extends JPanel implements ActionListener {
    private int newNodeSuffix = 1;
//    private static String ADD_COMMAND = "add";
    private static String REMOVE_COMMAND = "remove";
    private static String CLEAR_COMMAND = "clear";

    private DynamicTree treePanel;
    //private Admin adminInstance;
    
    private JButton addUserButton;
    private JTextField addUserTextField;
    
    private JButton addGroupButton;
    private JTextField addGroupTextField;
    
    private JButton userViewButton;
    private JButton userTotalButton;
    private JButton groupTotalButton;
    private JButton messageTotalButton;
    private JButton percentageButton;
    
    private Admin adminInstance;
    
    private List<UserView> userViewList;
    
    
    public TreeView() {
        super(new BorderLayout());
        
        this.userViewList = new ArrayList<UserView>();
        
        //Create the components.
        treePanel = new DynamicTree();        
//        populateTree(treePanel);
          
//        JButton addButton = new JButton("Add");
//        addButton.setActionCommand(ADD_COMMAND);
//        addButton.addActionListener(this);
       
        JButton removeButton = new JButton("Remove");
        removeButton.setActionCommand(REMOVE_COMMAND);
        removeButton.addActionListener(this);
         
        JButton clearButton = new JButton("Clear");
        clearButton.setActionCommand(CLEAR_COMMAND);
        clearButton.addActionListener(this);
        
        
        //User Button 
        addUserButton = new JButton("Add User");
        addUserButton.setPreferredSize(new Dimension(100, 30));
        addUserButton.addActionListener(this);
        
        //User Text Field 
        addUserTextField = new JTextField();
        addUserTextField.setPreferredSize(new Dimension(150, 30));
        addUserTextField.setForeground(Color.gray);
        addUserTextField.setText("User Id");
        
        //Group Button 
        addGroupButton = new JButton("Add Group");
        addGroupButton.setPreferredSize(new Dimension(100, 30));
        addGroupButton.addActionListener(this);
        
        //Group Text Field
        addGroupTextField = new JTextField();
        addGroupTextField.setPreferredSize(new Dimension(150, 30));
        addGroupTextField.setForeground(Color.gray);
        addGroupTextField.setText("Group Id");

        //User View Button 
        userViewButton = new JButton("Open User View");
        userViewButton.setPreferredSize(new Dimension(250, 30));
        userViewButton.addActionListener(this);
        
        //User Total Button
        userTotalButton = new JButton("Show User Total");
        userTotalButton.setPreferredSize(new Dimension(150, 30));
        userTotalButton.addActionListener(this);
        
        //Group Total Button
        groupTotalButton = new JButton("Show Group Total");
        groupTotalButton.setPreferredSize(new Dimension(150, 30));
        groupTotalButton.addActionListener(this);
        
        //Message Total Button
        messageTotalButton = new JButton("Show Message Total");
        messageTotalButton.addActionListener(this);
        
        //Percentage Button
        percentageButton = new JButton("Show Positive Percentage");
        percentageButton.addActionListener(this);
        
 
        //Lay everything out.
        treePanel.setPreferredSize(new Dimension(300, 150));
        add(treePanel, BorderLayout.CENTER);
 
        JPanel panel = new JPanel(new GridLayout(0,3));
        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(350,300));
        
//        panel.add(addButton);
        panel.add(removeButton); 
        panel.add(clearButton);
        panel2.add(addUserButton);
        panel2.add(addUserTextField);
        panel2.add(addGroupButton);
        panel2.add(addGroupTextField);
        panel2.add(userViewButton);
        panel2.add(userTotalButton);
        panel2.add(groupTotalButton);
        panel2.add(messageTotalButton);
        panel2.add(percentageButton);
        add(panel, BorderLayout.SOUTH);  
        add(panel2, BorderLayout.EAST);
    }
    

    
    public void populateTree(DynamicTree treePanel) {        
//    	DefaultMutableTreeNode root = null;
//    	User user0 = new User("stu0");
//    	root = treePanel.addObject(null, user0);
//    	
//        DefaultMutableTreeNode userGroup = null;
//    	DefaultMutableTreeNode user = null;
//    	DefaultMutableTreeNode userGroup2 = null;
//    	
//    	
//    	User user1 = new User("John");
//    	User user2 = new User("Bob");
//    	User user3 = new User("Steve");
//    	User user4 = new User("stu3");
//    	
//    	//Added users to user group 
//    	userGroup = treePanel.addObject(null, "CS356");
//    	treePanel.addObject(userGroup, user1);
//    	treePanel.addObject(userGroup, user2);
//    	treePanel.addObject(userGroup, user3);
//    	
//    	//Nested user group folder
//    	userGroup2 = treePanel.addObject(userGroup, "CS356Session01");
//    	treePanel.addObject(userGroup2, user4);
    	
    }
    
    
    /*
     * Get the user group text field 
     * @return String 
     */
   public String getUserGroup() {
	   return addGroupTextField.getText();
   }
    
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
//        if (ADD_COMMAND.equals(command)) {
//            treePanel.addObject("Added");
//        } 
        if (REMOVE_COMMAND.equals(command)) {
            //Remove button clicked
            treePanel.removeCurrentNode();
        } else if (CLEAR_COMMAND.equals(command)) {
            //Clear button clicked.
            treePanel.clear();
        }
        else if(e.getSource() == addUserButton) {
        	treePanel.addObject(addUserTextField.getText());
        	
        	 //Get singleton instance from TreeView
        	this.adminInstance = Admin.getInstance();
        	
         	//Pass user text-field text to admin, so admin can create a new user 
        	this.adminInstance.addUser(addUserTextField.getText());
        	//new Admin().addUser(addUserTextField.getText());
        	
        	System.out.println("User button");
        	
        	
        }
        else if(e.getSource() == addGroupButton) {
        	
        	DefaultMutableTreeNode parentNode = null;
        	//get current selected tree node 
            TreePath parentPath = treePanel.getCurrentTreeNode().getSelectionPath();
        	 parentNode = (DefaultMutableTreeNode)
                     (parentPath.getLastPathComponent());
        	 
        	//Add group to current parent node
        	treePanel.addObject(parentNode, addGroupTextField.getText());
        	
       	 	//Get singleton instance from Admin
        	this.adminInstance = Admin.getInstance();
        	
         	//Pass user text-field text to admin, so admin can create a new user group
        	this.adminInstance.addUserGroup(addGroupTextField.getText());
        	
        	System.out.println("User group button");
        }
        else if(e.getSource() == userViewButton) {
        	 TreePath parentPath = treePanel.getCurrentTreeNode().getSelectionPath();
   
        	 if(parentPath != null) {
        		//Open up user view window when pressed and pass currently selected user
              	UserView newUserView = new UserView(parentPath.getPathComponent(1).toString());
              	
              	userViewList.add(newUserView);	//list of created user view windows
              	newUserView.setUserViewList(userViewList);	//set user view list 
              	
        	 }
        	 else {
        		 System.out.println("No user selected");
        	 } 
        	System.out.println("User view button");
        }
        else if(e.getSource() == userTotalButton) {
        	//Get singleton instance from Admin
        	this.adminInstance = Admin.getInstance();
        	
        	//Pop-up message
        	JOptionPane.showMessageDialog(null, this.adminInstance.getTotalUsers(),"User Total", JOptionPane.PLAIN_MESSAGE);
        	System.out.println("User total button");
        }
        else if(e.getSource() == groupTotalButton) {
        	//Get singleton instance from Admin
        	this.adminInstance = Admin.getInstance();
        	
        	//Pop-up message
        	JOptionPane.showMessageDialog(null, this.adminInstance.getTotalUserGroups(),"User Group Total", JOptionPane.PLAIN_MESSAGE);
        	System.out.println("Group total button");
        }
        else if(e.getSource() == messageTotalButton) {
        	System.out.println("Message total button");
        }
        else if(e.getSource() == percentageButton) {
        	System.out.println("Positive percentage button");
        } 
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Admin Control Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        TreeView newContentPane = new TreeView();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
         
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}