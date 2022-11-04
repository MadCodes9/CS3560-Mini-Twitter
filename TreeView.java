
/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
 

 
/*
 * This code is based on an example provided by Richard Stanford, 
 * a tutorial reader.
 */
 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
 
public class TreeView extends JPanel implements ActionListener {
    private int newNodeSuffix = 1;
//    private static String ADD_COMMAND = "add";
    private static String REMOVE_COMMAND = "remove";
    private static String CLEAR_COMMAND = "clear";

    private DynamicTree treePanel;
    private Admin adminInstance;
    
    private JButton addUserButton;
    private JTextField addUserTextField;
    
    private JButton addGroupButton;
    private JTextField addGroupTextField;
    
    private JButton userViewButton;
    private JButton userTotalButton;
    private JButton groupTotalButton;
    private JButton messageTotalButton;
    private JButton percentageButton;

 
    public TreeView() {
        super(new BorderLayout());
         
        //Create the components.
        treePanel = new DynamicTree();        
        populateTree(treePanel);
       
        
 
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
        addUserButton.addActionListener(this);
        
        //User Text Field 
        addUserTextField = new JTextField();
        addUserTextField.setPreferredSize(new Dimension(250, 40));
        addUserTextField.setForeground(Color.gray);
        addUserTextField.setText("User Id");
        
        //Group Button 
        addGroupButton = new JButton("Add Group");
        addGroupButton.addActionListener(this);
        
        //Group Text Field
        addGroupTextField = new JTextField();
        addGroupTextField.setPreferredSize(new Dimension(250, 40));
        addGroupTextField.setForeground(Color.gray);
        addGroupTextField.setText("Group Id");

        //User View Button 
        userViewButton = new JButton("Open User View");
        userViewButton.addActionListener(this);
        
        //User Total Button
        userTotalButton = new JButton("Show User Total");
        userTotalButton.addActionListener(this);
        
        //Group Total Button
        groupTotalButton = new JButton("Show Group Total");
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
        panel2.setPreferredSize(new Dimension(300,150));
        
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
        	System.out.println("Added " + addUserTextField.getText() + " user");
        	
        }
        else if(e.getSource() == addGroupButton) {
        	
        	DefaultMutableTreeNode parentNode = null;
        	//get current selected tree node 
            TreePath parentPath = treePanel.getCurrentTreeNode().getSelectionPath();
        	 parentNode = (DefaultMutableTreeNode)
                     (parentPath.getLastPathComponent());
        	 
        	//Add group to current parent node
        	treePanel.addObject(parentNode, addGroupTextField.getText());
        	System.out.println("Added " + addGroupTextField.getText() + " user group");
        }
        else if(e.getSource() == userViewButton) {
        	System.out.println("User view button");
        }
        else if(e.getSource() == userTotalButton) {
        	System.out.println("User total button");
        }
        else if(e.getSource() == groupTotalButton) {
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
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("DynamicTreeDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        TreeView newContentPane = new TreeView();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
         
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
                
            }
        });
    }
}