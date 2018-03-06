package components;

import java.util.List;

public class Flashcard
{
    private String subject;
    private Question question;
    private boolean isAnswerCorrect = false;

    public Flashcard(String subject, Question question) {
        this.subject = subject;
        this.question = question;
    }

    public boolean isAnswerCorrect() {
        return isAnswerCorrect;
    }

    public List getAnswerOptions() {
        return question.getAnswerOptions();
    }

    public void setResponse(String response) {
        checkResponse(response);
    }

    protected void checkResponse(String response) {
        switch (question.getQuestionType()){
            case MULTIPLE_CHOICE :
                checkMultChoiceQuestion(Character.toUpperCase(response.charAt(0)));
                break;
            case TRUE_OR_FALSE :
                verifyTrueFalseResponse(Character.toUpperCase(response.charAt(0)));
                break;
            case MULTIPLE_SELECT : break;
            case FILL_IN_BLANK : break;
        }
    }

    private void checkMultChoiceQuestion(char choice) {
        final int optSize = question.getAnswerOptions().size();
        if ((choice <= 'A'+(optSize-1))) {
          isAnswerCorrect = question.confirmAnswer(Character.toString(choice));
        }
    }

    // TODO
    private boolean checkMultipleSelectQuestion(String response) {
        return false;
    }

    // TODO
    private boolean checkFillInBlankQuestion(String answer) {
        return false;
    }

    // TODO
    private void verifyTrueFalseResponse(char answer) {
        isAnswerCorrect = question.confirmAnswer(Character.toString(answer));
    }

    public Question getQuestion() { return question; }

    @Override
    public String toString() {
        StringBuilder cardStringBuilder = new StringBuilder();
        String text = "subject: "+subject+
                "\nquestion: "+question+"\n---";
        cardStringBuilder.append(text);
        cardStringBuilder.append(question.getAnswerOptions().toString());
        return cardStringBuilder.toString();
    }
}