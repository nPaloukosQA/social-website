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
    private String picturelnk;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    private List<Social> socials = new ArrayList<>();

    public Post() {
    }

    public Post(String picturelnk) {
        this.picturelnk = picturelnk;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getPicturelnk() {
        return picturelnk;
    }

    public void setPicturelnk(String picturelnk) {
        this.picturelnk = picturelnk;
    }

    public List<Social> getSocials() {
        return socials;
    }

    public void setSocials(List<Social> socials) {
        this.socials = socials;
    }
}
