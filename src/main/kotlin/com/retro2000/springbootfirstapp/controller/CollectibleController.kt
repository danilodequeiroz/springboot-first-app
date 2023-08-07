package com.retro2000.springbootfirstapp.controller

import com.retro2000.springbootfirstapp.controller.CollectibleController.Companion.COLLECTIBLES_PATH
import com.retro2000.springbootfirstapp.model.Collectible
import com.retro2000.springbootfirstapp.model.dto.CollectibleDto
import com.retro2000.springbootfirstapp.model.extensions.toCollectible
import com.retro2000.springbootfirstapp.model.extensions.toCollectibleDtoMutableList
import com.retro2000.springbootfirstapp.repository.CollectibleRepository
import com.retro2000.springbootfirstapp.util.SuppressNames.Companion.UNUSED
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(COLLECTIBLES_PATH)
@Suppress(UNUSED)
class CollectibleController {

    companion object {
        const val COLLECTIBLES_PATH = "/collectibles"
    }

    @Autowired
    private lateinit var collectibleRepository: CollectibleRepository

    @GetMapping
    @ResponseBody
    fun getUsers(): MutableList<CollectibleDto> {
        return collectibleRepository.findAll().toCollectibleDtoMutableList()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCollectible(
        @RequestBody collectibleDto: CollectibleDto
    ): ResponseEntity<Collectible> {
//        return if (userRepository.findByUserName(userDto.userDto).isEmpty()) {
        collectibleRepository.save(collectibleDto.toCollectible())
        return ResponseEntity.ok().build()
//        } else {
//            ResponseEntity.unprocessableEntity().build()
//        }
    }
}