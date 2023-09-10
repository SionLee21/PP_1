package org.voca;
import word.Word;
import java.util.*;
import engines.* ;
import java.io.FileReader;
public class Voca implements iVoca {
    Scanner scanner = new Scanner(System.in);
    Engines myEngine = new Engines();

    public static void main(String[] args) {
        Voca myVoca = new Voca();
        myVoca.run();
    }

    public void run() {
        myEngine.loadFile();
        System.out.println("*** 영단어 마스터 ***");
        while (true) {
            switch (displayMenu()) {
                case 1:
                    displayAllWords();
                    break;
                case 2:
                    displayWordsByDifficulty();
                    break;
                case 3:
                    searchWord();
                    break;
                case 4:
                    myEngine.addWord();
                    break;
                case 5:
                    myEngine.modifyWord();
                    break;
                case 6:
                    myEngine.deleteWord();
                    break;
                case 7:
                    myEngine.saveToFile();
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
        System.out.print(
                "\n********************\n" +
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
        Map<String, Word> wordsMap = myEngine.getWordsMap();
        if (wordsMap.isEmpty()) {
            System.out.println("입력된 단어가 없습니다.");
        } else {
            System.out.println("--------------------------------");
            for (Word word : wordsMap.values()) {
                System.out.println(word);
            }
            System.out.println("--------------------------------");
        }
    }

    @Override
    public void displayWordsByDifficulty() {
        int difficultyFilter;
        while (true) {
            System.out.print("난이도(1, 2, 3): ");
            difficultyFilter = scanner.nextInt();

            if (difficultyFilter == 1 || difficultyFilter == 2 || difficultyFilter == 3) {
                break;
            } else {
                System.out.println("유효하지 않은 입력입니다. 다시 입력하세요.");
                scanner.nextLine();
            }
        }

        Map<String, Word> wordsMap = myEngine.getWordsMap();
        boolean foundWords = false;

        System.out.println("--------------------------------");
        for (Word word : wordsMap.values()) {
            if (word.getDifficulty() == difficultyFilter) {
                System.out.println(word);
                foundWords = true;
            }
        }

        if (!foundWords) {
            System.out.println("해당 난이도의 단어가 없습니다.");
        }
        System.out.println("--------------------------------");
    }

    @Override
    public void searchWord() {
        scanner.nextLine();
        System.out.print("단어 검색: ");
        String searchWord = scanner.nextLine();

        Map<String, Word> wordsMap = myEngine.getWordsMap();
        boolean foundWord = false;

        System.out.println("--------------------------------");
        for (Word word : wordsMap.values()) {
            if (word.getWord().equalsIgnoreCase(searchWord)) {
                System.out.println(word.getWord() + ": " + word.getMeaning());
                foundWord = true;
            }
        }

        if (!foundWord) {
            System.out.println("해당 단어를 찾을 수 없습니다.");
        }
        System.out.println("--------------------------------");
    }
}

