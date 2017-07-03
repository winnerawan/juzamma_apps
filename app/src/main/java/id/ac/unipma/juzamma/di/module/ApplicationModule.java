package id.ac.unipma.juzamma.di.module;

import android.app.Application;
import android.content.Context;



import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import id.ac.unipma.juzamma.data.AppDataManager;
import id.ac.unipma.juzamma.data.DataManager;
import id.ac.unipma.juzamma.data.db.AppDbHelper;
import id.ac.unipma.juzamma.data.db.DbHelper;
import id.ac.unipma.juzamma.data.network.ApiHelper;
import id.ac.unipma.juzamma.data.network.AppApiHelper;
import id.ac.unipma.juzamma.data.prefs.AppPreferencesHelper;
import id.ac.unipma.juzamma.data.prefs.PreferencesHelper;
import id.ac.unipma.juzamma.di.ApplicationContext;
import id.ac.unipma.juzamma.di.PreferenceInfo;
import id.ac.unipma.juzamma.utils.AppConstants;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

}
