package components;

import java.util.Set;
import java.util.HashSet;

// TODO: Build a builder for this

public class Flashcard<T extends Comparable<T>>
{
    private String subject;
    private Question question;
    private Set<Question.Answer<T>> responseSet;
    private boolean isCorrectResponse = false;

    private Flashcard() {
        this.responseSet = new HashSet<>();
    }

    public Flashcard(String subject, Question question) {
        this();
        this.subject = subject;
        this.question = question;
        this.responseSet = new HashSet<>();
    }

    public boolean isResponseCorrect() {
        return isCorrectResponse;
    }

    public void setResponse(Question.Answer<T> response) {
        responseSet.add(response);
    }

    public void checkResponse() {
        isCorrectResponse = responseSet.stream()
                .allMatch(r -> r.equals(question.getCorrectAnswer()));
    }

    public Question getQuestion() { return question; }

    @Override
    public String toString() {
        return "subject="+subject+", " +
                "\nquestion="+question+""+
                "--- " +
                "\n" +question.getAnswerChoices();
    }
}