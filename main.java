// Written by Allen Rand

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class main {

	// List_node (name, value, count)
	// main will demonstrate each of the ways of organizing the lists
	// will need to add a forth organization soon...

	// print function flags
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

	public static void main(String[] args) {
		ArrayList<List_node> generated_list = new ArrayList<List_node>();
		// change this to false if you want to use the hard coded data sets
		if (true) {
			if (args.length < 2) {
				System.out.println("usage file_names file_number of queries");
				System.exit(0);
			}

		}
		// names for the files to be read in from the command line.
		// replace the names fqueries and fnames below if you want to 
		// use the files that are read in.
		String[] fnames = null;
		int[] fqueries = null;
		
		try {
			int x = 0;
			BufferedReader in = new BufferedReader(new FileReader(
					args[1]));
			String str;
			str = in.readLine();
			
			while ((str = in.readLine()) != null) {
				fnames = str.split(",");
			}
			in.close();
			
			
			BufferedReader in2 = new BufferedReader(new FileReader(
					args[2]));
			
			String str2;
			str = in.readLine();
			String[] ar;
			x = 0;
			
			while ((str2 = in.readLine()) != null) {
				ar = str2.split(",");
				for(x = 0; x < ar.length; x++ )
				fqueries[x] = Integer.parseInt(ar[x]);
				
			}
			in2.close();
			
		} catch (IOException e) {
			System.out.println("File Read Error");
		}

		String[] games = { "Cincinati vs. Hampton", "Harvard vs. Wisconsin",
				"Oregon vs. Butler", "West Virginia vs. Texas",
				"Butler vs. Butler", "West Virginia vs. Arkansas",
				"Notre Dame vs. Notre Dame", "Cincinati vs. Texas",
				"Northeastern vs. Northeastern", "Kentucky vs. Texas",
				"Cincinati vs. Kentucky", "Purdue vs. Arkansas",
				"Arkansas vs. Cincinati", "Notre Dame vs. Buffalo",
				"Texas vs. Oregon", "Hampton vs. Hampton",
				"Hampton vs. Buffalo", "Purdue vs. Butler",
				"Arkansas vs. West Virginia", "Northeastern vs. Arkansas",
				"Butler vs. Hampton", "Northeastern vs. Cincinati",
				"Wisconsin vs. Texas", "Purdue vs. West Virginia",
				"West Virginia vs. Notre Dame", "Purdue vs. Notre Dame",
				"Butler vs. Texas", "West Virginia vs. Buffalo",
				"Hampton vs. Wisconsin", "Texas vs. Butler",
				"Butler vs. Purdue", "Oregon vs. Northeastern",
				"Northeastern vs. Texas", "Arkansas vs. Northeastern",
				"Notre Dame vs. Northeastern", "Buffalo vs. Hampton",
				"Texas vs. Wisconsin", "Harvard vs. Cincinati",
				"Harvard vs. Hampton", "Hampton vs. Butler",
				"Northeastern vs. Kentucky", "Wisconsin vs. Cincinati",
				"Kentucky vs. Cincinati", "Arkansas vs. Hampton",
				"Butler vs. Notre Dame", "Arkansas vs. Oregon",
				"Arkansas vs. Notre Dame", "Buffalo vs. Northeastern",
				"Arkansas vs. Buffalo", "Cincinati vs. Purdue",
				"Harvard vs. Oregon", "Kentucky vs. Harvard",
				"Northeastern vs. Notre Dame", "Cincinati vs. Wisconsin",
				"Wisconsin vs. Kentucky", "Northeastern vs. Purdue",
				"Wisconsin vs. Wisconsin", "Oregon vs. Kentucky",
				"Notre Dame vs. Butler", "Harvard vs. Notre Dame",
				"Kentucky vs. Notre Dame", "Kentucky vs. Purdue",
				"Buffalo vs. Arkansas", "Cincinati vs. Northeastern",
				"Wisconsin vs. Northeastern", "Buffalo vs. Buffalo",
				"Wisconsin vs. Buffalo", "Arkansas vs. Kentucky",
				"Cincinati vs. Buffalo", "Hampton vs. Harvard",
				"Harvard vs. Texas", "Purdue vs. Cincinati",
				"Purdue vs. Northeastern", "Arkansas vs. Texas",
				"Texas vs. Hampton", "Oregon vs. Purdue",
				"Notre Dame vs. Hampton", "Northeastern vs. Wisconsin",
				"Kentucky vs. Oregon", "Harvard vs. Buffalo",
				"Purdue vs. Buffalo", "West Virginia vs. West Virginia",
				"Kentucky vs. Northeastern", "Wisconsin vs. Harvard",
				"West Virginia vs. Wisconsin", "Harvard vs. West Virginia",
				"Northeastern vs. Oregon", "Buffalo vs. Butler",
				"Oregon vs. Buffalo", "Hampton vs. Purdue",
				"Buffalo vs. Kentucky", "Notre Dame vs. West Virginia",
				"Oregon vs. Cincinati", "Notre Dame vs. Kentucky",
				"Kentucky vs. Kentucky", "Harvard vs. Arkansas",
				"Texas vs. Harvard", "Harvard vs. Kentucky",
				"Arkansas vs. Purdue", "Hampton vs. Texas",
				"Butler vs. Buffalo", "Buffalo vs. Wisconsin",
				"Texas vs. Purdue", "Hampton vs. Oregon",
				"West Virginia vs. Harvard", "Oregon vs. Hampton",
				"Cincinati vs. Harvard", "Hampton vs. Kentucky",
				"Wisconsin vs. Oregon", "Harvard vs. Harvard",
				"West Virginia vs. Purdue", "Kentucky vs. West Virginia",
				"Butler vs. Northeastern", "Wisconsin vs. Notre Dame",
				"Buffalo vs. Cincinati", "Notre Dame vs. Cincinati",
				"Harvard vs. Butler", "Northeastern vs. Buffalo",
				"Buffalo vs. Harvard", "Butler vs. Harvard",
				"Kentucky vs. Wisconsin", "Buffalo vs. Oregon",
				"Harvard vs. Purdue", "Buffalo vs. Purdue",
				"West Virginia vs. Oregon", "Cincinati vs. Arkansas",
				"Cincinati vs. Cincinati", "Purdue vs. Kentucky",
				"West Virginia vs. Hampton", "West Virginia vs. Kentucky",
				"Oregon vs. Arkansas", "Butler vs. Arkansas",
				"Oregon vs. Wisconsin", "Wisconsin vs. Hampton",
				"Oregon vs. Oregon", "Texas vs. Texas", "Butler vs. Cincinati",
				"Notre Dame vs. Texas", "Notre Dame vs. Harvard",
				"Oregon vs. Notre Dame", "Butler vs. Kentucky",
				"Texas vs. Northeastern" };

		String[] movie = { "Cinderella", "Insurgent", "Run All Night",
				"The Gunman", "Chappie", "Kingsman: The Secret Service",
				"Focus", "McFarland, USA", "The Lazarus Effect",
				"American Sniper", "Selma", "Paddington", "The Imitation Game",
				"Big Hero 6", "Jupiter Ascending" };

		String[] rest = { "Nom Chompsky’s (New!)", "McDonalds", "Subway",
				"Erb Gerb", "Papa Johns", "Asian Kitchen", "Fugu", "Milio’s",
				"Dominos", "Pita Pit", "Parthenon", "Mediterranean Cafe",
				"Taco Bros", "Chipotle", "Qdoba" };

		int[] games_queries = { 0, 1, 2, 3, 0, 0, 4, 5, 6, 7, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 8, 9, 10, 11, 0, 0, 0, 0, 0, 0, 0, 0, 12, 13, 14,
				15, 2, 16, 17, 12, 12, 12, 18, 19, 20, 21, 22, 23, 24, 12, 25,
				25, 25, 26, 27, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 28, 29,
				29, 29, 29, 30, 31, 32, 33, 34, 35, 36, 29, 29, 29, 29, 29, 37,
				38, 39, 40, 29, 29, 29, 29, 29, 29, 29, 29, 41, 41, 35, 42, 43,
				44, 37, 45, 16, 41, 46, 47, 48, 41, 41, 41, 41, 39, 39, 39, 5,
				39, 39, 39, 49, 49, 49, 49, 49, 49, 49, 49, 50, 50, 50, 50, 50,
				50, 50, 50, 50, 51, 51, 51, 52, 53, 17, 51, 51, 51, 51, 51, 51,
				51, 51, 54, 54, 54, 54, 55, 55, 55, 56, 57, 58, 59, 55, 55, 55,
				60, 60, 51, 30, 61, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 60,
				60, 60, 60, 60, 60, 60, 60, 60, 60, 62, 62, 62, 62, 62, 62, 62,
				62, 62, 62, 62, 62, 62, 29, 29, 29, 63, 49, 64, 65, 48, 29, 29,
				29, 29, 37, 66, 67, 28, 68, 29, 29, 29, 29, 65, 65, 65, 69, 65,
				70, 70, 71, 70, 70, 70, 70, 70, 70, 72, 73, 74, 16, 75, 20, 76,
				77, 27, 78, 73, 73, 73, 73, 79, 79, 79, 79, 44, 80, 79, 79, 79,
				79, 79, 79, 79, 79, 79, 79, 79, 73, 73, 73, 73, 81, 82, 24, 83,
				73, 73, 73, 84, 85, 73, 73, 86, 63, 87, 88, 81, 4, 89, 73, 73,
				90, 91, 73, 73, 73, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92, 92,
				79, 93, 94, 15, 53, 78, 95, 96, 92, 92, 97, 3, 98, 8, 99, 100,
				101, 102, 92, 29, 103, 96, 29, 29, 29, 104, 105, 22, 29, 29,
				29, 29, 29, 29, 91, 36, 46, 29, 29, 29, 29, 29, 85, 29, 29, 29,
				29, 29, 79, 79, 79, 79, 79, 79, 79, 79, 79, 106, 10, 107, 79,
				108, 108, 108, 108, 108, 109, 63, 108, 108, 14, 110, 108, 108,
				108, 108, 108, 108, 111, 111, 111, 111, 111, 112, 112, 112,
				112, 112, 112, 112, 112, 112, 104, 104, 113, 114, 115, 116,
				104, 98, 117, 99, 42, 118, 104, 1, 16, 53, 109, 104, 104, 104,
				104, 104, 104, 104, 104, 104, 104, 119, 120, 104, 104, 104, 55,
				104, 104, 121, 122, 123, 104, 104, 104, 104, 63, 124, 31, 125,
				126, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127,
				127, 128, 124, 127, 127, 127, 127, 127, 127, 127, 70, 127, 54,
				129, 86, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127,
				127, 99, 99, 99, 99, 130, 131, 132, 99, 133, 0, 134, 135, 47,
				99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 136, 105, 113, 137,
				99, 138, 139, 72, 34, 140, 41, 99, 99, 99, 99, 99, 99, 99, 125,
				46, 141, 138, 43, 93, 99, 99, 99 };

		int[] movie_queries = { 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 2, 0, 0, 1, 1,
				0, 1, 2, 0, 1, 1, 1, 2, 2, 1, 2, 2, 1, 2, 0, 1, 2, 0, 1, 2, 0,
				0, 1, 0, 0, 2, 2, 2, 0, 2, 1, 0, 1, 3, 2, 3, 0, 2, 1, 0, 0, 2,
				3, 0, 0, 2, 2, 2, 1, 3, 2, 3, 1, 3, 1, 1, 0, 2, 2, 2, 0, 2, 2,
				0, 1, 3, 3, 3, 4, 4, 4, 3, 1, 3, 1, 3, 4, 2, 4, 2, 1, 3, 3, 1,
				4, 4, 2, 4, 1, 3, 1, 1, 4, 2, 2, 4, 1, 3, 1, 1, 4, 2, 2, 3, 0,
				3, 2, 3, 0, 1, 4, 3, 2, 3, 0, 3, 4, 3, 3, 0, 3, 4, 3, 4, 0, 3,
				2, 1, 1, 1, 4, 4, 2, 4, 1, 4, 4, 4, 2, 0, 3, 3, 4, 3, 1, 4, 4,
				3, 2, 0, 3, 3, 4, 1, 0, 3, 3, 2, 1, 0, 3, 3, 4, 3, 1, 4, 4, 2,
				2, 1, 4, 4, 3, 2, 0, 3, 3, 2, 3, 5, 5, 5, 6, 6, 6, 5, 5, 5, 6,
				5, 6, 5, 6, 7, 7, 6, 7, 5, 6, 7, 5, 6, 7, 5, 5, 6, 6, 6, 7, 5,
				5, 6, 7, 6, 7, 6, 5, 6, 5, 5, 7, 7, 7, 5, 7, 8, 7, 5, 7, 8, 5,
				5, 7, 8, 5, 6, 8, 7, 6, 6, 8, 6, 6, 5, 7, 7, 7, 5, 7, 7, 5, 6,
				8, 7, 6, 6, 8, 8, 6, 5, 7, 7, 5, 8, 8, 6, 7, 5, 7, 8, 7, 8, 9,
				8, 6, 5, 7, 6, 7, 8, 7, 8, 9, 6, 8, 8, 8, 9, 9, 9, 5, 6, 8, 8,
				6, 9, 9, 7, 7, 5, 8, 7, 8, 6, 6, 9, 8, 7, 6, 5, 8, 9, 6, 6, 6,
				9, 8, 9, 5, 5, 8, 7, 8, 8, 5, 8, 8, 9, 8, 6, 9, 9, 8, 9, 6, 9,
				9, 8, 7, 5, 8, 8, 8, 8, 6, 9, 9, 7, 7, 5, 8, 8, 9, 6, 5, 8, 8,
				7, 6, 6, 9, 9, 7, 9, 5, 8, 8, 8, 8, 5, 8, 8, 9, 6, 10, 10, 11,
				10, 10, 11, 10, 11, 11, 11, 10, 11, 10, 10, 11, 12, 10, 11, 10,
				10, 11, 12, 11, 12, 11, 10, 11, 11, 11, 12, 12, 11, 12, 11, 10,
				11, 10, 10, 11, 12, 11, 13, 11, 13, 11, 13, 12, 13, 10, 12, 13,
				12, 11, 13, 11, 13, 10, 12, 13, 10, 11, 13, 12, 13, 10, 12, 13,
				10, 10, 12, 12, 10, 10, 12, 13, 12, 11, 13, 12, 13, 11, 13, 11,
				11, 14, 12, 12, 14, 10, 12, 12, 12, 13, 13, 13, 10, 11, 13, 11,
				13, 14, 12, 14, 12, 11, 13, 11, 13, 14, 12, 14, 12, 10, 12, 13,
				12, 13, 14, 13, 12, 10, 13, 14, 11, 12, 11, 14, 14, 12, 10, 10,
				13, 14, 11, 12, 10, 13, 13, 13, 12, 11, 14, 14, 14, 12, 11, 14,
				14, 12, 14, 10, 13, 13, 13, 11, 10, 13, 13, 12, 11, 11, 14, 14,
				12, 14, 10, 13, 13, 12, 11, 11, 14, 14, 12, 14, 11, 14, 14, 12,
				14, 10, 13, 13, 14, 11, 11, 14, 14, 14, 12, 10, 13, 13, 14, 11 };

		int[] rest_queries = { 2, 5, 12, 14, 3, 7, 9, 0, 0, 0, 0, 11, 0, 12, 0,
				0, 13, 0, 0, 1, 3, 0, 0, 1, 0, 3, 0, 0, 0, 1, 0, 0, 5, 0, 8, 0,
				0, 0, 12, 0, 6, 4, 1, 0, 0, 0, 8, 8, 5, 0, 7, 11, 13, 13, 0, 4,
				10, 0, 11, 12, 11, 8, 8, 10, 4, 0, 1, 3, 12, 8, 2, 5, 9, 14, 0,
				9, 4, 6, 3, 3, 6, 11, 14, 1, 2, 0, 4, 7, 8, 2, 9, 13, 12, 1, 6,
				4, 7, 1, 13, 0, 5, 7, 2, 10 };

		// set the data sets here to display them
		// set current and and current in to fname
		// and fqueries respectively to use command line input
		String[] current = movie;
		int[] current_int = movie_queries;

		// fill list with nodes
		for (int i = 0; i < current.length; i++) {
			generated_list.add(new List_node(current[i], i, 0));

		}// end for
			// create the classes
		organize_list algs = new organize_list(generated_list);

		System.out.println("Linear:");
		for (int i = 0; i < current_int.length; i++) {
			algs.linear(current_int[i]);
		}
		algs.print_list(19);
		// algs.print_list(9);
		// algs.print_list(14);

		System.out.println("\n\nMOVE TO FRONT:");
		for (int i = 0; i < current_int.length; i++) {
			algs.mtf(current_int[i]);
		}
		algs.print_list(16);
		// algs.print_list(6);
		// algs.print_list(12);

		System.out.println("\n\nTRANSPOSE:");
		for (int i = 0; i < current_int.length; i++) {
			algs.transpose(current_int[i]);
		}
		algs.print_list(17);
		// algs.print_list(7);
		// algs.print_list(11);

		System.out.println("\n\nCOUNT:");
		for (int i = 0; i < current_int.length; i++) {
			algs.count(current_int[i]);
		}
		algs.print_list(18);
		// algs.print_list(8);
		// algs.print_list(13);

		System.out.println("\n\nMOVE HALF WAY TO FRONT");
		for (int i = 0; i < current_int.length; i++) {
			algs.mtf_2(current_int[i]);
		}
		algs.print_list(20);
		// algs.print_list(10);
		// algs.print_list(15);

	}// end main
}// end class

