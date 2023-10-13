package facebook;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FacebookController {
    public TextField username;
    public TextField message;
    public TextField filename;
    public TextField caption;
    public ComboBox posts;
    public TextField comment;

    private NewsFeed newsFeed;

    //constructor
    public FacebookController() {
        newsFeed = new NewsFeed();
    }

    //initialize JavaFx controls
    public void initialize() {
        updateComboBox();
    }

    public void addMessage(ActionEvent actionEvent) {
        String username = this.username.getText().trim(); //trim() dient om de spaties aan de buitenkant van een String te verwijderen.
        String message = this.message.getText().trim();
        if (username.length() == 0) {
            System.out.println("Fill in user name!");
        } else {
            if (message.length() == 0) {
                System.out.println("Add a message first.");
            } else {
                MessagePost messagePost = new MessagePost(username, message);
                newsFeed.addPost(messagePost);
                this.message.clear();
            }
        }
        updateComboBox();
    }

    public void addPhoto(ActionEvent actionEvent) {
        String username = this.username.getText().trim(); //trim() dient om de spaties aan de buitenkant van een String te verwijderen.
        String filename = this.filename.getText().trim();
        String caption = this.caption.getText().trim();
        if (username.length() == 0) {
            System.out.println("Fill in user name!");
        } else {
            if (filename.length() == 0) {
                System.out.println("Add a filename first.");
            } else {
                if (caption.length() == 0) {
                    System.out.println("Add a caption first.");
                } else {
                    PhotoPost photoPost = new PhotoPost(username, filename, caption);
                    newsFeed.addPost(photoPost);
                    this.filename.clear();
                    this.caption.clear();
                }
            }
        }
        updateComboBox();
    }

    public void printPosts(ActionEvent actionEvent) {
        newsFeed.show();
    }

    public void comment(ActionEvent actionEvent) {
        String comment = this.comment.getText().trim();
        if (comment.length() == 0) {
            System.out.println("Fill in comment.");
        } else {
            if (posts.getSelectionModel().getSelectedIndex() >= 0) {
                Post p = newsFeed.getPost(posts.getSelectionModel().getSelectedIndex());
                p.addComment(comment);
            } else {
                System.out.println("No post selected.");
            }
        }
        this.comment.clear();
    }

    public void unlike(ActionEvent actionEvent) {
        if (posts.getSelectionModel().getSelectedIndex() >= 0) {
            Post p = newsFeed.getPost(posts.getSelectionModel().getSelectedIndex());
            p.unlike();
        } else {
            System.out.println("No post selected.");
        }
    }

    public void like(ActionEvent actionEvent) {
        if (posts.getSelectionModel().getSelectedIndex() >= 0) {
            Post p = newsFeed.getPost(posts.getSelectionModel().getSelectedIndex());
            p.like();
        } else {
            System.out.println("No post selected.");
        }
    }

    private void updateComboBox() {
        posts.getItems().clear();
        for (int i = 0; i < newsFeed.getNumberOfPosts(); i++) {
            posts.getItems().add(newsFeed.getPost(i).getSummary());
        }
        posts.getSelectionModel().selectFirst();
    }
}
