package id.ac.unipma.juzamma.data.network;

import com.rx2androidnetworking.Rx2AndroidNetworking;

import javax.inject.Inject;
import javax.inject.Singleton;

import id.ac.unipma.juzamma.data.db.model.Surah;
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

@Singleton
public class AppApiHelper implements ApiHelper {

    @Inject
    public AppApiHelper() {
    }

    @Override
    public Observable<SurahResponse> getAllSurah() {
        return Rx2AndroidNetworking.get(ApiEndPoint.END_POINT_LIST)
                .build()
                .getObjectObservable(SurahResponse.class);
    }

    @Override
    public Observable<VerseResponse> getVerse(int surah_id) {
        return Rx2AndroidNetworking.get(ApiEndPoint.END_POINT_SURAH+surah_id)
                .build()
                .getObjectObservable(VerseResponse.class);
    }
}
