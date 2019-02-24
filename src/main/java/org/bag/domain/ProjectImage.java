package org.bag.domain;

import java.util.Objects;

/**
 * Plaatje behorende bij een project.
 */
public class ProjectImage {
    int id;
    String imageUrl;

    public ProjectImage(String imageUrl) {
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
        ProjectImage that = (ProjectImage) o;
        return imageUrl.equals(that.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageUrl);
    }
}
