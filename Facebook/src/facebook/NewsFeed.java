package facebook;

import java.util.ArrayList;


public class NewsFeed {
    private ArrayList<Post> newsfeed;

    public NewsFeed() {
        this.newsfeed = new ArrayList<>();
    }



    public void addPost(Post post) {
        newsfeed.add(post);
    }

    public void show() {
        if (newsfeed.size() == 0) {
            System.out.println("Newsfeed is still empty");
        } else {
            System.out.println("Newsfeed:");
            for (Post post : newsfeed) {
                post.display();
                System.out.println("");
            }
        }
    }

    public int getNumberOfPosts() {
        return newsfeed.size();
    }

    public Post getPost(int index) {
        if (index >= 0 && index < newsfeed.size()) {
            return newsfeed.get(index);
        } else {
            return null;
        }
    }
}
