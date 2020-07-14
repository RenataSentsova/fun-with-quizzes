package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Checkbox extends Question {
    private HashMap<Integer, String> allAnswers;
    private ArrayList<Integer> rightAnswers;

    public Checkbox (String question, HashMap<Integer, String> allAnswers, ArrayList<Integer> rightAnswers) {
        super(question);
        this.allAnswers = allAnswers;
        this.rightAnswers = rightAnswers;
    }

    public HashMap<Integer, String> getAllAnswers() {
        return allAnswers;
    }
    public ArrayList<Integer> getRightAnswers() {
        return rightAnswers;
    }

    public void display() {
        System.out.println("Q: " + getQuestion());
        System.out.println("This question can have multiple answers. Enter their numbers separated by commas:");
        for (int i = 0; i < getAllAnswers().size(); i++) {
            System.out.println(i + ": " + getAllAnswers().get(i));
        }
    }

    public boolean checkAnswer(ArrayList<String> indx) {
        if (indx.size() != getRightAnswers().size()) return false;
        for (String userInput: indx) {
            boolean flag = true;
            try {
                Integer num = Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                flag = false;
            }

            if (flag) {
                if (!getAllAnswers().containsKey(Integer.parseInt(userInput))) return false;
            }
            else return false;
        }
        return true;
    }
}
