package org.bag.dto.assemblers;

import org.bag.domain.Project;
import org.bag.domain.Image;
import org.bag.dto.FrontendProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Maakt een FrontendProject aan obv een Project
 */
public class FrontendProjectAssembler {
    private Project project;

    public FrontendProjectAssembler(Project project) {
        this.project = project;
    }

    public FrontendProject assemble(Locale locale) throws Exception {
        return new FrontendProject(project.id(),
                project.getTitle(locale.getLanguage()),
                project.getLocatie(locale.getLanguage()),
                project.bannerImage().url(),
                project.frontPageImage().url(),
                getImageList(project));
    }

    private List<String> getImageList(Project project) {
        ArrayList<String> images = new ArrayList<>();
        for (Image image : project.images()) {
                images.add(image.url());
        }
        return images;
    }


}
