
public class Huffman {
	String s = "", code = "";;
	HuffmanNode[] alphabetArray = new HuffmanNode[26];
	SortedList list = new SortedList();

	public Huffman(String s) {
		this.s = s;
		for (int i = 0; i < 26; i++) {
			alphabetArray[i] = new HuffmanNode((char) (i + 97), 0, null, null);
		}
	}

	public String encode() {
		setFreq();
		makeTree();
		traverse(list.pop(), "");
		assignCode();
		for (int i = 0; i < 26; i++) {
			System.out.println(alphabetArray[i].getChar() + " is " + alphabetArray[i].getCode());
		}

		return code;
	}

	private String assignCode() {
		String code = "";
		for (int i = 0; i < s.length(); i++) {
			code += alphabetArray[((int) s.charAt(i)) - 97].getCode();
		}
		this.code = code;
		return code;
	}

	private void setFreq() {
		for (int i = 0; i < s.length(); i++) {
			alphabetArray[((int) s.charAt(i)) - 97].incrementFrequency();
		}
		for (int i = 0; i < 26; i++) {
			if (alphabetArray[i].getFrequency() > 0)
				list.insert(alphabetArray[i]);
		}
	}

	private void makeTree() {
		while (list.getSize() > 1) {
			HuffmanNode tmp1 = list.pop();
			HuffmanNode tmp2 = list.pop();
			list.insert(new HuffmanNode(' ', tmp1.getFrequency() + tmp2.getFrequency(), tmp1, tmp2));
		}
	}

	private void traverse(HuffmanNode n, String s) {
		if (n.getChar() != ' ') {
			n.setCode(s);
			return;
		}
		if (n.getLeft() != null)
			traverse(n.getLeft(), s + '0');
		if (n.getRight() != null)
			traverse(n.getRight(), s + '1');
	}
}
