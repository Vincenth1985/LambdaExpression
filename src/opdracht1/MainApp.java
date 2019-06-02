package opdracht1;

import opdracht2.TextScrambler;
import opdracht2.TextUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MainApp {

    public static void main(String[] args) {


        TextPrinter textPrinter = new TextPrinter("Hello this are my Lambdas, interested");
        //Gebruik van Predicate functional interface en de default methodes.
        Predicate<String> condition = s->s.contains("e");
        Predicate<String> condition2 = s->s.contains( "a");
        Predicate<String> condition3 = condition2.or(condition);



        System.out.println("Woorden met letter 'e'");
        System.out.println("-".repeat(30));
        textPrinter.filteredWord(condition);
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
        System.out.println("-".repeat(40));
        //Ik roep de statische methode van de interface TextUtil die dezelfde parameters en return type heeft als de process methode in Wordprocessor interface.
        textPrinter.printProcessedWords(TextUtil::reverse);
        System.out.println();


        System.out.println("Druk letters Met Object Gebonden methode");
        System.out.println("-".repeat(40));
        TextScrambler textScrambler = new TextScrambler();
        //textPrinter.printProcessedWords(s -> textScrambler.scramble(s));
        //shorter.
        //Ik maak hier een instantie van de Klasse TextScrambler en gebruik de methode scramble die match met process.
        textPrinter.printProcessedWords(textScrambler::scramble);
        System.out.println();


        System.out.println("Druk Woorden Hoofdletter met ongebonden object methode");
        System.out.println("-".repeat(40));
        textPrinter.printProcessedWords(String::toUpperCase);
        System.out.println();


        System.out.println("Druk Woorden in cijfers met constructor referentie");
        System.out.println("-".repeat(40));
        textPrinter.setSentence("134 345 23 34 12212 4545 343");
        textPrinter.printNumberValues(s -> new BigDecimal(s));
        //shorter
        //textPrinter.printNumberValues(BigDecimal::new);
        System.out.println();

        System.out.println("Druk Som met constructor referentie");
        System.out.println("-".repeat(40));
        textPrinter.setSentence("134 345 23 34 12212 4545 343");
        textPrinter.printSum(s -> new BigDecimal(s));
        //shorter
        //textPrinter.printNumberValues(BigDecimal::new);

    }
}
