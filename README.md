# The Game of Life
## An adaptation of John Conways's cellular automaton

![image](https://github.com/Danton1/Game-of-Life/assets/107024401/1919f2ba-58f8-421e-bc0c-dbbf1c5ea048)


### Overview
This project is an implementation of Conway's Game of Life, a classic cellular automaton. The original automaton simulates the evolution of a grid of cells based on simple rules, resulting in fascinating emergent behaviour. My iteration implements Plants, Herbivores, Carnivores, and Omnivores that express different behaviours based on their specific rules, and navigate through the world interacting with each other.

### Lifeforms
- **Plants (Green)**:
  - Color: Green
  - Behavior: Plants are stationary and do not move. They serve as a food source for herbivores, carnivores, and omnivores.
  - Reproduction: Plants can give birth under specific conditions, including having at least 2 plant neighbours, at least 3 free neighbouring cells, and no food in neighbouring cells.

- **Herbivores (Yellow)**:
  - Color: Yellow
  - Behavior: Herbivores eat only plants. They must find and consume plants within 5 moves to survive. Herbivores can move around the grid to find food.
  - Reproduction: Herbivores can give birth under specific conditions, including having at least 1 other herbivore neighbour, at least two free neighbouring cells, and at least 2 neighbouring cells with food (plants).

- **Carnivores (Red)**:
  - Color: Red
  - Behavior: Carnivores eat herbivores and omnivores. Similar to herbivores, they must find and consume food within 5 moves to survive. Carnivores can move around the grid to find food.
  - Reproduction: Carnivores can give birth under specific conditions, including having at least 1 other carnivore neighbour, at least three free neighbouring cells, and at least 2 neighbouring cells with food (herbivores or omnivores).

- **Omnivores (Blue)**:
  - Color: Blue
  - Behavior: Omnivores are versatile and can eat plants, herbivores, and carnivores. They must also find and consume food within 5 moves to survive and can move around the grid.
  - Reproduction: Omnivores can give birth under specific conditions, including having at least 1 other omnivore neighbour, at least three free neighbouring cells, and at least 1 neighbouring cell with food (plants, herbivores, or carnivores).



### Usage
To run the simulation:
1. Clone this repository to your local machine.
2. Open the project in your preferred IDE.
3. Compile and run the main class.

### Initial Design:
Made by:
 - Danton Soares
 - Soomin Jeong

![UML Initial Design](https://github.com/Danton1/Game-of-Life/assets/107024401/6dc2685c-c8d3-43ea-9120-db79ab019e30)

### Initial prompt:

You are going to create a simulation of a simple world. Often referred to as “The game of Life” (not related to the Parker Brothers board game). The world starts off with Plants and Herbivores (plant eaters) on a grid randomly placed. The grid displays the plants (green) and Herbivores (yellow) by filling in the squares where they are found. Blank squares represent empty areas. Herbivores “graze” by moving around the grid eating plants they find. Herbivores must find a plant to eat before 5 “turns” have passed or they die. A “turn” is a step in time which occurs when a user clicks anywhere on the window displaying the world. Herbivores move by checking neighboring cells and randomly picking one. They cannot move to a neighboring cell that contains a Herbivore. They move 1 cell per turn. Plants do not move. Plant however will seed. Each plant will send seeds to a random neighboring empty cell assuming that there are at least 3 empty cells to send seeds to and there are exactly 4 other plants to help cross pollenate. 

It is important that you think about future changes before building your simulation. Movement patterns may change, procreation by animals, new rules governing behaviors, and physical representations. This does not imply that all of these changes will occur, nor does it preclude others from being introduced. By carefully thinking about what could be added or changed and designing with that flexibility in mind you’ll find the future parts for assignment 2 easier to accommodate.


<img src="https://media1.tenor.com/m/7dP6_v1QkIIAAAAC/pokemon-bulbasaur.gif" width="400px">


