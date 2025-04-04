package traffus.blog.traffus_blog.base.config

import jakarta.servlet.MultipartConfigElement
import org.springframework.boot.web.servlet.MultipartConfigFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.util.unit.DataSize

@Configuration
class FileUploadConfig {
    @Bean
    fun multipartConfigElement(): MultipartConfigElement {
        val factory = MultipartConfigFactory()
        factory.setMaxFileSize(DataSize.parse("10MB"))
        factory.setMaxRequestSize(DataSize.parse("10MB"))
        return factory.createMultipartConfig()
    }
}