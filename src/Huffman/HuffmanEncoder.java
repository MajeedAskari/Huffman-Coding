package Huffman;
import tools.*;

public class HuffmanEncoder {
	String s = "", code = "";;
	HuffmanNode[] alphabetArray = new HuffmanNode[26];
	SortedList list = new SortedList();
	HuffmanNode root = null;

	public HuffmanEncoder(String s) {
		this.s = s;
		for (int i = 0; i < 26; i++) {
			alphabetArray[i] = new HuffmanNode((char) (i + 97), 0, null, null);
		}
	}

	public String encode() {

		setFreq(); // determine freq of each char (node)
		makeTree(); // makes the tree using huffman algorithm
		root = list.pop();
		traverse(root, ""); // set each characters code
		replaceCode(); // replace the chars whith their codes
		
		// printing each characters code
		for (int i = 0; i < 26; i++) {
			if (alphabetArray[i].getFrequency() > 0)
				System.out.println(alphabetArray[i].getChar() + " is " + alphabetArray[i].getCode());
		}
		return code;
	}

	public String getTree() { // return tree in string form
		if (root == null)
			encode();
		StringbyRef tree = new StringbyRef();
		writeTree(root, tree);
		return tree.s;
	}
// recursive code to put tree structure in a string efficiently
	private void writeTree(HuffmanNode n, StringbyRef s) {
		if (n.getChar() != ' ')
			s.s = s.s + '0' + n.getChar();

		else {
			s.s = s.s + '1';
			if (n.getLeft() != null)
				writeTree(n.getLeft(), s);
			if (n.getRight() != null)
				writeTree(n.getRight(), s);
		}
	}

	private String replaceCode() {
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
