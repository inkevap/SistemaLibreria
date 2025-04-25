package sistemalibreria.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sistemalibreria.interfaces.IUserRepository;
import sistemalibreria.model.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static sistemalibreria.util.Constants.*;

public class MemoryUserRepositoryTest {

    IUserRepository dbUser = new MemoryUserRepository();
    User lucmart = new User();
    User migroja = new User();
    User oscpare = new User();
    User camirod = new User();
    User danmeji = new User();
    User usuario01 = new User();
    User usuario02 = new User();
    User usuario03 = new User();
    User usuario04 = new User();
    User usuario05 = new User();
    User usuario06 = new User();
    User usuario07 = new User();
    User usuario08 = new User();
    User usuario09 = new User();
    User usuario10 = new User();
    User usuario11 = new User();
    User usuario12 = new User();
    User usuario13 = new User();
    User usuario14 = new User();
    User usuario15 = new User();
    User usuario16 = new User();
    User usuario17 = new User();
    User usuario18 = new User();

    @BeforeEach
    public void SetupDataBase() {

        lucmart.setUserStatus(false);  // Estado del usuario
        lucmart.setUserAddress("Calle 1 Zona 10, Ciudad Ejemplo");  // Direccion fisica
        lucmart.setUserEmail("lucmart@example.com"); //Email ficticio
        lucmart.setUserName("Lucía Martínez"); // Nombre y apellido
        lucmart.setUserPassword("Password123!"); //Contraseña ficticia
        lucmart.setUserPersonalId("ID-100"); // ID personal ficticio
        lucmart.setUserRole(GUEST_ROLE);  // Rol del usuario
        lucmart.setUserNickName("lucmart"); //Nickname ficticio
        lucmart.setUserPhoneNumber("5676-3526"); // Numero de telefono

        migroja.setUserStatus(false);
        migroja.setUserAddress("Calle 2 Zona 1, Ciudad Ejemplo");
        migroja.setUserEmail("migroja@example.com");
        migroja.setUserName("Miguel Rojas");
        migroja.setUserPassword("Password123!");
        migroja.setUserPersonalId("ID-101");
        migroja.setUserRole(ADMIN_ROLE);
        migroja.setUserNickName("migroja");
        migroja.setUserPhoneNumber("3991-7166");

        oscpare.setUserStatus(false);  // Estado del usuario
        oscpare.setUserAddress("Calle 18 Zona 4, Ciudad Ejemplo");  // Direccion fisica
        oscpare.setUserEmail("oscpare@example.com"); //Email ficticio
        oscpare.setUserName("Óscar Paredes"); // Nombre y apellido
        oscpare.setUserPassword("Password123!"); //Contraseña ficticia
        oscpare.setUserPersonalId("ID-117"); // ID personal ficticio
        oscpare.setUserRole(ADMIN_ROLE);  // Rol del usuario
        oscpare.setUserNickName("oscpare"); //Nickname ficticio
        oscpare.setUserPhoneNumber("7871-4002"); // Numero de telefono

        camirod.setUserStatus(true);  // Estado del usuario
        camirod.setUserAddress("Calle 19 Zona 8, Ciudad Ejemplo");  // Direccion fisica
        camirod.setUserEmail("camirod@example.com"); //Email ficticio
        camirod.setUserName("Camila Rodríguez"); // Nombre y apellido
        camirod.setUserPassword("Password123!"); //Contraseña ficticia
        camirod.setUserPersonalId("ID-118"); // ID personal ficticio
        camirod.setUserRole(USER_ROLE);  // Rol del usuario
        camirod.setUserNickName("camirod"); //Nickname ficticio
        camirod.setUserPhoneNumber("6028-1934"); // Numero de telefono

        danmeji.setUserStatus(true);  // Estado del usuario
        danmeji.setUserAddress("Calle 20 Zona 2, Ciudad Ejemplo");  // Direccion fisica
        danmeji.setUserEmail("danmeji@example.com"); //Email ficticio
        danmeji.setUserName("Daniel Mejía"); // Nombre y apellido
        danmeji.setUserPassword("Password123!"); //Contraseña ficticia
        danmeji.setUserPersonalId("ID-119"); // ID personal ficticio
        danmeji.setUserRole(GUEST_ROLE);  // Rol del usuario
        danmeji.setUserNickName("danmeji"); //Nickname ficticio
        danmeji.setUserPhoneNumber("4590-8157"); // Numero de telefono

        usuario01.setUserStatus(true);
        usuario01.setUserAddress("123 Calle Falsa, Ciudad Fantasía");
        usuario01.setUserEmail("lucia.martinez@example.com");
        usuario01.setUserName("Lucía Martínez");
        usuario01.setUserPassword("Password");
        usuario01.setUserPersonalId("ID-001");
        usuario01.setUserRole(USER_ROLE);
        usuario01.setUserNickName("lucimtz");
        usuario01.setUserPhoneNumber("4521-8793");

        usuario02.setUserStatus(false);
        usuario02.setUserAddress("Av. del Sol 45, Pueblo Nuevo");
        usuario02.setUserEmail("miguel.rojas@example.com");
        usuario02.setUserName("Miguel Rojas");
        usuario02.setUserPassword("Password");
        usuario02.setUserPersonalId("ID-002");
        usuario02.setUserRole(ADMIN_ROLE);
        usuario02.setUserNickName("mikeRJ");
        usuario02.setUserPhoneNumber("3124-5678");

        usuario03.setUserStatus(true);
        usuario03.setUserAddress("Calle Luna 101, Villa Claro");
        usuario03.setUserEmail("ana.perez@example.com");
        usuario03.setUserName("Ana Pérez");
        usuario03.setUserPassword("Password");
        usuario03.setUserPersonalId("ID-003");
        usuario03.setUserRole(USER_ROLE);
        usuario03.setUserNickName("ana_92");
        usuario03.setUserPhoneNumber("2345-9832");

        usuario04.setUserStatus(false);
        usuario04.setUserAddress("Boulevard Central 77, Metropolis");
        usuario04.setUserEmail("diego.salas@example.com");
        usuario04.setUserName("Diego Salas");
        usuario04.setUserPassword("Password");
        usuario04.setUserPersonalId("ID-004");
        usuario04.setUserRole(GUEST_ROLE);
        usuario04.setUserNickName("dsalasx");
        usuario04.setUserPhoneNumber("4210-3312");

        usuario05.setUserStatus(true);
        usuario05.setUserAddress("Calle Norte 25, Ciudadela");
        usuario05.setUserEmail("maria.lopez@example.com");
        usuario05.setUserName("María López");
        usuario05.setUserPassword("Password");
        usuario05.setUserPersonalId("ID-005");
        usuario05.setUserRole(USER_ROLE);
        usuario05.setUserNickName("mlopez25");
        usuario05.setUserPhoneNumber("3098-4456");

        usuario06.setUserStatus(true);
        usuario06.setUserAddress("Camino Real 3, Altavista");
        usuario06.setUserEmail("carlos.fernandez@example.com");
        usuario06.setUserName("Carlos Fernández");
        usuario06.setUserPassword("Password");
        usuario06.setUserPersonalId("ID-006");
        usuario06.setUserRole(ADMIN_ROLE);
        usuario06.setUserNickName("cfer88");
        usuario06.setUserPhoneNumber("3890-1283");

        usuario07.setUserStatus(false);
        usuario07.setUserAddress("Paseo del Lago 99, Laguna Azul");
        usuario07.setUserEmail("sofia.garcia@example.com");
        usuario07.setUserName("Sofía García");
        usuario07.setUserPassword("Password");
        usuario07.setUserPersonalId("ID-007");
        usuario07.setUserRole(USER_ROLE);
        usuario07.setUserNickName("sofi_g");
        usuario07.setUserPhoneNumber("2389-7645");

        usuario08.setUserStatus(true);
        usuario08.setUserAddress("Ruta 66 Km 23, Carretera Norte");
        usuario08.setUserEmail("andres.vargas@example.com");
        usuario08.setUserName("Andrés Vargas");
        usuario08.setUserPassword("Password");
        usuario08.setUserPersonalId("ID-008");
        usuario08.setUserRole(GUEST_ROLE);
        usuario08.setUserNickName("avargas");
        usuario08.setUserPhoneNumber("2145-8763");

        usuario09.setUserStatus(true);
        usuario09.setUserAddress("Camino del Bosque 13, El Retiro");
        usuario09.setUserEmail("laura.ramirez@example.com");
        usuario09.setUserName("Laura Ramírez");
        usuario09.setUserPassword("Password");
        usuario09.setUserPersonalId("ID-009");
        usuario09.setUserRole(USER_ROLE);
        usuario09.setUserNickName("laura_rx");
        usuario09.setUserPhoneNumber("3180-6432");

        usuario10.setUserStatus(false);
        usuario10.setUserAddress("Av. Paz Mundial 555, Col. Esperanza");
        usuario10.setUserEmail("julio.reyes@example.com");
        usuario10.setUserName("Julio Reyes");
        usuario10.setUserPassword("Password");
        usuario10.setUserPersonalId("ID-010");
        usuario10.setUserRole(ADMIN_ROLE);
        usuario10.setUserNickName("jreyes555");
        usuario10.setUserPhoneNumber("4093-2170");

        usuario11.setUserStatus(true);
        usuario11.setUserAddress("Calle Sur 12, Jardines del Sur");
        usuario11.setUserEmail("renata.mendoza@example.com");
        usuario11.setUserName("Renata Mendoza");
        usuario11.setUserPassword("Password");
        usuario11.setUserPersonalId("ID-011");
        usuario11.setUserRole(USER_ROLE);
        usuario11.setUserNickName("renmendz");
        usuario11.setUserPhoneNumber("3928-1065");

        usuario12.setUserStatus(true);
        usuario12.setUserAddress("Mirador 7, Cerro Verde");
        usuario12.setUserEmail("marco.diaz@example.com");
        usuario12.setUserName("Marco Díaz");
        usuario12.setUserPassword("Password");
        usuario12.setUserPersonalId("ID-012");
        usuario12.setUserRole(GUEST_ROLE);
        usuario12.setUserNickName("marcodiaz");
        usuario12.setUserPhoneNumber("3980-4450");

        usuario13.setUserStatus(false);
        usuario13.setUserAddress("Residencial Altos 303, Ciudad Blanca");
        usuario13.setUserEmail("pamela.soto@example.com");
        usuario13.setUserName("Pamela Soto");
        usuario13.setUserPassword("Password");
        usuario13.setUserPersonalId("ID-013");
        usuario13.setUserRole(USER_ROLE);
        usuario13.setUserNickName("pamesoto");
        usuario13.setUserPhoneNumber("3267-7856");

        usuario14.setUserStatus(true);
        usuario14.setUserAddress("La Vega 9, Campo Alegre");
        usuario14.setUserEmail("alejandro.castro@example.com");
        usuario14.setUserName("Alejandro Castro");
        usuario14.setUserPassword("Password");
        usuario14.setUserPersonalId("ID-014");
        usuario14.setUserRole(ADMIN_ROLE);
        usuario14.setUserNickName("acastro");
        usuario14.setUserPhoneNumber("2139-6750");

        usuario15.setUserStatus(false);
        usuario15.setUserAddress("Zona 10, Plaza Real");
        usuario15.setUserEmail("emilia.vera@example.com");
        usuario15.setUserName("Emilia Vera");
        usuario15.setUserPassword("Password");
        usuario15.setUserPersonalId("ID-015");
        usuario15.setUserRole(USER_ROLE);
        usuario15.setUserNickName("emivera");
        usuario15.setUserPhoneNumber("3745-8102");

        usuario16.setUserStatus(true);
        usuario16.setUserAddress("Urbanización El Prado, Calle 2");
        usuario16.setUserEmail("hugo.martin@example.com");
        usuario16.setUserName("Hugo Martín");
        usuario16.setUserPassword("Password");
        usuario16.setUserPersonalId("ID-016");
        usuario16.setUserRole(GUEST_ROLE);
        usuario16.setUserNickName("hugom");
        usuario16.setUserPhoneNumber("2319-4457");

        usuario17.setUserStatus(true);
        usuario17.setUserAddress("Av. Montaña Alta 89");
        usuario17.setUserEmail("valeria.santos@example.com");
        usuario17.setUserName("Valeria Santos");
        usuario17.setUserPassword("Password");
        usuario17.setUserPersonalId("ID-017");
        usuario17.setUserRole(USER_ROLE);
        usuario17.setUserNickName("val_san");
        usuario17.setUserPhoneNumber("4275-3380");

        usuario18.setUserStatus(false);
        usuario18.setUserAddress("Col. Estrella del Norte, Casa 11");
        usuario18.setUserEmail("oscar.paredes@example.com");
        usuario18.setUserName("Óscar Paredes");
        usuario18.setUserPassword("Password");
        usuario18.setUserPersonalId("ID-018");
        usuario18.setUserRole(ADMIN_ROLE);
        usuario18.setUserNickName("oskarp");
        usuario18.setUserPhoneNumber("4099-2022");

        dbUser.addUser(camirod);
        dbUser.addUser(danmeji);
        dbUser.addUser(oscpare);
        dbUser.addUser(migroja);
        dbUser.addUser(lucmart);
        dbUser.addUser(usuario01);
        dbUser.addUser(usuario02);
        dbUser.addUser(usuario03);
        dbUser.addUser(usuario04);
        dbUser.addUser(usuario05);
        dbUser.addUser(usuario06);
        dbUser.addUser(usuario07);
        dbUser.addUser(usuario08);
        dbUser.addUser(usuario09);
        dbUser.addUser(usuario10);
        dbUser.addUser(usuario11);
        dbUser.addUser(usuario12);
        dbUser.addUser(usuario13);
        dbUser.addUser(usuario14);
        dbUser.addUser(usuario15);
        dbUser.addUser(usuario16);
        dbUser.addUser(usuario17);
        dbUser.addUser(usuario18);
    }

