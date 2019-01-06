import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Tagger {
	//der text aus eine file gelsen und in eine liste verwandelt deren einträge immer [wort,tag] sind
	ArrayList<String[]> taggedWords = new ArrayList<String[]>();
	//alle tags die in dem file vorkommen
	ArrayList<String> tags = new ArrayList<String>();
	//position korrespondieren zu den positionen in tags.
	//jeder eintrag ist ein array mit den warscheinlichkeiten dass sie aus dem tag folgen.
	ArrayList<ArrayList<Float>> probabiltys = new ArrayList<ArrayList<Float>>();

	public void read(String file) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(file)));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] taggedline = line.split("\t");
				taggedWords.add(taggedline);
			}

			for (String[] tag : taggedWords) {
				if (!tags.contains(tag[1])) {
					tags.add(tag[1]);
				}
			}
			for (int i = 0; i < tags.size(); i++) {
				String currentTag = tags.get(i);
				ArrayList<Float> currentProbs = new ArrayList<Float>();
				
				for (int j = 0; j < tags.size(); j++) {
					String postTag = tags.get(j);
					float count = 0;
					float tagCount = 0;
					for (String[] tag : taggedWords) {
						if (tag[1].equals(currentTag)) {
							tagCount++;
						}

					}
					for (int k = 0; k < taggedWords.size()-1; k++) {
						if (taggedWords.get(k)[1].equals(currentTag) && taggedWords.get(k + 1)[1].equals(postTag)) {
							count++;
							
						}
					}

					currentProbs.add( (count / tagCount));
					
					 

				}
				System.out.println(currentProbs);
				probabiltys.add(currentProbs);
				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String getNextTag(String currentTag) {
		int tagPos = 0;
		for (int i = 0; i < tags.size(); i++) {
			if(tags.get(i).equals(currentTag)) {
				tagPos = i;
			}
		}
		ArrayList<Float> nextProbs = probabiltys.get(tagPos);
		ArrayList<String> possibleNext = new ArrayList<String>();
		for (int i = 0; i < nextProbs.size(); i++) {
			float poss = 10 * nextProbs.get(i);
			for(int j = 0;j<poss;j++ ) {
				possibleNext.add(tags.get(i));
			}
		}
		int random = (int)(Math.random() * possibleNext.size() + 1);
		return possibleNext.get(random);
	}
	public String getNextWord(String currentTag) {
		String nextTag = getNextTag(currentTag);
		return getWordFromTag(nextTag);
	}
	private String getWordFromTag(String nextTag) {
		// TODO Auto-generated method stub
		ArrayList<String> wordsWithTag = new ArrayList<String>();
		for(String[] word : taggedWords) {
			if(word[1].equals(nextTag)) {
				wordsWithTag.add(word[0]);
			}
		}
		return wordsWithTag.get((int)(Math.random() * wordsWithTag.size()+0));
	}
	public String getTagFromWord(String word) {
		for(String[]tag :taggedWords) {
			if(tag[0].equals(word)) {
				return tag[1];
			}
		}
		return "not in DB";
	}
	public ArrayList<String> makePoStags(ArrayList<String> words){
		ArrayList<String> poStags = new ArrayList<String>();
		for(String word:words) {
			poStags.add(getTagFromWord(word));
		}
		return poStags;
	}
}
