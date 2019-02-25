package org.bag.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Project voor de BAG Site
 */
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String titel;
    private String locatie;

    @JoinTable
    @OneToMany
    private List<Image> images;

    @ManyToOne
    @JoinColumn(name = "bannerImageID")
    private Image bannerImage;

    @ManyToOne
    @JoinColumn(name = "frontPageImageID")
    private Image frontPageImage;

    public Project(){}

    /**
     * Maakt een project aan. De banner en frontend index moeten geldig zijn mbt de images List.
     * @throws Exception Ongeldige index opgegeven
     */
    public Project(String titel, String locatie, List<Image> images, int bannerImageIndex, int frontPageImageIndex) throws Exception {

        this.titel = titel;
        this.locatie = locatie;
        this.images = images;

        this.bannerImage = validateAndGet(images, bannerImageIndex);
        this.frontPageImage = validateAndGet(images, frontPageImageIndex);
    }

    private Image validateAndGet(List<Image> images, int index) throws Exception {
        if(images.isEmpty() || (index > images.size()-1))
            throw new Exception("Invalid index");

        return images.get(index);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return titel;
    }

    public String getLocatie() {
        return locatie;
    }

    public List<Image> getImages() {
        return images;
    }

    public Image getBannerImage() {
        return bannerImage;
    }

    public Image getFrontpageImage() {
        return frontPageImage;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public void setBannerImage(Image bannerImage) {
        this.bannerImage = bannerImage;
    }

    public void setFrontPageImage(Image frontPageImage) {
        this.frontPageImage = frontPageImage;
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
