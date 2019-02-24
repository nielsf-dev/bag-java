package org.bag.dto.assemblers;

import org.bag.domain.Project;
import org.bag.domain.ProjectImage;
import org.bag.dto.FrontendProject;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class FrontendProjectAssemblerTest {

    @Test
    public void testImages() throws Exception {

        ArrayList<ProjectImage> images = new ArrayList<>();
        images.add(new ProjectImage("image1.jpg"));
        images.add(new ProjectImage("image2.jpg"));

        Project project = new Project("detitel", "delocatei", images, 0,1);

        FrontendProjectAssembler projectAssembler = new FrontendProjectAssembler(project);
        FrontendProject frontendProject = projectAssembler.assemble();
        Assert.assertEquals("banner images moet uit de images",1,frontendProject.getProjectImageUrls().size());
    }
}