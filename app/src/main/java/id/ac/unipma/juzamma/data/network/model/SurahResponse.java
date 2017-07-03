package id.ac.unipma.juzamma.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import id.ac.unipma.juzamma.data.db.model.Surah;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

public class SurahResponse {

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("surah")
    @Expose
    private List<Surah> surah = null;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public List<Surah> getSurah() {
        return surah;
    }

    public void setSurah(List<Surah> surah) {
        this.surah = surah;
    }
}
