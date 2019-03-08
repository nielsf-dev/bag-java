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

    private String titel_nl;
    private String titel_us;
    private String titel_ch;

    private String locatie_nl;
    private String locatie_us;
    private String locatie_ch;

    @JoinTable
    @OneToMany
    private List<Image> images;

    @ManyToOne
    @JoinColumn
    private Image bannerImage;

    @ManyToOne
    @JoinColumn
    private Image frontPageImage;

    protected Project(){}

    /**
     * Maakt een project aan. De banner en frontend index moeten geldig zijn mbt de images List.
     * @throws Exception Ongeldige index opgegeven
     */
    public Project(String titel, String locatie, List<Image> images, int bannerImageIndex, int frontPageImageIndex) throws Exception {

        this.titel_nl = titel;
        this.locatie_nl = locatie;
        this.images = images;

        this.bannerImage = validateAndGet(images, bannerImageIndex);
        this.frontPageImage = validateAndGet(images, frontPageImageIndex);
    }

    private Image validateAndGet(List<Image> images, int index) throws Exception {
        if(images.isEmpty() || (index > images.size()-1))
            throw new Exception("Invalid index");

        return images.get(index);
    }

    public int id() {
        return id;
    }

    public String getTitle(){
        return getTitle("nl");
    }

    public String getTitle(String locale) {
        if(locale == "nl")
            return titel_nl;
        else if(locale == "us")
            return titel_us;
        else return titel_ch;
    }

    public String locatie() {
        return locatie_nl;
    }

    public List<Image> images() {
        return images;
    }

    public Image bannerImage() {
        return bannerImage;
    }

    public Image frontPageImage() {
        return frontPageImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return titel_nl.equals(project.titel_nl) &&
                locatie_nl.equals(project.locatie_nl) &&
                images.equals(project.images) &&
                bannerImage.equals(project.bannerImage) &&
                frontPageImage.equals(project.frontPageImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titel_nl, locatie_nl, images, bannerImage, frontPageImage);
    }
}
