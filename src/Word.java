
public class Word {
    private String word_target = "";
    private String word_explain = "";

    public Word() {
        word_target = "";
        word_explain = "";
    }

    public Word(Word d) {
        this.word_target = d.word_target;
        this.word_explain = d.word_explain;
    }

    public void setWord_target(String s) {
        word_target = s;
    }

    public String getWord_target() {
        return this.word_target;
    }

    public void setWord_explain(String s) {
        word_explain = s;
    }

    public String getWord_explain() {
        return this.word_explain;
    }
}
