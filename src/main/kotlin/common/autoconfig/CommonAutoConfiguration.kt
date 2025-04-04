package common.autoconfig

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = ["common.service"])
class CommonAutoConfiguration
