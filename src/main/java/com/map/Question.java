package com.map;


import java.util.List;

import javax.persistence.*;

@Entity
public class Question {

    @Id
    private int questionId;
    private String question;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Answer> answers;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
