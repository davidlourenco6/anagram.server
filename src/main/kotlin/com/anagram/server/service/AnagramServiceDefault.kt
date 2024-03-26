package com.anagram.server.service

import org.springframework.stereotype.Service

@Service
class AnagramServiceDefault : AnagramService {

    // Data structure to store anagrams
    private val anagrams: MutableMap<String, MutableSet<String>> = mutableMapOf()

    // Complexity O(n log(n))
    override fun areAnagrams(text1: String, text2: String): Boolean {
        if (text1.length != text2.length) {
            return false
        }

        val charArr1 = text1.toCharArray().sortedArray()
        val charArr2 = text2.toCharArray().sortedArray()

        return String(charArr1) == String(charArr2)
    }

    override fun addAnagram(word: String) {
        val sortedWord = sortWord(word) // Sort characters in the word
        anagrams.getOrPut(sortedWord) { mutableSetOf() }.add(word) // Add word to the set of anagrams
    }

    override fun addAnagrams(words: List<String>) {
        for (word in words) {
            addAnagram(word)
        }
    }

    override fun findAnagrams(word: String): Set<String> {
        val sortedWord = sortWord(word) // Sort characters in the word
        return anagrams.getOrDefault(sortedWord, emptySet()) // Retrieve anagrams for the sorted word
    }

    // Complexity O(n log(n))
    override fun sortWord(word: String): String {
        val sortedChars: CharArray = word.toCharArray().sortedArray()
        return String(sortedChars)
    }

}