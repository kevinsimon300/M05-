/**
 * @author: Kevin Simón Pérez
 *
 */

import java.util.Scanner;

public class Bitllets_SimonKevin {
    /**
     * procedure to display the welcome message
     */
    private static void messageInit(){
        final String BLUE = "\033[34m";
        final String RESET = "\u001B[0m";
        final String message = "--------------------\nQuin bitllet desitja adquirir?\n1 - Bitllet senzill\n 2 - TCasual\n 3 - TUsual\n 4 - TFamiliar\n 5 - TJove";
        System.out.println(BLUE+message+RESET);
    }

    /**
     * Function to transform zones to number
     * @param zonesViatjarInt
     * @param zonesViatjar
     * @return zonesViatjarInt
     */
    private static int parseInt (int zonesViatjarInt, String zonesViatjar){
        if(zonesViatjar.equals("zona1")){
            zonesViatjarInt = 1;
        }else if(zonesViatjar.equals("zona2")){
            zonesViatjarInt = 2;
        }else if(zonesViatjar.equals("zona3")){
            zonesViatjarInt = 3;
        }
        return zonesViatjarInt;
    }

    /**
     * Function that calculates the total price of the ticket
     * @param ticketName
     * @param zonesViatjarInt
     * @return calculusTicket
     */
    private static float calculateTicket(String ticketName, int zonesViatjarInt){
        float ticketPrice = 0.0f;
        float calculusTicket = 0.0f;
        for (int i = 1; i <= zonesViatjarInt; i++) {
            if(ticketName.equals("Bitllet senzill")){
                ticketPrice = 2.40f;
                if(i == 1){
                    calculusTicket = ticketPrice;
                }
                if(zonesViatjarInt == 2){
                    calculusTicket = ticketPrice*1.3125f;
                }else if(zonesViatjarInt == 3){
                    calculusTicket = ticketPrice*1.8443f;
                }

            }else if(ticketName.equals("TCasual")){
                ticketPrice = 11.35f;
                if(i == 1){
                    calculusTicket = ticketPrice;
                }
                if(zonesViatjarInt == 2){
                    calculusTicket = ticketPrice*1.3125f;
                }else if(zonesViatjarInt == 3){
                    calculusTicket = ticketPrice*1.8443f;
                }
            }else if(ticketName.equals("TUsual")){
                ticketPrice = 40.00f;
                if(i == 1){
                    calculusTicket = ticketPrice;
                }
                if(zonesViatjarInt == 2){
                    calculusTicket = ticketPrice*1.3125f;
                }else if(zonesViatjarInt == 3){
                    calculusTicket = ticketPrice*1.8443f;
                }
            }else if(ticketName.equals("TFamiliar")){
                ticketPrice = 10.00f;
                if(i == 1){
                    calculusTicket = ticketPrice;
                }
                if(zonesViatjarInt == 2){
                    calculusTicket = ticketPrice*1.3125f;
                }else if(zonesViatjarInt == 3){
                    calculusTicket = ticketPrice*1.8443f;
                }
            }else if(ticketName.equals("TJove")){
                ticketPrice = 80.40f;
                if(i == 1){
                    calculusTicket = ticketPrice;
                }
                if(zonesViatjarInt == 2){
                    calculusTicket = ticketPrice*1.3125f;
                }else if(zonesViatjarInt == 3){
                    calculusTicket = ticketPrice*1.8443f;
                }
            }
            System.out.println("El preu del bitllet es "+ calculusTicket);
        }
        return calculusTicket;
    }


    /**
     * Function that verifies that the entered number is an integer
     * @param message
     * @param correctType
     * @param input
     * @return isInt
     */
    private static int hasNextInt(String message,boolean correctType, Scanner input){
        int isInt = 0;
        do{
            System.out.println(message);
            correctType = input.hasNextInt();
            if(correctType){
                isInt = input.nextInt();
                input.nextLine();
            }else{
                System.out.println("ERROR! Introdueix un número sencer");
                input.nextLine();
            }
        }while (!correctType);
        return isInt;
    }

    /**
     * Function used to indicate the areas of the ticket
     * @param zonesViatgar
     * @param input
     * @return zonesViarjar
     */

    private static String zonesaViatjar(int zonesViatgar, Scanner input){
        boolean isCorrectType = false;
        String zonesViarjar = "";
        do {
            zonesViatgar = hasNextInt("Introdueix el número de zones: ",isCorrectType, input);
            switch (zonesViatgar){
                case 1:
                    System.out.println("S'ha escollit la zona 1");
                    zonesViarjar = "zona1";
                    break;
                case 2:
                    System.out.println("S'ha escollit la zona 2");
                    zonesViarjar = "zona2";
                    break;
                case 3:
                    System.out.println("S'ha escollit la zona 3");
                    zonesViarjar = "zona3";
                    break;
                default:
                    System.out.println("ERROR! Introdueix una zona correcta");
            }
        }while(zonesViatgar < 1 || zonesViatgar > 3);
        return zonesViarjar;
    }

    /**
     * Function used to collet the ticket and show the ticker breakdown to the user interface
     * @param price
     * @param tiketName
     * @param zonesViatjar
     * @param input
     */

