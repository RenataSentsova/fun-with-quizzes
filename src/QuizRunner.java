import model.Checkbox;
import model.MultipleChoice;
import model.TrueFalse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class QuizRunner {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int score = 0;

        // q1
        String m1Question = "Which planet is closest to the sun?";
        HashMap<Integer, String> m1Answers = new HashMap<>();
        m1Answers.put(0, "Mars"); m1Answers.put(1, "Mercury");
        m1Answers.put(2, "Jupiter");
        MultipleChoice m1 = new MultipleChoice(m1Question, m1Answers, 1);
        //q2
        String c1Question = "What color is in the rainbow?";
        HashMap<Integer, String> c1Answers = new HashMap<>();
        c1Answers.put(0, "Green"); c1Answers.put(1, "Brown");
        c1Answers.put(2, "Red");
        ArrayList<Integer> c1RAnsw = new ArrayList<>();
        c1RAnsw.add(0); c1RAnsw.add(2);
        Checkbox c1 = new Checkbox(c1Question, c1Answers, c1RAnsw);
        //q3
        String t1Question = "There are five different blood groups.";
        String t1Answer = "False";
        TrueFalse t1 = new TrueFalse(t1Question, t1Answer.toLowerCase());
        // all questions in quiz
        ArrayList<MultipleChoice> quizM = new ArrayList<>();
        quizM.add(m1);
        ArrayList<Checkbox> quizC = new ArrayList<>();
        quizC.add(c1);
        ArrayList<TrueFalse> quizTF = new ArrayList<>();
        quizTF.add(t1);

        int i = 0;
        ArrayList<Integer> mistakes = new ArrayList<>();
        for (MultipleChoice question: quizM) {
            System.out.println("QUESTION " + i);
            question.display();
            int answ = scanner.nextInt();
            scanner.nextLine();
            if (question.checkAnswer(answ)) score++;
            else mistakes.add(i);
            i++;
        }
        for (Checkbox question: quizC) {
            System.out.println("QUESTION " + i);
            question.display();
            String str = scanner.nextLine();
            ArrayList<String> answ = new ArrayList<>(Arrays.asList(str.split("\\s*,\\s*")));
            if (question.checkAnswer(answ)) score++;
            else mistakes.add(i);
            i++;
        }
        for (TrueFalse question: quizTF) {
            System.out.println("QUESTION " + i);
            question.display();
            String str = scanner.nextLine().toLowerCase();
            if(question.checkAnswer(str)) score++;
            else mistakes.add(i);
            i++;
        }

        System.out.println("SCORE: " + score + " of " + i);
        System.out.println("Failed questions: QUESTION" + mistakes);
    }
}
