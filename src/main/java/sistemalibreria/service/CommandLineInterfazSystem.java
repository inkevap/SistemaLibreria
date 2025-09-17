package sistemalibreria.service;

import sistemalibreria.DTO.UserCredentialsDTO;
import sistemalibreria.interfaces.IAdminUserService;
import sistemalibreria.interfaces.IAuthenticationService;
import sistemalibreria.interfaces.IUserService;
import sistemalibreria.model.User;

import static sistemalibreria.util.RequestUserInfo.*;

public class CommandLineInterfazSystem {

    private final IUserService userManagementService;
    private final IAdminUserService adminUserManagementService;
    private final IAuthenticationService authService;
    private User userCurrentlyLogedIn;

    public CommandLineInterfazSystem(IUserService userManagementService, IAdminUserService adminUserManagementService,
                                     IAuthenticationService authService
    ) {
        this.userManagementService = userManagementService;
        this.adminUserManagementService = adminUserManagementService;
        this.authService = authService;
    }

    public void innitCLI() {
        mainMenu();
    }

    private void mainMenu() {
        int option;
        do {
            System.out.print("""
                    --------------------------------------------
                    1️⃣  Iniciar Sesión 🔐
                    2️⃣  Registrarte 📝
                    3️⃣  Salir 🚪
                    
                    Escoge una opción: 🎯\t""");
            option = askForInt(1, 3);

            switch (option) {
                case 1 -> login();
                case 2 -> signIn();
                case 3 -> System.out.print("""
                        --------------------------------------------
                        Esperamos tenerte de vuelta pronto! 🙏
                        Hasta la próxima! 👋
                        --------------------------------------------
                        """);
                default -> System.out.println("Esa opcion no existe");
            }

        } while (option != 3);
    }

    private void signIn() {
        boolean isNewUserInfoCorrect = false;
        boolean isUserAdded = false;
        User tempUser;
        do {
            System.out.print("""
                    --------------------------------------------
                    A continuacion se le pediran datos personales
                    para poder crear su cuenta.
                    
                    Por favor ingrese su informacion:
                    """);
            System.out.println("--------------------------------------------");
            System.out.print("Ingresa tu nombre: ");
            String newUserInfo_UserName = askForString(5, 13);
            System.out.print("Ingresa tu nombre de usuario: ");
            String newUserInfo_NickName = askForString(3, 10);
            System.out.print("Ingresa tu contraseña de usuario: ");
            String newUserInfo_Password = askForString(5, 15);
            System.out.print("Ingresa tu direccion: ");
            String newUserInfo_Address = askForString(2, 20);
            System.out.print("Ingresa tu numero de telefono: ");
            String newUserInfo_PhoneNumber = askForString(2, 20);
            System.out.print("Ingresa tu identificacion personal: ");
            String newUserInfo_PersonalId = askForString(2, 20);
            System.out.print("Ingresa tu correo electronico: ");
            String newUserInfo_Email = askForString(2, 20);

            tempUser = new User(newUserInfo_UserName, newUserInfo_Email,
                    newUserInfo_NickName, newUserInfo_Password,
                    newUserInfo_Address, newUserInfo_PhoneNumber,
                    newUserInfo_PersonalId);
            System.out.println("--------------------------------------------");
            System.out.println(tempUser.toString());
            System.out.println("--------------------------------------------");
            //Todo agregar usuario a la base de datos
            System.out.print("Es tu informacion correcta? Si/No ");
            isNewUserInfoCorrect = askForBoolean();
        } while (!isNewUserInfoCorrect);

        if (authService.registerNewUser(tempUser)) {
            System.out.printf("""
                    --------------------------------------------
                    Bienvenido %s es un gusto tenerte aca.
                    A continuacion puedes iniciar sesion con tu nuevo usuario
                    %n""", tempUser.getUserName());
        } else {
            System.out.printf("""
                    --------------------------------------------
                    Se ha encontrado un error y el usuario %s no se agrego.
                    A continuacion puedes intentar registrarte de nuevo.
                    %n""", tempUser.getUserName());
        }

        mainMenu();
    }

