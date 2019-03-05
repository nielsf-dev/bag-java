package org.bag.domain;

import javax.persistence.*;
import java.util.Objects;

/**
 * Plaatje behorende bij een project.
 */
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String imageUrl;

    protected Image(){}

    public Image(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int id() {
        return id;
    }

    public String url() {
        return imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image that = (Image) o;
        return imageUrl.equals(that.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageUrl);
    }
}
