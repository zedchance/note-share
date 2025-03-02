---
title: "CS10-labs"
tags: "processing"
---

# CS10 Labs

## Lab 1 - My "creature"

```java
/*
Zed Chance
Lab 1
CS 10
Summer 18
My "creature" 
*/

//Setup
size(800,600);
background(0);

//MENS BATHROOM SIGN

//Signpost
rectMode(CENTER);
noStroke();
fill(113,86,86);
rect(200,475,30,250);

//Background circle
fill(70,89,255);
ellipseMode(CENTER);
stroke(255);
strokeWeight(5);
ellipse(200,200,350,350);

//Head
noStroke();
fill(220);
ellipse(200,100,70,70);

//Torso
rectMode(CENTER);
rect(200,190,60,100);

//Arms
rect(200,150,100,20,10);
rectMode(CORNER);
rect(145,140,20,100,10);
rect(235,140,20,100,10);

//Legs
rect(170,230,27,100,10);
rect(203,230,27,100,10);

//WOMENS BATHROOM SIGN

//Signpost
rectMode(CENTER);
noStroke();
fill(113,86,86);
rect(600,475,30,250);

//Background circle
fill(70,89,255);
ellipseMode(CENTER);
stroke(255);
strokeWeight(5);
ellipse(600,200,350,350);

//Head
noStroke();
fill(220);
ellipse(600,100,70,70);

//Torso
rectMode(CENTER);
rect(600,190,60,100);

//Arms
rect(600,150,100,20,10);
rectMode(CORNER);
stroke(220);
strokeWeight(25);
line(560,155,535,235);
line(640,155,665,235);

//Dress
quad(585,190,565,255,635,255,615,190);

//Legs
noStroke();
rect(570,230,27,100,10);
rect(603,230,27,100,10);

//ARROW SIGNS
//left background
rectMode(CENTER);
fill(220);
rect(200,450,150,75,10);
fill(150);
rect(200,450,145,70,10);

//left arrow
fill(255);
rect(210,450,60,25);
triangle(190,425,190,475,150,450);

//right background
rectMode(CENTER);
fill(220);
rect(600,450,150,75,10);
fill(150);
rect(600,450,145,70,10);

//right arrow
fill(255);
rect(590,450,60,25);
triangle(610,425,610,475,650,450);
```

## Lab 2 - Making my creature redraw with the mouse's movement

```java
/*
Zed Chance
Lab 2
CS 10
Summer 18
Making my creature redraw with the mouse's movement
*/

//Setup
void setup() {
  size(400, 600);
  background(0);
  
  //Signpost
  rectMode(CENTER);
  noStroke();
  fill(113, 86, 86);
  rect(200, 475, 30, 250);
  
  //Background circle
  fill(70, 89, 255);
  ellipseMode(CENTER);
  stroke(255);
  strokeWeight(5);
  ellipse(200, 200, 350, 350);
}

//Continuously redraw the human
void draw() {
  //Declare mouse
  int x = mouseX;
  int y = mouseY;
  
  //Head
  stroke(0);
  strokeWeight(1); //Had to add weight, otherwise it was hard to tell if it was moving
  fill(220,x,y);
  ellipse(x,y,70,70); //was 200,100
  
  //Arms
  rect(x,y+50,100,20,10); //was 200,150
  rectMode(CORNER);
  rect(x-55,y+40,20,100,10); //was 145/140
  rect(x+35,y+40,20,100,10); //was 235/140
  
  //Legs
  rect(x-30,y+130,27,100,10); //was 170,230
  rect(x+3,y+130,27,100,10); //was 203,230
  
  //Torso
  rectMode(CENTER);
  rect(x,y+90,60,100); //was 200,190
}

//Click mouse to reset
void mousePressed() {
  background(0);
  
  //Signpost
  rectMode(CENTER);
  noStroke();
  fill(113, 86, 86);
  rect(200, 475, 30, 250);
  
  //Background circle
  fill(70, 89, 255);
  ellipseMode(CENTER);
  stroke(255);
  strokeWeight(5);
  ellipse(200, 200, 350, 350);
  
  println(hour(),":",minute(),":",second(),"-","Mouse input detected: Background reset");
}
```

## Lab 4 - Launching my "creature" like a rocket

