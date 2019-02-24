package org.bag.dto.assemblers;

import org.bag.domain.Project;
import org.bag.domain.ProjectImage;
import org.bag.dto.FrontendProject;

import java.util.ArrayList;
import java.util.List;

public class FrontendProjectAssembler {
    Project project;

    public FrontendProjectAssembler(Project project) {
        this.project = project;
    }

    public FrontendProject assemble() throws Exception {
        return new FrontendProject(project.id(),
                project.title(),
                project.locatie(),
                project.bannerImage().url(),
                project.frontPageImage().url(),
                getImageList(project));
    }

    // de banner image moet uit de images collectie gehaald worden
    private List<String> getImageList(Project project) {
        ArrayList<String> images = new ArrayList<>();
        for (ProjectImage projectImage : project.images()) {
            if(!projectImage.equals(project.bannerImage()))
                images.add(projectImage.url());
        }
        return images;
    }


}
