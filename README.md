# LoomVisualizer by Jacek Strotz

A program that graphs a pattern based on loom size, color, and repeat sequence.

## Problem

Round looms come in many sizes. For hats specifically, different size looms are needed for different size heads.

Example of many different sized round looms:

![Many sizes of round looms](/images/Looms.jpeg)
###### (from [this link](https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.amazon.com%2FNovelinks-Round-Knitting-Looms-Set%2Fdp%2FB07H89TC2C&psig=AOvVaw13cxREyfcUuM3pz2gw1m7q&ust=1644463997578000&source=images&cd=vfe&ved=0CAwQjhxqFwoTCKDa_PXX8fUCFQAAAAAdAAAAABAE))

Round looms are sized by number of pegs. The most common sizes are 24, 31, 36, or 41 pegs, where the last loom size produces the largest hat in circumference.

However, as solid color hats are boring, some hobbyists like to create designs to make unique hats. The most simple representation of these patterns is a transition
between two colors, usually dark starting at the bottom fading into a lighter color towards the top. Sort of like [this](https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2Floomknittinglane%2F&psig=AOvVaw1F14fNRpxDZubVXGO9-TES&ust=1644465057617000&source=images&cd=vfe&ved=0CAwQjhxqFwoTCOCs-fbb8fUCFQAAAAAdAAAAABAF),
but with a transitionary pattern between the two solid blocks:

![Example of a simple hat design](/images/Example1.jpeg)

On an even-numbered size loom, such as 24, or 36, this transitionary pattern could be labeled as ON - where "O" represents the old color (the one that starts the hat),
and "N" represents the new color (the color that is being transitioned to).

This means that per two pegs on the loom, one is of the old color, and one is of the new color. This works out perfectly, since 24 and 36 are divisible by 2 (the size of the pattern).
However, a problem arises when a prime number is used, like 31 or 41. For example, on a loom with 31 pegs, an even pattern will not be completed a whole number of times.
Since 31 (peg size) divided by 2 (pattern length) is exactly 15.5. Therefore, a pattern of 2 will repeat 15 times and then only finish half of the 16th pattern.

The difference between odd and even loom sizes create a discrepancy in patterns. A non-divisible pattern length on a certain-sized loom will create a slanted design,
while a divisible pattern length on the same loom will create a straight upward design. The differences in these patterns will be demonstrated visually later,
now that the issue has been identified.

## Solution

The output on a hat of a certain pattern on a certain loom size can be predicted by graphing. With a loom size of 31 and pattern length of 2 (represented by ON), 
a graph can be created by alternating each square (first square - old color, second square - new color, third square - old color) until reaching the end of the
size of the loom (31). Then, move up a row to the top left, and begin where the pattern ended. The first square in the row above the starting row will be represented
by the new color (because the 31st square will be an old colored square). This process is extremely lengthy to graph by hand.

Fortunately, computers can do the dirty work in a fraction of the time. Just like any other program, the most difficult part is teaching the computer how to graph
the solution. Thankfully, there is an operator in math called the **modulus**, which returns the remainder of a quotient (which in most programming languages is
signified by the % symbol). To demonstrate, 31 % 2 is 1. 31 divided by 2 is 15 with remainder 1. This process is useful as the index of the pattern can be predicted
as the row is switched from one to the next. In the previously stated example, we can predict the the pattern will continue at the 2nd index (which would be a new
colored square). 

The computer needs to keep a running total of the index of the pattern that is currently being used. With this information, and the **modulus operator**, the
pattern can be graphed accordingly. 

Here are some examples of different patterns (where old color is blue, and new color is gray):

Graph of the output of a hat on a loom with 31 pegs and a pattern of length 2 - represented by "ON"
![Example 1](/images/Example2.png)

43 pegs, and a pattern of length 4, represented by "ONNO"
![Example 2](/images/Example3.png)

24 pegs, and a pattern of length 5, represented by "ONNNO"
![Example 3](/images/Example4.png)

##### NOTE: These images are from Version 6 of the program.

A hat with four complex patterns, different row sizes, and five different colors (Version 7):
![Example 8](/images/Example8.png)

## Update
With increasing complexity to match the demand of hat designs, I published a Version 7 update which added a significant number of new features. For one, the program now prompted the user to select a number of patterns. A user can select between one and four patterns (any more or less would be hard to picture on a hat). Then, the user can select **n+1** colors, where **n** is the number of patterns (4 patterns - 5 colors). This is the highest number of patterns needed for the type of knitting the program was designed for. Additionally, the user can change the number of rows that a pattern applies for. A pattern lasting two rows will transition to the next pattern much differently than the same pattern lasting five rows. With all of these new options, I found it may be difficult to keep track of each changing variable. To counteract this, I added a key which reminds the user of which patterns they selected and which colors they picked.

Along with that, there is now a new user interface. Pictured below are examples of the program's windows.

The Main tab, where all things about the pattern are handled
![Example 6](/images/Example6.png)

The Visual tab, where the pattern is drawn
![Example 5](/images/Example5.png)

The Key tab
![Example 7](/images/Example7.png)

## Conclusion

Ultimately, this program allows a hobbyist to examine an instant graphical representation of a pattern on a staggered round loom. The patterns can be visualized
instantly instead of spending an unrealistic amount of time graphing by hand.

### Details
This project was done as request by Dr. Anne Triplet from the University of Mount Union. There were no benefits or punishments for completion or failure of this 
project. This program was written in Java purely as a demonstration of self-taught capabilities and as an exercise to improve my Java knowledge.
