package org.bag.dto;

import java.util.List;

/**
 * Representatie van een project voor de frontend.
 */
public class FrontendProject {
    int id;
    String title;
    String location;
    String bannerImageUrl;
    String frontPageImageUrl;
    List<String> projectImageUrls;

    public FrontendProject(int id, String title, String location, String bannerImageUrl, String frontPageImageUrl, List<String> projectImageUrls) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.bannerImageUrl = bannerImageUrl;
        this.frontPageImageUrl = frontPageImageUrl;
        this.projectImageUrls = projectImageUrls;
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