    @DisplayName("Agrega satisfacoriamente los usuarios")
    @Test
    public void addUser_AddUsersSuccesfully() {
        assertEquals(5,dbUser.findAllUsers().size());
        assertTrue(dbUser.findAllUsers().contains(camirod));
        assertTrue(dbUser.findAllUsers().contains(danmeji));
        assertTrue(dbUser.findAllUsers().contains(oscpare));
        assertTrue(dbUser.findAllUsers().contains(migroja));
        assertTrue(dbUser.findAllUsers().contains(oscpare));
    }

    @DisplayName("Agrega satisfacoriamente los usuarios")
    @Test
    public void addUser_WhenItsADuplicateValue() {
        dbUser.addUser(usuario01);
        assertEquals(1, dbUser.findUsersByText("ID-001").size());
    }

    @DisplayName("Agrega satisfacoriamente los usuarios")
    @Test
    public void findUserById_BringsTheRightObject() {
        var userLookingfor = dbUser.findAllUsers().get(1);
        var userFound = dbUser.findUserById(userLookingfor.getUserSerialId());
        assertTrue(userFound.isPresent());
        assertEquals(userLookingfor.getUserName(),userFound.get().getUserName());
        userFound = dbUser.findUserById(154);
        assertFalse(userFound.isPresent());
    }

