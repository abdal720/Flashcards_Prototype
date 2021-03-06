# Flashcards

A small API that creates custom flashcards for dynamically revising notes.

## What are flashcards? 
Keep your course subjects organized, and ready for interactive studying!
This API can be used to generate customized flashcards based on user prescribed questions and answers. For now it's just a subcomponent of a
larger program who's aim is to help students study even more effectively. The use of flashcards is a great study habit to apply. 

------
## Class Descriptions

### Flashcards
The Flashcard class contains the question, the subject/topic of that question, and a boolean for whether or not its question has been answered correctly.

### Question
This abstract class contains the actual question (a String), can sometimes be a statement based on the question's type. There are 4 question types: 
**Multiple Choice** , **Multiple Select** , **True or False** & **Fill in the Blank**. Each type extending Question.
Question objects also contain a varied range of corresponding Answer objects, and/or Answer options to choose from.

### Answer
Objects of this class are created to be held by a corresponding Question instance. Can be compared with other Answer objects created from user input to determine an answer's validity.

### FlashcardBuilder
This class contains static methods for creating a Flashcard object of any Question type. Manual construction of Flashcard objects with different question types, can be laborious. FlashcardBuilder makes it a breeze. Just specify the question's Type, the literal question, answer options if any, and the correct answer(s).
