package at.jku;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Das ist der Buchstabencounter!");

        String textString = "Ich bin Johannes123456";


        char[] car = new char[]{'A', 'Ä', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'Ö', 'P', 'Q', 'R', 'S', 'ß', 'T', 'U', 'Ü', 'V', 'W', 'X', 'Y', 'Z',
                ' ',',','.','!','?','-','+','*','/','"',
                '0', '1', '2','3','4','5','6','7','8','9'};
        int[] carCounter = new int[ car.length]; // 30];

        // Meine Test
        System.out.println("Zeichen" + car[0]);
        System.out.println("" + car[0]);
        System.out.println(car[0] + car[1]);
        System.out.println("Zeichen: " + car[0] + car[1] );
        // Ende meine Test


        // Abfrage für die Texteingabe
        System.out.println("Bitte geben sie den Text ein, von dem Sie die Anzahl der Zeichen zählen möchten:");
        Scanner scanner = new Scanner(System.in) ;

        textString = scanner.nextLine();

        // alle Zeichen Drucken
        System.out.println("Es wird nach folgenden Zeichen gesucht");
        for (int i = 0; i < car.length; i++) {
            System.out.print(car[i] + "\t");
        }
        System.out.println();

        for (int i = 0; i < textString.length(); i++) {
            // Zeichen im Text
            for (int j = 0; j < car.length; j++) {
                String newString = "";
                newString = newString + textString.charAt(i);
                String compareString = "";
                compareString = compareString + car[j];

                if (newString.equalsIgnoreCase(compareString)) {

                    carCounter[j]++;

                }
            }

        }

        for (int i = 0 ; i < car.length ; i++){
            System.out.println("Das Zeichen:\t" + car[i] + "\tist\t\t" + carCounter[i] + "\tmal im Text enthalten");
        }




    }
}
