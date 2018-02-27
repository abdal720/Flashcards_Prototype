package components;

public class FillInBlank extends Question {
    private Answer<String> correctAns;

    public FillInBlank(String question, Answer<String> correctAns) {
        super(Question.Type.FILL_IN_BLANK, question, new Answer<>(correctAns));
        this.correctAns = new Answer(correctAns);
    }

    @Override
    public Answer<String> getCorrectAnswer() {
        return this.correctAns;
    }
    @Override
    public void setCorrectAnswer(Answer correctAns) {
        this.correctAns = correctAns;
    }
}