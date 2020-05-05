package com.qa.dto;

import java.util.List;

public class PostDTO {

    private Long pid;
    private String pictureLink;
    private List<PostDTO> posts;

    public PostDTO(){}

    public PostDTO(String pictureLink, List<PostDTO> posts) {
        super();
        this.pictureLink = pictureLink;
        this.posts = posts;
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

    public List<PostDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDTO> posts) {
        this.posts = posts;
    }
}
