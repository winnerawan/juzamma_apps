package id.ac.unipma.juzamma.ui.read;

import java.util.List;

import id.ac.unipma.juzamma.data.db.model.Verse;
import id.ac.unipma.juzamma.ui.base.MvpView;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

public interface ReadView extends MvpView {

    void showVerse(List<Verse> verses);
}
