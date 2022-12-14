import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//Leaf class of composite pattern
public class User implements SystemEntry, Observer, Visitable{
	private String id;
	private static int numOfUsers = 0;
	private static int numOfMessages = 0;
	private HashMap<String, List<String>> followers;
	private HashMap<String, List<String>> messages;
	private List<String> follower;
	private List<String> message;
	private List<String> listOfFollowers;
	private List<String> listOfMessages;
	private TwitterNewsFeed twitterNewsFeed;
	
	private Timestamp creationTime;
	private Timestamp lastUpdateTime;
	private String lastUpdateUser;

	public User(String id){
		super();
		this.id = id;
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
	 * Setter method for creation time of user
	 */
	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}
	
	/*
	 * Getter method for creation time of user
	 * return  Timestamp the  last update time 
	 */
	public Timestamp getCreationTime() {
		return creationTime;
	}
	

	/*
	 * Setter method for last update time of user
	 */
	public void setLastUpdateTime(Timestamp lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	
	/*
	 * Getter method for last update time of user post
	 * return Timestamp the  last update time 
	 */
	public Timestamp getLastUpdateTime() {
		return lastUpdateTime;
	}
	
	/*
	 * Getter method for last update user
	 * return String the  last update user 
	 */
	public String getLastUpdateUser() {
		return lastUpdateUser;
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
	
	/*
	 * Get the all the followers of the current user 
	 * @return List<String> the list of followers 
	 */
	public List<String> getFollowers() {
		this.listOfFollowers = new ArrayList<String>();
		
		for (String key : followers.keySet()) {
		    for (String r : followers.get(key)) {
		    	listOfFollowers.add(r.toString());    
		    }
		}
		 return listOfFollowers;	
	}
	
	/*
	 * Get the all the messages of the current user 
	 * @return List<String> the list of messages 
	 */
	public List<String> getMessages(){
		this.listOfMessages = new ArrayList<String>();
		
		for (String key : messages.keySet()) {
		    for (String r : messages.get(key)) {
		    	listOfMessages.add(r.toString());    
		    }
		}
		return listOfMessages;
	}

	/*
	 * Post a message on News Feed and notify all followers of posted message
	 * @param String a message to be posted 
	 */
	public void postMessage(String message) {
		String post;
		numOfMessages++;	//increase total message size
		
		//Last update time is set when user posts a message 
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		setLastUpdateTime(timestamp);
		System.out.println("UPDATE TIME: " + getLastUpdateTime());	
		
		//last updated user
		lastUpdateUser = getId();
		
		//Current user should be able to see their own post in News Feed
		post = getId() + ": " + message;
		this.message.add(post);
		Arrays.asList(this.message);
		
		//Add messages to current user 
		messages.put(getId(), this.message);
		  
		System.out.println("LAST UPDATED USER: " + getId());			
	    twitterNewsFeed.notifyObservers(getId(), message, getLastUpdateTime());  
	    twitterNewsFeed.displayNewsFeed(messages);
	}
	
	/*
	 * Update the current user's follower's messages
	 * @param String the current user, String the follower to be updates, String the message to be updated
	 */
	@Override
	public void update(String sender, String obs, String message, Timestamp lastUpdateTime) {
		String post;

		if(message == null) {
			System.out.println("No message");
		}
		else {
			numOfMessages++; //update total message when updated in followers feed
			
			post = sender + ": " + message;
			this.message.add(post);
			Arrays.asList(this.message);
			
			//Add messages to current user 
			messages.put(obs, this.message);
			
			//Update to in followers feed of last time updated
			setLastUpdateTime(lastUpdateTime);
			
			System.out.println("Message to " + obs + " from " + sender + ": " + message);
			System.out.println("FOLLWER LAST UPDATE TIME: " + getLastUpdateTime());
		
		}		
	}
	

	/*
	 * Return the total number of messages
	 * @return integer
	*/
	public int getTotalMessages() {
		return numOfMessages;
	}
		
	/*
	 * Return the total number of users
	 * From composite class
	 * @return integer
	*/
	@Override
	public int getTotalUsers() {
		return numOfUsers;
	}

	@Override
	public int getTotalUserGroups() {
		// Do nothing
		return 0;
	}

	/*
	 * Implementation from Visitor interface 
	 * @param UserTypeVisitor the visitor type User 
	 */
	@Override
	public void accept(UserTypeVisitor visitor) {
		visitor.visit(this);
	}
}
