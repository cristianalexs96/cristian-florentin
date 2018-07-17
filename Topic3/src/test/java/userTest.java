import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class userTest {
    @Test
    void createUserTest() {
        user user1 = new userInMemory("username", "password");
        user1.setBornDate("22-2-12");
        user1.setName("Name and Last Name");
        user1.setCard("1111 000 111");
        Assert.assertNotNull(user1);
    }

    @Test
    void editUsernameTest() {
        user user1 = new userInMemory("username", "password");
        user1.setBornDate("22-2-12");
        user1.setName("Name and Last Name");
        user1.setCard("1111 000 111");
        user1.setUsername("username_edit");
        Assert.assertEquals("username_edit", user1.getUsername());
    }

    @Test
    void editPasswordTest() {
        user user1 = new userInMemory("username", "password");
        user1.setBornDate("22-2-12");
        user1.setName("Name and Last Name");
        user1.setCard("1111 000 111");
        user1.setPassword("password_edit");
        Assert.assertEquals("password_edit", user1.getPassword());
    }
}
