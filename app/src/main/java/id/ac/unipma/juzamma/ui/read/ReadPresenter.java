package id.ac.unipma.juzamma.ui.read;

import com.androidnetworking.error.ANError;
import com.google.gson.Gson;

import javax.inject.Inject;

import id.ac.unipma.juzamma.data.DataManager;
import id.ac.unipma.juzamma.data.network.model.VerseResponse;
import id.ac.unipma.juzamma.ui.base.BasePresenter;
import id.ac.unipma.juzamma.utils.AppLogger;
import id.ac.unipma.juzamma.utils.rx.SchedulerProvider;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

public class ReadPresenter<V extends ReadView> extends BasePresenter<V> implements ReadMvpPresenter<V> {

    @Inject
    public ReadPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onSurahSelected(int surah_id) {
        getMvpView().showLoading();
        getCompositeDisposable().add(getDataManager()
                .getVerse(surah_id)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(verseResponse -> {
                    if (verseResponse!=null && !verseResponse.getError()) {
                        getMvpView().showVerse(verseResponse.getVerse());
                        AppLogger.e(new Gson().toJson(verseResponse));
                    }
                    getMvpView().hideLoading();
                }, throwable -> {
                    if (!isViewAttached()) {
                        return;
                    }

                    getMvpView().hideLoading();

                    // handle the error here
                    if (throwable instanceof ANError) {
                        ANError anError = (ANError) throwable;
                        handleApiError(anError);
                    }
                }));
    }
}
