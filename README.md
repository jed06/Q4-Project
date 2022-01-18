# 🐷PEPPA IN SPACE!🐷

### 🐽 My quarter 2 project is inspired by Peppa Pig "A Trip to the Moon!"
I made this game for my AP Computer Science Class project. Me and my classmates decided to make games inspired by Peppa Pig, a very cute little pig. In this game, peppa is in space and needs to avoid asteroids. To earn points, Peppa should collect the glowing stars. This game is very fun and easy to play!
### 🐽 Here is an overview of what the game looks like:
When the player first starts the game, they will see instructions on how to play.

![Loom _ Free Screen   Video Recording Software - 7 January 2022](https://user-images.githubusercontent.com/89813821/148616467-fd49b03e-8d90-4930-9a34-4b2f80992842.gif)

After pressing the enter key to start the game, the asteroids will start falling from the top of the frame. The player's objective is to avoid touching the asteroids and collect the stars. They can move peppa around using the arrow keys. When peppa collects a star, the player gets a point and the score color changes to a random color.

![Loom _ Free Screen   Video Recording Software - 7 January 2022 (1)](https://user-images.githubusercontent.com/89813821/148616792-0e8831d5-0cde-402a-995d-014cc81cf13d.gif)


If peppa gets hit by an asteroid, the player will lose the game. They can see their score and see the highest score. The player can restart the game by pressing the enter key.

![Loom _ Free Screen   Video Recording Software - 7 January 2022 (2)](https://user-images.githubusercontent.com/89813821/148617381-7585de7c-207b-4bfb-81cd-98cfde69cc42.gif)

### 🐽 Here is an overview of the code used in this game:
To program this game, I needed several classes for different parts of the game. Some of the classes I used were Background.java, Frame.java, Music.java, Obstacle.java, Peppa.java, and Star.java. I used these classes to program the different behaviors and attributes for different game components. One of the most important classes in the program was the Frame.java class. This class helps all the objects move around and contains most of the important logic for this game.
 Here is an example of collision between peppa and the star (pep is peppa)
  ```
  if((star1.x >= pep.x && star1.x <= pep.x  + 110) || star1.x + star1.w >= pep.x && star1.x + star1.w <= pep.x  + 110){
			if(star1.y >= pep.y && star1.y < pep.y + 200){
				
				Score += 1;
					
				star1.y = -315;
				star1.x = rn.nextInt(700 - 10 + 1) + 10;
				scoreColor = scoreColors[rn.nextInt(scoreColors.length)];
					
			}
		}
    
  ```
 Here is an example of the update method used to move the objects. This code was used to update the picture's location based on x and y coordinates.
  ```
  private void update() {
		// update y location based on velocity in y
		
		y += vy; // velocity in y affects y location
		vy = ay;
		
		// when asteroid falls to bottom, bring it back to the top
		
		if (y > 850) {
			y = -100;
			x = rn.nextInt(700 - 10 + 1) + 10;
		}
		
		tx.setToTranslation(x, y);
		tx.scale(0.4, 0.4);
	}
 ```   
### 🐽 What I learned:
In the past semester of my class, we learned alot about programming in java. 
One way I incorporated what I learned about arrays was through the score color displayed in the top right corner. When the player scores a point, the score color will change to a random color.
```
Color scoreColors[] = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.LIGHT_GRAY, Color.PINK};
```
Later when checking for collision, the color will change to a random one from the array above if collision occurs.
```
if((star1.x >= pep.x && star1.x <= pep.x  + 110) || star1.x + star1.w >= pep.x && star1.x + star1.w <= pep.x  + 110){
			if(star1.y >= pep.y && star1.y < pep.y + 200){
				
				Score += 1;
					
				star1.y = -315;
				star1.x = rn.nextInt(700 - 10 + 1) + 10;
				**scoreColor = scoreColors[rn.nextInt(scoreColors.length)];**
					
			}
		}
```

One way I incorporated Array Lists into my program was through keeping track of the high score. When the player lost the game, their score would be added into the array list called scores.
```
ArrayList <Integer> scores = new ArrayList <Integer>();
```
Then, it would sort the list from least to greatest and display the highest one.
```
if(scores.size() >= 1) {
				Collections.sort(scores);
				g.drawString("highest score: " + scores.get(scores.size()-1), 50, 400);
			}
```

### 🐽 About the creators:
Jessica : Boss legend programer. Jessica programmed most of the components of this game ;)

Hannah : Designer/ Assistant programer. Hannah chose many of the  amazing images for the objects and helped give recommendations. Hannah also helped when Jessica forgot how to use colors.

Nancy : Inspirational Artist/ Motivator. Nancy loves peppa, therefore this game was created in her honor. Nancy also kept everyone motivated through her exquisite compliments.




![20211214_105923](https://user-images.githubusercontent.com/89813821/148727162-ac9e7314-6a1e-465e-b4cf-3d66b10aa534.jpg)


###### q2-base-project-jed06
###### q2-base-project-jed06 created by GitHub Classroom
