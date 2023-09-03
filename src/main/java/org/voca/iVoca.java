package org.voca;

public interface iVoca {
    void displayMenu();
    void addWord(int difficulty, String word, String meaning);
    void displayAllWords();
    void displayWordsByDifficulty(int difficulty);
    String searchWord(String word);
    void modifyWord(String word, String newMeaning);
    void deleteWord(String word);
    void saveToFile();
    void exit();
}
