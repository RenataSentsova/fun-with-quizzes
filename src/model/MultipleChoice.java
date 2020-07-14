package model;

import java.util.HashMap;

public class MultipleChoice extends Question {

    private HashMap<Integer, String> allAnswers;
    private Integer rightAnswer;

    public MultipleChoice(String question, HashMap<Integer, String> allAnswers, Integer rightAnswer) {
        super(question);
        this.allAnswers = allAnswers;
        this.rightAnswer = rightAnswer;
    }

    public HashMap<Integer, String> getAllAnswers() {
        return allAnswers;
    }
    public Integer getRightAnswer() {
        return rightAnswer;
    }

    public void display() {
        System.out.println("Q: " + getQuestion());
        System.out.println("Only one answer is correct. Enter it's number:");
        for (int i = 0; i < getAllAnswers().size(); i++) {
            System.out.println(i + ": " + getAllAnswers().get(i));
        }
    }

    public boolean checkAnswer(Integer indx) {
        if (getAllAnswers().containsKey(indx)) {
            return getRightAnswer().equals(indx);
        }
        return false;
    }
}
