package org.bag.domain;

import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ProjectTest {

    @Test
    public void createProjectGood() throws Exception {
        ArrayList<ProjectImage> images = new ArrayList<>();
        images.add(new ProjectImage("image1.jpg"));
        images.add(new ProjectImage("image2.jpg"));

        Project project = new Project("detitel", "delocatei", images, 0,1);
        Assert.assertNotNull("Geldige indices", project);
    }

    @Test(expected = Exception.class)
    public void createProjectBad() throws Exception {
        ArrayList<ProjectImage> images = new ArrayList<>();
        images.add(new ProjectImage("image1.jpg"));
        images.add(new ProjectImage("image2.jpg"));

        Project project = new Project("detitel", "delocatei", images, 2,0);
    }

    @Test(expected = Exception.class)
    public void createProjectBad2() throws Exception {
        ArrayList<ProjectImage> images = new ArrayList<>();
        images.add(new ProjectImage("image1.jpg"));
        images.add(new ProjectImage("image2.jpg"));

        Project project = new Project("detitel", "delocatei", images, 0,2);
    }
}