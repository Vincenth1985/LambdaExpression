package Opdracht1;

public class MainApp {

    public static void main(String[] args) {


        TextPrinter textPrinter = new TextPrinter("Hello this are my Lambdas");


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


    }
}
