package com.settlement.fastcampussettlementkotlin.interfaces.controller.test

import com.settlement.fastcampussettlementkotlin.application.dummy.DummyFacade
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/test/dummy")
class CreateDummyController(
    private val dummyFacade: DummyFacade
) {

    @PostMapping("/size/{size}")
    fun create(@PathVariable size: Int) {

        for (i in 1..size) {
            dummyFacade.createOrder(i.toLong())
        }
    }
}