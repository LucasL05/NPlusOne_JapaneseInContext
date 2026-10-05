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
fun createKnownLemmas(knownWords: List<String>, tokenizer: Tokenizer): Set<String> {

    val known_lemmas: Set<String> = buildSet {
        for (word in knownWords) {
            if (word.isEmpty()) continue

            token = tokenizer.tokenize(word).first()
            when (token.partOfSpeechLevel1) {
                //Particle
                "助詞" -> continue
                //Auxiliary verb
                "助動詞" -> continue
                //Punctuation
                "記号" -> continue
            }

            lemma = token.baseForm
            //Filter out invalid words
            if (lemma == "*") continue

            add(lemma)
        }
    }
}


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
