Project4
05-05-13
*********************
Nikita Miroshnichenko

email: nmiroshn@u.rochester.edu

*********************
Class: 76802 CSC 172
Lab: 76826 CSC 172

*********************
Compile: javac mainreader.java
*********************
Run: java mainreader

For command line arguments please enter -fin and the name of the file being read. 
Example common line argument format: -fin monroe-county.tab

After the program runs, two jframes will appear on screen. One jframe will have the map, and the other will have the map with the Minimum Spanning Tree imposed onto it.
Colors used:
Black: Map Lines
Yellow: Points
Red: MST
Blue: Shortest Path between points.

After the 2 maps are displayed on screen, the program prompts the use to enter the two points used for the Shortest Path calculation. Please enter the point id, x and y coordinate. When finished entering data please enter ^d. 

Example standard input format: 
i26759940 590.6698711568986 506.66639722222254
i26759941 581.6081809825608 505.50223888889224
^d

The program will then calculate the shortest path, print it out and display a jframe display with the map showed the shortest path.
*********************
Report Documentation:
	This project is split up between point.java (intersection class), line.java (road class), graph.java (graph drawing class), mwst.java (the minimum weight spanning tree class), dij.java (dijkstra's algorithm calculation) and main driver(the main driver class). 
	The point and line classes define the basic road and intersection classes. Points have x and y coordinates, names (the ids entered) and colors. The point class keeps track of all points entered and also keeps track of which lines connect to each point. 
	The line class is defined by two points, a name and the weight of the line. The weight of a line is defined by its length (in this project, it is unfavorable for a line to have a long length - since a MWST is calculated). 
	The graph class is used to graph the specified points linkedlist and line linkedlist and arraylist onto a Jframe. 
	The mwst class is used to calculate the mwst of the system of lines contained in the input file dataset. THe mwst simply calculates the mwst of the dataset and returns a line array representing it. 
	The dij class used the dijkstra algorithm to calculate the shortest path (in terms of roads) between two intersections. The method takes in two points to be calculated, used the hashtable of connected lines and points from the point class, as well as the hashset of all points retrieved from the input dataset. The resultant return of the dij method is an ArrayList of the lines connecting the shortest path from point1 to point2. 
	The maindriver class puts all of the previously implemented class together. Firstly the command arguments are read for the input file, which is scanned through creating linked lists of points and lines. The scanner also makes a hashtable for each point, showing connecting lines and their end points. The scanner also makes a hashset of all points entered. Also an arraylist of lines is made. The linkedlists are passed into a graph object and drawn to show the map of the system. The linkedlists are also passed into a graph object to draw a mwst. The created hashtable and hashset are stored to be later used the dij.java file to calculate the shortest path between two desired points entered by the user. If the two points have a possible shortest path using the lines contained in the dataset file, then the connecting lines will be printed out and the shortest path will be superimposed upon the regular map of the system and displayed in a jframe. 
 
*********************
Report Run Time Analysis: 
	The shortest path method implemented dijkstra's algorithm so the runtime of that method was O(n^2). The MWST used ints as weights, so the run time is o(m+n log n). The graph file's runtime is O(n), as it only used for loops. Point and line classes are constant time. The main files's (maindriver.java) runtime is estimated at 0(n^2), as the largest run time operation involves double while loops. Overall, since dijkstra's algorithm or the mwst algorithm are not called in the while loops of maindriver, the overall run time of the program should be O(n^2).

