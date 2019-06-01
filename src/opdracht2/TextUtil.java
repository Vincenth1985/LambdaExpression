package opdracht2;

public interface TextUtil {

    public static String reverse(String s) {

        StringBuilder stringBuilder = new StringBuilder(s);
        return stringBuilder.reverse().toString();
    }
}
