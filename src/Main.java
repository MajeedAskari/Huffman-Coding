import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

import Huffman.*;
// produce huffman code - tree
// decode using coded text and tree
public class Main {

	public static void main(String[] args) {
		String s = "xxyzpxxsxyyxpyzrrrzxxqyttq";

		File file = new File("text.txt");

		try {
			Scanner sc = new Scanner(file);
			s = sc.next();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		HuffmanEncoder h = new HuffmanEncoder(s);
		String encode = h.encode();
		String tree = h.getTree();
		System.out.println(encode);

		HuffmanDecoder hd = new HuffmanDecoder();
		String val = hd.decode(encode, tree);
		System.out.println(s);
		System.out.println(val);

		BufferedWriter writer = null;
		try {
			File compressedFile = new File("code.txt");
			writer = new BufferedWriter(new FileWriter(compressedFile));
			writer.write(encode);
			writer.newLine();
			writer.write(tree);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (Exception e) {
			}
		}
	}

}
