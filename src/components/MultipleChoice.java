package components;

public class MultipleChoice extends Question {
    private Answer<String> correctAns;

    public MultipleChoice(String question, Answer<String> correctAns, Answer<String> ... choices) {
        super(Question.Type.MULTIPLE_CHOICE, question, choices);
        this.correctAns = correctAns;
    }

    @Override
    public Answer<String> getCorrectAnswer() {
        return this.correctAns;
    }

    @Override
    public void setCorrectAnswer(Answer correctAns) {

    }
}
