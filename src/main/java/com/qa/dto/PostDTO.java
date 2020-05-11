package com.qa.dto;

import com.qa.domain.Post;


import java.util.Objects;

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


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PostDTO other = (PostDTO) obj;
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

}
