import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//2. A user has 1) an unique ID; 2) a list of user IDs that are following this user (followers); 3)
//a list of user IDs being followed by this user (followings); 4) a news feed list containing a
//list of Twitter messages.

//4. Users can choose to follow other users (not user groups) by providing the target user ID.
//Unfollow is not required.
//
//5. Users can also post a short Tweet message (a String), so that all the followers can see
//this message in their news feed lists. Of course, the user can also see his or her own
//posted messages.

//Uses composite pattern//leaf class

public class User implements TwitterUsers, Observer{
	private String id;
	private static int numOfUsers = 0;
	private HashMap<String, String> following;
	private List<User> followers;

	User(String id){
		this.id = id;
		this.following = new HashMap<String, String>();
		this.followers = new ArrayList<User>();
		numOfUsers++;
	}
	
	/*
	 * Return the total number 
	 * return integer
	*/
	@Override
	public void totalNum() {
		System.out.println(String.valueOf(getTotalNum()));
	}
	
	/*
	 * Getter method for user id 
	 * return String
	*/
	public String getId() {
		return this.id;
	}
	
	/*
	 * Setter method for user id 
	 * @param id  unique user id 
	*/
	public void setId(String id) {
		this.id = id;
	}
	
	/*
	 * Current user follows another user
	*/
	public void follow(String id) {
		following.put(getId(), id);
	}
	
	
	public int getTotalNum() {
		return numOfUsers;
	}
	
	@Override
	public void update(Message message) {
		System.out.println(getId() + ":" + message.getMessageContent());
		
		
	}

}
