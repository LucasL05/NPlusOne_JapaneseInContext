package org.example
import com.atilika.kuromoji.ipadic.Tokenizer
import com.atilika.kuromoji.ipadic.Token
// If you know ahead of time that you will store a large number of items, 
// you can pre-size it using HashSet(initialCapacity) 
// to avoid intermediate resize operations

// --info
//stacktrace
fun main() {
    println("First, let's try to parse a sentence with kuromoji")
    val word1 = "私"
    val word2 = "寝ました"
    val known_words = setOf(word1, word2)
    
    val tokenizer = Tokenizer()
    val firstToken = tokenizer.tokenize(word2).first()
    val lemma = firstToken.baseForm
    println("$lemma")
}
