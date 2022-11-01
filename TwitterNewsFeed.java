import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class TwitterNewsFeed implements Subject {
	/*
	 * 
	 * TwitterNewsFeed can be observed by implementing Observer interface and
	 * registering as listener.
	 * 
	 */
	private List<Observer> observers;
	
	public TwitterNewsFeed() {
		this.observers = new ArrayList<>();
		//currentWeather = WeatherType.SUNNY;
	
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
	 public void notifyObservers(Message message) {
		System.out.println("Notified followers!");
		for (Observer obs : observers) {
			obs.update(message);
		}
	}
}
