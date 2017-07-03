package id.ac.unipma.juzamma.ui.main.about;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.HashMap;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.ac.unipma.juzamma.R;
import id.ac.unipma.juzamma.di.component.ActivityComponent;
import id.ac.unipma.juzamma.ui.base.BaseFragment;
import id.ac.unipma.juzamma.ui.main.home.HomeMvpPresenter;
import id.ac.unipma.juzamma.ui.main.home.HomeView;
import id.ac.unipma.juzamma.utils.AppConstants;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

public class AboutFragment extends BaseFragment implements AboutView {

    @Inject
    AboutMvpPresenter<AboutView> mPresenter;

    public static AboutFragment newInstance() {
        Bundle args = new Bundle();
        AboutFragment fragment = new AboutFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
            //mOpenSourceAdapter.setCallback(this);
        }

        return view;
    }

    @OnClick(R.id.view_profile)
    void onViewProfile(View v) {
        v.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.image_click));
        viewProfile();
    }

    @OnClick(R.id.contact)
    void onShowContact(View v) {
        v.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.image_click));
        showContact();
    }


    @Override
    protected void setUp(View view) {

    }

    @Override
    public void showContact() {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse(AppConstants.MAIL_TO));
        startActivity(Intent.createChooser(emailIntent, AppConstants.CONTACT));
    }

    @Override
    public void viewProfile() {
        String url = AppConstants.PROFILE_LINK;
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
