package com.anagram.server.service

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class AnagramServiceDefaultImplTest {

    private lateinit var anagramService: AnagramServiceDefault

    @BeforeEach
    fun setup() {
        anagramService = AnagramServiceDefault()
    }

    @Test
    fun givenAnagrams_whenAreAnagrams_shouldReturnTrue() {

        val a = "aba"
        val b = "aab"

        val result = anagramService.areAnagrams(a,b)

        assert(result)
    }

    @Test
    fun givenAnagrams_whenAreAnagrams_shouldReturnFalse() {

        val a = "xyz"
        val b = "aab"

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

        // Call the function to be tested
        anagramService.addAnagrams(words)

        val result = anagramService.findAnagrams("listen")
        // Assert that each word and its anagrams have been added correctly
        assert(result.contains("listen"))
        assert(result.contains("silent"))
        assert(result.contains("enlist"))
        assert(result.contains("tinsel"))
    }

}