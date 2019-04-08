package org.bag.dto

/**
 * Representatie van een [Project] tbv de Updater applicatie.
 * Hierin zijn alle talen aanwezig en kan per plaatje gekozen worden of het de frontend- of bannerimage betreft.
 */
class UpdaterProject{

        var id: Int = 0

        /** de titel in het nederlands */
        var titel_nl: String = ""

        /** De locatie in het nederlands */
        var locatie_nl: String = ""

        /** De tekst in het nederlands */
        var text_nl: String = ""

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

        /**
         * De plaatjes
         */
        var images: ArrayList<UpdaterProjectImage> = ArrayList()

        constructor(){
                println("test")
        }

        constructor(id:Int,titel_nl:String,locatie_nl:String,text_nl:String,titel_en:String,titel_zh:String, locatie_en:String,locatie_zh:String,text_en:String,text_zh:String){
                this.id = id
                this.titel_nl = titel_nl
                this.locatie_nl = locatie_nl
                this.text_nl = text_nl
                this.titel_en = titel_en
                this.titel_zh = titel_zh
                this.locatie_en = locatie_en
                this.locatie_zh = locatie_zh
                this.text_en = text_en
                this.text_zh = text_zh
        }
}




