import java.util.ArrayList;
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

public class User implements TwitterUsers{
	private String id;
	private int numOfUsers = 0;
	private List<String> followers;
	private List<User> following;
	private TwitterNewsFeed twitterNewsFeed;

	User(String id){
		this.id = id;
		this.numOfUsers += 1;
		followers = new ArrayList<String>();
		following = new ArrayList<User>();
		twitterNewsFeed = new TwitterNewsFeed();
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
	 * return String
	*/
	public void setId(String id) {
		this.id = id;
	}
	
	/*
	 * Display the twitter news feed
	*/
	public void displayNewsFeed() {
		twitterNewsFeed.getNewsFeed();
	}
	
	/*
	 * User follows another user
	*/
	public void follow(String id) {
		followers.add(id);
	}
	
	public void post(String msg) {
		
	}
	
	public int getTotalNum() {
		return this.numOfUsers;
	}

	/*
	 * Return the total number 
	 * return integer
	*/
	@Override
	public void totalNum() {
		System.out.println(String.valueOf(getTotalNum()));
	}
	
	


}
