package id.ac.unipma.juzamma.ui.main.help;

import javax.inject.Inject;

import id.ac.unipma.juzamma.data.DataManager;
import id.ac.unipma.juzamma.ui.base.BasePresenter;
import id.ac.unipma.juzamma.utils.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

public class HelpPresenter<V extends HelpView> extends BasePresenter<V> implements HelpMvpPresenter<V> {

    @Inject
    public HelpPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
