package org.bag.domain

import spock.lang.Specification

class ProjectSpec extends Specification {

    def "Verwacht title in juiste language"() {
        given:
        def project = createProject()
        project.titel_en = "us title"

        expect:
        title == project.getTitle(lang)

        where: "default is nl"
        lang    | title
        "en"    | "us title"
        "zh"    | ""
        "onzin" | "nl title"
        "nl"    | "nl title"
    }

    def "Verwacht locatie in juiste language"() {
        given:
        def project = createProject()
        project.locatie_en = "us locatie"

        expect:
        title == project.getLocatie(lang)

        where: "default is nl"
        lang    | title
        "en"    | "us locatie"
        "zh"    | ""
        "onzin" | "nl locatie"
    }

    def "Verwacht text in juiste language"() {
        given:
        def project = createProject()
        project.text_en = "us test"

        expect:
        title == project.getText(lang)

        where: "default is nl"
        lang    | title
        "en"    | "us test"
        "zh"    | ""
        "onzin" | "nl test"
    }

    def createProject(){
        return new Project(0,"nl title", "nl locatie", "nl test", createImages(), 0, 0)
    }

    def createImages() {
        return [new Image("image1.jpg"), new Image("image2.jpg")]
    }
}
