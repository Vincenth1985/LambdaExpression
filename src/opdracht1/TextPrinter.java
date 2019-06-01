package opdracht1;

import opdracht2.WordProcessor;

public class TextPrinter {

    private String sentence;

    public TextPrinter(String sentence) {
        this.sentence = sentence;
    }


    public String filteredWord(WordFilter filter) {

        for (String s : sentence.split(" ")) {
            if (filter.isValid(s)) {
                System.out.println(s);
            }
        }


        return null;
    }

    public void printProcessedWords(WordProcessor wordProcessor) {
        for (String s : sentence.split(" ")) {
            System.out.println(wordProcessor.process(s));

        }

    }


}


