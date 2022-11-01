
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
		
		User s1 = new User("123456"); 
		User s2 = new User("909012"); 
		TwitterNewsFeed p = new TwitterNewsFeed();
		
		p.attach(s1);
		p.attach(s2);
		p.notifyObservers(new Message("First Message"));   //s1 and s2 will receive the update
		
		s1.update(new Message("New Post"));
		s2.update(new Message("Hi there!"));
		
		admin.totalNum();
	
	}

}
