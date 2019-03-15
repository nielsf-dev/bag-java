package org.bag.domain

import java.util.*
import javax.persistence.*

/**
 * Project voor de BAG Site
 */
@Entity
class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int = 0

    var titel_nl: String
    var titel_en: String
    var titel_zh: String

    var locatie_nl: String
    var locatie_en: String
    var locatie_zh: String

    var text_nl: String
    var text_en: String
    var text_zh: String

    @JoinTable
    @OneToMany
    val images: List<Image>

    @ManyToOne
    @JoinColumn
    private var bannerImage: Image

    @ManyToOne
    @JoinColumn
    private var frontPageImage: Image

    /**
     * Maakt een project aan. De [bannerImageIndex] en [frontPageImageIndex] moeten geldig zijn mbt de [images].
     * @throws Exception Ongeldige index opgegeven
     */
    constructor(titel: String, locatie: String, text: String, images: List<Image>, bannerImageIndex: Int, frontPageImageIndex: Int) {
        this.titel_nl = titel
        this.titel_en = ""
        this.titel_zh = ""

        this.locatie_nl = locatie
        this.locatie_en = ""
        this.locatie_zh = ""

        this.text_nl = text
        this.text_en = ""
        this.text_zh = ""

        this.images = images
        this.bannerImage = validateAndGet(bannerImageIndex)
        this.frontPageImage = validateAndGet(frontPageImageIndex)
    }

    private fun validateAndGet(index: Int): Image {
        if (images.isEmpty() || index > images.size - 1)
            throw Exception("Invalid index")

        return images[index]
    }

    /**
     * Haal de titel op in de juiste [lang]
     */
    fun getTitle(lang: String): String {
        return when {
            lang === SupportedProjectLanguage.English.text -> titel_en
            lang === SupportedProjectLanguage.Chinese.text -> titel_zh
            else -> titel_nl
        }
    }

    /**
     * Haal de titel op in de juiste [lang]
     */
    fun getLocatie(lang: String): String {
        return when {
            lang === SupportedProjectLanguage.English.text -> locatie_en
            lang === SupportedProjectLanguage.Chinese.text -> locatie_zh
            else -> locatie_nl
        }
    }

    /**
     * Haal de text op in de juiste [lang]
     */
    fun getText(lang: String): String {
        return when {
            lang === SupportedProjectLanguage.English.text -> text_en
            lang === SupportedProjectLanguage.Chinese.text -> text_zh
            else -> text_nl
        }
    }

    fun getBannerImage() : Image {
        return bannerImage
    }

    fun setBannerImage(imageIndex: Int){
        bannerImage = validateAndGet(imageIndex)
    }

    fun getFrontendImage() : Image {
        return frontPageImage
    }

    fun setFrontendImage(imageIndex: Int){
        frontPageImage = validateAndGet(imageIndex)
    }
}



