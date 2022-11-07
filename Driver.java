
public class Driver {

	public static void main(String[] args) {
	
		User s1 = new User("John"); 
		User s2 = new User("Bob"); 
		User s3 = new User("Matt");
		s1.follow(s2);
		s2.follow(s1);
		s1.follow(s3);
		System.out.println();
		
		s1.postMessage("John says hi");
		System.out.println();
		s2.postMessage("Bob responds hi back");
	
		
//		//Create and display GUI 
//		javax.swing.SwingUtilities.invokeLater(new Runnable() {
//          public void run() {
//        	  TreeView.createAndShowGUI();   
//          }
//      });
//
//		
	
	}

}
