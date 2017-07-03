package id.ac.unipma.juzamma.di.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import id.ac.unipma.juzamma.JuzzAmmaApplication;
import id.ac.unipma.juzamma.data.DataManager;
import id.ac.unipma.juzamma.di.ApplicationContext;
import id.ac.unipma.juzamma.di.module.ApplicationModule;
import id.ac.unipma.juzamma.service.SyncService;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(JuzzAmmaApplication app);

    void inject(SyncService service);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();}
