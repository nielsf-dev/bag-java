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
    private String titel_en;
    private String titel_zh;

    private String locatie_nl;
    private String locatie_en;
    private String locatie_zh;

    private String text_nl;
    private String text_en;
    private String text_zh;

    @JoinTable
    @OneToMany
    private List<Image> images;

    @ManyToOne
    @JoinColumn
    private Image bannerImage;

    @ManyToOne
    @JoinColumn
    private Image frontPageImage;

    private Project(){}

    /**
     * Maakt een project aan. De banner en frontend index moeten geldig zijn mbt de images List.
     * @throws Exception Ongeldige index opgegeven
     */
    public Project(String titel, String locatie, String text, List<Image> images, int bannerImageIndex, int frontPageImageIndex) throws Exception {
        this.titel_nl = titel;
        this.locatie_nl = locatie;
        this.text_nl = text;

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

    public String getTitle(String lang) {
        if(lang == SupportedProjectLanguage.English.text)
            return titel_en;
        else if(lang == SupportedProjectLanguage.Chinese.text)
            return titel_zh;
        else
            return titel_nl;
    }

    public String getLocatie(String lang) {
        if(lang == SupportedProjectLanguage.English.text)
            return locatie_en;
        else if(lang == SupportedProjectLanguage.Chinese.text)
            return locatie_zh;
        else
            return locatie_nl;
    }

    public String getText(String lang) {
        if(lang == SupportedProjectLanguage.English.text)
            return text_en;
        else if(lang == SupportedProjectLanguage.Chinese.text)
            return text_zh;
        else
            return text_nl;
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

    public String getTitel_nl() {
        return titel_nl;
    }

    public void setTitel_nl(String titel_nl) {
        this.titel_nl = titel_nl;
    }

    public String getTitel_en() {
        return titel_en;
    }

    public void setTitel_en(String titel_en) {
        this.titel_en = titel_en;
    }

    public String getTitel_zh() {
        return titel_zh;
    }

    public void setTitel_zh(String titel_zh) {
        this.titel_zh = titel_zh;
    }

    public String getLocatie_nl() {
        return locatie_nl;
    }

    public void setLocatie_nl(String locatie_nl) {
        this.locatie_nl = locatie_nl;
    }

    public String getLocatie_en() {
        return locatie_en;
    }

    public void setLocatie_en(String locatie_en) {
        this.locatie_en = locatie_en;
    }

    public String getLocatie_zh() {
        return locatie_zh;
    }

    public void setLocatie_zh(String locatie_zh) {
        this.locatie_zh = locatie_zh;
    }

    public String getText_nl() {
        return text_nl;
    }

    public void setText_nl(String text_nl) {
        this.text_nl = text_nl;
    }

    public String getText_en() {
        return text_en;
    }

    public void setText_en(String text_en) {
        this.text_en = text_en;
    }

    public String getText_zh() {
        return text_zh;
    }

    public void setText_zh(String text_zh) {
        this.text_zh = text_zh;
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



