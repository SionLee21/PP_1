package org.voca;
import java.util.Scanner;

public class Voca implements iVoca{
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Voca myVoca = new Voca();
        myVoca.run();
    }
    public void run() {
        while (true) {
            switch (displayMenu()) {
                case 1:
                    voca.displayAllWords();
                    break;
                case 2:
                    System.out.print("난이도(1,2,3): ");
                    int difficulty = scanner.nextInt();
                    dictionary.displayWordsByDifficulty(difficulty);
                    break;
                case 3:
                    System.out.print("단어 검색: ");
                    String searchWord = scanner.nextLine();
                    String meaning = dictionary.searchWord(searchWord);
                    System.out.println(meaning);
                    break;
                case 4:
                    System.out.print("난이도(1,2,3) & 새 단어 입력: ");
                    int newDifficulty = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.print("새 단어 입력: ");
                    String newWord = scanner.nextLine();
                    System.out.print("뜻 입력: ");
                    String newMeaning = scanner.nextLine();
                    dictionary.addWord(newDifficulty, newWord, newMeaning);
                    break;
                case 5:
                    System.out.print("수정할 단어 입력: ");
                    String wordToModify = scanner.nextLine();
                    System.out.print("새 뜻 입력: ");
                    String newWordMeaning = scanner.nextLine();
                    dictionary.modifyWord(wordToModify, newWordMeaning);
                    break;
                case 6:
                    System.out.print("삭제할 단어 입력: ");
                    String wordToDelete = scanner.nextLine();
                    dictionary.deleteWord(wordToDelete);
                    break;
                case 7:
                    dictionary.saveToFile();
                    break;
                case 0:
                    System.out.println("프로그램 종료! 다음에 만나요~");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("유효하지 않은 메뉴 선택입니다.");
            }
        }
    }

    @Override
    public int displayMenu() {
        System.out.println(
                "*** 영단어 마스터 ***\n" +
                "********************\n" +
                "1. 모든 단어 보기\n" +
                "2. 수준별 단어 보기\n" +
                "3. 단어 검색\n" +
                "4. 단어 추가\n" +
                "5. 단어 수정\n" +
                "6. 단어 삭제\n" +
                "7. 파일 저장\n" +
                "0. 나가기\n" +
                "********************\n" +
                "=> 원하는 메뉴는? "
        );
        return scanner.nextInt();
    }


    @Override
    public void displayAllWords() {
        System.out.println("--------------------------------");
        for (Word word : words) {
            System.out.println(word);
        }
        System.out.println("--------------------------------");
    }
/*
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
    */
}


