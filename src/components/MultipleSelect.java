package components;

import java.util.List;

public class MultipleSelect extends Question {
    private Answer<List<String>> correctAns;

    public MultipleSelect(String question, Answer<List<String>> correctAns, Answer<String> ... choices) {
        super(Question.Type.MULTIPLE_SELECT, question, choices);
        this.correctAns = correctAns;
    }

    @Override
    public Answer<List<String>> getCorrectAnswer() {
        return this.correctAns;
    }

    @Override
    public void setCorrectAnswer(Answer correctAns) {
        this.correctAns = correctAns;
    }
}
