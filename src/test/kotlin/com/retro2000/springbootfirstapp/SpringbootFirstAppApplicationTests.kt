package com.retro2000.springbootfirstapp

import com.retro2000.springbootfirstapp.configuration.InvalidFields
import com.retro2000.springbootfirstapp.model.*
import com.retro2000.springbootfirstapp.model.extensions.toCollectibleDto
import com.retro2000.springbootfirstapp.model.extensions.toUserDto
import com.retro2000.springbootfirstapp.model.extensions.toUserDtoMutableList
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate

@SpringBootTest
class SpringbootFirstAppApplicationTests {

    @Test
    fun createUser() {
        val user = User(
            userId = 1L,
            firstName = "Shao",
            lastName = "Kahn",
            userName = "don_t_make_me_laugh",
            collectible = mockk()

        )

        assert(user.userName == "don_t_make_me_laugh")
    }

    @Test
    fun createCollectible() {
        val long = 1L

        val collectible = Collectible(
            collectibleId = long,
            brand = "Hot Wheels",
            scale = "1:64",
            acquiredDate = LocalDate.EPOCH
        )
        val user = spyk<User>(block = {
            this.collectible = collectible
        })

        assert(collectible.collectibleId == long)
        assert(collectible.brand == "Hot Wheels")
        assert(collectible.scale == "1:64")
        assert(collectible.acquiredDate == LocalDate.EPOCH)
        assert(user.collectible == collectible)
    }

    @Test
    fun createUserDto() {
        val long = 1L
        val user = User(
            userId = long,
            firstName = "Shao",
            lastName = "Kahn",
            userName = "don_t_make_me_laugh",
            collectible = spyk(objToCopy = Collectible())
        )

        every { user.collectible?.collectibleId } returns 1L

        val dtoList = mutableListOf(user).toUserDtoMutableList()
        assert(dtoList.first().userId == long)
        assert(dtoList.first().firstName == "Shao")
        assert(dtoList.first().lastName == "Kahn")
        assert(dtoList.first().userName == "don_t_make_me_laugh")
        assert(dtoList.first().collectible != null)
    }

    @Test
    fun createCollectibleModel() {
        val model = CollectibleModel(
            modelId = 1L,
            modelType = "Action Figure",
            brand = "Action Figure",
        )
        assert(model.modelId == 1L)
        assert(model.modelType == "Action Figure")
        assert(model.brand == "Action Figure")
    }

    @Test
    fun createInvalidFields() {
        val invalidFields = InvalidFields(
            field = "userName",
            error = "length must be between 4 and 64",
        )
        assert(invalidFields.field == "userName")
        assert(invalidFields.error == "length must be between 4 and 64")
    }

    @Test
    fun createPrices() {
        val long = 1L
        val price = Price(
            priceId = long,
            price = long,
            currency = "USD",
        )
        assert(price.priceId == long)
        assert(price.price == long)
        assert(price.currency == "USD")
    }

    @Test
    fun createRealCarModel() {
        val long = 1L
        val invalidFields = RealCarModel(
            priceId = long,
            name = "911 GT3 RS",
            brand = "Porsche"
        )
        assert(invalidFields.priceId == long)
        assert(invalidFields.name == "911 GT3 RS")
        assert(invalidFields.brand == "Porsche")
    }

    @Test
    fun convertUserToUserDto() {
        User(
            userId = 1L,
            firstName = "Shao",
            lastName = "Kahn",
            userName = "don_t_make_me_laugh",
            collectible = mockk(relaxed = true)
        ).apply {
            this.toUserDto().apply {
                assert(this.userId == 1L)
                assert(this.firstName == "Shao")
                assert(this.lastName == "Kahn")
                assert(this.userName == "don_t_make_me_laugh")
            }
        }
    }

    @Test
    fun convertCollectibleToCollectibleDto() {
        Collectible(
            collectibleId = 1L,
            brand = "Hot Wheels",
            scale = "1:64",
            acquiredDate = LocalDate.EPOCH
        ).apply {
            this.toCollectibleDto().apply {
                assert(this.collectibleId == 1L)
                assert(this.brand == "Hot Wheels")
                assert(this.scale == "1:64")
                assert(this.acquiredDate == LocalDate.EPOCH)
            }
        }
    }
}
