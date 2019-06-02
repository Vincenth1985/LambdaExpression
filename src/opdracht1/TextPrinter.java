package opdracht1;

import opdracht2.NumberParser;
import opdracht2.WordProcessor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class TextPrinter {

    private String sentence;
    private Consumer<String> consumer;


    public TextPrinter(String sentence) {
        this.sentence = sentence;
    }

    public TextPrinter(Consumer<String> consumer) {
        this.consumer = consumer;
        //consumer.accept(this.sentence);
    }

    public TextPrinter(String sentence, Consumer<String> consumer) {
        this.sentence = sentence;
        this.consumer = consumer;
    }

    public String filteredWord(Predicate<String> predicate, Consumer<String> consumer) {

        for (String s : sentence.split(" ")) {
            if (predicate.test(s)) {
                consumer.accept(s);
            }
        }


        return null;
    }

    public void printProcessedWords(Function<String, String> wordProcessor) {
        for (String s : sentence.split(" ")) {
            //Vervang van mijn eigen WordProcessor functional interface door Function interface met aanroep naar de apply methode die een een object van een bepaalde type terug geeft in een andere type.We gebruiken hier Java.util.function interfaces.
            consumer.accept(s);
        }

    }

    public void printNumberValues(Function<String, BigDecimal> numberParser) {
        for (String s : sentence.split(" ")) {
            System.out.println(numberParser.apply(s));
        }
    }

    public void printSum(Function<String, BigDecimal> parser) {
        int x = 0;
        for (String s : sentence.split(" ")) {
            x += parser.apply(s).toBigInteger().intValue();
        }
        System.out.println(x);
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public Consumer<String> getConsumer() {
        return this.consumer;
    }

    public void setConsumer(Consumer<String> consumer) {
        this.consumer = consumer;
    }
}


