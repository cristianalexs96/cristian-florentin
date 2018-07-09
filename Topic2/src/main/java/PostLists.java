import java.util.ArrayList;

public class PostLists {
    private static PostLists ourInstance = new PostLists();

    public static PostLists getInstance() {
        return ourInstance;
    }

    public ArrayList<String> list;

    public PostLists() {

        list = new ArrayList<String>();
    }

    public String AddPost(String post){
        if (list.size() > 9) {
            list.remove(9);
        }
        list.add(0, post);
        return ("Post Added");
    }

    public void DeletePost(String post){
        list.remove(post);
    }

    public ArrayList ShowList(){
        return list;
    }
}
