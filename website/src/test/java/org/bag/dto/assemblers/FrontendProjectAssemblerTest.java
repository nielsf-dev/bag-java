package org.bag.dto.assemblers;

import org.bag.domain.Project;
import org.bag.domain.Image;
import org.bag.dto.FrontendProject;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Locale;

public class FrontendProjectAssemblerTest {

    @Test
    public void testImages() throws Exception {

        ArrayList<Image> images = new ArrayList<>();
        images.add(new Image("image1.jpg"));
        images.add(new Image("image2.jpg"));

        Project project = new Project("detitel", "delocatei", "", images, 0,1);
        project.setTitel_en("The title");

        FrontendProjectAssembler projectAssembler = new FrontendProjectAssembler(project);
        Locale locale = new Locale("en", "US");
        FrontendProject frontendProject = projectAssembler.assemble(locale);
        Assert.assertEquals("Title in juiste taal", "The title", project.getTitle(locale.getLanguage()));
        Assert.assertEquals("images moeten omgezetn worden",2,frontendProject.getProjectImageUrls().size());
    }
}