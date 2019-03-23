package org.bag.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UpdateProjectController{

    @GetMapping("/secret/project")
    fun somethingSecret() : String{
        return "muchsecret"
    }
}