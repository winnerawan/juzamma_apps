package id.ac.unipma.juzamma.ui.main.list;

import id.ac.unipma.juzamma.ui.base.MvpPresenter;
import id.ac.unipma.juzamma.ui.main.home.HomeView;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

public interface ListMvpPresenter<V extends ListView> extends MvpPresenter<V> {


    void onViewPrepared();
}
