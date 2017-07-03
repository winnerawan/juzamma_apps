package id.ac.unipma.juzamma.ui.read;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unipma.juzamma.R;
import id.ac.unipma.juzamma.data.db.model.Verse;
import id.ac.unipma.juzamma.di.component.ActivityComponent;
import id.ac.unipma.juzamma.ui.base.BaseActivity;
import id.ac.unipma.juzamma.ui.base.BaseFragment;
import id.ac.unipma.juzamma.ui.helper.GlowingText;
import id.ac.unipma.juzamma.ui.main.MainActivity;
import id.ac.unipma.juzamma.utils.AppConstants;
import id.ac.unipma.juzamma.utils.AppLogger;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

public class ReadActvity extends BaseActivity implements ReadView {

    private static final String TAG = "ReadActvity";
    @Inject
    ReadMvpPresenter<ReadView> mPresenter;

    @Inject
    VerseAdapter mAdapter;

    @BindView(R.id.recycler_verse)
    RecyclerView mRecyclerView;

    GlowingText mGlowText;

    float startGlowRadius = 6f,         // Glowing starts with this Intensity
            minGlowRadius = 3f,         // Minimum Glowing Intensity
            maxGlowRadius = 15f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);

        setUp();


    }

    @Override
    protected void setUp() {
        Bundle bundle = getIntent().getExtras();
        int surah_id = bundle.getInt(AppConstants.SURAH_ID);
        mPresenter.onSurahSelected(surah_id);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


    }

    @Override
    public void showVerse(List<Verse> verses) {
        mAdapter.addItems(verses);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
