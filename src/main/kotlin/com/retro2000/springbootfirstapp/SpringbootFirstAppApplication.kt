package com.retro2000.springbootfirstapp

import com.retro2000.springbootfirstapp.util.SuppressNames.Companion.UNUSED
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.data.web.config.EnableSpringDataWebSupport
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter

@EnableSpringDataWebSupport
@SpringBootApplication
@EnableCaching
class SpringbootFirstAppApplication {

	@Bean
	@Suppress(UNUSED)
	fun protobufHttpMessageConverter(): ProtobufHttpMessageConverter? {
		return ProtobufHttpMessageConverter()
	}

}

fun main(args: Array<String>) {
	runApplication<SpringbootFirstAppApplication>(*args)
}
