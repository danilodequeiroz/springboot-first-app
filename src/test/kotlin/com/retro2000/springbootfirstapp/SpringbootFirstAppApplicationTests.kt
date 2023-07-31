package com.retro2000.springbootfirstapp

import com.retro2000.springbootfirstapp.dto.UserDto
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

	@Test
	fun createUserDto() {
		val user = User()
		val long = Random(Long.MAX_VALUE).nextLong()
		user.userId = long
		user.firstName = "Shao"
		user.lastName = "Kahn"
		user.userName = "don_t_make_me_laugh"
		val dtoList = UserDto.convertToUserDtoList(mutableListOf(user))
		assert(dtoList.first().userId == long)
		assert(dtoList.first().firstName == "Shao")
		assert(dtoList.first().lastName == "Kahn")
		assert(dtoList.first().userName == "don_t_make_me_laugh")
	}
}
