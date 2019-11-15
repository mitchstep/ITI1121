import java.util.Calendar;
import java.util.Date;
import java.lang.String;

public class Post implements Likeable, Comparable<Post> {

    protected int likes;
    private Date timeStamp;
    private String userName;

    public Post(String userName) {
      this.likes = 0;
      this.userName = userName;
      this.timeStamp = Calendar.getInstance().getTime();
    }

    public String getUserName() {
	     return userName;
    }

    public Date getTimeStamp() {
	     return timeStamp;
    }

    @Override
    public void like() {
        likes++;
    }

    @Override
    public int getLikes() {
        return likes;
    }

    // Implement the methods required by the interface Likeable.
    // This file will not compile unless they are present with the correct name and signature.

    public String toString() {
    	String str = new String();
    	str = getClass().getName() + ": " + timeStamp + ", " + userName + ", likes = " + likes;
    	return  str;
    }


  	public int compareTo(Post other){
  		if(this.timeStamp == other.timeStamp){
  		    return 0;
        }else if(this.timeStamp.before(other.timeStamp)){
            return -1;
        }else {
  		    return 1;
        }
  	}

  	public boolean isPopular(){
  		return(getLikes()>100);
  	}
}
