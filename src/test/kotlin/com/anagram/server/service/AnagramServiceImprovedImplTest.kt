package com.anagram.server.service

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class AnagramServiceImprovedImplTest {

    private lateinit var anagramService: AnagramServiceImprovedImpl

    @BeforeEach
    fun setup() {
        anagramService = AnagramServiceImprovedImpl()
    }

    @Test
    fun givenGameState_whenStartGame_thenReturnNewGameState() {

        val a = "aba"
        val b = "aab"

        val result = anagramService.areAnagrams(a,b)

        assert(result)
    }

    @Test
    fun givenGameState_whenRestartGame_thenReturnUpdatedGameState() {

        val a = "aba"
        val b = "aab"
        val c = "baa"

        anagramService.addAnagram(a)
        anagramService.addAnagram(b)

        val result = anagramService.findAnagrams(c)
        assert(result.toList().size == 2)
    }

    @Test
    fun givenGameState_whenRestartGame() {

        val a = "abc"
        val b = "def"
        val c = "ghi"

        anagramService.addAnagram(a)
        anagramService.addAnagram(b)

        val result = anagramService.findAnagrams(c)
        assert(result.toList().isEmpty())
    }


}