package Opdracht1;

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


}
