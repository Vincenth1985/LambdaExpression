package opdracht1;

import opdracht2.TextScrambler;
import opdracht2.TextUtil;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class MainApp {

    public static void test(int x, Predicate<Integer> predicate) {
        System.out.println(predicate.test(x));
    }


    public static void main(String[] args) {


        TextPrinter textPrinter = new TextPrinter("Hello this are my Lambdas, interested",System.out::print);
        //Gebruik van Predicate functional interface en de default methodes.
        Predicate<String> condition = s -> s.contains("e");
        Predicate<String> condition2 = s -> s.contains("a");
        Predicate<String> condition3 = condition2.or(condition);

        //Test met de predicate en nog andere parameters.De lambda expression weet wat die moet implementeren
        System.out.println("Predicate Interface test");
        System.out.println("-".repeat(30));
        test(45, s -> s > 45);


        System.out.println("\nWoorden met letter 'e'");
        System.out.println("-".repeat(30));
        textPrinter.filteredWord(condition, s -> System.out.println(s));
        System.out.println();


        System.out.println("\nWoorden met meer letters dan 4");
        System.out.println("-".repeat(30));
        textPrinter.filteredWord(s -> s.length() > 4, s -> System.out.println(s));
        System.out.println();


        System.out.println("\nWoorden met eerste letter a");
        System.out.println("-".repeat(30));
        textPrinter.filteredWord(s -> s.charAt(0) == 'a', System.out::println);
        System.out.println();


        System.out.println("\nWoorden met tweede letter als 'e'");
        System.out.println("-".repeat(30));
        textPrinter.filteredWord(s -> s.charAt(1) == 'e', System.out::print);
        System.out.println();


        System.out.println("\nWoorden met twee letters'e'");
        System.out.println("-".repeat(30));
        Predicate<String> condition6 = s -> s.matches("[a-zA-Z]*e[a-zA-Z]*e[a-zA-Z]*");
        textPrinter.filteredWord(condition6, System.out::print);
        System.out.println();


        System.out.println("\nDruk Woorden Omgekeerd Met Statische methode");
        System.out.println("-".repeat(45));
        //Ik roep de statische methode van de interface TextUtil die dezelfde parameters en return type heeft als de process methode in Wordprocessor interface.
        textPrinter.printProcessedWords(TextUtil::reverse);
        System.out.println();


        System.out.println("\nDruk letters Met Object Gebonden methode");
        System.out.println("-".repeat(40));
        TextScrambler textScrambler = new TextScrambler();
        //textPrinter.printProcessedWords(s -> textScrambler.scramble(s));
        //shorter.
        //Ik maak hier een instantie van de Klasse TextScrambler en gebruik de methode scramble die match met process.
        textPrinter.printProcessedWords(textScrambler::scramble);
        System.out.println();


        System.out.println("\nDruk Woorden Hoofdletter met ongebonden object methode");
        System.out.println("-".repeat(40));
        textPrinter.printProcessedWords(String::toUpperCase);
        System.out.println();


        System.out.println("\nDruk Woorden in cijfers met constructor referentie");
        System.out.println("-".repeat(40));
        textPrinter.setSentence("134 345 23 34 12212 4545 343");
        textPrinter.printNumberValues(s -> new BigDecimal(s));
        //shorter
        //textPrinter.printNumberValues(BigDecimal::new);
        System.out.println();

        System.out.println("\nDruk Som met constructor referentie");
        System.out.println("-".repeat(40));
        textPrinter.setSentence("134 345 23 34 12212 4545 343");
        textPrinter.printSum(s -> new BigDecimal(s));
        //shorter
        //textPrinter.printNumberValues(BigDecimal::new);


        System.out.println("\nOpdract 3 Standaard Functionele interfaces Oefeningen");
        System.out.println("-".repeat(55));

        Function<String, String> toUppercase = s -> s.toUpperCase();
        Function<String, StringBuilder> toReverse = s -> new StringBuilder(s).reverse();
        System.out.println(toUppercase.andThen(toReverse).apply("Hello My Friend"));


        System.out.println("\nOpdract 3 Standaard Functionele interfaces Consumer bij de constructor toegevoegd");
        System.out.println("-".repeat(80));
        //Mijn constructor print een sysout dankzij de consumer parameter.Is niet de bedoeling maar voor het oefenen.
        //TextPrinter textPrinter1 = new TextPrinter("Hello", s -> System.out.println(textPrinter.getSentence()));

        //Hieronder maak ik een nieuwe instantie met een consumer als parameter die geinitialiseerd word.Ik kan die nadien setten en getten.
        TextPrinter textPrinter2 = new TextPrinter(s -> System.out.println(s.toUpperCase()));
        textPrinter.setSentence("Test met de Consumer die bij de constructor genitialiseerd word");
        textPrinter2.setConsumer(s-> System.out.println(s.toLowerCase()));
        textPrinter2.getConsumer().accept(textPrinter.getSentence());


    }
}
