package components;

import java.util.List;

public class MultipleSelect extends Question {
    private List<Answer<String>> correctAns;

    public MultipleSelect(String question, List<Answer<String>> selections) {
        super(Question.Type.MULTIPLE_SELECT, question, selections);
    }

    @Override
    public List<Answer<String>> getCorrectAnswer() {
        return this.correctAns;
    }


    @Override
    public void setCorrectAnswer(List correctAns) {

    }
}
