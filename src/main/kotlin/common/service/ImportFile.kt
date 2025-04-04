package common.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.Resource
import org.springframework.core.io.ResourceLoader
import java.nio.charset.StandardCharsets


class ImportFile(
    @Autowired val resourceLoader: ResourceLoader,
) {

    fun import( path: String ) : String {
        val resource: Resource = resourceLoader.getResource("classpath:" + path)

        return resource.inputStream.bufferedReader(StandardCharsets.UTF_8).use { it.readText() }

    }
}