package org.bag.domain

import org.bag.domain.Image
import org.bag.domain.Project
import org.junit.Assert
import org.junit.Test

import java.util.ArrayList

class ProjectTest {

    @Test
    @Throws(Exception::class)
    fun createProjectGood() {
        val images = createImages()

        val project = Project(0,"detitel", "tekst", "", images, 0, 1)
        Assert.assertNotNull("Geldige indices", project)
    }

    private fun createImages(): ArrayList<Image> {
        val images = ArrayList<Image>()
        images.add(Image("image1.jpg"))
        images.add(Image("image2.jpg"))
        return images
    }

    @Test(expected = Exception::class)
    @Throws(Exception::class)
    fun createProjectBad() {
        val images = createImages()

        val project = Project(0,"detitel", "tekst", "delocatei", images, 2, 0)
        Assert.assertNotNull(project)
    }

    @Test(expected = Exception::class)
    @Throws(Exception::class)
    fun createProjectBad2() {
        val images = createImages()
        val project = Project(0,"detitel", "tekst", "delocatei", images, 0, 2)
    }

    @Test
    @Throws(Exception::class)
    fun getTitle() {
        val project = Project(0,"nl title", "tekst", "test", createImages(), 0, 0)
        project.titel_en = "us title"

        Assert.assertEquals("Expect correct title for lang", "us title", project.getTitle("en"))
        Assert.assertEquals("No title if not provided", "", project.getTitle("zh"))
        Assert.assertEquals("Non existing languague defaults to NL", "nl title", project.getTitle("onzin"))
    }

    @Test
    @Throws(Exception::class)
    fun getLocatie() {
        val project = Project(0,"test", "nl locatie", "tekst", createImages(), 0, 0)
        project.locatie_en = "us locatie"

        Assert.assertEquals("Expect correct locatie for lang", "us locatie", project.getLocatie("en"))
        Assert.assertEquals("No title if not provided", "", project.getLocatie("zh"))
        Assert.assertEquals("Non existing languague defaults to NL", "nl locatie", project.getLocatie("onzin"))
    }

    @Test
    @Throws(Exception::class)
    fun getText() {
        val project = Project(0,"test", "nl locatie", "tekst", createImages(), 0, 0)
        project.text_en = "us tekst"

        Assert.assertEquals("Expect correct text for lang", "us tekst", project.getText("en"))
        val text : String = project.getText("zh")
        Assert.assertEquals("No tekst if not provided", "", text)
        Assert.assertEquals("Non existing languague defaults to NL", "tekst", project.getText("onzin"))
    }
}