import java.util.List;
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
	private List<String> messages;
	private String message;
	
	public TwitterNewsFeed() {
		this.observers = new ArrayList<>();
		this.users = new ArrayList<String>();
		this.messages  = new ArrayList<String>();		
	}
	
	public void postMessage(String message) {
		  System.out.println("Message posted on topic: " + message);
	      this.message = message;
	      messages.add(message);
	      notifyObservers();
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
	public String getMessage() {
		return this.message;
	}
	
	@Override
	public void notifyObservers() {
		System.out.println("Notified followers and yourself!");
//		
//		this.message = message;
		if(!observers.isEmpty() && observers != null) {
			for (Observer obs : observers) {
				obs.update(getMessage());
			}
		}
		else {
			System.out.println("There are no post to notify");
		}
	}
	
	
}
