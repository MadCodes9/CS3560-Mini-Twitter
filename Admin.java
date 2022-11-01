import java.util.ArrayList;
import java.util.List;

//1. There is a centralized admin control panel to create users and user groups.
//6. A few analysis features are needed in the admin control panel: 1) output the total
//number of users; 2) output the total number of groups; 3) output the total number of
//Tweet messages in all the users’ news feed; 4) output the percentage of the positive
//Tweet messages in all the users’ news feed (the message containing positive words,
//such as good, great, excellent, etc.) Free free to decide the positive words.


//THIS IS THE COMPOSITE CLASS/ELEMENT
public class Admin implements TwitterUsers{
	private List<TwitterUsers> childUsers;
	private List<TwitterUsers> users;
	private List<TwitterUsers> userGroups;
	
    public Admin() {
        this.childUsers = new ArrayList<>();
        this.users = new ArrayList<>();
        this.userGroups = new ArrayList<>();
    }
    
    public void addUser(TwitterUsers user) {
    	childUsers.add(user);
    	users.add(user);
    }
    
    public void addUserGroup(TwitterUsers userGroup) {
    	childUsers.add(userGroup);
    	userGroups.add(userGroup);
    }
    
//    public void getUserTotal() {
//    	users.size();
//    }
//    
//    public void getUserGroupTotal() {
//    	userGroups.size();
//    }
    
	@Override
	public void totalNum() {
		//childUsers.forEach(TwitterUsers::totalNum);
//		users.forEach(TwitterUsers::totalNum);
//		userGroups.forEach(TwitterUsers::totalNum);
		System.out.println("User Size: " + users.size());
		System.out.println("User Group Size: " + userGroups.size());
		System.out.println(childUsers.size());
		
	}

}
