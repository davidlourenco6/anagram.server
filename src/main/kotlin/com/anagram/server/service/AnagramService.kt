package com.anagram.server.service


interface AnagramService {

    /**
    *  Given two strings, find if are anagrams
    *
    * @param [text1] String one
    * @param [text2] String two
    * @return A [Boolean] that represents if Strings are anagrams
    */
    fun areAnagrams(text1: String, text2: String): Boolean

    /**
    *  Given a String, add it to the Data Structure
    *
    * @param [word] String one
    */
    fun addAnagram(word: String)

    /**
    *  Given a List<String>, add the element to the Data Structure
    *
    * @param [words] List<String> to add to de Sata Structure
    */
    fun addAnagrams(words: List<String>)

    /**
    *  Given a String, return all the present anagrams
    *
    * @param [word] String one
    * @return A [Set<String>] that are anagrams of the input
    */
    fun findAnagrams(word: String): Set<String>

    /**
     *  Given a String, returns a sorted String by alphanumerical order
     *
     * @param [word] String to sort
     * @return A sorted [String]
     */
    fun sortWord(word: String): String

}