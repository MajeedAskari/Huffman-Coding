
public class Main {

	public static void main(String[] args) {
		String s = "xxyzpxxsxyyxpyzrrrzxxqyttq";
		Huffman h = new Huffman(s);
		System.out.println(h.encode());
	}

}
