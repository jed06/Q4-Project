# Guess the Peppa : APCSA Quarter 4 Final Project
#### By: Jessica David and Hannah Samueul
## Introduction
#### Guess the Peppa is a single player game that involves the user guessing cards from a deck of Peppa themed cards. The goal of the game is to guess what card the computer selected from the deck. To help with making the guess, there are a set of questions you can ask to eliminated cards from the deck, after a certain amount of attempt, you are prompted to make a final guess. 
## Classes/Objects
### Card
<hr>
The Card class allows you to create a single card object. This class allowed us to create the appearance of the card and the attributes of it such if the card's characters wore jewlery or has facial hair or both. These feature are known as a instance variable which we will use to check with against the Computer selected card to see if it was a match.

![card](https://user-images.githubusercontent.com/90801601/171283924-8c66e601-00db-494f-a064-cbc704a8955c.PNG)

### Deck
<hr>
The Deck Class assembles single card object in a game board array. Everytime the game is run, the code utilizes ***switch statements*** which allows us to paint a deck in a 4 X four pattern based on whether row is divisble by 4. Switch case statement are the replacement to a tree of if statment. When there are multiple check are being done and they all correlate to each other, its better to use a switch statement. In addition to this, the deck class has methods that set the red X image over a card in the deck if the instance variable of that card int he deck does not match with the instance variables of the card the computer chose. 

![deck'](https://user-images.githubusercontent.com/90801601/171284946-21dbb122-f138-4ee0-9537-c0a22ff8d9e2.PNG)


### Game Board
<hr>
The Game Board class keeps track and sets all the attributes of a card in code. Each card as a string value that tells you name of the character a boolean values that correspond to whethere or not the character has a certain attribute. When we first started designing the cards, chose which cards had what attributes to create as many combinations without repeating the exact same attributes within the card. We mapped this out on a googal doc and the converted our choices into code. 

![chart](https://user-images.githubusercontent.com/90801601/171285690-32b5563d-5110-42f8-a905-b01207b9d7cd.PNG)

The Game Board class also intstilaizes the content of the dialogue box which conains all the questions a user can "ask" to the CPU to eliminated cards from the deck.

//inset loom of dialogue box


### Splash Frame 
The splash frame is the home screen of our game. We used our quarter 2 skills to paint picture object of peppa characters, the background image, and  draw a string to tell the user to press the enter key. The Splash frame implement the Action and Key Listerner features. These implementations allow the code to detect when the user pressed the enter key. If if detect the keycode 10 it will close the splash frame and open open up the Guess Peppa Frame as well as play the peppa soundtrack. 
![homscreen](https://user-images.githubusercontent.com/90801601/171329066-728545c3-4807-4647-9364-024d9b9d329f.gif)


### Picture/CardPicture
//reading the file paths
### Music
//peppa sound track
## Technical Challenges
### JFrame, JButton, JPanels, JLabel, J-EVERYTHING!
<hr>
//Playing around with the bounds of panels and attaching them to the main frame
### reading a file
<hr>
//creating a timer and presenting it visibly on the screen
### working with Jframe
<hr>

##  Trello
<hr>

![trello](https://user-images.githubusercontent.com/90801601/171287576-30003a0d-451e-4224-8669-78f14465fc46.PNG)

## Conclusion
### video
<hr>

### presentation
<hr>

