package components;

import java.util.List;

public class TrueOrFalse extends Question {
    private Answer<Boolean> correctAns;

    public TrueOrFalse(String question, boolean correctAns) {
        super(Question.Type.TRUE_OR_FALSE, question, new Answer(correctAns));
        this.correctAns = new Answer(correctAns);
    }

    @Override
    public Answer<Boolean> getCorrectAnswer() {
        return this.correctAns;
    }

    @Override
    public void setCorrectAnswer(Answer correctAns) {
        this.correctAns = correctAns;
    }
}
