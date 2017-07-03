package id.ac.unipma.juzamma.data.db.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

public class Surah {

    @SerializedName("surah_id")
    @Expose
    private Integer surahId;
    @SerializedName("surah_name")
    @Expose
    private String surahName;
    @SerializedName("surah_description")
    @Expose
    private String surahDescription;

    public Integer getSurahId() {
        return surahId;
    }

    public void setSurahId(Integer surahId) {
        this.surahId = surahId;
    }

    public String getSurahName() {
        return surahName;
    }

    public void setSurahName(String surahName) {
        this.surahName = surahName;
    }

    public String getSurahDescription() {
        return surahDescription;
    }

    public void setSurahDescription(String surahDescription) {
        this.surahDescription = surahDescription;
    }
}
