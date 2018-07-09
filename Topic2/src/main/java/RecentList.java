import java.util.ArrayList;

public class RecentList {
    public ArrayList<String> list = new ArrayList<String>();

    public RecentList() {
    }

    public void AddFile(String file) {
        if (list.contains(file)){
            list.remove(file);
        }
        else{
            if (list.size() > 14){
                list.remove(14);
            }
        }
        list.add(0,file);
    }

    public ArrayList<String> ShowList(){
        return list;
    }
}
