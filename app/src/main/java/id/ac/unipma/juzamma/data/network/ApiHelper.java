package id.ac.unipma.juzamma.data.network;

import id.ac.unipma.juzamma.data.network.model.SurahRequest;
import id.ac.unipma.juzamma.data.network.model.SurahResponse;
import id.ac.unipma.juzamma.data.network.model.VerseResponse;
import io.reactivex.Observable;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

public interface ApiHelper {

    Observable<SurahResponse> getAllSurah();

    Observable<VerseResponse> getVerse(int surah_id);
}
