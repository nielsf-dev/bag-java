package org.bag.dto

import java.io.IOException

// kennelijk als ik ze niet via de constructor doe gaat het fout met jackson?
class UpdaterProjectImage {
    var id: Int
    var url: String
    var isFrontend: Boolean
    var isBanner: Boolean

    constructor(){
        println("default")
        id = 0
        url = ""
        isFrontend = false
        isBanner = false
    }

    constructor(id:Int,url:String,isFrontend:Boolean,isBanner:Boolean){
        this.id = id
        this.url = url
        this.isFrontend = isFrontend
        this.isBanner = isBanner
    }
}

