package org.bag.domain;

import java.util.List;
import java.util.Objects;

/**
 * Project voor de BAG Site
 */
public class Project {
    int id;
    String titel;
    String locatie;
    List<ProjectImage> images;
    ProjectImage bannerImage;
    ProjectImage frontPageImage;

    public Project(String titel, String locatie, List<ProjectImage> images, int bannerImageIndex, int frontPageImageIndex) throws Exception {
        this.titel = titel;
        this.locatie = locatie;
        this.images = images;

        bannerImage = validateAndGet(images, bannerImageIndex);
        frontPageImage = validateAndGet(images, frontPageImageIndex);
    }

    private ProjectImage validateAndGet(List<ProjectImage> images, int index) throws Exception {
        if(images.isEmpty() || (index > images.size()-1))
            throw new Exception("Invalid index");

        return images.get(index);
    }

    public int id() {
        return id;
    }

    public String title() {
        return titel;
    }

    public String locatie() {
        return locatie;
    }

    public List<ProjectImage> images() {
        return images;
    }

    public ProjectImage bannerImage() {
        return bannerImage;
    }

    public ProjectImage frontPageImage() {
        return frontPageImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return titel.equals(project.titel) &&
                locatie.equals(project.locatie) &&
                images.equals(project.images) &&
                bannerImage.equals(project.bannerImage) &&
                frontPageImage.equals(project.frontPageImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titel, locatie, images, bannerImage, frontPageImage);
    }
}