    @DisplayName("Encuentra usuarios basado en distintos parametros")
    @Test
    public void findUserByText_BringsUserWithDifferentParameters(){

        //Por correo
        var usersFound = dbUser.findUsersByText("@example.com");
        assertEquals(23, usersFound.size());

        //por nombre
        usersFound = dbUser.findUsersByText("Daniel");
        if(!usersFound.isEmpty()){
            assertEquals("ID-119", usersFound.getFirst().getUserPersonalId());
        }else {
            fail("No encuentra por numbre");
        }

        //Por direccion
        usersFound = dbUser.findUsersByText("Calle 18 Zona 4");
        if(!usersFound.isEmpty()){
            assertEquals("oscpare", usersFound.getFirst().getUserNickName());
        }else {
            fail("No encuentra por direccion");
        }

        //Por Nickname
        usersFound = dbUser.findUsersByText("dsalasx");
        if(!usersFound.isEmpty()){
            assertEquals("ID-004", usersFound.getFirst().getUserPersonalId());
        }else {
            fail("No encuentra por nickname");
        }

        //Por Role
        usersFound = dbUser.findUsersByText(ADMIN_ROLE);
        if(!usersFound.isEmpty()){
            assertEquals(7, usersFound.size());
        }else {
            fail("No encuentra por role");
        }

        //Por Numero de telefono
        usersFound = dbUser.findUsersByText("3180-6432");
        if(!usersFound.isEmpty()){
            assertEquals("laura_rx", usersFound.getFirst().getUserNickName());
        }else {
            fail("No encuentra por Numero de telefono");
        }

        //Por personal ID
        usersFound = dbUser.findUsersByText("ID-011");
        if(!usersFound.isEmpty()){
        assertEquals("renmendz", usersFound.getFirst().getUserNickName());
        }else {
            fail("No encuentra por personal Id");
        }
    }

    @DisplayName("Elimina usuarios basado en el serialID")
    @Test
    public void removeUser_RemovesUserWhenExists(){
    dbUser.findUsersByText("4099-2022").stream().findFirst().ifPresent(user -> dbUser.removeUser(user.getUserSerialId()));
    assertEquals(22, dbUser.findAllUsers().size());
    assertFalse(dbUser.existsByEmail("oscar.paredes@example.com"));
    dbUser.removeUser(1569);
    assertEquals(22, dbUser.findAllUsers().size());
    }

    @DisplayName("Actualiza un objeto existente")
    @Test
    public void updateUser_UpdatesUserWhenExists(){
        var results = dbUser.findUsersByText("alejandro.castro@example.com");
        if(!results.isEmpty()) {
            if(results.size() == 1){
                var newUser = results.getFirst();
                //TODO pendiente terminar de escribir pruebas unitarias

            }
        }
    }
}