```java
/*
Zed Chance
Lab 4
CS 10
Summer 18
Launching my "creature" like a rocket
*/

//Initialize variables
float r = 0;
float g = 0;
float b = 0;

float x = 0;
float y = 0;

void setup() {
  size(400,600);
  x = width/2; //x is centered
  y = height + 50; //starts 50 pixels below
  background(0);
}

void draw() {
  background(0);
  
  //Head
  noStroke();
  fill(255,255,255);
  ellipse(x,y,70,70);
  
  //Arms
  rect(x,y+50,100,20,10);
  rectMode(CORNER);
  rect(x-55,y+40,20,100,10);
  rect(x+35,y+40,20,100,10);
  
  //Legs
  rect(x-30,y+130,27,100,10);
  rect(x+3,y+130,27,100,10);
  
  //Torso
  rectMode(CENTER);
  rect(x,y+90,60,100);
  
  //Rockets
  r);
  b = 5;
  g);
  fill(r,g,b); //Jets random color between yellow and red
  
  triangle(x-55,y+135,x-35,y+135,x-45,y+160); //Hand jets
  triangle(x+55,y+135,x+35,y+135,x+45,y+160);
  
  triangle(x-30,y+225,x-5,y+225,x-18,y+255); //Feet jets
  triangle(x+30,y+225,x+5,y+225,x+18,y+255);
  
  //Blast off!
  x);
  y = y - 2.5;
}
```

## Lab 5 - Creature screensaver

```java
/*
Zed Chance
Lab 5
CS 10
Summer 18
Creature screensaver
*/

//Initialize variables
float r = 0;
float g = 0;
float b = 0;

float x = 0;
float y = 0;

float xSpeed = 3;
float ySpeed = 1;

void setup() {
  size(600,600);
  x = width/2;
  y = height/4;
  background(0);
}

void draw() {
  background(0);
  
  //Horizontal movement
  x = x + xSpeed;
  if (x > width-55 || x < 55) {
    xSpeed = xSpeed*-1;
  }
  
  //Vertical movement
  y = y + ySpeed;
  if (y > height-230 || y < 35) {
    ySpeed = ySpeed*-1;
  }
  
  //Color changes with quadrant
  if (x < width/2 && y < height/2) {
    r = 0;
    g = 0;
    b = 255;
  }
  
  if (x > width/2 && y < height/2) {
    r = 255;
    g = 0;
    b = 0;
  }
  
  if (x < width/2 && y > height/3) {
    r = 0;
    g = 255;
    b = 0;
  }
  
  if (x > width/2 && y > height/3) {
    r = 0;
    g = 255;
    b = 255;
  }
  
  //Fill body with color determined by above
  fill(r,g,b);
  noStroke();
  
  //Head
  ellipse(x,y,70,70);
  
  //Arms
  rect(x,y+50,100,20,10);
  rectMode(CORNER);
  rect(x-55,y+40,20,100,10);
  rect(x+35,y+40,20,100,10);
  
  //Legs
  rect(x-30,y+130,27,100,10);
  rect(x+3,y+130,27,100,10);
  
  //Torso
  rectMode(CENTER);
  rect(x,y+90,60,100);
}
```

## Lab 6 - Multiplying creature with loops

```java
/*
Zed Chance
Lab 6
CS 10
Summer 18
Multiplying creature with loops
*/

//Setup
size(800,300);
background(0);

//Initialize variables
float x = -20;
float y = 50;

float r = 0;
float g = 0;
float b = 0;

while (x < width) {
  //Color
  noStroke();
  fill(r,g,b);
  
  //Head
  ellipse(x,y,70,70);
  
  //Arms
  rect(x,y+50,100,20,10);
  rectMode(CORNER);
  rect(x-55,y+40,20,100,10);
  rect(x+35,y+40,20,100,10);
  
  //Legs
  rect(x-30,y+130,27,100,10);
  rect(x+3,y+130,27,100,10);
  
  //Torso
  rectMode(CENTER);
  rect(x,y+90,60,100);
  
  //Randomly change color pallette
  r);
  g);
  b);
  
  //Move creature over
  x = x + 120;
}
```

## Lab 7 - Using a function to create multiple creatures

```java
/*
Zed Chance
Lab 6
CS 10
Summer 18
Using a function to create multiple creatures
*/

//Define my creature function
void myCreature(float x,float y,color c) {
  //Color
  noStroke();
  fill(c);
  
  //Head
  ellipse(x,y,70,70);
  
  //Arms
  rect(x,y+50,100,20,10);
  rectMode(CORNER);
  rect(x-55,y+40,20,100,10);
  rect(x+35,y+40,20,100,10);
  
  //Legs
  rect(x-30,y+130,27,100,10);
  rect(x+3,y+130,27,100,10);
  
  //Torso
  rectMode(CENTER);
  rect(x,y+90,60,100);
}

void setup() {
  size(800,800);
  background(0);
}

void draw() {
  //Call my creature function in draw function
  myCreature(random(width),random(height),color(random(255),random(255),random(255)));
}
```


