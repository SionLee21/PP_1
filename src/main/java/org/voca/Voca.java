package org.voca;
import word.*;
import java.util.Scanner;
import java.util.List;
import engines.*;
public class Voca implements iVoca{
    Scanner scanner = new Scanner(System.in);
    Engines myEngine = new Engines();
    public static void main(String[] args) {
        Voca myVoca = new Voca();
        myVoca.run();
    }
    public void run() {
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
                case 0:
                    System.out.println("프로그램 종료! 다음에 만나요~");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("유효하지 않은 메뉴 선택입니다.");
            }
                    /*
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


                     */
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
        List<Word> words = myEngine.getWords(); // Engines 클래스의 getWords() 메서드로 단어 목록 가져오기
        if (words.isEmpty()) {
            System.out.println("입력된 단어가 없습니다.");
        } else {
            System.out.println("--------------------------------");
            for (Word word : words) {
                System.out.println(word);
            }
            System.out.println("--------------------------------");
        }
    }


    @Override
    public void displayWordsByDifficulty() {
        int difficultyFilter;

        // 유효한 난이도가 입력될 때까지 대기
        while (true) {
            System.out.print("난이도(1, 2, 3): ");
            difficultyFilter = scanner.nextInt();

            if (difficultyFilter == 1 || difficultyFilter == 2 || difficultyFilter == 3) {
                break; // 유효한 난이도가 입력되면 루프 종료
            } else {
                System.out.println("유효하지 않은 입력입니다. 다시 입력하세요.");
                scanner.nextLine(); // 잘못된 입력 값을 스캔하고 버림
            }
        }

        List<Word> words = myEngine.getWords();
        boolean foundWords = false; // 해당 난이도의 단어를 찾았는지 여부를 나타내는 변수

        System.out.println("--------------------------------");
        for (Word word : words) {
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
        System.out.print("단어 검색: ");
        String searchWord = scanner.nextLine();

        List<Word> words = myEngine.getWords();
        boolean foundWord = false; // 검색된 단어를 찾았는지 여부를 나타내는 변수

        System.out.println("--------------------------------");
        for (Word word : words) {
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


