package org.bag.controllers

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AnotherController{

    val logger = LoggerFactory.getLogger(AnotherController::class.java)

    @GetMapping("/blabla")
    fun doSomething() : Int{
        logger.info("Doing something")
        return 187
    }
}
