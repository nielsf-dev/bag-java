package org.bag.domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ProjectTest {

    @Test
    public void createProjectGood() throws Exception {
        ArrayList<Image> images = new ArrayList<>();
        images.add(new Image("image1.jpg"));
        images.add(new Image("image2.jpg"));

        Project project = new Project("detitel", "delocatei", images, 0,1);
        Assert.assertNotNull("Geldige indices", project);
    }

    @Test(expected = Exception.class)
    public void createProjectBad() throws Exception {
        ArrayList<Image> images = new ArrayList<>();
        images.add(new Image("image1.jpg"));
        images.add(new Image("image2.jpg"));

        Project project = new Project("detitel", "delocatei", images, 2,0);
        Project project1 = new Project();
        Assert.assertNotNull(project1);
    }

    @Test(expected = Exception.class)
    public void createProjectBad2() throws Exception {
        ArrayList<Image> images = new ArrayList<>();
        images.add(new Image("image1.jpg"));
        images.add(new Image("image2.jpg"));

        Project project = new Project("detitel", "delocatei", images, 0,2);
    }
}