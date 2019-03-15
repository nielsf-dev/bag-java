package org.bag

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.ComponentScans
import org.springframework.web.servlet.LocaleResolver
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor
import org.springframework.web.servlet.i18n.SessionLocaleResolver

import java.util.Locale

@SpringBootApplication
@ComponentScans(
        ComponentScan("org.bag.controllers"),
        ComponentScan("org.bag.service"))
open class Application : WebMvcConfigurer {

    @Bean
    open fun localeResolver(): LocaleResolver {
        val slr = SessionLocaleResolver()
        slr.setDefaultLocale(Locale("nl", "NL"))
        return slr
    }

    @Bean
    open fun localeChangeInterceptor(): LocaleChangeInterceptor {
        val lci = LocaleChangeInterceptor()
        lci.paramName = "lang"
        return lci
    }

    override fun addInterceptors(registry: InterceptorRegistry?) {
        registry!!.addInterceptor(localeChangeInterceptor())
    }
}

fun main(args: Array<String>) {
    val builder = Locale.Builder().setLanguage("nl").setRegion("US")
    val locale1 = builder.build()

    SpringApplication.run(Application::class.java, *args)
}


