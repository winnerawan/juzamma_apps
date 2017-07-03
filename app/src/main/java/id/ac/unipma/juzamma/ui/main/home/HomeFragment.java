package id.ac.unipma.juzamma.ui.main.home;

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

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import agency.tango.android.avatarview.IImageLoader;
import agency.tango.android.avatarview.loader.PicassoLoader;
import agency.tango.android.avatarview.views.AvatarView;
import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unipma.juzamma.R;
import id.ac.unipma.juzamma.data.db.model.Surah;
import id.ac.unipma.juzamma.di.component.ActivityComponent;
import id.ac.unipma.juzamma.ui.base.BaseFragment;
import id.ac.unipma.juzamma.ui.main.list.SurahAdapter;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

public class HomeFragment extends BaseFragment implements HomeView {

    @Inject
    HomeMvpPresenter<HomeView> mPresenter;

    @Inject
    SurahAdapter mAdapter;

    @Inject
    LinearLayoutManager mLayoutManager;

    @BindView(R.id.slider)
    SliderLayout mSliderLayout;

    @BindView(R.id.recycler_surah)
    RecyclerView mRecyclerView;

    @BindView(R.id.av0)
    AvatarView av0;

    @BindView(R.id.av1)
    AvatarView av1;

    @BindView(R.id.av2)
    AvatarView av2;

    @BindView(R.id.searchtext)
    EditText etSearch;

    IImageLoader mImageLoader = new PicassoLoader();
    List<Surah> mSurah;

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_home, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
            //mOpenSourceAdapter.setCallback(this);
        }

        initializedSlider();

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
        mImageLoader.loadImage(av0, "A", "A");
        mImageLoader.loadImage(av1, "B", "B");
        mImageLoader.loadImage(av2, "C", "C");
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
        mPresenter.onViewPrepared();
        initializedSlider();
    }

    @Override
    public void loadSurah(List<Surah> list) {
        mSurah = list;
        mAdapter.addItems(list);
    }

    @Override
    public void initializedSlider() {

        HashMap<String, String> url_maps = new HashMap<>();
        url_maps.put("1", "http://img09.deviantart.net/2f21/i/2011/328/4/d/labbaik_ya_hussein_by_shiagraphic-d4h5o44.jpg");
        url_maps.put("2", "https://onehdwallpaper.com/wp-content/uploads/2015/07/Bismillah-Islamic-HD-Wallpaper.jpg");
        for (String name : url_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(getActivity());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            //.setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);
            mSliderLayout.addSlider(textSliderView);

            mSliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
            mSliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
            mSliderLayout.setCustomAnimation(new DescriptionAnimation());
            mSliderLayout.setDuration(5000);
            //mSliderLayout.addOnPageChangeListener(this);
            //ListView l = (ListView)findViewById(R.id.transformers);
            //l.setAdapter(new TransformerAdapter(this));
        }
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
