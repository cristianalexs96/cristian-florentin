/**
 * The userInMemory class represents an User
 * @author CRISTIAN
 */
public class userInMemory implements user{

    String name;
    String username;
    String password;
    String card;
    String bornDate;

    /**
     * it sets the values to the username and password
     * @param name Username value
     * @param pass Password value
     */

    public userInMemory (String name, String pass){
        this.username = name;
        this.password = pass;
    }

    /**
     * its instance the class without setting anything
     */

    public userInMemory() {
        this.username = null;
        this.password = null;
    }

    /**
     * it sets the value to the name
     * @param name name value
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * it sets the value to the Born Date
     * @param bornDate born date value
     */

    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    }

    /**
     * it gets the value of the Born Date
     * @return A String with the born Date
     */

    public String getBornDate() {
        return this.bornDate;
    }

    /**
     * it gets the value of the Name
     * @return A String with the Name
     */

    public String getName() {
        return this.name;
    }

    /**
     * it sets the value to the Credit Card
     * @param card credit card number value
     */


    public void setCard(String card) {
        this.card = card;
    }

    /**
     * it gets the value of the Credit Card
     * @return A String with the Credit Card
     */

    public String getCard() {
        return this.card;
    }

    /**
     * it sets the value to the UserName
     * @param username username value
     */

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * it gets the value of the Username
     * @return A String with the Username value
     */

    public String getUsername() {
        return this.username;
    }

    /**
     * it sets the value to the Password
     * @param password value of the password
     */

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * it gets the value of the Password
     * @return A String with the Password value
     */

    public String getPassword() {
        return this.password;
    }
}
