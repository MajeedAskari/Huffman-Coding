package Huffman;
import tools.*;

public class HuffmanDecoder {
	HuffmanNode root = null;

	public String decode(String s, String tree) {
		StringbyRef tree2 = new StringbyRef();
		tree2.s = tree;
		root = readTree(tree2);
		return ReplaceCode(s);
	}

	private String ReplaceCode(String code) {
		String val = "";
		HuffmanNode tmp = root;
		for (int i = 0; i < code.length(); i++) {
			if (tmp.getChar() != ' ') {
				val = val + tmp.getChar();
				tmp = root;
			}
			if (code.charAt(i) == '0') {
				tmp = tmp.getLeft();
				if (tmp.getChar() != ' ') {
					val = val + tmp.getChar();
					tmp = root;
				}
			} else {
				tmp = tmp.getRight();
				if (tmp.getChar() != ' ') {
					val = val + tmp.getChar();
					tmp = root;
				}
			}
		}
		return val;
	}

	private HuffmanNode readTree(StringbyRef s) { // makes the tree from string form
		HuffmanNode root = null;
		char nextBit = s.s.charAt(0);
		s.s = s.s.substring(1);
		if (nextBit == '0') {
			root = new HuffmanNode(s.s.charAt(0), -1, null, null);
			s.s = s.s.substring(1);
			return root;
		} else {
			root = new HuffmanNode(' ', -1, null, null);
			root.setLeft(readTree(s));
			root.setRight(readTree(s));
			return root;
		}
	}

}
