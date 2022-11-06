import java.util.ArrayList;
import java.util.List;

//1. There is a centralized admin control panel to create users and user groups.
//6. A few analysis features are needed in the admin control panel: 1) output the total
//number of users; 2) output the total number of groups; 3) output the total number of
//Tweet messages in all the users’ news feed; 4) output the percentage of the positive
//Tweet messages in all the users’ news feed (the message containing positive words,
//such as good, great, excellent, etc.) Free free to decide the positive words.

/**
 * 
 * With Composite we can treat tree hierarchies of objects with uniform
 * interface (LetterComposite). In this example we have sentences composed of
 * words composed of letters.
 * 
 */
public class Admin extends TreeView implements SystemEntry{
	
	//Singleton pattern for instance
	private TreeView treeViewInstance;
	private List<SystemEntry> user;
	private List<SystemEntry> userGroup;
	
    public Admin() {
    	treeViewInstance = new TreeView();
    	user = new ArrayList<SystemEntry>();
    	userGroup = new ArrayList<SystemEntry>();
    }
        
    public void addUser() {
		user.add(new User(treeViewInstance.getUser()));
		printTotalUsers();
		
		System.out.println("Added " + treeViewInstance.getUser() + " user");
	}
    
    public void addUserGroup() {
    	userGroup.add(new UserGroup(treeViewInstance.getUserGroup()));
    	printTotalUserGroups();
    	
    	System.out.println("Added " + treeViewInstance.getUserGroup() + " user group");
    }

    //Composite methods
	@Override
	public void printTotalUsers() {
		user.forEach(SystemEntry::printTotalUsers);
	}
	@Override
	public void printTotalUserGroups(){
		userGroup.forEach(SystemEntry::printTotalUserGroups);
		
	}
    
//    SystemEntry addUserGroup() {
//    	List<UserGroup> userGroup = new ArrayList<UserGroup>();
//    	userGroup.add(new UserGroup())
//    	
//    }
    


}
