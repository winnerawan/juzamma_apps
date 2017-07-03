package id.ac.unipma.juzamma.ui.main.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import agency.tango.android.avatarview.IImageLoader;
import agency.tango.android.avatarview.loader.PicassoLoader;
import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unipma.juzamma.R;
import id.ac.unipma.juzamma.data.db.model.Surah;
import id.ac.unipma.juzamma.di.component.ActivityComponent;
import id.ac.unipma.juzamma.ui.base.BaseFragment;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

public class ListFragment extends BaseFragment implements ListView {

    @Inject
    ListMvpPresenter<ListView> mPresenter;

    @Inject
    SurahAdapter mAdapter;

    @Inject
    LinearLayoutManager mLayoutManager;

    @BindView(R.id.recycler_surah)
    RecyclerView mRecyclerView;

    @BindView(R.id.searchtext)
    EditText etSearch;

    IImageLoader mImageLoader = new PicassoLoader();

    List<Surah> mSurah;


    public static ListFragment newInstance() {
        Bundle args = new Bundle();
        ListFragment fragment = new ListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        getAllowEnterTransitionOverlap();
        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
            //mOpenSourceAdapter.setCallback(this);
        }

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (mSurah !=null) {
                    final List<Surah> filtered = filter(mSurah, etSearch.getText().toString().toLowerCase());
                    mAdapter = new SurahAdapter(filtered);
                    mRecyclerView.setAdapter(mAdapter);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return view;
    }

    @Override
    protected void setUp(View view) {
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
        mPresenter.onViewPrepared();
    }

    @Override
    public void loadSurah(List<Surah> surah) {
        mSurah = surah;
        mAdapter.addItems(surah);
    }

    @Override
    public List<Surah> filter(List<Surah> surahs, String query) {
        query = query.toLowerCase();
        final List<Surah> filtered = new ArrayList<>();
        for (Surah model : surahs) {
            String name = model.getSurahName().toLowerCase();
            String number = model.getSurahId().toString();
            if (name.contains(query) || number.contains(query)) {
                filtered.add(model);
            }
        }
        return filtered;
    }
}
