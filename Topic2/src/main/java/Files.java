import java.util.ArrayList;

public class Files {
    public RecentList recentList;

    public Files() {
        recentList = new RecentList();
    }

    public void OpenFile(String file){
        recentList.AddFile(file);
    }

    public ArrayList<String> ShowRecentList() {
        return (recentList.ShowList());
    }
}
