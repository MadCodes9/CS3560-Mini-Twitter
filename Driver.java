
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwitterUsers user = new User("123456");
		TwitterUsers user2 = new User("132326");
		TwitterUsers userGroup = new UserGroup("90909");
		Admin admin = new Admin();
		
		admin.addUser(user);
		admin.addUser(user2);
		admin.addUserGroup(userGroup);
		
		admin.totalNum();
	}

}
