import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

//Uses composite pattern//leaf class
public class UserGroup implements SystemEntry, Visitable {
	private String id;
	private static int numOfUserGroups = 0;
	private List<User> userGroup;
	private Timestamp creationTime;

	/*
	 * Setter method for creation time of user group
	 */
	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
		System.out.println("Creation time for user group: " + this.creationTime);
	}
	
	/*
	 * Getter method for creation time of user group
	 * return long the creation time
	 */
	public Timestamp getCreationTime() {
		return creationTime;
	}
	
	public UserGroup(String id){
		super();
		this.id = id;
		this.userGroup = new ArrayList<User>();
		numOfUserGroups ++;
	}
	
	/*
	 * Getter method for user group id 
	 * return String
	*/
	public String getId() {
		return this.id;
	}

	/*
	 * Setter method for user group id 
	 * @param String the user group id
	*/
	public void setId(String id) {
		this.id = id;
	}
	
	/*
	 * Add user to user group list
	 * @param user the user to be added 
	 */
	public void add(User user) {
		userGroup.add(user);
	}

	//From composite class
	@Override
	public int getTotalUsers() {
		// Do nothing 
		return 0;
	}

	/*
	 * Return the total number of user groups  
	 * @return integer
	*/
	@Override
	public int getTotalUserGroups() {
		//System.out.println("Total number of user groups: " + String.valueOf(getTotalNumOfUserGroups()));	
		return numOfUserGroups;
	}

	/*
	 * Implementation from Visitor interface 
	 * @param UserTypeVisitor the visitor type UserGroup 
	 */
	@Override
	public void accept(UserTypeVisitor visitor) {
		visitor.visit(this);
	}
	
	
}
