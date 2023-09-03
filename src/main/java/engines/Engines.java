package engines;
import java.util.Scanner;
import java.util.List;
import word.*;
import java.util.ArrayList;
public class Engines implements iEngine{
    List<Word> words;
    public Engines() {
        words = new ArrayList<>(); // ArrayList로 초기화
    }
    public void addWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("난이도(1,2,3) & 새 단어 입력: ");
        int newDifficulty = scanner.nextInt();
        String newWord = scanner.nextLine();
        System.out.print("뜻 입력: ");
        String newMeaning = scanner.nextLine();
        Word word = new Word(newDifficulty, newWord, newMeaning);
        words.add(word);
        System.out.println("\n새 단어가 단어장에 추가되었습니다 !!!");
    }

    @Override
    public List<Word> getWords() {
        return words;
    }
}
