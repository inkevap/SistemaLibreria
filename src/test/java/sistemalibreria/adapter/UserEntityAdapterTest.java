package sistemalibreria.adapter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sistemalibreria.model.User;
import sistemalibreria.model.UserEntity;
import sistemalibreria.util.BCryptEncryptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static sistemalibreria.adapter.UserEntityAdapter.entityToUser;
import static sistemalibreria.adapter.UserEntityAdapter.userToEntity;

public class UserEntityAdapterTest {

    @DisplayName("verifica si convierte satisfactoriamente User a UserEntity")
    @Test
    public void UserToUserEntity_ReturnsEntityWithTheSameInfo(){

        User userToConvert = new User(
                "Miguel Rojas",
                "migroja@example.com",
                "migroja",
                "Password123!",
                "Calle 2 Zona 1, Ciudad Ejemplo",
                "3991-7166",
                "ID-101"
        );

        UserEntity userConverted= userToEntity(userToConvert);
        assertEquals("Miguel Rojas",userConverted.getUserName());
        assertEquals("migroja@example.com",userConverted.getUserEmail());
        assertEquals("migroja",userConverted.getUserNickName());
        assertTrue(new BCryptEncryptor().checkPassword("Password123!",userConverted.getUserPassword()));
        assertEquals("Calle 2 Zona 1, Ciudad Ejemplo",userConverted.getUserAddress());
        assertEquals("3991-7166",userConverted.getUserPhoneNumber());
        assertEquals("ID-101",userConverted.getUserPersonalId());
    }

    @DisplayName("verifica si convierte satisfactoriamente UserEntity a User")
    @Test
    public void UserEntityToUser_ReturnsUserWithTheSameInfo(){

        UserEntity userToConvert = new UserEntity(
                "Miguel Rojas",
                "migroja@example.com",
                "migroja",
                "Password123!",
                "Calle 2 Zona 1, Ciudad Ejemplo",
                "3991-7166",
                "ID-101"
        );

        User userConverted= entityToUser(userToConvert);
        assertEquals("Miguel Rojas",userConverted.getUserName());
        assertEquals("migroja@example.com",userConverted.getUserEmail());
        assertEquals("migroja",userConverted.getUserNickName());
        assertTrue(new BCryptEncryptor().checkPassword("Password123!",userConverted.getUserPassword()));
        assertEquals("Calle 2 Zona 1, Ciudad Ejemplo",userConverted.getUserAddress());
        assertEquals("3991-7166",userConverted.getUserPhoneNumber());
        assertEquals("ID-101",userConverted.getUserPersonalId());
        assertTrue(userConverted.getUserSerialId() != -1);
    }
}
