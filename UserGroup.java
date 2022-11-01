
//3. A usergroup has an unique ID, which can be used to group users. A user group can
//contain any number of users. The same user can only be included in one group. Of
//course, a user group can contain other user groups recursively. There is always a root
//group called Root to include everything.

//Uses composite pattern//leaf class
public class UserGroup implements TwitterUsers{
	private String id;
	private int numOfUserGroups = 0;

	UserGroup(String id){
		this.id = id;
		this.numOfUserGroups += 1;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public int getTotalNum() {
		return this.numOfUserGroups;
	}


	@Override
	public void totalNum() {
		System.out.println(String.valueOf(getTotalNum()));
	}
	
}
