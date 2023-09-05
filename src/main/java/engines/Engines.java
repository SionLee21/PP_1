package engines;
import word.*;
import java.io.*;
import java.util.*;

public class Engines implements iEngine {
    Map<String, Word> wordsMap; // 단어를 이름(단어)으로 관리하기 위한 Map

    public Engines() {
        wordsMap = new HashMap<>(); // HashMap으로 초기화
    }

    @Override
    public void addWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("난이도(1,2,3) & 새 단어 입력: ");
        int newDifficulty = scanner.nextInt();
        String newWord = scanner.next();
        scanner.nextLine(); // 개행문자 제거
        System.out.print("뜻 입력: ");
        String newMeaning = scanner.nextLine();
        // 이미 단어가 있는지 확인하고, 중복된 단어는 추가하지 않음
        if (wordsMap.containsKey(newWord)) {
            System.out.println("이미 존재하는 단어입니다.");
        } else {
            Word word = new Word(newDifficulty,newWord, newMeaning);
            wordsMap.put(newWord, word);
            System.out.println("\n새 단어가 단어장에 추가되었습니다 !!!");
        }
    }

    @Override
    public void modifyWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("수정할 단어 입력: ");
        String modifyWord = scanner.nextLine();
        // 수정할 단어가 단어장에 있는지 확인
        if (wordsMap.containsKey(modifyWord)) {
            System.out.print("새로운 뜻 입력: ");
            String newMeaning = scanner.nextLine();
            Word word = wordsMap.get(modifyWord);
            word.setMeaning(newMeaning);
            System.out.println("\n단어가 수정되었습니다 !!!");
        } else {
            System.out.println("단어장에 없는 단어입니다.");
        }
    }

    @Override
    public void deleteWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("삭제할 단어 입력: ");
        String deleteWord = scanner.nextLine();

        // 삭제할 단어가 단어장에 있는지 확인
        if (wordsMap.containsKey(deleteWord)) {
            wordsMap.remove(deleteWord);
            System.out.println("\n단어가 삭제되었습니다 !!!");
        } else {
            System.out.println("단어장에 없는 단어입니다.");
        }
    }

    @Override
    public void saveToFile() {
        // 파일 저장 코드는 이전과 동일하게 사용 가능
        // 단, 단어를 리스트 대신 Map에서 가져와야 함
        List<Word> words = new ArrayList<>(wordsMap.values());

        try (FileWriter fileWriter = new FileWriter("voca.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            for (Word word : words) {
                bufferedWriter.write(word.toString()); // 단어 객체를 문자열로 변환하여 파일에 쓰기
                bufferedWriter.newLine(); // 새로운 줄로 이동
            }

            System.out.println("파일에 저장되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("파일 저장 중 오류가 발생했습니다.");
        }
    }

    @Override
    public Map<String, Word> getWordsMap() {
        return wordsMap;
    }
}
