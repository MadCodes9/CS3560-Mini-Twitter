import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

//1. There is a centralized admin control panel to create users and user groups.
//6. A few analysis features are needed in the admin control panel: 1) output the total
//number of users; 2) output the total number of groups; 3) output the total number of
//Tweet messages in all the users’ news feed; 4) output the percentage of the positive
//Tweet messages in all the users’ news feed (the message containing positive words,
//such as good, great, excellent, etc.) Free free to decide the positive words.

public class Admin extends TreeView {
	//private List<Admin> childUsers;
//	private List<User> users;
//	private List<UserGroup> userGroups;
//	
	
	private List<DefaultMutableTreeNode> root;
	private List<DefaultMutableTreeNode> userGroups;
	private DefaultMutableTreeNode users;
	private DynamicTree treePanel;
	private TreeView treeViewInstance;
	
	
	private HashMap<User, UserGroup> usersUserGroups;
	
    public Admin() {
        //this.childUsers = new ArrayList<>();
//        this.users = new ArrayList<>();
//        this.userGroups = new ArrayList<>();
        this.root = new ArrayList<>();
        //this.users = new ArrayList<>();
        this.userGroups = new ArrayList<>();
        
        //CREATE SINGLETON FOR INSATNCE
//        this.treePanel = this.treeViewInstance.getTreePanel();
        
//        this.treeViewInstance = new TreeView();
        
        this.usersUserGroups = new HashMap<>();
        
    }
    
//    public void addUserAtRoot(User user) {
//    	this.root.add(this.treePanel.addObject(null, user));
//   
//    }
    
    
    public void addUser(User user) {
    	this.users = user;
    }
    
    public DefaultMutableTreeNode getUser() {
    	return this.users;
    }
    
    
    
    public void addUserGroup(UserGroup userGroup) {
    	//childUsers.add(userGroup);
//    	userGroups.add(userGroup);
    }
    
    
//	public void totalNum() {
//		//childUsers.forEach(TwitterUsers::totalNum);
////		users.forEach(TwitterUsers::totalNum);
////		userGroups.forEach(TwitterUsers::totalNum);
//		System.out.println("User Size: " + users.size());
//		System.out.println("User Group Size: " + userGroups.size());
//		System.out.println(childUsers.size());
//		
//	}

}
