package components;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

public abstract class Question <T extends Comparable<T>> {
    public enum Type {
        MULTIPLE_CHOICE, MULTIPLE_SELECT,
        TRUE_OR_FALSE, FILL_IN_BLANK
    }
    protected String question;
    protected Set<Answer<T>> answerChoices;
    protected Type questionType;

    public Question(Type questionType, String question, Answer<T> ... answerChoices) {
        this.question = question;
        this.answerChoices = new HashSet<>();
        this.questionType = questionType;
        initAnswerChoices(answerChoices);
    }

    public abstract <T extends Comparable<T> & List<Answer<T>>> Answer<T> getCorrectAnswer();
    public abstract <T extends Comparable<T> & List<Answer<T>>> void setCorrectAnswer(Answer<T> correctAns);

    private void initAnswerChoices(Answer<T> ... answerSet) {
        for (Answer<T> ans : answerSet) {
            this.answerChoices.add(ans);
        }
    }

    public static class Answer<T> {
        private T actualAnswer;

        public Answer(T actualAnswer) {
            this.actualAnswer = actualAnswer;
        }
        public T getActualAnswer() {
            return actualAnswer;
        }
    }

    public String getQuestion() {
        return this.question;
    }

    public Type getType() {
        return this.questionType;
    }

    public Set<Answer<T>> getAnswerChoices() {
        return this.answerChoices;
    }

    public Type getQuestionType() {
        return this.questionType;
    }
}
