import java.util.ArrayList;
import java.util.List;

//1. There is a centralized admin control panel to create users and user groups.
//6. A few analysis features are needed in the admin control panel: 1) output the total
//number of users; 2) output the total number of groups; 3) output the total number of
//Tweet messages in all the users’ news feed; 4) output the percentage of the positive
//Tweet messages in all the users’ news feed (the message containing positive words,
//such as good, great, excellent, etc.) Free free to decide the positive words.

public class Admin extends TreeView {
	
	//Singleton pattern for instance
	private TreeView treeViewInstance;
	private String textField;
	
    public Admin(String textField) {
    	this.textField = textField;
    }
        
//    private void addUser() {
//    	if(treeViewInstance.getUser() != null) {
//    		User user = new User(treeViewInstance.getUser());
//    		
//    		
//    	}
//    	else {
//    		System.out.println("No user to add");
//    	}
//    	
//    }
//    
    
    private void addUserGroup(UserGroup userGroup) {

    }
    
    public void addUser() {
		List<User> user = new ArrayList<User>();
		user.add(new User(this.textField));
		
		for (User w : user) {
			System.out.println("Total Users: " +String.valueOf(w.totalNumOfUsers()));;
			System.out.println(user);
		}
		System.out.println("Added " + this.textField + " user");
	}
    
//    SystemEntry addUserGroup() {
//    	List<UserGroup> userGroup = new ArrayList<UserGroup>();
//    	userGroup.add(new UserGroup())
//    	
//    }
    


}
