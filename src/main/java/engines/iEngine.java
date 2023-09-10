package engines;
import java.util.Map;
import word.*;

public interface iEngine {
    void loadFile();
    void addWord();
    void modifyWord();
    void deleteWord();
    void saveToFile();
    Map<String, Word> getWordsMap();
}

