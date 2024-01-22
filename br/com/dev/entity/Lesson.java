package br.com.dev.entity;

public abstract class Lesson {

    private String title;

    public Lesson(String title) {
        this.title = title;
    }

    public abstract int duration();
}
