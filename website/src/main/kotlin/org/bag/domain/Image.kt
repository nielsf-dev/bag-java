package org.bag.domain

import javax.persistence.*
import java.util.Objects

/**
 * Plaatje behorende bij een project.
 */
@Entity
class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int = 0

    val url: String

    constructor(imageUrl: String) {
        this.url = imageUrl
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        val that = o as Image?
        return url == that!!.url
    }

    override fun hashCode(): Int {
        return Objects.hash(url)
    }

    private constructor(){
        this.url = ""
    }
}
