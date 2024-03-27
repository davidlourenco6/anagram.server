package com.anagram.server.service

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class AnagramServiceImplImplTest {

    private lateinit var anagramService: AnagramServiceImpl

    @BeforeEach
    fun setup() {
        anagramService = AnagramServiceImpl()
    }

    @Test
    fun givenAnagrams_whenAreAnagrams_shouldReturnTrue() {

        val a = "angel"
        val b = "glean"

        val result = anagramService.areAnagrams(a,b)

        assert(result)
    }

    @Test
    fun givenAnagrams_whenAreAnagrams_shouldReturnFalse() {

        val a = "angel"
        val b = "anger"

        val result = anagramService.areAnagrams(a,b)

        assert(!result)
    }

    @Test
    fun givenAnagrams_whenAreAnagrams_shouldReturnFalseDueDifferentLength() {

        val a = "angel"
        val b = "ange"

        val result = anagramService.areAnagrams(a,b)

        assert(!result)
    }

    @Test
    fun givenAnagram_whenFindAnagrams_shouldReturnAnagramsList() {

        val a = "aba"
        val b = "aab"
        val c = "baa"

        anagramService.addAnagram(a)
        anagramService.addAnagram(b)

        val result = anagramService.findAnagrams(c)
        assert(result.toList().size == 2)
    }

    @Test
    fun givenAnagram_whenFindAnagrams_shouldReturnEmptyList() {

        val a = "abc"
        val b = "def"
        val c = "ghi"

        anagramService.addAnagram(a)
        anagramService.addAnagram(b)

        val result = anagramService.findAnagrams(c)
        assert(result.toList().isEmpty())
    }

    @Test
    fun givenListOfAnagrams_when_addAnagrams_shouldAddOnDataStructure() {
        val words = listOf("listen", "silent", "enlist", "tinsel")

        anagramService.addAnagrams(words)

        val result = anagramService.findAnagrams("listen")

        assert(result.contains("listen"))
        assert(result.contains("silent"))
        assert(result.contains("enlist"))
        assert(result.contains("tinsel"))
    }

}