package components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FillInBlank extends Question {
    private List<Answer<String>> correctAns;

    public FillInBlank(String question, List<Answer<String>> ansSelections, List<Answer<String>> correctAns) {
        super(Question.Type.FILL_IN_BLANK, question, ansSelections);
        this.correctAns = new ArrayList<>(correctAns.size());
        setCorrectAnswer(correctAns);
    }

    protected void setCorrectAnswer(Answer ... ans) {

    }

    @Override
    protected void setCorrectAnswer(List answer) {

    }

    @Override
    protected List<Answer<String>> getCorrectAnswer() {
        return this.correctAns;
    }
}