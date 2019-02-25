package org.bag.dto.assemblers;

import org.bag.domain.Project;
import org.bag.domain.Image;
import org.bag.dto.FrontendProject;

import java.util.ArrayList;
import java.util.List;

/**
 * Maakt een FrontendProject aan obv een Project
 */
public class FrontendProjectAssembler {
    private Project project;

    public FrontendProjectAssembler(Project project) {
        this.project = project;
    }

    public FrontendProject assemble() throws Exception {
        return new FrontendProject(project.getId(),
                project.getTitle(),
                project.getLocatie(),
                project.getBannerImage().getUrl(),
                project.getFrontpageImage().getUrl(),
                getImageList(project));
    }

    private List<String> getImageList(Project project) {
        ArrayList<String> images = new ArrayList<>();
        for (Image image : project.getImages()) {
                images.add(image.getUrl());
        }
        return images;
    }


}
