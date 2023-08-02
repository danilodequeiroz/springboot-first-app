package com.retro2000.springbootfirstapp.repository

import com.retro2000.springbootfirstapp.model.Collectible
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CollectibleRepository : JpaRepository<Collectible, Long>