package word;

public class Word {
    private int difficulty;
    private String word;
    private String meaning;

    public Word(int difficulty, String word, String meaning) {
        this.difficulty = difficulty;
        this.word = word;
        this.meaning = meaning;
    }
    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getWord() {
        return word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String newMeaning) {
        this.meaning = newMeaning;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(difficulty).append(" ");
        for (int i = 0; i < difficulty; i++) {
            builder.append("*");
        }
        builder.append(" ").append(word).append(" ").append(meaning);
        return builder.toString();
    }
}
