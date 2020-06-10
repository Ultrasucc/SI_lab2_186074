import org.junit.Test;

import static org.junit.Assert.*;

public class SILab2Test {
    @Test
    public void test1() {
        assertEquals(SILab2.function(null, null), false); //1, 2

        User userN = new User("name", null, "mail");
        User userP = new User(null, "passworD123", "mail");
        //nema razlika dali username ili password e null, funkcijata pak kje vrati false
        assertEquals(SILab2.function(userN, null), false); //1, 3, 2
        assertEquals(SILab2.function(userP, null), false); //1, 3, 2

        User user2 = new User("name", "name", "mail");
        //pw = username -> False (za pw!=username) i False (pw length < 8)
        assertEquals(SILab2.function(user2, null), false); //1, 3, 4, 2

        User user3 = new User("name", "notstrongenough", "mail");
        assertEquals(SILab2.function(user3, null), false); //1, 3, 4, 5, 6, 7, 8, 9, 2

        User user4 = new User("name", "un1queP@ssword", "mail");
        assertEquals(SILab2.function(user4, null), true); // 1, 3, 4, 5, 6, 7, 8, 9, 5, 10
    }
    @Test
    public void test2() {
        //1:
        User user1 = new User("name", null, "mail");
        assertEquals(SILab2.function(user1, null), false);
        assertEquals(SILab2.function(null, null), false);

        //3:
        User user2 = new User("name", "name", "mail");
        assertEquals(SILab2.function(user1, null), false);
        assertEquals(SILab2.function(user2, null), false);

        //4:
        User user3 = new User("name", "password", "mail");
        assertEquals(SILab2.function(user2, null), false);
        assertEquals(SILab2.function(user3, null), false);

        //6, 7, 8:
        User user4 = new User("name", "un1queP@ssword", "mail");
        //dovolno e samo 1 od uslovite da ne e ispolnet za da 9 e netochen
        assertEquals(SILab2.function(user3,null ), false);
        //9:
        assertEquals(SILab2.function(user4, null), true);
    }
}
