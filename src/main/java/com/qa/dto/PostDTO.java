package com.qa.dto;

import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class PostDTO {

    private Long pid;
    private String pictureLink;

    public PostDTO(){}

    public PostDTO(String pictureLink) {

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

}
