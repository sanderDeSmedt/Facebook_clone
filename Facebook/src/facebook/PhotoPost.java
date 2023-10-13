package facebook;

public class PhotoPost extends Post{

    String filename;
    String caption;

    @Override
    public void display()
    {
        System.out.println(getUsername());
        System.out.println("  [" + filename + "]");
        System.out.println("  " + caption);
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
        return "Photo by " + getUsername() + ": " + filename;
    }

    //constructor
    public PhotoPost(String username, String filename, String caption) {
        super(username);
        this.filename = filename.toLowerCase();
        this.caption = caption;
    }

    //getters
    public String getFilename() {
        return filename;
    }

    public String getCaption() {
        return caption;
    }
}
