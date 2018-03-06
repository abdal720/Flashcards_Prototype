package components;

import java.util.*;

public abstract class Question<T extends Comparable<T>> implements Answerable
{
    public enum Type {
        MULTIPLE_CHOICE, MULTIPLE_SELECT, TRUE_OR_FALSE, FILL_IN_BLANK
    }
    protected Type questionType;
    protected List<Answer<T>> answerOptions;
    protected String question;

    public Question(Type questionType, String question, List<Answer<T>> answerOptions) {
        this.question = question;
        this.questionType = questionType;
        this.answerOptions = new ArrayList<>();
        this.answerOptions.addAll(answerOptions);
    }

    public static class Answer<T extends Comparable<T>> {
        private T answer;
        public Answer(T answerOption) { this.answer = answerOption; }
        public T getAnswer() { return this.answer; }

        @Override
        public boolean equals(Object o) {
            if (o == this) return true;
            if (!(o instanceof Answer)) return false;
            return answer.compareTo(((Answer<T>) o).getAnswer()) == 0;
        }
        @Override
        public int hashCode() {
            return (404+answer.toString().hashCode()/8);
        }
        @Override
        public String toString() {
            return answer.toString();
        }
    }

    public List<Answer<T>> getAnswerOptions() {
        return this.answerOptions;
    }

    protected abstract <T extends Comparable<T>> void setCorrectAnswer(List<Answer<T>> answer);
    protected abstract List<Answer<T>> getCorrectAnswer();

    public String getQuestion() {
        return this.question;
    }
    public Type getQuestionType() {
        return this.questionType;
    }

    @Override
    public String toString() {
        return question;
    }
}