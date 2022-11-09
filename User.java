import java.util.ArrayList;
import java.util.Arrays;
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
	//private HashMap<String, String> following;
	private HashMap<String, List<String>> followers;
	private HashMap<String, List<String>> messages;
	private List<String> follower;
	private List<String> message;
	List<String> listOfFollowers;
	List<String> listOfMessages;
	
	TwitterNewsFeed twitterNewsFeed;

	public User(String id){
		super();
		this.id = id;
		//this.following = new HashMap<String, String>();
		this.followers = new HashMap<String, List<String>>();
		this.messages = new HashMap<String, List<String>>();
		this.follower = new ArrayList<String>();
		this.message = new ArrayList<String>();
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
	 * Current user follows another user and store in hash map 
	 * @param Observer the user to follow
	*/
	public void follow(Observer user) {
		follower.add(user.toString());
		 Arrays.asList(follower);
		 
		//Add followers to current user
		followers.put(getId(), follower);
		
		twitterNewsFeed.attach(user);
		System.out.println(getId() + " now following " + user.toString());
	}
	
	public List<String> getFollowers() {
		this.listOfFollowers = new ArrayList<String>();
		
		for (String key : followers.keySet()) {
		    for (String r : followers.get(key)) {
		    	listOfFollowers.add(r.toString());    
		    }
//		    System.out.println(key + " is following " + listOfFollowers);
		}
//		
//		followers.entrySet().forEach(entry -> {
//			
//			listOfFollowers.add(entry.getValue().toString());
//		    System.out.println(entry.getKey() + " is following " + entry.getValue());
//		});
		 return listOfFollowers;	
	}
	
	public List<String> getMessages(){
		this.listOfMessages = new ArrayList<String>();
		
		for (String key : messages.keySet()) {
		    for (String r : messages.get(key)) {
		    	listOfMessages.add(r.toString());    
		    }
//		    System.out.println(key + " is following " + listOfFollowers);
		}
		return listOfMessages;
	}

	/*
	 * Post a message on News Feed and notify all followers of posted message
	 * @param String a message to be posted 
	 */
	public void postMessage(String message) {
		String post;
		
		//Current user should be able to see their own post in News Feed
		post = getId() + ": " + message;
		this.message.add(post);
		Arrays.asList(this.message);
		
		//Add messages to current user 
		messages.put(getId(), this.message);
		
		System.out.println(getId() + " posted on topic: " + message);			
	    twitterNewsFeed.notifyObservers(getId(), message);  
	    
	    twitterNewsFeed.displayNewsFeed(messages);
	}
	
	@Override
	public void update(String sender, String obs, String message) {
		String post;

		if(message == null) {
			System.out.println("No message");
		}
		else {
			post = sender + ": " + message;
			this.message.add(post);
			Arrays.asList(this.message);
			
			//Add messages to current user 
			messages.put(obs, this.message);
			
			System.out.println("Message to " + obs + " from " + sender + ": " + message);
			
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
