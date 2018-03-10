import components.Flashcard;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import components.FlashcardBuilder;
import components.Question;
import components.Question.*;

public class Main {
    public static void main(String[] args) {
        testMultipleChoiceCard(1);
        testTrueOrFalseCard(2);
        testMultipleSelectCard(3);
        testFillInBlankCard(4);
    }

    public static void testMultipleChoiceCard(int questionNum) {
        List<String> choiceList = new ArrayList<>();
        String subject = "computer science",
               question = "What are four aspects of algorithm complexity?",
               a = "input size, runtime, output size, rate of growth",
               b = "rate of growth, input size, CPU speed, runtime",
               c = "runtime, RAM space, output size, input size",
               d = "input size, CPU speed, RAM space, output size";
        choiceList.add(a);
        choiceList.add(b);
        choiceList.add(c);
        choiceList.add(d);
        String correctAnswer = choiceList.get(1);
        Flashcard multChoiceCard = FlashcardBuilder.buildMultipleChoiceCard(
                subject, question, choiceList, correctAnswer
        );
        while (!multChoiceCard.isAnswerCorrect())
        {
            System.out.println("Subject: "+subject+".");
            System.out.println("Question "+questionNum+".");
            System.out.println(multChoiceCard.getQuestion().toString() + "\n");
            printOptions(multChoiceCard.getQuestion());
            String input = new Scanner(System.in).nextLine().toUpperCase();
            multChoiceCard.setResponse(input);
            printWhetherCorrect(multChoiceCard);
        }
    }

    public static void testTrueOrFalseCard(int questionNum) {
        String subject = "Astronomy";
        String question = "Low thermal pressure can prevent interstellar clouds from " +
                          "gravitationally contracting.";
        // TODO: hint- cool enough to be a star
        Flashcard trueFalseCard = FlashcardBuilder.buildTrueOrFalseCard(subject, question, false);
        while (!trueFalseCard.isAnswerCorrect())
        {
            System.out.println("Subject "+subject);
            System.out.println("Question "+questionNum+".");
            System.out.println(trueFalseCard.getQuestion().toString());
            printOptions(trueFalseCard.getQuestion());
            String input = new Scanner(System.in).nextLine();
            trueFalseCard.setResponse(input);
            printWhetherCorrect(trueFalseCard);
        }
    }

    public static void testMultipleSelectCard(int questionNum) {
        List<String> selectionList = new ArrayList<>(5),
                     correctAnswers = new ArrayList(3);
        String subject  = "Psychology",
               question = "Choose the three mental stages involved with learning and memory:",
               a = "encoding", b = "filtering", c = "retrieval", d = "acquirement", e = "storage";
        selectionList.add(a);
        selectionList.add(b);
        selectionList.add(c);
        selectionList.add(d);
        selectionList.add(e);
        correctAnswers.add(a);
        correctAnswers.add(c);
        correctAnswers.add(e);
        Flashcard multiSelectCard = FlashcardBuilder.buildMultipleSelectCard(
                subject, question, selectionList, correctAnswers);
        while (!multiSelectCard.isAnswerCorrect())
        {
            System.out.println("Subject: "+subject);
            System.out.println("Question: "+questionNum);
            System.out.println(multiSelectCard.getQuestion().toString());
            printOptions(multiSelectCard.getQuestion());
            String input = new Scanner(System.in).nextLine().replaceAll("\\s", "");
            multiSelectCard.setResponse(input);
            printWhetherCorrect(multiSelectCard);
        }
    }

    public static void testFillInBlankCard(int questionNum) {
        List<String> correctAns = new ArrayList<>();
        String subject = "Calculus",
               question = "The _______ ____ is used to differentiate two or more compositional functions.",
               answer = "chain rule";
        correctAns.add(answer);
        Flashcard fillInBlankCard = FlashcardBuilder.buildFillInBlankCard(subject, question, correctAns);

        while (!fillInBlankCard.isAnswerCorrect())
        {
            System.out.println("Subject: "+subject);
            System.out.println("Question: "+questionNum);
            System.out.println(fillInBlankCard.getQuestion().toString());
            String input = new Scanner(System.in).nextLine();
            fillInBlankCard.setResponse(input);
            printWhetherCorrect(fillInBlankCard);
        }
    }

    public static void printOptions(Question question) {
        switch (question.getQuestionType()) {
            case MULTIPLE_CHOICE : printMultChoiceOpts(question.getAnswerOptions()); break;
            case MULTIPLE_SELECT : printMultChoiceOpts(question.getAnswerOptions()); break;
            case TRUE_OR_FALSE   : printTrueFalseOpts(question.getAnswerOptions());  break;
            default :                                                                break;
        }
    }

    public static void printTrueFalseOpts(List<Answer> options) {
        System.out.println(options.get(1).toString()+"(t) or (f)"+options.get(0));
    }

    public static void printMultChoiceOpts(List<Answer> options) {
        char key = 'a';
        for (Object ansOpt : options) {
            System.out.println(key+". "+ansOpt.toString());
            key++;
        }
    }

    public static void printWhetherCorrect(Flashcard flashcard) {
        System.out.println(flashcard.isAnswerCorrect() ? "Correct!\n" : "Incorrect.\n");
    }
}