package at.jku;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("##########################################");
        System.out.println("####  Das ist der Buchstabencounter!  ####");
        System.out.println("##########################################");

        String textString = "";

        char[] car = new char[]{'A', 'Ä', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'Ö', 'P', 'Q', 'R', 'S', 'ß', 'T', 'U', 'Ü', 'V', 'W', 'X', 'Y', 'Z',
                ' ', ',', '.', '!', '?', '-', '+', '*', '/', '"', '(', ')',
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        int numberNotDefinesCharFound = 0 ;
        int[] carCounter = new int[car.length]; // 30];

        // Meine Test
        /*System.out.println("Zeichen" + car[0]);
        System.out.println("" + car[0]);
        System.out.println(car[0] + car[1]);
        System.out.println("Zeichen: " + car[0] + car[1]);*/
        // Ende meine Test


        // Text Eingabe bei dem die Zeichen gezählt werden

        boolean isFinished = false;

        while (!isFinished){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Bitte geben Sie den Text ein bei dem Sie die Zeichen zählen wollen:  ");
            System.out.println("Oder starten sie die Zählung mit der Eingabe: 'start'");
            String scannedString = scannInput(); //scanner.nextLine();

            if (scannedString.equalsIgnoreCase("start")){

                isFinished = true;

            }else{

            textString = textString + scannedString ;

            }
        }

        System.out.println();
        System.out.println("Es werden die Anzahl der Zeichen in Folgendem Text ermittelt:");
        System.out.println();
        System.out.println(textString);

        // alle Zeichen nach denen gesucht wird drucken
        System.out.println();
        System.out.println("Es wird nach folgenden Zeichen gesucht");
        for (int i = 0; i < car.length; i++) {
            System.out.print(car[i] + "\t");
        }
        System.out.println();

        // Zeichen zählen
        for (int i = 0; i < textString.length(); i++) {
            // Zeichen im Text
            for (int j = 0; j < car.length; j++) {

                String newString = "";
                newString = newString + textString.charAt(i);
                String compareString = "";
                compareString = compareString + car[j];

                if (newString.equalsIgnoreCase(compareString)) {
                    carCounter[j]++;
                    break; // for Schleife beenden
                }

                if (j== car.length-1){
                    numberNotDefinesCharFound ++ ;// Zeichen zählen die nicht definiert sind
                }
            }

        }

        printResult(car, numberNotDefinesCharFound, carCounter);

        // Sortiern mit Bubblesort
        System.out.println();
        System.out.println("Sortiert:");

        for (int n = car.length; n > 1; n--) {
            for (int i = 0; i < (n - 1); i++) {
                if (carCounter[i] < carCounter[i + 1]) {
                    int intTemp = carCounter[i];
                    carCounter[i] = carCounter[i + 1];
                    carCounter[i + 1] = intTemp;
                    char carTemp = car[i];
                    car[i] = car[i + 1];
                    car[i + 1] = carTemp;
                }
            }
        }

        // Ergebnis in sortierter Reihenfolge drucken
        printResult(car, numberNotDefinesCharFound, carCounter);

    }

    private static void printResult(char[] car, int numberNotDefinesCharFound, int[] carCounter) {
        for (int i = 0; i < car.length; i++) {
            System.out.println("Das Zeichen:\t" + car[i] + "\tist\t\t" + carCounter[i] + "\tmal im Text enthalten");
        }

        System.out.println("" + numberNotDefinesCharFound + " Zeichen sind in der Suche nicht definiert");
    }

    private static String scannInput (){
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        return string;
    }
}
