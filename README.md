# The Game of Life
## An adaptation of John Conways's cellular automaton

<img src="https://media1.tenor.com/m/7dP6_v1QkIIAAAAC/pokemon-bulbasaur.gif" width="400px">

### Authors:
 - Danton Soares
 - Soomin Jeong

### Description:

You are going to create a simulation of a simple world. Often referred to as “The game of Life” (not related to the Parker Brothers board game). The world starts off with Plants and Herbivores (plant eaters) on a grid randomly placed. The grid displays the plants (green) and Herbivores (yellow) by filling in the squares where they are found. Blank squares represent empty areas. Herbivores “graze” by moving around the grid eating plants they find. Herbivores must find a plant to eat before 5 “turns” have passed or they die. A “turn” is a step in time which occurs when a user clicks anywhere on the window displaying the world. Herbivores move by checking neighboring cells and randomly picking one. They cannot move to a neighboring cell that contains a Herbivore. They move 1 cell per turn. Plants do not move. Plant however will seed. Each plant will send seeds to a random neighboring empty cell assuming that there are at least 3 empty cells to send seeds to and there are exactly 4 other plants to help cross pollenate. 

It is important that you think about future changes before building your simulation. Movement patterns may change, procreation by animals, new rules governing behaviors, and physical representations. This does not imply that all of these changes will occur, nor does it preclude others from being introduced. By carefully thinking about what could be added or changed and designing with that flexibility in mind you’ll find the future parts for assignment 2 easier to accommodate.

