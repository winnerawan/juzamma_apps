package id.ac.unipma.juzamma.ui.main.home;

import id.ac.unipma.juzamma.ui.base.MvpPresenter;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

public interface HomeMvpPresenter<V extends HomeView> extends MvpPresenter<V> {

    void onViewPrepared();
}
