package org.bag

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
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
import javax.sql.DataSource

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

    @Bean
    open fun dataSource(): DataSource {
        val config = createHikariConfig()
        return HikariDataSource(config)
    }

    private fun createHikariConfig(): HikariConfig {
        val config = HikariConfig()

        // some comment to deploy

        // Is er een heroku cs?
        val connectionString = System.getenv()["JDBC_DATABASE_URL"]
        if (connectionString == null) {
            // Nee, connectie maken met kantoor
            config.jdbcUrl = "jdbc:postgresql://127.0.0.1:5432/bag-java"
            config.username = "postgres"
            config.password = "toor"
        } else {
            // Ja, die gebruiken
            config.jdbcUrl = connectionString
        }

        return config
    }

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(localeChangeInterceptor())
    }
}

fun main(args: Array<String>) {
    Locale.setDefault(Locale("nl", "NL"))
    SpringApplication.run(Application::class.java, *args)
}


