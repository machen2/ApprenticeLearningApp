package com.pillar.pillarLearningCenter.model;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String title;

    public String content;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }

        if (!(o instanceof Post)) {
            return false;
        }

        Post post2 = (Post) o;
        return post2.getId() == this.getId() && post2.getTitle().equals(this.getTitle()) && post2.getContent().equals(this.getContent());
    }
}