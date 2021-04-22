## Assignment 9
Group members: Hankai Jing, Ying Zeng, Chieh Lin Lee

For this assignment, we used the singleton pattern, as well as the MVC architecture to structure our code.

Singleton pattern:
  For the Options class, it represents the list of option that the parser may encounter and process.
  These information won't change during the life time of the program. So only one instance of the
  Options class is needed to coordinate actions across the program. Thus, in Main class, I created a
  static private field to store the instance of Options. No matter how many parser objects are
  being created, they all use the same instance of Options.

To do class is considered to be the model of the mvc architecture because it talks to data source to
retrieve and store data. The TodoApplication class is considered to part of controller of mvc
architecture because it has some methods that change the data, for example the addTodo() and setComplete()
that add a new to do task or change the complete status of a certain to do task.


