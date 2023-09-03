package org.voca;
import menu.Menu;
public class Voca implements iVoca{
    public static void main(String[] args) {
        Voca myVoca = new Voca();
        myVoca.run();
    }
    public void run(){
        while(true){

        }
    }

    @Override
    public void displayMenu() {

    }

    @Override
    public void addWord(int difficulty, String word, String meaning) {

    }

    @Override
    public void displayAllWords() {

    }

    @Override
    public void displayWordsByDifficulty(int difficulty) {

    }

    @Override
    public String searchWord(String word) {
        return null;
    }

    @Override
    public void modifyWord(String word, String newMeaning) {

    }

    @Override
    public void deleteWord(String word) {

    }

    @Override
    public void saveToFile() {

    }

    @Override
    public void exit() {

    }
}


