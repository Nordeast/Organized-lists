// Written by Allen Rand
// This class will take in a array list of the data to be queried
// The functions take in a distinct value that is contained in the 
// List_node and does the look up.
// This look up is counted and the print function at the bottom will 
// print out the data and a few stats.
import java.util.ArrayList;

public class organize_list extends ArrayList<List_node> {
	ArrayList<List_node> list; // holds the list
    int MTF_queries = 0;
    int MTF_total_access = 0;// total number of times mtf has been queried
    int Transpose_queries = 0; 
	int Transpose_total_access = 0;
	int Count_queries = 0; 
	int Count_total_access = 0;
	
	ArrayList<Integer> MTF = new ArrayList<Integer>();
	ArrayList<Integer> transpose = new ArrayList<Integer>();    
	ArrayList<Integer> count = new ArrayList<Integer>();    
	public organize_list(ArrayList<List_node> l) {
		// must be constructed with a already filled list.
		list = l;
	}

	public void mtf(int value) {
		// if the value is in the list then move that node to the front of the
		// list
		MTF_queries = 0;
		int index = -1;
		List_node current = null;
		for (int i = 0; i < list.size(); i++) {// find the element in the list
			MTF_queries++; // incr the query count
			if (list.get(i).get_value() == value) {
				index = i; // set values of the found node
				current = list.get(i);

				break;
			}
		}
		
		if (index == -1) {// cannot find the node
			System.out.printf("Cannot find value: %d", value);

		}
		MTF.add(MTF_queries); // add look ups to the list
		MTF_total_access++;// incr the total access count
		list.remove(index); // remove the node
		list.add(0, current);// place it at the head of the list

	}

