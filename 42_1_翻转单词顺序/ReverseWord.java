import java.util.List;
import java.util.ArrayList;

public class ReverseWord {
    public static String reverse(String sentence) {
        if (sentence == null || sentence.length() <= 1)
            return sentence;

        List<String> words = splitSentence(sentence);
        StringBuilder sb = new StringBuilder(2 * words.size() - 1);

        for (int i = words.size() - 1; i > 0; i--) {
            sb.append(words.get(i));
            sb.append(" ");
        }
        sb.append(words.get(0));
        return sb.toString();
    }

    private static List<String> splitSentence(String sentence) {
        // 假设单词不以空白开始和结束，单词之间的空白仅一个空白
        List<String> ret = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                ret.add(sentence.substring(start, i));
                start = i + 1;
            }
        }
        if (start != sentence.length())
            ret.add(sentence.substring(start, sentence.length()));
        return ret;
    }

    public static void test() {
        System.out.println(reverse("I am a student."));
        System.out.println(reverse("student."));
    }

    public static void main(String[] args) {
        test();
    }
}