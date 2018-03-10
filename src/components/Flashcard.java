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

    public void setResponse(String ... response) {
        checkResponse(response);
    }

    protected void checkResponse(String ... response) {
        char charVal = Character.toUpperCase(response[0].charAt(0));
        switch (question.getQuestionType())
        {
            case MULTIPLE_CHOICE : verifyMultiChoiceResponse(charVal);     break;
            case TRUE_OR_FALSE   : verifyTrueOrFalseResponse(charVal);     break;
            case FILL_IN_BLANK   : verifyFillInBlankResponse(response);    break;
            case MULTIPLE_SELECT : verifyMultiSelectResponse(response[0]); break;
            default              :                                         return;
        }
    }

    private void verifyMultiChoiceResponse(char choice) {
        final int optSize = question.getAnswerOptions().size();
        if ((choice <= 'A'+(optSize-1))) {
          isAnswerCorrect = question.confirmAnswer(Character.toString(choice));
        }

    }

    private void verifyMultiSelectResponse(String response) {
        final int numAns = question.getCorrectAnswer().size();
        if (response.length() < numAns) return;
        response = response.substring(0, numAns);
        isAnswerCorrect = question.confirmAnswer(response);
    }

    private void verifyFillInBlankResponse(String[] answers) {
        isAnswerCorrect = ((FillInBlank)  question).confirmAnswer(answers);
    }

    private void verifyTrueOrFalseResponse(char answer) {
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