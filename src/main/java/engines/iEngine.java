package engines;
import java.util.List;
import word.*;
public interface iEngine {
    void addWord();
    List<Word> getWords();

    /*
    void modifyWord(String word, String newMeaning);
    void deleteWord(String word);
    void saveToFile();
    void exit();


     */
}
