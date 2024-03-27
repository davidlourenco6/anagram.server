package com.anagram.server.service

import org.springframework.stereotype.Service

@Service
class AnagramServiceImprovedImpl: AnagramService {

    // Data structure to store anagrams
    private val anagrams: MutableMap<String, MutableSet<String>> = mutableMapOf()

    // Complexity: O(n + m)
    override fun areAnagrams(text1: String, text2: String): Boolean {
        if (text1.length != text2.length) {
            return false
        }

        val freqMap1 = buildFrequencyMap(text1)
        val freqMap2 = buildFrequencyMap(text2)

        return freqMap1 == freqMap2 // Compare frequency maps
    }

    private fun buildFrequencyMap(text: String): Map<Char, Int> {
        val freqMap = mutableMapOf<Char, Int>()
        for (c in text) {
            freqMap[c] = freqMap.getOrDefault(c, 0) + 1 // Increment character count or default (0) + 1
        }
        return freqMap
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

    // Complexity: O(n)
    override fun sortWord(word: String): String {
        val charCount = IntArray(256) // Assuming ASCII characters
        val sortedChars = CharArray(word.length)

        // Counting the occurrences of each character
        for (c in word) {
            charCount[c.code]++
        }

        // Building the sorted character array
        var index = 0
        for (i in charCount.indices) {
            while (charCount[i] > 0) {
                sortedChars[index++] = i.toChar()
                charCount[i]--
            }
        }
        return String(sortedChars)
    }


}