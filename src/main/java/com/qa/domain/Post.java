package com.qa.domain;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Post {

    @Id
    @GeneratedValue

    private Long pid;
    private String pictureLink;

    @ManyToOne(targetEntity = Social.class)
    private Social social;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }

    public Social getSocial() {
        return social;
    }

    public void setSocial(Social social) {
        this.social = social;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return pid.equals(post.pid) &&
                pictureLink.equals(post.pictureLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pid, pictureLink);
    }
}
