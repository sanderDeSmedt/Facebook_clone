package facebook;



public class MessagePost extends Post {

    private String message;

    @Override
    public void display()
    {
        System.out.println(getUsername());
        System.out.println(message);
        System.out.print(timeString(getTimestamp()));

        if(getLikeCounter() > 0) {
            System.out.println("  -  " + getLikeCounter() + " people like this.");
        }
        else {
            System.out.println();
        }

        printComments();
    }

    @Override
    public String getSummary() {
        return "Message by " + getUsername() + ": " + message;
    }

    //constructor
    public MessagePost(String username, String message) {
        super(username);
        this.message = message;
    }

    //getters
    public String getMessage() {
        return message;
    }
}