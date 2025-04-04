package traffus.blog.traffus_blog.base.component

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import traffus.blog.traffus_blog.template.service.impl.TemplateInstallerService
import traffus.blog.traffus_blog.textContent.feature.blog.servise.impl.installer.BlogInstallerService
import traffus.blog.traffus_blog.textContent.servise.impl.ContentInstallerService


import java.util.logging.Logger


@Component
class DataInitializer(
    private val templateInstallerService: TemplateInstallerService,
private val contentInstallerService: ContentInstallerService,
private val  blogInstallerService: BlogInstallerService,
    ) : CommandLineRunner {

    private val log = Logger.getLogger("CDP_SITE.BlogInstallerService")


    override fun run(vararg args: String?) {
        try {
            log.info(" START INSTALLER")

            initializeData()

            log.info(" END ALL INSTALL")
        } catch (e: Exception) {
            log.info("Failed to execute CommandLineRunner" + e)
        }
    }

    private fun initializeData() {

        log.info(" templateInstallerService.install()")
        templateInstallerService.install()



        log.info(" contentInstallerService.install()")
        contentInstallerService.install()

        log.info(" categoryProjectInstallerService.install()")
      //  categoryProjectInstallerService.install()

        log.info(" blogInstallerService.install()")
        blogInstallerService.install()



    }
}