    private void login() {
        boolean isUserValidated = false;
        int attempt = 0;
        do {
            System.out.println("--------------------------------------------");
            System.out.print("Ingresa tu nombre de usuario: ");
            String user = askForString(5, 13);
            System.out.print("Ingresa tu contraseña: ");
            String password = askForString(5, 15);
            var validatingUser = authService.validateUser(new UserCredentialsDTO(user, password));
            if (validatingUser.isPresent()) {
                isUserValidated = true;
                userCurrentlyLogedIn = validatingUser.get();
            } else {
                attempt++;
                System.out.println("--------------------------------------------");
                System.out.println("Tu usuario o contraseña es incorrecto.");
                System.out.println("Tienes " + (3 - attempt) + " de 3 intentos.");
            }

            if(attempt >= 3){
                System.out.println("--------------------------------------------");
                System.out.println("Tus intentos se han acabado, \nseras regresado al menu principal.");
            }

        } while (!isUserValidated && attempt < 3);


        if (isUserValidated) {
            System.out.printf("""
                    --------------------------------------------
                    Bienvenido %s es un gusto tenerte aca.
                    A continuacion tienes las opciones de %s.
                    %n""", userCurrentlyLogedIn.getUserName(), userCurrentlyLogedIn.getUserRole().getDescripcion());
            switch (userCurrentlyLogedIn.getUserRole()) {
                case ADMIN -> menuAdmin();
                case USER -> menuUser();
                default -> System.out.print("""
                        --------------------------------------------
                        
                        Usuario Guest, accede con un usuario admin o
                        user.
                        
                        """);


            }
        } else {
            mainMenu();
        }

    }

    private void menuUser() {
        int option;
        do {
            System.out.print("""
                    --------------------------------------------
                    1. Prestar un libro 📚
                    2. Actualizar mi información 🛠️
                    3. Ver historial de libros prestados 📖
                    4. Ver historial de multas 💸
                    5. Cerrar Sesión 🔙
                    
                    Escoge una opción:\t""");
            option = askForInt(1, 5);

            switch (option) {
                case 1 -> borrowBook();
                case 2 -> updateUserInfo();
                case 3 -> showBorrowedBooksHistory();
                case 4 -> showPenaltiesHistory();
                case 5 -> System.out.print("""
                        --------------------------------------------
                        
                        Hasta pronto!, Cerrando sesion...
                        
                        """);
                default -> System.out.println("Esa opcion no existe");
            }

        } while (option != 5);

    }

    private void borrowBook() {
        int option;
        do {
            System.out.print("""
                    --------------------------------------------
                    1. Ver libros disponibles 📘
                    2. Buscar libro por ISBN 🔎
                    3. Buscar libro por palabras clave 🗝️
                    4. Regresar al menú principal 🔙
                    
                    Escoge una opción:\t""");
            option = askForInt(1, 4);

            switch (option) {
                case 1 -> notAssignedYetFinalFunction();
                case 2 -> notAssignedYetFinalFunction();
                case 3 -> notAssignedYetFinalFunction();
                case 4 -> System.out.print("""
                        --------------------------------------------
                        Regresando al menu principal...
                        """);
                default -> System.out.println("Esa opcion no existe");
            }

        } while (option != 4);
    }

    private void updateUserInfo() {
        int option;
        do {
            System.out.print("""
                    --------------------------------------------
                    1. Actualizar Nombre ✏️
                    2. Actualizar Email 📧
                    3. Actualizar Contraseña 🔒
                    4. Actualizar Dirección 🏠
                    5. Actualizar Número de teléfono 📞
                    6. Actualizar Identificación Personal 🆔
                    7. Regresar al menú principal 🔙
                    
                    Escoge una opción:\t""");
            option = askForInt(1, 7);

            switch (option) {
                case 1 -> notAssignedYetFinalFunction();
                case 2 -> notAssignedYetFinalFunction();
                case 3 -> notAssignedYetFinalFunction();
                case 4 -> notAssignedYetFinalFunction();
                case 5 -> notAssignedYetFinalFunction();
                case 6 -> notAssignedYetFinalFunction();
                case 7 -> System.out.print("""
                        --------------------------------------------
                        Regresando al menu principal...
                        """);
                default -> System.out.println("Esa opcion no existe");
            }

        } while (option != 7);
    }

    private void showBorrowedBooksHistory() {
        System.out.println("Mostrar historial de libros");
        notAssignedYet();
    }

    private void showPenaltiesHistory() {
        System.out.println("Mostrar historial de multas");
        notAssignedYet();
    }

    private void menuAdmin() {
        int option;
        do {
            System.out.print("""
                    --------------------------------------------
                    1. Administrar Usuarios 👥
                    2. Ver historial de actividades 📜
                    3. Administrar Libros 📚
                    4. Estadísticas 📊
                    5. Cerrar Sesión 🔙
                    
                    Escoge una opción:\t""");
            option = askForInt(1, 5);

            switch (option) {
                case 1 -> adminUsers();
                case 2 -> showRecords();
                case 3 -> adminBooks();
                case 4 -> showStats();
                case 5 -> System.out.print("""
                        --------------------------------------------
                        
                        Hasta pronto!, Cerrando sesion...
                        
                        """);
                default -> System.out.println("Esa opcion no existe");
            }

        } while (option != 5);

    }

