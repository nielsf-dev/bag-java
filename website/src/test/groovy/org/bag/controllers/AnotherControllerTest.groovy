package org.bag.controllers

import spock.lang.Specification

class AnotherControllerTest extends Specification {
    def "DoSomething"() {
        given: "bla"
        def anotherController = new AnotherController()

        expect: "bloe WE GAAN NOG FF"
        anotherController.doSomething() == 187
    }
}
