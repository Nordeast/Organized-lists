// Written by Allen Rand
// This class will take in a array list of the data to be queried
// The functions take in a distinct value that is contained in the 
// List_node and does the look up.
// This look up is counted and the print function at the bottom will 
// print out the data and a few stats.
import java.util.ArrayList;

public class organize_list extends ArrayList<List_node> {
	// These hold the list for the different operations
	private ArrayList<List_node> list; // holds the list
	private ArrayList<List_node> linear_list;
	private ArrayList<List_node> MTF_list;
	private ArrayList<List_node> Transpose_list;
	private ArrayList<List_node> Count_list;
	private ArrayList<List_node> MTF_list_2;
	
	private int MTF_queries = 0;
	private int MTF_total_access = 0;// total number of times mtf has been queried
	private int Transpose_queries = 0;
	private int Transpose_total_access = 0;
	private int Count_queries = 0;
	private int Count_total_access = 0;
	private int Linear_queries = 0;
	private int Linear_total_access = 0;
	private int MTF_total_access_2 = 0;
	private int MTF_queries_2 = 0;
	// these lists hold a history for the number of look ups per query
	private ArrayList<Integer> MTF = new ArrayList<Integer>();
	private ArrayList<Integer> transpose = new ArrayList<Integer>();
	private ArrayList<Integer> count = new ArrayList<Integer>();
	private ArrayList<Integer> linear = new ArrayList<Integer>();
	private ArrayList<Integer> MTF_2 = new ArrayList<Integer>();
	



	public organize_list(ArrayList<List_node> l) {
		// must be constructed with a already filled list.
		// These hold the list for the different operations
		list = l;
		linear_list = l;
		MTF_list = l;
		Transpose_list = l;
		Count_list = l;
		MTF_list_2 = l;
	}

	public void reset_lists() {
		// reset the lists to the original.
		linear_list = list;
		MTF_list = list;
		Transpose_list = list;
		Count_list = list;
		MTF_list_2 = list;
	}

	public void linear(int value) {
		// this function does the standard
		int index = -1;

		Linear_queries = 0;
		for (int i = 0; i < linear_list.size(); i++) {// find the element in the
			// list
			Linear_queries++; // incr the query count
			if (linear_list.get(i).get_value() == value) {
				index = i; // set values of the found node
				break;
			}
		}

		if (index == -1) {// cannot find the node
			System.out.printf("Cannot find value: %d", value);

		}
		linear.add(Linear_queries); // add look ups to the list
		Linear_total_access++;// incr the total access count

	}

	public void mtf(int value) {
		// if the value is in the list then move that node to the front of the
		// list
		MTF_queries = 0;
		int index = -1;
		List_node current = null;
		for (int i = 0; i < MTF_list.size(); i++) {// find the element in the
			// list
			MTF_queries++; // incr the query count
			if (MTF_list.get(i).get_value() == value) {
				index = i; // set values of the found node
				current = MTF_list.get(i);

				break;
			}
		}

		if (index == -1) {// cannot find the node
			System.out.printf("Cannot find value: %d", value);

		}
		MTF.add(MTF_queries); // add look ups to the list
		MTF_total_access++;// incr the total access count
		MTF_list.remove(index); // remove the node
		MTF_list.add(0, current);// place it at the head of the list

	}

	public void transpose(int value) {
		// if the value is in the list then switch that node with the one before
		// it
		Transpose_queries = 0;

		int index = -1;
		List_node current = null;

		for (int i = 0; i < Transpose_list.size(); i++) {// find the element in
			// the list
			Transpose_queries++;// incr the query count
			if (Transpose_list.get(i).get_value() == value) {
				index = i;// set values of the found node
				current = Transpose_list.get(i);

				break;
			}
		}
		if (index == -1) { // cannot find the node
			System.out.printf("Cannot find value: %d", value);

		}
		// rearrange list
		if (index > 0) { // if it is not the first node

			Transpose_list.remove(current); // remove the node
			Transpose_list.add(index - 1, current);// place it up one index in
			// the list

		}// end if
		transpose.add(Transpose_queries); // add look ups to the list
		Transpose_total_access++;// incr the total access count

	}

	public void count(int value) {
		// if the value is in the list then increment its count and then
		// do insertion sort on the list
		int index = -1;
		Count_queries = 0;
		Count_total_access++;// incr the total access count
		
		// find the element in the list
		for (int i = 0; i < Count_list.size(); i++) {
		
			Count_queries++;// incr the query count
			if (Count_list.get(i).get_value() == value) {
				Count_list.get(i).incr_count();// increase count by one
				index++;

				break;
			}
		}
		if (index == -1) { // cannot find the node
			System.out.printf("Cannot find value: %d", value);

		}
		count.add(Count_queries); // add look ups to the list
		// rearrange list with insertion sort
		List_node x;
		for (int i = 1; i < Count_list.size(); i++) {

			x = Count_list.get(i);
			int j;

			for (j = i; j > 0
					&& x.get_count() > Count_list.get(j - 1).get_count(); j--) {
				Count_list.set(j, Count_list.get(j - 1));

			} // end if
			Count_list.set(j, x);
		}
	}
	