    private void adminUsers() {
        int option;
        do {
            System.out.print("""
                    --------------------------------------------
                    1. Cambiar información personal 👤
                    2. Cambiar información de otro usuario 🧑‍🤝‍🧑
                    3. Crear Nuevo Usuario ➕
                    4. Activar / Desactivar / Eliminar Usuarios ⚙️
                    5. Regresar al menú principal 🔙
                    
                    Escoge una opción:\t""");
            option = askForInt(1, 6);

            switch (option) {
                case 1 -> notAssignedYet();
                case 2 -> notAssignedYet();
                case 3 -> notAssignedYet();
                case 4 -> notAssignedYet();
                case 5 -> System.out.print("""
                        --------------------------------------------
                        Regresando al menu principal...
                        """);
                default -> System.out.println("Esa opcion no existe");
            }

        } while (option != 5);

    }

    private void showRecords() {
        int option;
        do {
            System.out.print("""
                    --------------------------------------------
                    1. Ver historial de multas 💸
                    2. Ver historial de préstamos 📖
                    3. Modificar / Eliminar multa ✏️
                    4. Pagar multas 💰
                    5. Regresar al menú principal 🔙
                    
                    Escoge una opción:\t""");
            option = askForInt(1, 6);

            switch (option) {
                case 1 -> notAssignedYet();
                case 2 -> notAssignedYet();
                case 3 -> notAssignedYet();
                case 4 -> notAssignedYet();
                case 5 -> System.out.print("""
                        --------------------------------------------
                        Regresando al menu principal...
                        """);
                default -> System.out.println("Esa opcion no existe");
            }

        } while (option != 5);
    }

    private void adminBooks() {
        int option;
        do {
            System.out.print("""
                    --------------------------------------------
                    1. Ver todos los libros (existentes y no disponibles) 📖
                    2. Añadir libros nuevos ➕
                    3. Modificar libros ✏️
                    4. Eliminar libros 🗑️
                    5. Regresar al menú principal 🔙
                    
                    Escoge una opción:\t""");
            option = askForInt(1, 6);

            switch (option) {
                case 1 -> notAssignedYet();
                case 2 -> notAssignedYet();
                case 3 -> notAssignedYet();
                case 4 -> notAssignedYet();
                case 5 -> System.out.print("""
                        --------------------------------------------
                        Regresando al menu principal...
                        """);
                default -> System.out.println("Esa opcion no existe");
            }

        } while (option != 5);
    }

    private void showStats() {
        int option;
        do {
            System.out.print("""
                    --------------------------------------------
                    1. Libros más prestados 🔁
                    2. Usuarios más activos 👥
                    3. Usuarios con más multas 💸
                    4. Historial de registro de usuarios 🕒
                    5. Libros menos prestados 📉
                    6. Actividad por fecha / mes 📆
                    7. Multas totales generadas 💰
                    8. Tasa de retención de usuarios 🔄
                    9. Tiempo promedio de devolución de libros ⏱️
                    10. Regresar al menú principal 🔙
                    
                    Escoge una opción:\t""");
            option = askForInt(1, 10);

            switch (option) {
                case 1 -> notAssignedYet();
                case 2 -> notAssignedYet();
                case 3 -> notAssignedYet();
                case 4 -> notAssignedYet();
                case 5 -> notAssignedYet();
                case 6 -> notAssignedYet();
                case 7 -> notAssignedYet();
                case 8 -> notAssignedYet();
                case 9 -> notAssignedYet();
                case 10 -> System.out.print("""
                        --------------------------------------------
                        Regresando al menu principal...
                        """);
                default -> System.out.println("Esa opcion no existe");
            }

        } while (option != 10);
    }

    private void notAssignedYet() {
        System.out.print("""
                --------------------------------------------
                ++++++++++++++++++++++++++++++++++++++++++++
                Este MENU no ha sido habilitada aun.
                ++++++++++++++++++++++++++++++++++++++++++++
                """);
    }

    private void notAssignedYetFinalFunction() {
        System.out.print("""
                --------------------------------------------
                ++++++++++++++++++++++++++++++++++++++++++++
                Esta OPCION no ha sido habilitada aun.
                ++++++++++++++++++++++++++++++++++++++++++++
                """);
    }


}
