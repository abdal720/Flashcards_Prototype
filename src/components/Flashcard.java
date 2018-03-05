package components;

import components.Question.*;
import java.util.HashMap;
import java.util.List;

public class Flashcard implements Answerable
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
            case MULTIPLE_SELECT : break;
            case FILL_IN_BLANK : break;
            case TRUE_OR_FALSE : break;
        }
    }

    private HashMap<Character, Answer<String>> multChoiceOptions;
    private void checkMultChoiceQuestion(char choice)
    {
        char opt = 'A';
        final int optSize = question.getAnswerOptions().size();
        if ((choice <= opt+(optSize-1))) {
            multChoiceOptions = new HashMap<>(optSize);
            for (int i = 0; i < optSize; i++, opt++) {
                multChoiceOptions.put(opt, ((Answer) question.getAnswerOptions().get(i)));
            }
            if (multChoiceOptions.containsKey(Character.toUpperCase(choice))) {
                Answer chosenAns = multChoiceOptions.get(choice);
                isAnswerCorrect = question.getCorrectAnswer().stream()
                        .allMatch(ans -> ans.equals(chosenAns));
            }
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
    private boolean checkTrueOrFalseQuestion(boolean trueOrFalse) {
        return false;
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