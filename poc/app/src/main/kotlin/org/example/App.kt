package org.example
import com.atilika.kuromoji.ipadic.Tokenizer
import com.atilika.kuromoji.ipadic.Token
// If you know ahead of time that you will store a large number of items, 
// you can pre-size it using HashSet(initialCapacity) 
// to avoid intermediate resize operations

// --info
//stacktrace

// Ignores:
// - Empty strings;
// - Invalid words;
// - Particles and punctuation marks;
// - Auxiliary verbs: e.g. Da, Desu;
fun createKnownLemmas(knownWords: List<String>, tokenizer: Tokenizer): Set<String> = buildSet {

    for (word in knownWords) {
        if (word.isEmpty()) continue

        val token = tokenizer.tokenize(word).first()
        when (token.partOfSpeechLevel1) {
            // Particle
            "助詞",   
            //Auxiliary verb     
            "助動詞",        
            //Punctuation
            "記号" -> continue
        }

        val lemma = token.baseForm
        //Filter out invalid words
        if (lemma == "*") continue

        add(lemma)
    }
}



fun main() {
    val tokenizer = Tokenizer()

    println("First, let's try to parse a sentence with kuromoji")
    val word1 = "私"
    val word2 = "oi"
    val word3 = "食べた"
    val word4 = ""
    val word5 = " "
    val word6 = "でした"
    val knownWords = listOf(word1, word2, word3, word4, word5, word6)
    val knownLemmas: Set<String> = createKnownLemmas(knownWords, tokenizer)

    for (lemma in knownLemmas) println("$lemma")

}
