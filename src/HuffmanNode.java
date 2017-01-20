
public class HuffmanNode {
	private char Char;
	private int frequency;
	private HuffmanNode left, right;
	String code = "";

	HuffmanNode(char ch, int frequency, HuffmanNode left, HuffmanNode right) {
		this.Char = ch;
		this.frequency = frequency;
		this.left = left;
		this.right = right;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public char getChar() {
		return Char;
	}

	public void incrementFrequency() {
		this.frequency = frequency + 1;
	}

	public void setChar(char ch) {
		this.Char = ch;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public HuffmanNode getLeft() {
		return left;
	}

	public void setLeft(HuffmanNode left) {
		this.left = left;
	}

	public HuffmanNode getRight() {
		return right;
	}

	public void setRight(HuffmanNode right) {
		this.right = right;
	}

}
