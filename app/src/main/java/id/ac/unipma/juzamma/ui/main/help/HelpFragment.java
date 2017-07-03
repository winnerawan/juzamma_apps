package id.ac.unipma.juzamma.ui.main.help;

import android.os.Bundle;
import android.view.View;

import javax.inject.Inject;

import id.ac.unipma.juzamma.ui.base.BaseFragment;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

public class HelpFragment extends BaseFragment implements HelpView {

    @Inject
    HelpMvpPresenter<HelpView> mPresenter;


    public static HelpFragment newInstance() {
        Bundle args = new Bundle();
        HelpFragment fragment = new HelpFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setUp(View view) {

    }
}
