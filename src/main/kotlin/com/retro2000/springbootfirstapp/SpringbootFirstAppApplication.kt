package com.retro2000.springbootfirstapp

import com.retro2000.springbootfirstapp.util.SuppressNames.Companion.UNUSED
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter


@SpringBootApplication
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
