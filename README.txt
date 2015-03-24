Name: Allen Rand, Ben Perry, James Ziglinski
Class: CS577
Date: 3/23/15
Assignment: Programming project 2 for hw3
Files: main.java organize_list.java list_node.java

Contents: The code is our implementation of 4 algoritms: Move to front, Transpose, Count and one we created Move halfway to front.
Also inluded in the implementation is a linear list for comparison.

MAIN:
Run main as normal to use the default data set. To run a different data set, change the initalization of current and current_int to 
another hardcoded data set. 

ORGANIZE_LIST:
This is were the functions are implemented. Each of the algoritms are contained in their own method and each of them have their
own arraylist. Included is a print function with many different presets of our design to print out the lists and other information.
Usage list_print(FLAG)
FLAGS
		// FLAGS
		// Each of the flags represent a different way to format the output
		// 1 - Print linear list
		// 2 - Print MTF list
		// 3 - Print Transpose list
		// 4 - Print Count list
		// 5 - Print MTF_2 list
		// 6 - print average MTF
		// 7 - print average transpose
		// 8 - print average count
		// 9 - print average linear
		// 10 - print average MTF_2
		// 11 - print mode transpose
		// 12 - print mode MTF
		// 13 - print mode Count
		// 14 - print linear mode
		// 15 - print mode MTF_2
		// 16 - print lookups per query list MTF
		// 17 - print lookups per query list transpose
		// 18 - print lookups per query list count
		// 19 - print lookups per query list linear
		// 20 - print lookups per query list MTF_2

LIST_NODE:
This is a simple node class containing 3 feilds name, value and count.