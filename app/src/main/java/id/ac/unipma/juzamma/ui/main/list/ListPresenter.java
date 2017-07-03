package id.ac.unipma.juzamma.ui.main.list;

import com.androidnetworking.error.ANError;

import javax.inject.Inject;

import id.ac.unipma.juzamma.data.DataManager;
import id.ac.unipma.juzamma.data.network.model.SurahResponse;
import id.ac.unipma.juzamma.ui.base.BasePresenter;
import id.ac.unipma.juzamma.ui.main.home.HomeMvpPresenter;
import id.ac.unipma.juzamma.ui.main.home.HomeView;
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

public class ListPresenter<V extends ListView> extends BasePresenter<V> implements ListMvpPresenter<V> {

    @Inject
    public ListPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared() {
        getMvpView().showLoading();
        getCompositeDisposable().add(getDataManager()
                .getAllSurah()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(surahResponse -> {
                    getMvpView().hideLoading();
                    getMvpView().hideKeyboard();
                    if (!surahResponse.getError()) {
                        getMvpView().loadSurah(surahResponse.getSurah());
                    }
                    getMvpView().hideLoading();
                    getMvpView().hideKeyboard();
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
