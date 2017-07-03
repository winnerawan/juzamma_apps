package id.ac.unipma.juzamma.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import id.ac.unipma.juzamma.data.db.model.Verse;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

public class VerseResponse {

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("verse")
    @Expose
    private List<Verse> verse = null;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public List<Verse> getVerse() {
        return verse;
    }

    public void setVerse(List<Verse> verse) {
        this.verse = verse;
    }
}
