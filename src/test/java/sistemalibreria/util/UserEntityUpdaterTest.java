package sistemalibreria.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sistemalibreria.model.UserEntity;
import sistemalibreria.model.UserRole;

import static org.junit.jupiter.api.Assertions.*;
import static sistemalibreria.util.UserUpdater.updateUser;

public class UserEntityUpdaterTest {
    @DisplayName("updateUser valida valores distintos/validos")
    @Test
    public void updateUser_updatesOnlyValidFields() {
        UserEntity userEntityOld = new UserEntity();
        userEntityOld.setUserStatus(true);
        userEntityOld.setUserAddress("3era calle");
        userEntityOld.setUserEmail("Inkev.ap@gmail.com");
        userEntityOld.setUserName("Kevin Pocon");
        userEntityOld.setUserPassword("Password");
        userEntityOld.setUserPersonalId("383512345");
        userEntityOld.setUserRole(UserRole.ADMIN);
        userEntityOld.setUserNickName("Inkevap");
        userEntityOld.setUserPhoneNumber("49606353");

        UserEntity userEntityNew = new UserEntity();
        userEntityNew.setUserStatus(false);
        userEntityNew.setUserAddress("3era calle");
        userEntityNew.setUserEmail("");
        userEntityNew.setUserName("Brian Pocon");
        userEntityNew.setUserPassword("Password");
        userEntityNew.setUserPersonalId("");
        userEntityNew.setUserRole(UserRole.NULL);
        userEntityNew.setUserNickName("Liebbergott");
        userEntityNew.setUserPhoneNumber("49606353");

        updateUser(userEntityOld, userEntityNew);

        assertEquals(false, userEntityOld.getUserStatus());
        assertEquals("3era calle", userEntityOld.getUserAddress());
        assertEquals("Inkev.ap@gmail.com", userEntityOld.getUserEmail());
        assertEquals("Brian Pocon", userEntityOld.getUserName());
        assertTrue(new BCryptEncryptor().checkPassword("Password",userEntityOld.getUserPassword()));
        assertEquals("383512345", userEntityOld.getUserPersonalId());
        assertEquals(UserRole.NULL, userEntityOld.getUserRole());
        assertEquals("Liebbergott", userEntityOld.getUserNickName());
        assertEquals("49606353", userEntityOld.getUserPhoneNumber());

    }

}