	//Move half-way to front Algorithm
	public void mtf_2(int value){
		// if the value is in the list, and it has been accessed
		//then move that node to the front of the list
		MTF_queries_2 = 0;
		int index = -1;
		List_node current = null;
		
		// find the element in the list
		for (int i = 0; i < MTF_list_2.size(); i++) {
			MTF_queries_2++; // incr the query count
			if (MTF_list_2.get(i).get_value() == value) {
				index = i; // set values of the found node
				current = MTF_list_2.get(i);

				MTF_list_2.get(i).count++;//increment the count
				break;
			}
		}

		if (index == -1) {// cannot find the node
			System.out.printf("Cannot find value: %d", value);

		}
		MTF_2.add(MTF_queries_2); // add look ups to the list
		MTF_total_access_2++;// incr the total access count

		//move element half way from current position to the front of the list
			MTF_list_2.remove(index); // remove the node
			MTF_list_2.add(index/2, current);// place it at the head of the list

		current.count++;//increment count


	}
	public void print_list(int flag) {
		double average = 0.0;
		int mode = 0;
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
		
		switch (flag) {

		case 1:

			for (int i = 0; i < linear_list.size(); i++) {// iterate through the
				// list

				if (i % 6 == 0) {
					System.out.println();
				}
				System.out.printf("[%s, %d] ", linear_list.get(i).get_name(),
						linear_list.get(i).get_value());
			}
			System.out.println();

			break;

		case 2:

			for (int i = 0; i < MTF_list.size(); i++) {// iterate through the
				// list

				if (i % 6 == 0) {
					System.out.println();
				}
				System.out.printf("[%s] ", MTF_list.get(i).get_name());
			}
			System.out.println();

			break;

		case 3:

			for (int i = 0; i < Transpose_list.size(); i++) {// iterate through
				// the list

				if (i % 6 == 0) {
					System.out.println();
				}
				System.out.printf("[%s] ", Transpose_list.get(i).get_name());
			}
			System.out.println();

			break;

		case 4:

			for (int i = 0; i < Count_list.size(); i++) {// iterate through the
				// list

				if (i % 6 == 0) {
					System.out.println();
				}
				System.out.printf("[%s,%d] ", Count_list.get(i).get_name(),
						Count_list.get(i).get_count());
			}
			System.out.println();

			break;
		case 5:

			for (int i = 0; i < MTF_list_2.size(); i++) {// iterate through the
				// list

				if (i % 6 == 0) {
					System.out.println();
				}
				System.out.printf("[%s] ", MTF_list_2.get(i).get_name());
			}
			System.out.println();

			break;

		case 6:
			// print average number of queries MTF
			average = list_average(MTF, MTF_total_access);
			System.out.printf("Average node accesses\n");
			System.out.printf("average number of node accesses MTF: %f\n",
					average);
			break;

		case 7:
			// print average number of queries transpose
			average = list_average(transpose, Transpose_total_access);
			System.out.printf("Average node accesses\n");
			System.out.printf(
					"average number of node accesses transpose: %f\n", average);
			break;
		case 8:
			// print average number of queries Count
			average = list_average(count, Count_total_access);
			System.out.printf("Average node accesses\n");
			System.out.printf("average number of node accesses Count: %f\n",
					average);
			break;
		case 9:
			// print average number of queries for linear
			average = list_average(linear, Linear_total_access);
			System.out.printf("Average node accesses\n");
			System.out.printf("average number of node accesses linear: %f\n",
					average);
			break;
		case 10:
			// print average number of queries MTF
			average = list_average(MTF_2, MTF_total_access_2);
			System.out.printf("Average node accesses\n");
			System.out.printf("average number of node accesses MTF: %f\n",
					average);
			break;
		case 11:
			// code found on stack over flow
			// find the mode Transpose
			mode = list_mode(transpose);
			System.out.println("Transpose mode: " + mode);
			break;
		case 12:
			// code found on stack over flow
			// find the mode MTF
			mode = list_mode(MTF);
			System.out.println("MTF mode: " + mode);
			break;
		case 13:
			// code found on stack over flow
			// find the mode Count
			mode = list_mode(count);
			System.out.println("count mode: " + mode);
			break;
		case 14:
			// code found on stack over flow
			// find the mode linear
			mode = list_mode(linear);
			System.out.println("Linear mode: " + mode);
			break;
		case 15:
			// code found on stack over flow
			// find the mode MTF
			mode = list_mode(MTF_2);
			System.out.println("MTF mode: " + mode);
			break;
		case 16:
			list_look_up_list(MTF);
			break;
		case 17:
			list_look_up_list(transpose);
			break;
		case 18:
			list_look_up_list(count);
			break;
		case 19:
			list_look_up_list(linear);
			break;
		case 20:
			list_look_up_list(MTF_2);
			break;	
		default:

			System.out.println("Usage list_print(FLAG)");

		}// end switch
	}// end list_print

	private int list_mode(ArrayList<Integer> l) {
		int index = 0;
		int[] cnt = new int[1000];

		// count the occurrences
		for (int i = 0; i < l.size(); i++) {
			cnt[l.get(i)]++;
		}

		// go backwards and find the count with the most occurrences
		index = cnt.length - 1;
		for (int i = cnt.length - 2; i >= 0; i--) {
			if (cnt[i] >= cnt[index])
				index = i;
		}
		return index;
	}// end list_mode

	private double list_average(ArrayList<Integer> l, int access) {
		int total_queries = 0;
		double average = 0.0;
		System.out.println();
		for (int i = 0; i < l.size(); i++) {
			total_queries += l.get(i);

		}
		System.out.println();
		average = (double) total_queries / access;// average
		// number
		// of
		// queries
		return average;
	}// end list_average

	private void list_look_up_list(ArrayList<Integer> l) {
		for (int i = 0; i < l.size(); i++) {
			System.out.printf("%d, ", l.get(i));
		}
	}// end list_look_up_list
}// end class
