package org.bag.service;

import org.bag.domain.Project;
import org.bag.domain.ProjectImage;
import org.bag.dto.FrontendProject;
import org.bag.dto.assemblers.FrontendProjectAssembler;

import java.util.ArrayList;

public class FrontendProjectService {
    public FrontendProject getProject(int id) throws Exception {

        ArrayList<ProjectImage> projectImages = new ArrayList<>();
        projectImages.add(new ProjectImage("/upload/portfolio/CityGarden/citygardenavond.jpg"));
        projectImages.add(new ProjectImage("/upload/portfolio/CityGarden/citygardenkop.jpg"));
        projectImages.add(new ProjectImage("/upload/portfolio/CityGarden/citygardentuin.jpg"));

        Project project = new Project("City Garden","Amstelveen",projectImages,0,1);

        FrontendProjectAssembler assembler = new FrontendProjectAssembler(project);
        return assembler.assemble();
    }
}
