package com.webtemplate.backend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "img")
public class Image extends BaseDomain<Image> {
    @Id
    @Column(name = "img_id")
    String imageId;

    @Column(name = "url")
    String url;

    public String getImageId() {
        return this.imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Image imageId(String imageId) {
        setImageId(imageId);
        return this;
    }

    public Image url(String url) {
        setUrl(url);
        return this;
    }

}
