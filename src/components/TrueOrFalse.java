package components;

import java.util.ArrayList;
import java.util.List;

public class TrueOrFalse extends Question {
    private List<Answer<Boolean>> correctAns;

    public TrueOrFalse(String question, List<Answer<Boolean>> options, Answer<Boolean> correctAns) {
        super(Question.Type.TRUE_OR_FALSE, question, options);
        this.correctAns = new ArrayList<>(1);
        this.correctAns.add(correctAns);
       // setCorrectAnswer(correctAns);
    }

    @Override
    public List<Answer<Boolean>> getCorrectAnswer() {
        return this.correctAns;
    }

    @Override
    public void setCorrectAnswer(List correctAns) {

    }
}
