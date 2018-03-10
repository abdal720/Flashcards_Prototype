package components;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FillInBlank extends Question {
    private List<Answer<String>> correctAns;

    public FillInBlank(String question, List<Answer<String>> correctAns) {
        super(Question.Type.FILL_IN_BLANK, question);
        this.correctAns = new ArrayList<>(correctAns.size());
        setCorrectAnswer(correctAns);
    }

    @Override
    protected void setCorrectAnswer(List answer) {
        this.correctAns.addAll(answer);
    }

    @Override
    protected List<Answer<String>> getCorrectAnswer() {
        return this.correctAns;
    }

    @Override
    public boolean confirmAnswer(String answer) {
        confirmAnswer(answer);
        return false;
    }

    public boolean confirmAnswer(String ... answers) {
        if (answers.length > correctAns.size() || answers.length < correctAns.size())
            return false;

        for (int i = 0 ; i < correctAns.size() ; i++) {
            Answer<String> ans = new Answer<>(answers[i]);
            if (!correctAns.get(i).equals(ans)) return false;
        }
        return true;
    }
}