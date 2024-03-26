package com.anagram.server.controller

import com.anagram.server.service.AnagramServiceImprovedImpl
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/anagram-game/")
class AnagramController(private var anagramServiceImprovedImpl: AnagramServiceImprovedImpl) {

    @PostMapping("v1/anagrams")
    fun addAnagrams(
        @RequestBody words: List<String>
    )
    {
        return anagramServiceImprovedImpl.addAnagrams(words)
    }

    @PostMapping("v1/anagram")
    fun addAnagram(
        @RequestBody word: String
    )
    {
        return anagramServiceImprovedImpl.addAnagram(word)
    }

    @GetMapping("v1/anagram-check/{anagram1}/{anagram2}")
    fun ensureAnagrams(
        @PathVariable anagram1: String,
        @PathVariable anagram2: String
    ): Boolean
    {
        return anagramServiceImprovedImpl.areAnagrams(anagram1, anagram2)
    }

    @GetMapping("v1/anagram-list/{anagram1}")
    fun fetchAnagrams(
        @PathVariable anagram1: String,
    ): Set<String>
    {
        return anagramServiceImprovedImpl.findAnagrams(anagram1)
    }
}