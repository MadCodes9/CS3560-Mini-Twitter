import java.util.List;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class TwitterNewsFeed implements Subject{
	/*
	 * 
	 * TwitterNewsFeed can be observed by implementing Observer interface and
	 * registering as listener.
	 * 
	 */
	private List<Observer> observers;
	
	public TwitterNewsFeed() {
		this.observers = new ArrayList<>();
	}
	
	/*
	 * Display the current news feed for debugging purposes
	 * @param HashMap<String, List<String>> the String of users and List of messages
	 */
	public void displayNewsFeed(HashMap<String, List<String>> messages) {
		System.out.println("= News Feed =");
		messages.entrySet().forEach(entry -> {
		    System.out.println(entry.getKey() + ": " + entry.getValue());
		});
		
	}
		
	/*
	 * Attach an observer to the current user, so that they are notified when updates occur
	 * @param Observer the user that is going to be notified 
	 */
	@Override
	public void attach(Observer obs) {
		observers.add(obs);
	}
	
	/*
	 * Detach an observer from the current user, so that they are no longer notified when updates occur
	 * @param Observer the user that is going to no longer be notified 
	 */
	@Override
	public void detach(Observer obs) {
		observers.remove(obs);
	}
	
	/*
	 * Notify all the observers of the current user, so that the curr user's followers are updated 
	 * @param String the current user, String the message to be updated 
	 */
	@Override
	public void notifyObservers(String sender, String message) {
		System.out.println("Notified followers");
		
		if(!observers.isEmpty() && observers != null) {
			for (Observer obs : observers) {
				obs.update(sender, obs.toString(), message);
			}
			
		}
		else {
			System.out.println("There are no post to notify");
		}
	}

	
	
}
