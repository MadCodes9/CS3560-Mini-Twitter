//Observer pattern
public interface Subject {
	public void attach(Observer observer);
	public void detach(Observer observer);
//	public Object getMessage();
	public void notifyObservers(String message);	
}
