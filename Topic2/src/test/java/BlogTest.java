import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BlogTest {

    @Test
    public void CreatePostTest(){
        Blog blog = mock(Blog.class);
        String post = "Post 1";
        when(blog.CreatePost(post)).thenReturn("Post Created");
        Assert.assertNotNull(blog.CreatePost(post));
    }

    @Test
    public void DeletePostTest(){
        Blog blog = mock(Blog.class);
        String post = "Post 1";
        when(blog.DeletePost(post)).thenReturn("Post Deleted");
        Assert.assertNotNull(blog.DeletePost(post));
    }

    @Test
    public void ShowPostsTest(){
        Blog blog = mock(Blog.class);
        String post = "Post 1";
        ArrayList <String> array = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            array.add("Post " + i);
        }
        when(blog.ShowRecentPosts()).thenReturn(array);
        Assert.assertTrue((blog.ShowRecentPosts()).size() <= 10);
    }



}
