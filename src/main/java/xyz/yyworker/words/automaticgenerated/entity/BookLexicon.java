package xyz.yyworker.words.automaticgenerated.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * (BookLexicon)实体类
 *
 * @author makejava
 * @since 2021-12-07 21:37:21
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookLexicon implements Serializable {
    private static final long serialVersionUID = 517436007183912407L;
    
    private Integer id;
    
    private String bookName;
    
    private String word;
    
    private String chineseParaphrase;
    
    private String englishParaphrase;
    
    private Integer lexiconId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getChineseParaphrase() {
        return chineseParaphrase;
    }

    public void setChineseParaphrase(String chineseParaphrase) {
        this.chineseParaphrase = chineseParaphrase;
    }

    public String getEnglishParaphrase() {
        return englishParaphrase;
    }

    public void setEnglishParaphrase(String englishParaphrase) {
        this.englishParaphrase = englishParaphrase;
    }

    public Integer getLexiconId() {
        return lexiconId;
    }

    public void setLexiconId(Integer lexiconId) {
        this.lexiconId = lexiconId;
    }

}

