package org.bag.controllers

import spock.lang.Specification

class AnotherControllerTest extends Specification {
    def "DoSomething"() {
        given: "bla"
        def anotherController = new AnotherController()

        expect: "bloe"
        anotherController.doSomething() == 187
    }
}
