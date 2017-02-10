package com.google.engedu.anagrams;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class AnagramDictionary {

    private static final int MIN_NUM_ANAGRAMS = 5;
    private static final int DEFAULT_WORD_LENGTH = 3;
    private static final int MAX_WORD_LENGTH = 7;
    private Random random = new Random();
    private HashSet<String> wordSet;
    private ArrayList<String> wordList;
    private HashMap<String,ArrayList<String>> lettersToWord;

    public AnagramDictionary(InputStream wordListStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(wordListStream));
        wordSet = new HashSet<>();
        wordList = new ArrayList<>();
        lettersToWord = new HashMap<>();
        populateData(in);
    }

    private void populateData(BufferedReader in) throws IOException {

        String line = "";
        while((line = in.readLine()) != null) {
            String word = line.trim();
            wordSet.add(word);
            wordList.add(word);
            String orderedWord = orderedLetters(word);
            if(!lettersToWord.containsKey(orderedWord)) {
                lettersToWord.put(orderedWord, new ArrayList<String>());
            }
            ArrayList<String> list = lettersToWord.get(orderedWord);
            list.add(word);
            lettersToWord.put(orderedWord, list);
        }
    }

    public String orderedLetters(String word){

        char[] wordArray = word.toCharArray();
        Arrays.sort(wordArray);
        return new String(wordArray);
    }

    public boolean isGoodWord(String word, String base) {

        return !word.contains(base) && wordSet.contains(word);

    }

    public ArrayList<String> getAnagramsWithOneMoreLetter(String word) {
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<Character> wordArray = new ArrayList<>();
        for(char c: word.toCharArray()){
            wordArray.add(c);
        }

        for(int i= (int)'a';i<=(int)'z';i++){
            wordArray.add(wordArray.size(), (char)i);
            addAnagrams(result,new ArrayList<>(wordArray),word);
            wordArray.remove(wordArray.size()-1);
        }
        return result;
    }


    private void addAnagrams(ArrayList<String> result,ArrayList<Character> wordArray,String word){
        Collections.sort(wordArray);
        StringBuilder builder = new StringBuilder();
        for(Character c: wordArray){
            builder.append(c);
        }
        if(lettersToWord.containsKey(builder.toString())){
            for(String s:lettersToWord.get(builder.toString())){
                if(isGoodWord(s,word))
                    result.add(s);
            }

        }

    }

    public String pickGoodStarterWord() {

        Random random = new Random();
        String word ="";
        int wordIndex = random.nextInt(wordList.size()-1);
        for(int i= wordIndex;i<wordList.size()-1;i++) {
            if((wordList.get(i).length()<4) ) {
                word = wordList.get(i);
                break;
            }
        }
        return word;
    }
}
