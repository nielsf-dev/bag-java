package org.bag.domain

import org.slf4j.LoggerFactory
import javax.persistence.*

/** Project voor de BAG Site */
@Entity
class Project(

        /** de titel in het nederlands */
        var titel_nl: String,

        /** De locatie in het nederlands */
        var locatie_nl: String,

        /** De tekst in het nederlands */
        var text_nl: String,

        /** De lijst met plaatjes */
        @JoinTable
        @OneToMany
        val images: List<Image>)
{

    /** De image op de banner */
    @ManyToOne
    @JoinColumn
    private var bannerImage: Image

    /** De images op de frontend */
    @ManyToOne
    @JoinColumn
    private var frontPageImage: Image

    /**
     * Maakt een project aan. De [bannerImageIndex] en [frontPageImageIndex] moeten geldig zijn mbt de [images].
     * @throws Exception Ongeldige index opgegeven
     */
    constructor(titel: String, locatie: String, text: String, images: List<Image>, bannerImageIndex: Int, frontPageImageIndex: Int) : this(titel, locatie, text, images) {
        this.bannerImage = validateAndGetFromImages(bannerImageIndex)
        this.frontPageImage = validateAndGetFromImages(frontPageImageIndex)
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int = 0

    /** de titel in het engels */
    var titel_en: String = ""

    /** de titel in het chinees */
    var titel_zh: String = ""

    /** De locatie in het engels */
    var locatie_en: String = ""

    /** De locatie in het chinees */
    var locatie_zh: String = ""

    /** De tekst in het engels */
    var text_en: String = ""

    /** De tekst in het chinees */
    var text_zh: String = ""

    init {
        bannerImage = validateAndGetFromImages(0)
        frontPageImage = validateAndGetFromImages(0)
    }

    private fun validateAndGetFromImages(index: Int): Image {
        if (images.isEmpty())
            throw Exception("No images")

        if(index > images.size - 1)
            throw Exception("Invalid index")

        return images[index]
    }

    /**
     * Haal de titel op in de juiste [lang]
     */
    fun getTitle(lang: String): String {
        logger.info("getting title for $lang")
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
        logger.info("getting locatie for $lang")
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
        logger.info("getting text for $lang")
        return when {
            lang === SupportedProjectLanguage.English.text -> text_en
            lang === SupportedProjectLanguage.Chinese.text -> text_zh
            else -> text_nl
        }
    }

    /** De banner images */
    fun getBannerImage() : Image {
        return bannerImage
    }

    /** Set de banner op [imageIndex] */
    fun setBannerImage(imageIndex: Int){
        bannerImage = validateAndGetFromImages(imageIndex)
    }

    /** De frontend image */
    fun getFrontendImage() : Image {
        return frontPageImage
    }

    /** Set de frontendimage op [imageIndex] */
    fun setFrontendImage(imageIndex: Int){
        frontPageImage = validateAndGetFromImages(imageIndex)
    }

    companion object {
        private val logger= LoggerFactory.getLogger(Project::class.java)
    }
}



