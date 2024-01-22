package br.com.dev.entity;

public class Task extends Lesson{
    private String description;
    private int questionCount;

    public Task(String title, String description, int questionCount) {
        super(title);
        this.description = description;
        this.questionCount = questionCount;
    }

    public String getDescription() {
        return description;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    @Override
    public int duration() {
        return questionCount * (300);
    }
}
