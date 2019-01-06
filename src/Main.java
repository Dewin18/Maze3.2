import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Tagger tag = new Tagger();
		tag.read("src/exampletext.txt");
		System.out.println(tag.getNextTag("tag7"));
		System.out.println(tag.getNextWord("tag7"));
		System.out.println(tag.getTagFromWord("word3"));
		ArrayList<String> words =new ArrayList<String>();
		words.add("word1");
		words.add("word12");
		words.add("word3");
		words.add("word4");
		System.out.println(tag.makePoStags(words));
		// TODO Auto-generated method stub

	}

}
