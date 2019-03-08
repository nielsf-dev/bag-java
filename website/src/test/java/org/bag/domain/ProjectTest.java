package org.bag.domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ProjectTest {

    @Test
    public void createProjectGood() throws Exception {
        ArrayList<Image> images = createImages();

        Project project = new Project("detitel", "tekst", "", images, 0,1);
        Assert.assertNotNull("Geldige indices", project);
    }

    private ArrayList<Image> createImages() {
        ArrayList<Image> images = new ArrayList<>();
        images.add(new Image("image1.jpg"));
        images.add(new Image("image2.jpg"));
        return images;
    }

    @Test(expected = Exception.class)
    public void createProjectBad() throws Exception {
        ArrayList<Image> images = createImages();

        Project project = new Project("detitel", "tekst", "delocatei", images, 2,0);
        Assert.assertNotNull(project);
    }

    @Test(expected = Exception.class)
    public void createProjectBad2() throws Exception {
        ArrayList<Image> images = createImages();
        Project project = new Project("detitel", "tekst", "delocatei", images, 0,2);
    }

    @Test
    public void getTitle() throws Exception {
        Project project = new Project("nl title", "tekst","test", createImages(),0, 0);
        project.setTitel_en("us title");

        Assert.assertEquals("Expect correct title for lang", "us title", project.getTitle("en"));
        Assert.assertEquals("No title if not provided", null, project.getTitle("zh"));
        Assert.assertEquals("Non existing languague defaults to NL", "nl title", project.getTitle("onzin"));
    }

    @Test
    public void getLocatie() throws Exception {
        Project project = new Project("test", "nl locatie","tekst", createImages(),0, 0);
        project.setLocatie_en("us locatie");

        Assert.assertEquals("Expect correct locatie for lang", "us locatie", project.getLocatie("en"));
        Assert.assertEquals("No title if not provided", null, project.getLocatie("zh"));
        Assert.assertEquals("Non existing languague defaults to NL", "nl locatie", project.getLocatie("onzin"));
    }

    @Test
    public void getText() throws Exception {
        Project project = new Project("test", "nl locatie","tekst", createImages(),0, 0);
        project.setText_en("us tekst");

        Assert.assertEquals("Expect correct text for lang", "us tekst", project.getText("en"));
        Assert.assertEquals("No tekst if not provided", null, project.getText("zh"));
        Assert.assertEquals("Non existing languague defaults to NL", "tekst", project.getText("onzin"));
    }
}