import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.tree.DefaultMutableTreeNode;

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

public class User implements SystemEntry, Observer{
	private String id;
	private static int numOfUsers = 0;
	private static int numOfMessages = 0;
	private HashMap<String, String> following;
	private List<User> followers;
	
	
	TwitterNewsFeed twitterNewsFeed;

	public User(String id){
		super();
		this.id = id;
		this.following = new HashMap<String, String>();
		this.followers = new ArrayList<User>();
		
		this.twitterNewsFeed = new TwitterNewsFeed();
		
		numOfUsers++;
	}
	
	/*
	 * Getter method for user id 
	 * return String
	*/
	public String getId() {
		return this.id;
	}
	
	/*
	 * This is to show id on the Tree View
	 */
	public String toString() {
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
	public void follow(Observer obs) {
		//following.put(getId(), id);
		twitterNewsFeed.attach(obs);
		System.out.println(getId() + " now following " + obs.toString());
	}

	public void postMessage(String message) {
		System.out.println(getId() + " posted on topic: " + message);			
	    twitterNewsFeed.notifyObservers(message);  
	}
	
	@Override
	public void update(String obs, String message) {
		if(message == null) {
			System.out.println("No message");
		}
		else {
			System.out.println("Message to " + obs + ":" + message);
		}
			
			
	}
	

	/*
	 * Return the total number of messages
	 * @return integer
	*/
	public int getTotalMessages() {
		return numOfMessages;
	}
	
	//From composite class
	/*
	 * Return the total number of users
	 * @return integer
	*/
	@Override
	public int getTotalUsers() {
//		 String.valueOf(getTotalNumOfUsers());
		return numOfUsers;
	}

	@Override
	public int getTotalUserGroups() {
		// Do nothing
		return 0;
	}



}
