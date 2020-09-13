package observerpattern;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;
 
/**
 * This interface handles adding, deleting and updating all observers
 */
interface Subject{
    public void register(Observer o);
    public void unregister(Observer o);
    public void notifyAllObservers(String s);
}
 
 
/**
 * The Observers update method is called when the Subject changes
 */
interface Observer{
    public CompletableFuture<String> update(String name, String s);
}
 
/**
 * This class extends Subject interface.
 */
class Celebrity implements Subject{
 
    private String celebrityName;  //name of the celebrity
    private ArrayList<Observer> followers;  //list of followers
     
     
    public Celebrity(String celebrityName) {
        this.celebrityName = celebrityName;
        followers = new ArrayList<Observer>();
    }
 
    /**
     * add follower to the celebrity's registered follower list
     */
    @Override
    public void register(Observer o) {
        followers.add(o);
        System.out.println(o + " has started following " + celebrityName);
    }
 
    /**
     * remove follower from celebrity's registered follower list
     */
    @Override
    public void unregister(Observer o) {
        followers.remove(o);
        System.out.println(o + " has stopped following " + celebrityName);
    }
     
     
    /**
     * Notify all the registered followers
     * @return 
     */
    @Override
    public void notifyAllObservers(String tweet) {
    	CompletableFuture<String>[] arr = new CompletableFuture[followers.size()];
    	StringBuilder sf = new StringBuilder();
        for(int i = 0 ; i < followers.size(); i++)
        {
        	arr[i] = followers.get(i).update(celebrityName, tweet).thenApplyAsync((s) -> {
            	//System.out.println(Thread.currentThread().getName());
            	//System.out.println(s);
            	return s;
            });
        }
        CompletableFuture<Object> allTweet = CompletableFuture.anyOf(arr);
        
    	while (!allTweet.isDone()) {
			//System.out.println("CompletableFuture is not finished yet...");
		}
		try {
			String result = (String) allTweet.get();
			String combined = Stream.of(arr)
					  .map(CompletableFuture::join)
					  .collect(Collectors.joining(" "));
			sf.append(result);
			System.out.println(combined);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
     
    /**
     * This method updates the tweet. 
     * It will internally call notifyAllObservers(tweet) method 
     * after updating the tweet. 
     * 
     */
    public void tweet(String tweet)
    {
         
        System.out.println("\n" + celebrityName + " has tweeted :: " + tweet + "\n");
         
        notifyAllObservers(tweet);
    }
     
}
 
/**
 * This class extends Observer interface.
 */
class Follower implements Observer{
 
    private String followerName;
     
    public Follower(String followerName) {
        this.followerName = followerName;
    }
 
    /**
     * This method will be called to update all followers regarding the 
     * new tweet posted by celebrity.
     */
    @Override
    public CompletableFuture<String> update(String celebrityName , String tweet) {
    	return CompletableFuture.supplyAsync(()->{
    		try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	System.out.println(Thread.currentThread().getName());
            return followerName + " has received "+ celebrityName + "'s tweet :: "+  tweet;
    	});
         
    }
 
    @Override
    public String toString() {
        return followerName;
    }
     
     
}
 
public class ObserverPattern {

    public static void main(String[] args) {
        Celebrity salmankhan = new Celebrity("Salman Khan");
        Celebrity ranbirkapoor = new Celebrity("Ranbir Kapoor");
         
        Follower jay = new Follower("jay");
        Follower rajan = new Follower("rajan");
        Follower raj = new Follower("raj");
        Follower vijay =  new Follower("vijay");
        Follower amit = new Follower("amit");
        Follower harsh =  new Follower("Harsh");
         
        salmankhan.register(jay);
        salmankhan.register(rajan);
        salmankhan.register(raj);
         
        ranbirkapoor.register(vijay);
        ranbirkapoor.register(amit);
        ranbirkapoor.register(harsh);
         
        salmankhan.tweet("Hey guys, came across this interesting trailer, check it out.");
        ranbirkapoor.tweet("Good Morning..!!");
         
        salmankhan.unregister(rajan);
         
        salmankhan.tweet("Teaser of Secret Superstar has been released..!!");
         
    }
}
