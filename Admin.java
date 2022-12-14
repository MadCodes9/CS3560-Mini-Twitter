import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

/**
 * 
 * With Composite we can treat tree hierarchies of objects with uniform
 * interface (SystemEntry).
 * 
 * Implementation of Visitor pattern 
 */
public class Admin extends TreeView implements SystemEntry, UserTypeVisitor{
	private List<SystemEntry> user;
	private List<SystemEntry> userGroup;
	private List<String> userList;
	private List<String> userGroupList;
	private User currentUser;
	private UserGroup currentUserGroup;
	protected static Admin adminInstance;
	private static float totalPositiveFound = 0;
	
	private float positivePercentage;
	
    public Admin() {
    	user = new ArrayList<SystemEntry>();
    	userGroup = new ArrayList<SystemEntry>();
    	userList = new ArrayList<String>();
    	userGroupList =  new ArrayList<String>();
    }
    
    /*
     * Singleton instance created
     * @return Admin the instance created 
     */
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
    	this.userList.add(user);
    	
    	//Set the creation time for user
     	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    	this.currentUser.setCreationTime(timestamp);
    	
		System.out.println("Total users: " + getTotalUsers());
	 	System.out.println("Added " + user + " user");
	}
    
    /*
     * Add a new user group, obtaining the data from the text-field 
     */
    public void addUserGroup(String userGroup) {
    	this.currentUserGroup = new UserGroup(userGroup);
    	this.userGroup.add(this.currentUserGroup);
    	this.userGroupList.add(userGroup);
    	
    	//Set the creation time for user group 
    	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    	this.currentUserGroup.setCreationTime(timestamp);
    
    	System.out.println("Total user groups: " + getTotalUserGroups());
    	System.out.println("Added " + userGroup + " user group");
    }
    
    /*
     * Get the current user 
     * @return List<SystemEntry> the user 
     */
    public List<SystemEntry> getUser() {
    	return this.user;
    }
    
    /*
     * Get the total amount of messages, if null then return 0
     * @return int the message total
     */
    public int getMessageTotal() {
    	if(this.currentUser == null) {
    		return 0;
    	}
    	else {
    		return this.currentUser.getTotalMessages();
    	}
    }
    
    /*
     * Get the positive percentage from the current user
     * @return float the positive percentage 
    */
    public float getPositivePercentage() {
    	if(this.currentUser == null) {
    		return positivePercentage;
    	}
    	else {
    		visit(this.currentUser);
    		return positivePercentage;
    	}
    }
    
    /*
	 * Composite method
	 * Return the total user size 
	 * @return int the user size 
	 */
	@Override
	public int getTotalUsers() {
		return user.size();
	}
	
	/*
	 * Composite method
	 * Return the total user group size 
	 * @return int the user group size 
	 */ 
	@Override
	public int getTotalUserGroups(){
		return userGroup.size();
		
	}

	/*
	 * From Visitor class
	 * Get the messages that users posted and check if there are any positive words
	 * @param User the user to check their messages
	 */
	@Override
	public void visit(User user) {
		List<String> checkMessages = user.getMessages();
		float totalMessages = user.getTotalMessages();	
		String[] positiveWords = {"happy", "good", "wonderful", "love", "lovely",
				"winner", "exceptional", "great"};
		String[] words = new String[] {};
		
		//Avoid undefined errors
		 if(totalMessages == 0) {
			 //do nothing 
		 }
		 else {
			//Spilt words from each message 
				for(int i = 0; i < checkMessages.size(); i++) {
					words = checkMessages.get(i).split("\\W+");	
				}
				
				//Find if any words have positive words and if so increase percentage
				 for (String word: words) {
					 for (String positiveWord: positiveWords) {
				           if(word.contains(positiveWord)) {
				        	   //increase positive message found  
				        	   totalPositiveFound++;
				        	 
				           }
				     }
			     }
				positivePercentage = (float)((totalPositiveFound / totalMessages) * 100);
		 }
	}

	@Override
	public void visit(UserGroup userGroup) {
		// do nothing
		
	}

	@Override
	public boolean validate(String id) {
		//Is not valid
		if(id.contains(" ")) {
			return false;
		}
		if(userList.contains(id) || userGroupList.contains(id)) {
			return false;
		}
		else {
			//Is valid 
			return true; 
		}
	}
	
	//Get the last user update
	public String getLastUpdatedUser() {
		if(currentUser.getLastUpdateUser() == null) {
			return "N/A";
		}
		else {
			return currentUser.getLastUpdateUser();
		}
	}
	
}
