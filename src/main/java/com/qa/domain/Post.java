package com.qa.domain;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue

    private Long pid;
    private String pictureLink;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    private List<Social> socials = new ArrayList<>();

    public Post() {
    }

    public Post(String pictureLink) {
        this.pictureLink = pictureLink;
    }

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

    public List<Social> getSocials() {
        return socials;
    }

    public void setSocials(List<Social> socials) {
        this.socials = socials;
    }
}
