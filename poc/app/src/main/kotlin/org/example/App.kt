package org.example
import com.atilika.kuromoji.ipadic.Tokenizer
import com.atilika.kuromoji.ipadic.Token
// If you know ahead of time that you will store a large number of items, 
// you can pre-size it using HashSet(initialCapacity) 
// to avoid intermediate resize operations

// --info
//stacktrace

fun createKnownLemmas(knownWords: List<String>): Set<String> {
    for (word in knownWords) {
        // Invalid words return "*"
    }
}

//lemmas can be null if the word already is in its base form

fun main() {
    println("First, let's try to parse a sentence with kuromoji")
    val word1 = "私"
    val word2 = "oi"
    val knownWords = listOf(word1, word2)
    
    val tokenizer = Tokenizer()
    val firstToken = tokenizer.tokenize(word1).first()
    val firstLemma = firstToken.baseForm  
    val secondToken = tokenizer.tokenize(word2).first()
    val secondLemma =  secondToken.baseForm
    println("$firstToken $firstLemma")
    println("$secondToken $secondLemma")
    println(secondLemma::class.simpleName)
}
