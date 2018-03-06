package components;
import java.util.List;

public interface Answerable {
    <T extends Comparable<T>> List<T> getAnswerOptions();
    boolean confirmAnswer(String answer);
}
