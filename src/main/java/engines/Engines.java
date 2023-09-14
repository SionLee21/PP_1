package engines;
import word.*;
import java.io.*;
import java.util.*;

public class Engines implements iEngine {
    Map<String, Word> wordsMap; // 단어를 이름으로 관리하기 위한 Map

    public Engines() {
        wordsMap = new HashMap<>(); // HashMap으로 초기화
        loadFile();
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
        System.out.print("수정할 단어 검색: ");
        String modifyWord = scanner.nextLine().toLowerCase();

        List<Word> foundWords = new ArrayList<>();

        System.out.println("--------------------------------");
        int index = 1;
        for (Word word : wordsMap.values()) {
            if (word.getWord().toLowerCase().contains(modifyWord)) {
                foundWords.add(word);
                System.out.println(index + " " + word.getWord() + " " + word.getMeaning());
                index++;
            }
        }

        if (foundWords.isEmpty()) {
            System.out.println("해당 단어를 찾을 수 없습니다.");
        } else {
            System.out.print("수정할 번호 선택: ");
            int selectedIndex = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            if (selectedIndex >= 1 && selectedIndex <= foundWords.size()) {
                Word selectedWord = foundWords.get(selectedIndex - 1);
                System.out.print("새로운 뜻 입력: ");
                String newMeaning = scanner.nextLine();
                selectedWord.setMeaning(newMeaning);
                System.out.println("\n단어가 수정되었습니다 !!!");
            } else {
                System.out.println("유효하지 않은 번호입니다.");
            }
        }
    }

    @Override
    public void deleteWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("삭제할 단어 검색: ");
        String deleteWord = scanner.nextLine().toLowerCase();

        List<Word> foundWords = new ArrayList<>();

        System.out.println("--------------------------------");
        int index = 1;
        for (Word word : wordsMap.values()) {
            if (word.getWord().toLowerCase().contains(deleteWord)) {
                foundWords.add(word);
                System.out.println(index + " " + word.getWord() + " " + word.getMeaning());
                index++;
            }
        }

        if (foundWords.isEmpty()) {
            System.out.println("해당 단어를 찾을 수 없습니다.");
        } else {
            System.out.print("=> 삭제할 번호 선택: ");
            int selectedIndex = scanner.nextInt();
            scanner.nextLine();
            if (selectedIndex >= 1 && selectedIndex <= foundWords.size()) {
                System.out.print("=> 정말로 삭제하실래요?(Y/n) ");
                char tf = scanner.next().charAt(0);
                if (tf == 'y' || tf == 'Y') {
                    Word selectedWord = foundWords.get(selectedIndex - 1);
                    wordsMap.remove(selectedWord.getWord());
                    System.out.println("\n선택한 단어 삭제 완료 !!! ");
                } else {
                    System.out.println("삭제를 취소했습니다.");
                }
            } else {
                System.out.println("유효하지 않은 번호입니다.");
            }
        }
    }



    @Override
    public void loadFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("voca.txt"))) {
            String line;
            int count = 0;
            boolean isEmpty = true; // 파일이 비어있는지 여부를 나타내는 변수

            while ((line = reader.readLine()) != null) {
                // 각 줄을 공백을 기준으로 단어와 뜻으로 분리
                String[] parts = line.split(" ", 3);

                // 올바르게 분리되지 않으면 건너뜀
                if (parts.length < 3) {
                    continue;
                }

                int loadedDifficulty = Integer.parseInt(parts[0]);
                String loadedWord = parts[1];
                String loadedMeaning = parts[2];

                // 별표를 제거
                loadedWord = loadedWord.replaceAll("\\*", "");
                Word word = new Word(loadedDifficulty, loadedWord, loadedMeaning);
                wordsMap.put(loadedWord.trim(), word);

                count++;
                isEmpty = false; // 파일이 비어있지 않음을 표시
            }

            if (isEmpty) {
                System.out.println("파일에 불러올 단어가 없습니다.");
            } else {
                System.out.println("=> " + count + "개 단어 로딩 완료!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("불러올 파일이 존재하지 않습니다.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("파일 불러오기 중 오류가 발생했습니다.");
        }
    }




    @Override
    public void saveToFile() {
        List<Word> words = new ArrayList<>(wordsMap.values());

        try (FileWriter fileWriter = new FileWriter("voca.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            for (Word word : words) {
                bufferedWriter.write(word.toString());
                bufferedWriter.newLine();
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
