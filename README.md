# Flashcards

A small API that creates custom flashcards for dynamically revising notes.

## What are flashcards? 
Keep your course subjects organized, and ready for interactive studying!
This API can be used to generate customized flashcards based on user prescribed questions and answers. For now it's just a subcomponent of a
larger program who's aim is to help students study even more effectively. The use of flashcards is a great study habit to apply. 

------
## Class Descriptions

### Flashcards
Flashcards contain a course subject, the question and a boolean for whether or not its question has been answered correctly.

### Question
This abstract class contains the actual question, can sometimes be a statement, based on question type. There are 4 Question Types: 
**Multiple Choice** , **Multiple Select** , **True or False** & **Fill in the Blank**. Each type extending Question.
Question objects also contains a varied range of corresponding Answer objects, and/or Answer options to choose from.

### Answer
The self-explanatory answer to a question. Can be compared with other Answer objects created from user input to determine validity.

### FlashcardBuilder
This class contains static methods for creating a Flashcard object of any Question type. Manual construction of Flashcard objects with different question types, can be laborious. FlashcardBuilder makes it a breeze. Just specify the type of question, the literal question, its answer(s), and answer options if any.
