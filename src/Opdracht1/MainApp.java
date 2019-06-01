package Opdracht1;

public class MainApp {

    public static void main(String[] args) {


        TextPrinter textPrinter = new TextPrinter("Hello this are my Lambdas");


        textPrinter.filteredWord(s -> s.contains("e"));


    }
}
