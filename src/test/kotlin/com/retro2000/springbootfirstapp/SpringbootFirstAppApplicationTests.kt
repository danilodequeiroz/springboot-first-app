package com.retro2000.springbootfirstapp

import com.retro2000.springbootfirstapp.model.User
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import kotlin.random.Random

@SpringBootTest
class SpringbootFirstAppApplicationTests {

	@Test
	fun createUser() {
		val user = User()
		user.userId = Random(Long.MAX_VALUE).nextLong()
		user.firstName = "Shao"
		user.lastName = "Kahn"
		user.userName = "don_t_make_me_laugh"
		assert(user.userName == "don_t_make_me_laugh")
	}
}
