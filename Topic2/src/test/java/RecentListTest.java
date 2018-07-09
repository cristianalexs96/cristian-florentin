import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class RecentListTest {

    @Test
    void NewRecentListTest(){
        Files explorer = new Files();
        ArrayList compare = new ArrayList();
        Assert.assertArrayEquals(explorer.ShowRecentList().toArray(), compare.toArray());
    }

    @Test
    void AddSingleFileTest() {
        Files explorer = new Files();
        explorer.OpenFile("File 1");
        ArrayList oldrecentlist = explorer.ShowRecentList();
        explorer.OpenFile("File 1");
        Assert.assertArrayEquals(explorer.ShowRecentList().toArray(), oldrecentlist.toArray());
    }

    @Test
    void AddMultipleFilesTest() {
        Files explorer = new Files();
        explorer.OpenFile("File 1");
        explorer.OpenFile("File 2");
        explorer.OpenFile("File 3");
        ArrayList<String> compare = new ArrayList<String>();
        compare.add("File 3");
        compare.add("File 2");
        compare.add("File 1");
        Assert.assertArrayEquals(explorer.ShowRecentList().toArray(), compare.toArray());
    }

    @Test
    void SameFileTest() {
        Files explorer = new Files();
        explorer.OpenFile("File 1");
        explorer.OpenFile("File 2");
        ArrayList<String> compare = new ArrayList<String>();
        compare.add("File 1");
        compare.add("File 2");
        explorer.OpenFile("File 1");
        Assert.assertArrayEquals(explorer.ShowRecentList().toArray(), compare.toArray());
    }

    @Test
    void RecentListSizeTest(){
        Files explorer = new Files();
        for(int x = 1; x < 20; x = x + 1){
            explorer.OpenFile("File" + x);
        }
        Assert.assertEquals((explorer.ShowRecentList()).size(), 15);
    }

}
