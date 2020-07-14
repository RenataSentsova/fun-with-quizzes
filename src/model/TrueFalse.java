package model;

public class TrueFalse extends Question{

    private String rightAnswer;

    public TrueFalse (String question, String rightAnswer) {
        super(question);
        this.rightAnswer = rightAnswer;
    }

    public void display() {
        System.out.println("Q: " + getQuestion());
        System.out.println("Enter only true or false:");
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public boolean checkAnswer(String answ) {
        return answ.equals(getRightAnswer());
    }
}
