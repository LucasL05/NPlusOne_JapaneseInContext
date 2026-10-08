NPlusOne_JapaneseInContext

I'm currently working on the app's proof of concept, using a tracer-bullet approach (the poc won't have a UI).

The workflow will be as follows:
1. Create an array of some strings with one Japanese word each (this will simulate Anki's API input); Done
2. Parse them with Kuromoji and make a set with their dictionary form called known_lemmas; Done
3. Fetch an article from NHK Easy (it'll probably be in JSON);
4. Parse it into sentences;
5. Apply Kuromoji to each sentence and gather its lemmas into a list;
6. Organize each sentence's data into CandidateSentence data classes, which will hold their rawText string and lemmas list;
7. For the lemmas in each Candidatesentence, do "CandidateSentence.lemma[i] is in known_lemmas";
8. if there is only one unknown lemma in a sentence:
9. True -> print CandidateSentence.rawText;
10. False -> Continue;
11. End

Some caveats to keep in mind:
1. Network latency will be the system's main bottleneck. Many articles should be fetched at once;
2. Kuromoji's dictionary will take some time to warm up, so it should be initiated as soon as the app launches;
3. I don't wanna get all known words from Anki every time the app is started, 
so there should be some kind of memory persistence in the real app;
4. I should also store something like a "read_phrases" hash, otherwise the app may give a user the same phrase multiple times,  
especially if their known_words set is small.
5. Most users probably won't have many particles in their Anki decks, so the app will not count them as words;
