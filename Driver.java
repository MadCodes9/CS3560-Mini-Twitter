
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		User user = new User("123456");
//		User user2 = new User("132326");
//		UserGroup userGroup = new UserGroup("90909");
//		Admin admin = new Admin();
//		
//		admin.addUser(user);
//		admin.addUser(user2);
//		admin.addUserGroup(userGroup);
//	
//		
//		User s1 = new User("123456"); 
//		User s2 = new User("909012"); 
//		TwitterNewsFeed p = new TwitterNewsFeed();
//		
//		p.attach(s1);
//		p.attach(s2);
//		p.postMessage("Hello there");
//		p.notifyObservers();   //s1 and s2 will receive the update
		
//		Admin admin = new Admin();
//		User user = new User("John");
//		admin.addUser(user);
		
		//Create and display GUI 
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
          public void run() {
        	  TreeView.createAndShowGUI();   
          }
      });
		
	
	}

}
