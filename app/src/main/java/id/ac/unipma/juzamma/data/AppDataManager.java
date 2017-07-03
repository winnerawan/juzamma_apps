package id.ac.unipma.juzamma.data;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import id.ac.unipma.juzamma.data.db.DbHelper;
import id.ac.unipma.juzamma.data.network.ApiHelper;
import id.ac.unipma.juzamma.data.network.model.SurahRequest;
import id.ac.unipma.juzamma.data.network.model.SurahResponse;
import id.ac.unipma.juzamma.data.network.model.VerseResponse;
import id.ac.unipma.juzamma.data.prefs.PreferencesHelper;
import id.ac.unipma.juzamma.di.ApplicationContext;
import io.reactivex.Observable;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final DbHelper mDbHelper;
    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          DbHelper dbHelper,
                          PreferencesHelper preferencesHelper,
                          ApiHelper apiHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }

    @Override
    public Observable<SurahResponse> getAllSurah() {
        return mApiHelper.getAllSurah();
    }

    @Override
    public Observable<VerseResponse> getVerse(int surah_id) {
        return mApiHelper.getVerse(surah_id);
    }
}
