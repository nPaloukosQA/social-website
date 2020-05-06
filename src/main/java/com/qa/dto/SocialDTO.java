package com.qa.dto;

import com.qa.domain.Post;

import java.util.List;

public class SocialDTO {

    private Long id;
    private String title;
    private String content;
    private List<PostDTO> posts;

   public SocialDTO(){

   }

   public SocialDTO (String title, String content, List<PostDTO> posts) {
       super();
       this.title = title;
       this.content = content;
       this.posts = posts;
   }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<PostDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDTO> posts) {
        this.posts = posts;
    }
}
