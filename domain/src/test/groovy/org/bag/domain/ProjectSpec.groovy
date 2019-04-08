package org.bag.domain

import spock.lang.Specification

class ProjectSpec extends Specification {
    def "GetTitle"() {
        given:
        def project = new Project(0,"nl title", "tekst", "test", createImages(), 0, 0)
        project.titel_en = "us title"

        expect:
        title == project.getTitle(lang)

        where:
        lang    | title
        "en"    | "us title"
        "zh"    | ""
        "onzin" | "nl title"
    }

    def "GetLocatie"() {
        given:
        def project = new Project(0,"nl title", "nl locatie", "test", createImages(), 0, 0)
        project.locatie_en = "us locatie"

        expect:
        title == project.getLocatie(lang)

        where:
        lang    | title
        "en"    | "us locatie"
        "zh"    | ""
        "onzin" | "nl locatie"
    }

    def "GetText"() {
        given:
        def project = new Project(0,"nl title", "nl locatie", "nl test", createImages(), 0, 0)
        project.text_en = "us test"

        expect:
        title == project.getText(lang)

        where:
        lang    | title
        "en"    | "us test"
        "zh"    | ""
        "onzin" | "nl test"
    }

    def createImages() {
        return [new Image("image1.jpg"), new Image("image2.jpg")]
    }
}
