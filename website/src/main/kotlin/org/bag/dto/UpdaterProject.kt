package org.bag.dto

class UpdaterProject(
        val id: Int,

        /** de titel in het nederlands */
        var titel_nl: String,

        /** De locatie in het nederlands */
        var locatie_nl: String,

        /** De tekst in het nederlands */
        var text_nl: String,

        /** de titel in het engels */
        var titel_en: String = "",

        /** de titel in het chinees */
        var titel_zh: String = "",

        /** De locatie in het engels */
        var locatie_en: String = "",

        /** De locatie in het chinees */
        var locatie_zh: String = "",

        /** De tekst in het engels */
        var text_en: String = "",

        /** De tekst in het chinees */
        var text_zh: String = "")




