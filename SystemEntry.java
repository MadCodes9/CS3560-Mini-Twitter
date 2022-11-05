import java.util.ArrayList;
import java.util.List;


/**
 * 
 * Composite interface.
 * 
 */
public abstract class SystemEntry {
	private List<SystemEntry> children = new ArrayList<SystemEntry>();
	
	public void add(SystemEntry user) {
		children.add(user);
	}

	public int count() {
		return children.size();
	}

	protected abstract void printThisBefore();

	protected abstract void printThisAfter();

	public void print() {
		printThisBefore();
		for (SystemEntry user : children) {
			user.print();
		}
		printThisAfter();
	}
}
