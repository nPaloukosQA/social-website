package com.qa.domain;

import javax.persistence.Entity;
import javax.persistence.*;
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
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Post other = (Post) obj;
        if (pictureLink == null) {
            if (other.pictureLink != null)
                return false;
        } else if (!pictureLink.equals(other.pictureLink))
            return false;
        if (pid == null) {
            if (other.pid != null)
                return false;
        } else if (!pid.equals(other.pid))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pid, pictureLink);
    }
}
