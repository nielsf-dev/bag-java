package org.bag.dto

/**
 * Representatie van een project voor de frontend. Hierin mag de banner image niet voorkomen tussen de normale images.
 * De image voor de frontpage moet er wel in zitten.
 */
class FrontendProject(val id: Int,
            val title: String,
            val location: String,
            val text: String,
            val bannerImageUrl: String,
            val frontPageImageUrl: String,
            val projectImageUrls: List<String>) {

    init {
        if (!projectImageUrls.contains(bannerImageUrl))
            throw Exception("Banner image moet tussen images")
        if (!projectImageUrls.contains(frontPageImageUrl))
            throw Exception("Frontpage image moet tussen images")
    }
}
