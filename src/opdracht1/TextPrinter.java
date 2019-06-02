package opdracht1;

import opdracht2.NumberParser;
import opdracht2.WordProcessor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.function.Function;
import java.util.function.Predicate;

public class TextPrinter {

    private String sentence;

    public TextPrinter(String sentence) {
        this.sentence = sentence;
    }


    public String filteredWord(Predicate<String> predicate) {

        for (String s : sentence.split(" ")) {
            if (predicate.test(s)) {
                System.out.println(s);
            }
        }


        return null;
    }

    public void printProcessedWords(Function<String,String> wordProcessor) {
        for (String s : sentence.split(" ")) {
            //Vervang van mijn eigen WordProcessor functional interface door Function interface met aanroep naar de apply methode die een een object van een bepaalde type terug geeft in een andere type.We gebruiken hier Java.util.function interfaces.
            System.out.println(wordProcessor.apply(s));

        }

    }

    public void printNumberValues(NumberParser numberParser) {
        for (String s : sentence.split(" ")) {
            System.out.println(numberParser.parse(s));
        }
    }

    public void printSum(NumberParser parser) {
        int x = 0;
        for (String s : sentence.split(" ")) {
            x += parser.parse(s).toBigInteger().intValue();

        }
        System.out.println(x);
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }
}


