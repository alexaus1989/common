package traffus.blog.traffus_blog.base.test.controller

import traffus.blog.traffus_blog.base.dto.response.ResponseWrapper
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.logging.Logger

@RestController
@CrossOrigin(origins = ["*"])
@RequestMapping("/test")
class TestController(

) {

    private val log: Logger = Logger.getLogger("CDP_SITE.TestController")
    @PostMapping("/post")
    fun message(): ResponseEntity<ResponseWrapper> {
        return ResponseEntity.ok(
            ResponseWrapper(
                success = true,
                data = "SUCCESS"
            )
        )
    }

    @GetMapping("/get")
    fun get(): ResponseEntity<ResponseWrapper> {
        return ResponseEntity.ok(
            ResponseWrapper(
                success = true,
                data = "SUCCESS"
            )
        )
    }
}