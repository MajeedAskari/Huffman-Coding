import java.util.ArrayList;

public class SortedList {

	private ArrayList<HuffmanNode> list = new ArrayList<>();

	public void insert(HuffmanNode n) {

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getFrequency() >= n.getFrequency()) {
				list.add(i, n);
			}
		}
	}

	public HuffmanNode pop() {

		return list.remove(0);
	}

	public int getSize() {
		return list.size();
	}
}
