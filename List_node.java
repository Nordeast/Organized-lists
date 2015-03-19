// Written by Allen Rand
public class List_node {
	public int value;
	public String name;
	public int count;

	public List_node(String n, int v, int c) {
		value = v;
		name = n;
		count = c;
	}

	public int get_value() {
		return value;
	}

	public String get_name() {
		return name;
	}

	public int get_count() {
		return count;
	}

	public void incr_count() {
		count++;
	}
}