    private static void pagarBitllet(float[] price, String[] tiketName, String[] zonesViatjar, Scanner input){
        float suma = 0.0f;
        float totalImport = 0.0f;
        float enteredImport = 0.0f;
        float[] monedesAceptades = {0.05f,0.10f,0.20f,0.50f,5.0f,10.0f,50.0f};
        for (int i = 0; i < price.length; i++) {
            suma += price[i];
        }
        System.out.println("S'ha de pagar "+suma);

        do{
            System.out.println("Introdueix monedes o bitllets vàlids de Dolar?");
            enteredImport = input.nextFloat();
            if(enteredImport >= suma){
                System.out.println("L'import es mès gran que "+suma);
            }else{
                if(enteredImport == monedesAceptades[0]){
                    totalImport += monedesAceptades[0];
                    System.out.println("S'ha introudit "+monedesAceptades[0]+" Falten "+(suma-totalImport));
                }else if(enteredImport == monedesAceptades[1]){
                    totalImport += monedesAceptades[1];
                    System.out.println("S'ha introudit "+monedesAceptades[1]+" Falten "+(suma-totalImport));
                }else if(enteredImport == monedesAceptades[2]){
                    totalImport += monedesAceptades[2];
                    System.out.println("S'ha introudit "+monedesAceptades[2]+" Falten "+(suma-totalImport));
                }else if(enteredImport == monedesAceptades[3]){
                    totalImport += monedesAceptades[3];
                    System.out.println("S'ha introudit "+monedesAceptades[3]+" Falten "+(suma-totalImport));
                }else if(enteredImport == monedesAceptades[4]){
                    totalImport += monedesAceptades[4];
                    System.out.println("S'ha introudit "+monedesAceptades[4]+" Falten "+(suma-totalImport));
                }else if(enteredImport == monedesAceptades[5]){
                    totalImport += monedesAceptades[5];
                    System.out.println("S'ha introudit "+monedesAceptades[5]+" Falten "+(suma-totalImport));
                }else if(enteredImport == monedesAceptades[6]){
                    totalImport += monedesAceptades[6];
                    System.out.println("S'ha introudit "+monedesAceptades[6]+" Falten "+(suma-totalImport));
                }else{
                    System.out.println("Moneda no vàlida");
                }
            }

        }while (totalImport < suma);

        System.out.println("_____TIQUET_____");
        for (int i = 0; i < tiketName.length; i++) {
            if(tiketName[i] != null && zonesViatjar[i] != null) {
                System.out.println(tiketName[i] + " " + zonesViatjar[i]);
            }
        }
        System.out.println("----------------\nReculli el teu tiquet.\nAdeu!!");
    }

    /**
     * Function that selects the name of the ticket
     * @param selectedOption
     * @return tiketType
     */

    private static String nomTicket(int selectedOption) {
        String tiketType = "";
        switch (selectedOption) {
            case 1:
                tiketType = "Bitllet senzill";
                break;
            case 2:
                tiketType = "TCasual";
                break;
            case 3:
                tiketType = "TUsual";
                break;
            case 4:
                tiketType = "TFamiliar";
                break;
            case 5:
                tiketType = "TJove";
                break;
        }
        return tiketType;
    }

    /**
     * Function that starts the programm
     * @param input
     */


    private static void runMenu(Scanner input){
        final String volsComprar = "Vols seguir comprant? [S/n]";
        int selectedOption = 0;
        boolean correctType = false;
        int zonesViatjarInt[] = new int[3];
        float[] price = new float[3];
        String[] ticketName = new String[3];
        String[] zonesViatjar = new String[3];
        int ticketsComprar = 0;
        char seguirComprant;
        do {
            messageInit();
            selectedOption = hasNextInt("Introdueix el típus de bitllet",correctType, input);
            if(selectedOption == 1 || selectedOption == 2 || selectedOption == 3 || selectedOption == 4 || selectedOption == 5){
                if(ticketsComprar <= 2) {
                    ticketName[ticketsComprar] = nomTicket(selectedOption);
                    zonesViatjar[ticketsComprar] = zonesaViatjar(zonesViatjarInt[ticketsComprar], input);
                    zonesViatjarInt[ticketsComprar] = parseInt(zonesViatjarInt[ticketsComprar], zonesViatjar[ticketsComprar]);
                    price[ticketsComprar] = calculateTicket(ticketName[ticketsComprar], zonesViatjarInt[ticketsComprar]);
                    ticketsComprar++;
                    System.out.println(volsComprar);
                    seguirComprant = input.nextLine().charAt(0);
                    if(seguirComprant == 'n' || seguirComprant == 'N'){
                        pagarBitllet(price, ticketName, zonesViatjar, input);
                        for (int i = 0; i < ticketsComprar; i++) {
                            zonesViatjar[ticketsComprar] = "";
                            ticketName[ticketsComprar] = "";
                            price[ticketsComprar] = 0;
                        }
                        ticketsComprar = 0;
                    }
                }else{
                    ticketsComprar--;
                    pagarBitllet(price, ticketName, zonesViatjar, input);
                    for (int i = 0; i < ticketsComprar; i++) {
                        zonesViatjar[ticketsComprar] = "";
                        ticketName[ticketsComprar] = "";
                        price[ticketsComprar] = 0;
                    }
                    ticketsComprar = 0;
                }
            }else if(selectedOption == 4321){
                System.out.println("Machine OFF!");
            }else{
                System.out.println("ERROR! Enter a correct option");
            }

        }while (selectedOption != 4321);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        runMenu(input);
    }
}
