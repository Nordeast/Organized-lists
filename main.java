// Written by Allen Rand

import java.util.ArrayList;

public class main {

	// List_node (name, value, count)
	// main will demonstrate each of the ways of organizing the lists
	// will need to add a forth organization soon...

	public static void main(String[] args) {
		ArrayList<List_node> generated_list = new ArrayList<List_node>();


		String[] rest = {"Cincinati vs. Hampton", "Harvard vs. Wisconsin", "Oregon vs. Butler", "West Virginia vs. Texas", "Butler vs. Butler", "West Virginia vs. Arkansas", "Notre Dame vs. Notre Dame", "Cincinati vs. Texas", "Northeastern vs. Northeastern", "Kentucky vs. Texas", "Cincinati vs. Kentucky", "Purdue vs. Arkansas", "Arkansas vs. Cincinati", "Notre Dame vs. Buffalo", "Texas vs. Oregon", "Hampton vs. Hampton", "Hampton vs. Buffalo", "Purdue vs. Butler", "Arkansas vs. West Virginia", "Northeastern vs. Arkansas", "Butler vs. Hampton", "Northeastern vs. Cincinati", "Wisconsin vs. Texas", "Purdue vs. West Virginia", "West Virginia vs. Notre Dame", "Purdue vs. Notre Dame", "Butler vs. Texas", "West Virginia vs. Buffalo", "Hampton vs. Wisconsin", "Texas vs. Butler", "Butler vs. Purdue", "Oregon vs. Northeastern", "Northeastern vs. Texas", "Arkansas vs. Northeastern", "Notre Dame vs. Northeastern", "Buffalo vs. Hampton", "Texas vs. Wisconsin", "Harvard vs. Cincinati", "Harvard vs. Hampton", "Hampton vs. Butler", "Northeastern vs. Kentucky", "Wisconsin vs. Cincinati", "Kentucky vs. Cincinati", "Arkansas vs. Hampton", "Butler vs. Notre Dame", "Arkansas vs. Oregon", "Arkansas vs. Notre Dame", "Buffalo vs. Northeastern", "Arkansas vs. Buffalo", "Cincinati vs. Purdue", "Harvard vs. Oregon", "Kentucky vs. Harvard", "Northeastern vs. Notre Dame", "Cincinati vs. Wisconsin", "Wisconsin vs. Kentucky", "Northeastern vs. Purdue", "Wisconsin vs. Wisconsin", "Oregon vs. Kentucky", "Notre Dame vs. Butler", "Harvard vs. Notre Dame", "Kentucky vs. Notre Dame", "Kentucky vs. Purdue", "Buffalo vs. Arkansas", "Cincinati vs. Northeastern", "Wisconsin vs. Northeastern", "Buffalo vs. Buffalo", "Wisconsin vs. Buffalo", "Arkansas vs. Kentucky", "Cincinati vs. Buffalo", "Hampton vs. Harvard", "Harvard vs. Texas", "Purdue vs. Cincinati", "Purdue vs. Northeastern", "Arkansas vs. Texas", "Texas vs. Hampton", "Oregon vs. Purdue", "Notre Dame vs. Hampton", "Northeastern vs. Wisconsin", "Kentucky vs. Oregon", "Harvard vs. Buffalo", "Purdue vs. Buffalo", "West Virginia vs. West Virginia", "Kentucky vs. Northeastern", "Wisconsin vs. Harvard", "West Virginia vs. Wisconsin", "Harvard vs. West Virginia", "Northeastern vs. Oregon", "Buffalo vs. Butler", "Oregon vs. Buffalo", "Hampton vs. Purdue", "Buffalo vs. Kentucky", "Notre Dame vs. West Virginia", "Oregon vs. Cincinati", "Notre Dame vs. Kentucky", "Kentucky vs. Kentucky", "Harvard vs. Arkansas", "Texas vs. Harvard", "Harvard vs. Kentucky", "Arkansas vs. Purdue", "Hampton vs. Texas", "Butler vs. Buffalo", "Buffalo vs. Wisconsin", "Texas vs. Purdue", "Hampton vs. Oregon", "West Virginia vs. Harvard", "Oregon vs. Hampton", "Cincinati vs. Harvard", "Hampton vs. Kentucky", "Wisconsin vs. Oregon", "Harvard vs. Harvard", "West Virginia vs. Purdue", "Kentucky vs. West Virginia", "Butler vs. Northeastern", "Wisconsin vs. Notre Dame", "Buffalo vs. Cincinati", "Notre Dame vs. Cincinati", "Harvard vs. Butler", "Northeastern vs. Buffalo", "Buffalo vs. Harvard", "Butler vs. Harvard", "Kentucky vs. Wisconsin", "Buffalo vs. Oregon", "Harvard vs. Purdue", "Buffalo vs. Purdue", "West Virginia vs. Oregon", "Cincinati vs. Arkansas", "Cincinati vs. Cincinati", "Purdue vs. Kentucky", "West Virginia vs. Hampton", "West Virginia vs. Kentucky", "Oregon vs. Arkansas", "Butler vs. Arkansas", "Oregon vs. Wisconsin", "Wisconsin vs. Hampton", "Oregon vs. Oregon", "Texas vs. Texas", "Butler vs. Cincinati", "Notre Dame vs. Texas", "Notre Dame vs. Harvard", "Oregon vs. Notre Dame", "Butler vs. Kentucky", "Texas vs. Northeastern"
};
		
		int[] rest_queries = {0, 1, 2, 3, 0, 0, 4, 5, 6, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 9, 10, 11, 0, 0, 0, 0, 0, 0, 0, 0, 12, 13, 14, 15, 2, 16, 17, 12, 12, 12, 18, 19, 20, 21, 22, 23, 24, 12, 25, 25, 25, 26, 27, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 28, 29, 29, 29, 29, 30, 31, 32, 33, 34, 35, 36, 29, 29, 29, 29, 29, 37, 38, 39, 40, 29, 29, 29, 29, 29, 29, 29, 29, 41, 41, 35, 42, 43, 44, 37, 45, 16, 41, 46, 47, 48, 41, 41, 41, 41, 39, 39, 39, 5, 39, 39, 39, 49, 49, 49, 49, 49, 49, 49, 49, 50, 50, 50, 50, 50, 50, 50, 50, 50, 51, 51, 51, 52, 53, 17, 51, 51, 51, 51, 51, 51, 51, 51, 54, 54, 54, 54, 55, 55, 55, 56, 57, 58, 59, 55, 55, 55, 60, 60, 51, 30, 61, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 62, 62, 62, 62, 62, 62, 62, 62, 62, 62, 62, 62, 62, 29, 29, 29, 63, 49, 64, 65, 48, 29, 29, 29, 29, 37, 66, 67, 28, 68, 29, 29, 29, 29, 65, 65, 65, 69, 65, 70, 70, 71, 70, 70, 70, 70, 70, 70, 72, 73, 74, 16, 75, 20, 76, 77, 27, 78, 73, 73, 73, 73, 79, 79, 79, 79, 44, 80, 79, 79, 79, 79, 79, 79, 79, 79, 79, 79, 79, 73, 73, 73, 73, 81, 82, 24, 83, 73, 73, 73, 84, 85, 73, 73, 86, 63, 87, 88, 81, 4, 89, 73, 73, 90, 91, 73, 73, 73, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 79, 93, 94, 15, 53, 78, 95, 96, 92, 92, 97, 3, 98, 8, 99, 100, 101, 102, 92, 29, 103, 96, 29, 29, 29, 104, 105, 22, 29, 29, 29, 29, 29, 29, 91, 36, 46, 29, 29, 29, 29, 29, 85, 29, 29, 29, 29, 29, 79, 79, 79, 79, 79, 79, 79, 79, 79, 106, 10, 107, 79, 108, 108, 108, 108, 108, 109, 63, 108, 108, 14, 110, 108, 108, 108, 108, 108, 108, 111, 111, 111, 111, 111, 112, 112, 112, 112, 112, 112, 112, 112, 112, 104, 104, 113, 114, 115, 116, 104, 98, 117, 99, 42, 118, 104, 1, 16, 53, 109, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 119, 120, 104, 104, 104, 55, 104, 104, 121, 122, 123, 104, 104, 104, 104, 63, 124, 31, 125, 126, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 128, 124, 127, 127, 127, 127, 127, 127, 127, 70, 127, 54, 129, 86, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 99, 99, 99, 99, 130, 131, 132, 99, 133, 0, 134, 135, 47, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 136, 105, 113, 137, 99, 138, 139, 72, 34, 140, 41, 99, 99, 99, 99, 99, 99, 99, 125, 46, 141, 138, 43, 93, 99, 99, 99};
		
		// fill lists with nodes
		for (int i = 0; i < rest.length; i++) {
			generated_list.add(new List_node(rest[i], i, 0));

		}// end for
		// create the classes 
		organize_list algs = new organize_list(generated_list);


		System.out.println("Linear:");
		for(int i = 0; i < rest_queries.length; i++){
			algs.linear(rest_queries[i]);
		}
		//algs.print_list(1);
		algs.print_list(8);
		algs.print_list(12);

		System.out.println("\n\nMOVE TO FRONT:");
		for(int i = 0; i < rest_queries.length; i++){
			algs.mtf(rest_queries[i]);
		}
		//algs.print_list(2);
		algs.print_list(5);
		algs.print_list(10);

		System.out.println("\n\nTRANSPOSE:");
		for(int i = 0; i < rest_queries.length; i++){
			algs.transpose(rest_queries[i]);
		}
		//algs.print_list(3);
		algs.print_list(6);
		algs.print_list(9);

		System.out
				.println("\n\nCOUNT:");
		for(int i = 0; i < rest_queries.length; i++){
			algs.count(rest_queries[i]);
		}
		//algs.print_list(4);
		algs.print_list(7);
		algs.print_list(11);

	}// end main

}// end class

