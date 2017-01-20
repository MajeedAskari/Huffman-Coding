
public class Huffman {
	String s = "";
	HuffmanNode[] alphabetArray = new HuffmanNode[26];
	SortedList list = new SortedList();

	public Huffman(String s) {
		this.s = s;
	}

	public String encode() {
		setFreq();
		while (list.getSize() > 1) {
			HuffmanNode tmp1 = list.pop();
			HuffmanNode tmp2 = list.pop();
			list.insert(new HuffmanNode(' ', tmp1.getFrequency() + tmp2.getFrequency(), tmp1, tmp2));
		}

		return null;
	}

	private void traverse(HuffmanNode n, String s){
		if(n.getChar() == ' '){
			n.setCode(s);
			return;
		}
		if(n.getLeft() != null)
		traverse(n.getLeft(), s + '0');
		if(n.getRight()) != null)
		traverse(n.getRight(), s + '1');
	}

	private void setFreq() {

		for (int i = 0; i < 26; i++) {
			alphabetArray[i] = new HuffmanNode((char) (i + 97), 0, null, null);
		}
		for (int i = 0; i < s.length(); i++) {
			alphabetArray[((int) s.charAt(i)) - 97].incrementFrequency();
			list.insert(alphabetArray[((int) s.charAt(i)) - 97]);
		}
	}
}
