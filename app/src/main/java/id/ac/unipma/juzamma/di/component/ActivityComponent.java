package id.ac.unipma.juzamma.di.component;

import dagger.Component;
import id.ac.unipma.juzamma.di.PerActivity;
import id.ac.unipma.juzamma.di.module.ActivityModule;
import id.ac.unipma.juzamma.ui.main.MainActivity;
import id.ac.unipma.juzamma.ui.main.about.AboutFragment;
import id.ac.unipma.juzamma.ui.main.home.HomeFragment;
import id.ac.unipma.juzamma.ui.main.list.ListFragment;
import id.ac.unipma.juzamma.ui.read.ReadActvity;
import id.ac.unipma.juzamma.ui.splash.SplashActivity;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);
    void inject(SplashActivity activity);
    void inject(HomeFragment fragment);
    void inject(ListFragment fragment);
    void inject(AboutFragment fragment);
    void inject(ReadActvity actvity);
}
