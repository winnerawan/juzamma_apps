package id.ac.unipma.juzamma.data.db.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

public class Verse {

    @SerializedName("verse_id")
    @Expose
    private Integer verseId;
    @SerializedName("verse_index")
    @Expose
    private Integer verseIndex;
    @SerializedName("verse_arabic")
    @Expose
    private String verseArabic;
    @SerializedName("verse_text")
    @Expose
    private String verseText;
    @SerializedName("verse_translation_id")
    @Expose
    private String verseTranslationId;
    @SerializedName("verse_translation_en")
    @Expose
    private String verseTranslationEn;
    @SerializedName("verse_path_audio")
    @Expose
    private String versePathAudio;

    public Integer getVerseId() {
        return verseId;
    }

    public void setVerseId(Integer verseId) {
        this.verseId = verseId;
    }

    public Integer getVerseIndex() {
        return verseIndex;
    }

    public void setVerseIndex(Integer verseIndex) {
        this.verseIndex = verseIndex;
    }

    public String getVerseArabic() {
        return verseArabic;
    }

    public void setVerseArabic(String verseArabic) {
        this.verseArabic = verseArabic;
    }

    public String getVerseText() {
        return verseText;
    }

    public void setVerseText(String verseText) {
        this.verseText = verseText;
    }

    public String getVerseTranslationId() {
        return verseTranslationId;
    }

    public void setVerseTranslationId(String verseTranslationId) {
        this.verseTranslationId = verseTranslationId;
    }

    public String getVerseTranslationEn() {
        return verseTranslationEn;
    }

    public void setVerseTranslationEn(String verseTranslationEn) {
        this.verseTranslationEn = verseTranslationEn;
    }

    public String getVersePathAudio() {
        return versePathAudio;
    }

    public void setVersePathAudio(String versePathAudio) {
        this.versePathAudio = versePathAudio;
    }
}
