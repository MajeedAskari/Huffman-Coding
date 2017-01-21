package tools;

import java.util.ArrayList;

public class SortedList {

	private ArrayList<HuffmanNode> list = new ArrayList<HuffmanNode>();

	public void insert(HuffmanNode n) {
		for (int i = 0; i <= list.size(); i++) {
			if (i == list.size() || list.get(i).getFrequency() >= n.getFrequency()) {
				list.add(i, n);
				break;
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
