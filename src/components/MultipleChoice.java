package components;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class MultipleChoice extends Question {
    private List<Answer<String>> correctAnswer;

    public MultipleChoice(String question, List<Answer<String>> ansChoices, Answer<String> correctAns) {
        super(Question.Type.MULTIPLE_CHOICE, question, ansChoices);
        this.correctAnswer = new ArrayList<>(1);
        setCorrectAnswer(correctAns);
    }

    private void setCorrectAnswer(Answer<String> ans) {
        List<Answer> answer = new ArrayList<>(1);
        answer.add(ans);
        setCorrectAnswer(answer);
    }

    @Override
    protected void setCorrectAnswer(List answer) {
        this.correctAnswer.addAll(answer);
    }

    @Override
    protected List<Answer<String>> getCorrectAnswer() {
        return correctAnswer;
    }

}
