
public class Driver {

	public static void main(String[] args) {
//		User s1 = new User("John"); 
//		User s2 = new User("Bob"); 
//		User s3 = new User("Matt");
//		s1.follow(s2);
//		s2.follow(s1);
//		s1.follow(s3);
//		System.out.println();
//		
//		s1.postMessage("John says hi");
//		System.out.println();
//		s2.postMessage("Bob responds hi back");
//		System.out.println();
//		
//		s1.displayFollowers();
//		s2.displayFollowers();
//		s3.displayFollowers();
//		
//		System.out.println();
//		s1.postMessage("John says bye");
//		
//		System.out.println();
//		s2.postMessage("Bob doesn't like matt");
//		
//		System.out.println();
//		s3.postMessage("Matt says he is happy");
		
		//Create and display GUI 
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
          public void run() {
        	  TreeView.createAndShowGUI();   
          }
      });

		
	
	}

}
