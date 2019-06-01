package opdracht1;

import opdracht2.TextUtil;

public class MainApp {

    public static void main(String[] args) {


        TextPrinter textPrinter = new TextPrinter("Hello this are my Lambdas, interested");


        System.out.println("Woorden met letter 'e'");
        System.out.println("-".repeat(30));
        textPrinter.filteredWord(s -> s.contains("e"));
        System.out.println();


        System.out.println("Woorden met meer letters dan 4");
        System.out.println("-".repeat(30));
        textPrinter.filteredWord(s -> s.length() > 4);
        System.out.println();


        System.out.println("Woorden met eerste letter a");
        System.out.println("-".repeat(30));
        textPrinter.filteredWord(s -> s.charAt(0) == 'a');
        System.out.println();


        System.out.println("Woorden met tweede letter als 'e'");
        System.out.println("-".repeat(30));
        textPrinter.filteredWord(s -> s.charAt(1) == 'e');
        System.out.println();



        System.out.println("Woorden met twee letters'e'");
        System.out.println("-".repeat(30));
        textPrinter.filteredWord(s -> s.matches("[a-zA-Z]*e[a-zA-Z]*e[a-zA-Z]*"));
        System.out.println();


        System.out.println("Druk Woorden Omgekeerd Met Statische methode");
        System.out.println("-".repeat(30));
        //Ik roep de statische methode van de interface TextUtil die dezelfde parameters en return type heeft als de process methode in Wordprocessor interface.
        textPrinter.printProcessedWords(TextUtil::reverse);
        System.out.println();

        




    }
}
