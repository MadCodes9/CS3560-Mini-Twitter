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
	private List<String> users;	
	private String message;
	HashMap<User, String> m;
	
	public TwitterNewsFeed() {
		this.observers = new ArrayList<>();
		this.users = new ArrayList<String>();
	}
	
	
	public void printNewsFeed() {
		System.out.println("= News Feed =");
		
	}
		
	@Override
	public void attach(Observer obs) {
		observers.add(obs);
	}
	
	@Override
	public void detach(Observer obs) {
		observers.remove(obs);
	}
	
	@Override
	public void notifyObservers(String message) {
		System.out.println("Notified followers");
		
		if(!observers.isEmpty() && observers != null) {
			for (Observer obs : observers) {
				obs.update(obs.toString(), message);
			}
			
		}
		else {
			System.out.println("There are no post to notify");
		}
	}

	
	
}
