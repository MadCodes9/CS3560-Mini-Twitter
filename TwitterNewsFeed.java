import java.util.List;
import java.util.Arrays;

//VISITOR PATTERN??

public class TwitterNewsFeed implements NewsFeedService {
	/*
	 * News feed list containing a list of Twitter messages
	 * return List	Twitter messages
	*/
	public List<String> getNewsFeed() {
		return Arrays.asList(new String[]{"f1 FB", "f2 FB", "f3 FB"});
	}
}
