package sistemalibreria.util;

import java.util.Scanner;

public class RequestUserInfo {

    public static int askForInt(int rangoInicial, int rangoFinal){

        Scanner askUser;
        boolean isInfoSavedandCorrect = false;
        int resultObtained = -1;
        while(!isInfoSavedandCorrect){
            try{
                askUser = new Scanner(System.in);
                resultObtained = Integer.parseInt(askUser.nextLine());
                if(resultObtained >= rangoInicial & resultObtained <= rangoFinal ){
                    isInfoSavedandCorrect = true;
                }else {
                    System.out.println("No hay opcion '" + resultObtained + "'. Escoge una opcion del menu." );
                }
            }catch(NumberFormatException e){
                System.out.println("El valor ingresado tiene que ser un numero.");
            };
        }
        return resultObtained;
    }

    public static String askForString(int minimo, int maximo){
        Scanner askUser;
        String resultObtained = null;
        boolean isInfoSavedandCorrect = false;
        while(!isInfoSavedandCorrect){
            askUser = new Scanner(System.in);
            resultObtained = askUser.nextLine();
            if(resultObtained.length() >= minimo & resultObtained.length() <= maximo){
                isInfoSavedandCorrect = true;
            }else{
                System.out.println("El valor no es valido, el texto tiene que tener entre "+minimo+" y "+maximo+" caracteres.");
            }
        }
        return resultObtained;
    }

    public static boolean askForBoolean(){
        Scanner askUser;
        String textObtained = null;
        boolean valueObtained = false;
        boolean isInfoSavedandCorrect = false;
        while(!isInfoSavedandCorrect){
            askUser = new Scanner(System.in);
            textObtained = askUser.nextLine();
            if(textObtained.length() <= 3 & !textObtained.isEmpty()) {
                if (textObtained.equalsIgnoreCase("si") || textObtained.equalsIgnoreCase("1") ||
                        textObtained.equalsIgnoreCase("y") || textObtained.equalsIgnoreCase("yes")
                        || textObtained.equalsIgnoreCase("s")
                ) {
                    valueObtained = true;
                    isInfoSavedandCorrect = true;
                } else if (textObtained.equalsIgnoreCase("no") || textObtained.equalsIgnoreCase("0") ||
                        textObtained.equalsIgnoreCase("n")
                ) {
                    valueObtained = false;
                    isInfoSavedandCorrect = true;
                } else {
                    System.out.println("Ingresa un valor valido, el texto tiene que tener SI/NO, 1/0, S/N, Y/N, YES/NO");
                }
            }else {
                System.out.println("Ingresa un valor valido, el texto tiene que tener SI/NO, 1/0, S/N, Y/N, YES/NO");
            }

        }
        return valueObtained;
    }

}
