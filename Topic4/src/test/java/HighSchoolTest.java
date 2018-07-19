import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class HighSchoolTest {

    private HighSchoolAccess connection = new HighSchoolAccess();

    @Test
    void connectionTest() {
        Assert.assertTrue(connection.connectBD());
    }

}
