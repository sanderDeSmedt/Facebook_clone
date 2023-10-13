package facebook;

import java.util.ArrayList;


public abstract class Post {

    private String username;
    private long timestamp;
    private int likeCounter;
    private ArrayList<String> comments;

    public String getUsername() {
        return username;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public int getLikeCounter() {
        return likeCounter;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void like() {
        likeCounter ++;
    }

    public void unlike() {
        if (likeCounter > 0) {
            likeCounter --;
        }
    }

    public void addComment(String comment) {
        comments.add(comment);
    }

    public abstract void display();

    /**
     * Create a string describing a time point in the past in terms
     * relative to current time, such as "30 seconds ago" or "7 minutes ago".
     * Currently, only seconds and minutes are used for the string.
     *
     * @param time  The time value to convert (in system milliseconds)
     * @return      A relative time string for the given time
     */

    public String timeString(long time)
    {
        long current = System.currentTimeMillis();
        long pastMillis = current - time;      // time passed in milliseconds
        long seconds = pastMillis/1000;
        long minutes = seconds/60;
        if(minutes > 0) {
            if (minutes > 1) {
                return minutes + " minutes ago";
            } else {
                return minutes + " minute ago";
            }
        }
        else {
            return seconds + " seconds ago";
        }
    }

    //constructor
    public Post(String username) {
        this.username = username;
        this.timestamp = System.currentTimeMillis();
        this.likeCounter = 0;
        this.comments = new ArrayList<>();
    }

    public void printComments() {
        if(getComments().isEmpty()) {
            System.out.println("   No comments.");
        }
        else {
            System.out.println("   " + getComments().size() + " comment(s).");
            for (String comment : comments) {
                System.out.println("   " + comment);
                System.out.println("------");
            }
        }
    }

    public abstract String getSummary();
}
