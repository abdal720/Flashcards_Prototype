package components;
import  components.Question.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlashcardBuilder
{
    private FlashcardBuilder() { }

    public static Flashcard buildTrueOrFalseCard(String subject, String statement, boolean correctAns)
    {
        Answer[] options = { new Answer(true),
                             new Answer(false)
        };
        Question<Boolean> trueOrFalseQuestion = new TrueOrFalse(
                statement, Arrays.asList(options), new Answer<>(correctAns));
        return new Flashcard(subject, trueOrFalseQuestion);
    }

    public static Flashcard buildMultipleChoiceCard(String subject, String question,
                                                    List<String> choices, String correctAnswer)
    {
        List<Answer<String>> ansChoices = new ArrayList<>();
        Answer<String> correctAns = new Answer<>(correctAnswer);
        choices.forEach(choice -> ansChoices.add(new Answer<>(choice)));
        Question<String> multiChoiceQuestion = new MultipleChoice(question, ansChoices, correctAns);
        return new Flashcard(subject, multiChoiceQuestion);
    }

    public static Flashcard buildMultipleSelectCard(String subject, String question,
                                                    List<String> selections, List<String> correctAnswers)
    {
        List<Answer<String>> ansSelections = new ArrayList<>(selections.size()),
                             correctAns = new ArrayList<>(correctAnswers.size());
        selections.forEach(
                selection -> ansSelections.add(new Answer<>(selection))
        );
        correctAnswers.forEach(
                answer -> correctAns.add(ansSelections.stream().filter(
                        ans -> ans.getAnswer().equals(answer)).findFirst().get())
        );
        Question<String> multSelectQuestion = new MultipleSelect(
                question, ansSelections, correctAns);
        return new Flashcard(subject, multSelectQuestion);
    }

    public static Flashcard buildFillInBlankCard(String subject, String question, List<String> correctAnswers) {
        List<Answer<String>> answers = new ArrayList<>(correctAnswers.size());
        correctAnswers.forEach(ans -> answers.add(new Answer<>(ans)));
        Question<String> fillInBlankQuestion = new FillInBlank(question, answers);
        return new Flashcard(subject, fillInBlankQuestion);
    }
}