	public void transpose(int value) {
		// if the value is in the list then switch that node with the one before
		// it
		Transpose_queries = 0; 
		
		int index = -1;
		List_node current = null;

		for (int i = 0; i < list.size(); i++) {// find the element in the list
			Transpose_queries++;// incr the query count
			if (list.get(i).get_value() == value) {
				index = i;// set values of the found node
				current = list.get(i);

				break;
			}
		}
		if (index == -1) { // cannot find the node
			System.out.printf("Cannot find value: %d", value);

		}
		// rearrange list
		if (index > 0) { // if it is not the first node

			list.remove(current); // remove the node
			list.add(index - 1, current);// place it up one index in the list

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
		for (int i = 0; i < list.size(); i++) {// find the element in the list
			Count_queries++;// incr the query count
			if (list.get(i).get_value() == value) {
				list.get(i).incr_count();// increase count by one
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
		for (int i = 1; i < list.size(); i++) {

			x = list.get(i);
			int j;

			for (j = i; j > 0 && x.get_count() > list.get(j - 1).get_count(); j--) {
				list.set(j, list.get(j - 1));

			} // end if
			list.set(j, x);
		}
	}

	public void print_list(int flag) {
		int total_queries = 0;
		double average = 0.0;
		int index = 0;
	    int cnt[];
		// FLAGS
		// Each of the flags represent a different way to format the output
		// 1 - [value]
		// 2 - [count]
		// 3 - [name]
		// 4 - [name,count]
		// 5 - [name,value]
		// 6 - [name,count,value]
		// 7 - print average mtf
		// 8 - print average transpose
		// 9 - print average count
	    // 10 - print mode transpose
	    // 11 - print mode MTF
	    // 12 - print mode Count
		switch (flag) {

		case 1:

			for (int i = 0; i < list.size(); i++) {// iterate through the list

				if (i % 15 == 0) {
					System.out.println();
				}
				System.out.printf("[%d] ", list.get(i).get_value());
			}

			break;

		case 2:

			for (int i = 0; i < list.size(); i++) {// iterate through the list

				if (i % 15 == 0) {
					System.out.println();
				}
				System.out.printf("[%d] ", list.get(i).get_count());
			}

			break;

		case 3:

			for (int i = 0; i < list.size(); i++) {// iterate through the list

				if (i % 6 == 0) {
					System.out.println();
				}
				System.out.printf("[%s] ", list.get(i).get_name());
			}

			break;

		case 4:

			for (int i = 0; i < list.size(); i++) {// iterate through the list

				if (i % 15 == 0) {
					System.out.println();
				}
				System.out.printf("[%s,%d] ", list.get(i).get_name(),
						list.get(i).get_count());
			}

			break;

		case 5:

			for (int i = 0; i < list.size(); i++) {// iterate through the list

				if (i % 15 == 0) {
					System.out.println();
				}
				System.out.printf("[%s,%d] ", list.get(i).get_name(),
						list.get(i).get_value());
			}

			break;

		case 6:

			for (int i = 0; i < list.size(); i++) {// iterate through the list

				if (i % 15 == 0) {
					System.out.println();
				}
				System.out.printf("[%s,%d,%d] ", list.get(i).get_name(), list
						.get(i).get_count(), list.get(i).get_value());
			}

			break;
		case 7:
			// print average number of queries
			total_queries = 0;
			average = 0.0;
			System.out.println();
			for(int i = 0; i < MTF.size() ; i++){
				total_queries += MTF.get(i);
				System.out.printf("%d, ", MTF.get(i));
			}
			average = (double) total_queries/MTF_total_access;// average number of queries
			System.out.printf("\nAverage node accesses\n");
			System.out.printf("average number of node accesses MTF: %f\n", average);
			break;
			
		case 8:
			total_queries = 0;
			average = 0.0;
			System.out.println();
			for(int i = 0; i < transpose.size() ; i++){
				total_queries += transpose.get(i);
				System.out.printf("%d, ", transpose.get(i));
			}
			
			average = (double) total_queries/Transpose_total_access;// average number of queries
			System.out.printf("\n\nAverage node accesses\n");
			System.out.printf("average number of node accesses transpose: %f\n", average);
			break;
		case 9:
			// print average number of queries
			total_queries = 0;
			average = 0.0;
			System.out.println();
			for(int i = 0; i < count.size() ; i++){
				total_queries += count.get(i);
				System.out.print(count.get(i) + " ");
				
			}
			average = (double) total_queries/Count_total_access;// average number of queries
			System.out.printf("\nAverage node accesses\n");
			System.out.printf("average number of node accesses Count: %f\n", average);
		break;
		case 10:
			// code found on stack over flow
			// find the mode
			
	
				index = 0;
				cnt = new int[1000];
	
			    //count the occurrences
			    for (int i=0; i < transpose.size(); i++) {
			        cnt[transpose.get(i)]++;
			    }
	
			    //go backwards and find the count with the most occurrences
			    index = cnt.length-1;
			    for (int i=cnt.length-2; i >=0; i--) {
			        if (cnt[i] >= cnt[index])
			            index = i;
			    }
			    System.out.println("\n\n Transpose mode: " + index);

		break;
		case 11:
			// code found on stack over flow
			// find the mode
			
	
				index = 0;
				cnt = new int[1000];
	
			    //count the occurrences
			    for (int i=0; i < MTF.size(); i++) {
			        cnt[MTF.get(i)]++;
			    }
	
			    //go backwards and find the count with the most occurrences
			    index = cnt.length-1;
			    for (int i=cnt.length-2; i >=0; i--) {
			        if (cnt[i] >= cnt[index])
			            index = i;
			    }
			    System.out.println("\n\nMTF mode: " + index);

		break;
		case 12:
			// code found on stack over flow
			// find the mode
			
				index = 0;
			    cnt = new int[1000];
	
			    //count the occurrences
			    for (int i=0; i < count.size(); i++) {
			        cnt[count.get(i)]++;
			    }
	
			    //go backwards and find the count with the most occurrences
			    index = cnt.length-1;
			    for (int i=cnt.length-2; i >=0; i--) {
			        if (cnt[i] >= cnt[index])
			            index = i;
			    }
			    System.out.println("\n\ncount mode: " + index);

		break;
		default:

			for (int i = 0; i < list.size(); i++) {// iterate through the list

				if (i % 15 == 0) {
					System.out.println();
				}
				System.out.printf("[%s,%d,%d] ", list.get(i).get_name(), list
						.get(i).get_count(), list.get(i).get_value());
			}

			break;

		}
	}
}
