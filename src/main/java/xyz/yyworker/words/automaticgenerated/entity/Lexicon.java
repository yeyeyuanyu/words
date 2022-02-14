package xyz.yyworker.words.automaticgenerated.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * (Lexicon)实体类
 *
 * @author makejava
 * @since 2021-12-07 21:41:32
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Lexicon implements Serializable {
    private static final long serialVersionUID = -24503067527225441L;
    
    private Integer id;
    
    private String word;
    
    private String wav;

    public Lexicon(String word, String wav) {
        this.word = word;
        this.wav = wav;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWav() {
        return wav;
    }

    public void setWav(String wav) {
        this.wav = wav;
    }

}

