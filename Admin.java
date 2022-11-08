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
 * interface (SystemEntry).
 * 
 */
public class Admin extends TreeView implements SystemEntry{
	private List<SystemEntry> user;
	private List<SystemEntry> userGroup;
	private User currentUser;
	protected static Admin adminInstance;
	
    public Admin() {
    	user = new ArrayList<SystemEntry>();
    	userGroup = new ArrayList<SystemEntry>();
    }
    
    //singleton instance created
    public static Admin getInstance() {
		if (adminInstance == null) {
			adminInstance = new Admin();
		}
		return adminInstance;
	}
    
    /*
     * Add a new user, obtaining the data from the text-field 
     */
    public void addUser(String user) {
    	this.currentUser = new User(user);
    	this.user.add(this.currentUser);
		System.out.println("Total users: " + getTotalUsers());
	 	System.out.println("Added " + user + " user");
	}
    
    /*
     * Add a new user group, obtaining the data from the text-field 
     */
    public void addUserGroup(String userGroup) {
    	this.userGroup.add(new UserGroup(userGroup));
    	getTotalUserGroups();
    	System.out.println("Total user groups: " + getTotalUserGroups());
    	System.out.println("Added " + userGroup + " user group");
    }
    

    public List<SystemEntry> getUser() {
    	return this.user;
    }
    
    //Composite methods
	@Override
	public int getTotalUsers() {
		return user.size();
		//user.forEach(SystemEntry::printTotalUsers);
	}
	@Override
	public int getTotalUserGroups(){
		return userGroup.size();
		//userGroup.forEach(SystemEntry::printTotalUserGroups);
		
	}

}
