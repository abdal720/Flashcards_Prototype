package components;

public class FlashcardBuilder {
    private FlashcardBuilder() { }

    public static Flashcard buildTrueOrFalse(String subject, String question, boolean correctAns) {
        Question<Boolean> trueOrFalseQuestion = new TrueOrFalse(question, correctAns);
        Flashcard flashcard = new Flashcard(subject, trueOrFalseQuestion);
        return null;
    }

    public static Flashcard buildMultipleChoice(String subject, String question,
                                                String correctAns, String ... choices)
    {
       // Question.Answer<String>
       // Question<String> multipleChoiceQuestion = new MultipleChoice(question, );
        return null;
    }

    public static Flashcard buildMultipleSelect() {
        return null;
    }

    public static Flashcard buildFillInBlank() {
        return null;
    }
}