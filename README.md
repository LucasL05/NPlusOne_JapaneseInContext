NPlusOne_JapaneseInContext

I'm currently working on the app's proof of concept, using a tracer-bullet approach (the poc won't have a UI).

The workflow will be as follow:
1. Create a set of two strings with one Japanese word each (this will simulate the imput from Anki's API);
2. Parse them with Kuromoji and find their dictionary form;
3. Save that into the app's database;
4. Fetch all words from the database;
5. Access NHK Easy;
6. Somehow compare the words from the database with the ones in a random NHK article;
7. Print the result of that comparison in the terminal;
