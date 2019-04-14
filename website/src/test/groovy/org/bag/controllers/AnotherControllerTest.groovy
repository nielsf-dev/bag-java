package org.bag.controllers

import org.bag.KingFrerichs
import spock.lang.Specification

class AnotherControllerTest extends Specification {
    def "DoSomething"() {
        given: "bla"
        def king = new KingFrerichs(45)
        def anotherController = new AnotherController()
        println(king.aantalJarenAanDeMacht)

        expect: "bloe WE GAAN NOG FF"
        anotherController.doSomething() == 187
    }
}
