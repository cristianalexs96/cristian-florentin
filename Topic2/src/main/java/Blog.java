import java.util.ArrayList;

public class Blog {
    private static Blog ourInstance = new Blog();

    public static Blog getInstance() {

        return ourInstance;
    }

    public PostLists postlist;

    public Blog() {
       this.postlist = new PostLists();
    }

    public String CreatePost(String post){
        this.postlist.AddPost(post);
        return ("Post " + post + "Has Created");
    }

    public ArrayList<String> ShowRecentPosts(){
        return this.postlist.ShowList();
    }

    public String DeletePost(String post){
        this.postlist.DeletePost(post);
        return ("Post " + post + "Has Deleted");
    }
}
