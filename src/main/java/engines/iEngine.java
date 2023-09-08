package engines;
import java.util.Map;
import word.*;

public interface iEngine {
    void addWord();
    void modifyWord();
    void deleteWord();
    void saveToFile();
    Map<String, Word> getWordsMap();
}

