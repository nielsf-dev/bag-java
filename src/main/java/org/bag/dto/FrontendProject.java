package org.bag.dto;

import java.util.List;

/**
 * Representatie van een project voor de frontend. Hierin mag de banner image niet voorkomen tussen de normale images.
 * De image voor de frontpage moet er wel in zitten.
 */
public class FrontendProject {
    private int id;
    private String title;
    private String location;
    private String bannerImageUrl;
    private String frontPageImageUrl;
    private List<String> projectImageUrls;

    public FrontendProject(int id, String title, String location, String bannerImageUrl, String frontPageImageUrl, List<String> projectImageUrls) throws Exception {
        this.id = id;
        this.title = title;
        this.location = location;
        this.bannerImageUrl = bannerImageUrl;
        this.frontPageImageUrl = frontPageImageUrl;
        this.projectImageUrls = projectImageUrls;

        if(!projectImageUrls.contains(bannerImageUrl))
            throw new Exception("Banner image moet tussen images");
        if(!projectImageUrls.contains(frontPageImageUrl))
            throw new Exception("Frontpage image moet tussen images");
    }

    public int getId(){
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public String getBannerImageUrl() {
        return bannerImageUrl;
    }

    public String getFrontPageImageUrl() {
        return frontPageImageUrl;
    }

    public List<String> getProjectImageUrls() {
        return projectImageUrls;
    }
}
