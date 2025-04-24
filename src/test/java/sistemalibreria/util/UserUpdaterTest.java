package sistemalibreria.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sistemalibreria.model.User;
import static org.junit.jupiter.api.Assertions.*;
import static sistemalibreria.util.Constants.ADMIN_ROLE;
import static sistemalibreria.util.UserUpdater.updateUser;

public class UserUpdaterTest {
    @DisplayName("updateUser valida valores distintos/validos")
    @Test
    public void updateUser_updatesOnlyValidFields() {
        User userOld = new User();
        userOld.setUserStatus(true);
        userOld.setUserAddress("3era calle");
        userOld.setUserEmail("Inkev.ap@gmail.com");
        userOld.setUserName("Kevin Pocon");
        userOld.setUserPassword("Password");
        userOld.setUserPersonalId("383512345");
        userOld.setUserRole(ADMIN_ROLE);
        userOld.setUserNickName("Inkevap");
        userOld.setUserPhoneNumber("49606353");

        User userNew = new User();
        userNew.setUserStatus(false);
        userNew.setUserAddress("3era calle");
        userNew.setUserEmail("");
        userNew.setUserName("Brian Pocon");
        userNew.setUserPassword("Password");
        userNew.setUserPersonalId("");
        userNew.setUserRole("");
        userNew.setUserNickName("Liebbergott");
        userNew.setUserPhoneNumber("49606353");

        updateUser(userOld, userNew);

        assertEquals(false, userOld.getUserStatus());
        assertEquals("3era calle", userOld.getUserAddress());
        assertEquals("Inkev.ap@gmail.com", userOld.getUserEmail());
        assertEquals("Brian Pocon", userOld.getUserName());
        assertEquals("Password", userOld.getUserPassword());
        assertEquals("383512345", userOld.getUserPersonalId());
        assertEquals(ADMIN_ROLE, userOld.getUserRole());
        assertEquals("Liebbergott", userOld.getUserNickName());
        assertEquals("49606353", userOld.getUserPhoneNumber());

    }

}
