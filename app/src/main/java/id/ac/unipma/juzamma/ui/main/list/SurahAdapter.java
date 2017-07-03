package id.ac.unipma.juzamma.ui.main.list;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import agency.tango.android.avatarview.IImageLoader;
import agency.tango.android.avatarview.loader.PicassoLoader;
import agency.tango.android.avatarview.views.AvatarView;
import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unipma.juzamma.R;
import id.ac.unipma.juzamma.data.db.model.Surah;
import id.ac.unipma.juzamma.ui.base.BaseViewHolder;
import id.ac.unipma.juzamma.ui.read.ReadActvity;
import id.ac.unipma.juzamma.utils.AppConstants;
import id.ac.unipma.juzamma.utils.AppLogger;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

public class SurahAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;

    private Callback mCallback;
    private List<Surah> mSurahs;

    public SurahAdapter(List<Surah> surahs) {
        mSurahs = surahs;
    }

    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new ViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.list_surah, parent, false));
            case VIEW_TYPE_EMPTY:
            default:
                return new EmptyViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.list_surah, parent, false));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mSurahs != null && mSurahs.size() > 0) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public int getItemCount() {
        if (mSurahs != null && mSurahs.size() > 0) {
            return mSurahs.size();
        } else {
            return 1;
        }
    }

    public void addItems(List<Surah> list) {
        mSurahs.addAll(list);
        notifyDataSetChanged();
    }


    public interface Callback {
        void onBlogEmptyViewRetryClick();
    }

    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.surah_image)
        AvatarView avSurah;

        @BindView(R.id.surah_name)
        TextView tvSurahName;

        @BindView(R.id.surah_desc)
        TextView tvSurahDesc;

        IImageLoader mImageLoader = new PicassoLoader();

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        protected void clear() {
            tvSurahName.setText("");
            tvSurahDesc.setText("");
        }

        public void onBind(int position) {
            super.onBind(position);

            final Surah surah = mSurahs.get(position);

            if (surah.getSurahName() != null) {
                tvSurahName.setText(surah.getSurahName());
                mImageLoader.loadImage(avSurah, surah.getSurahName(), surah.getSurahName());
            }

            if (surah.getSurahDescription() != null) {
                tvSurahDesc.setText(surah.getSurahDescription());
            }


            itemView.setOnClickListener(v -> {
                if (surah.getSurahName() != null) {

                    Intent i = new Intent(v.getContext(), ReadActvity.class);
                    i.putExtra(AppConstants.SURAH_ID, surah.getSurahId());
                    v.getContext().startActivity(i);
                    //fragment.setEnterTransition(TransitionInflater.from(v.getContext()).inflateTransition(android.R.anim.fade_in));
//                    ((FragmentActivity) v.getContext())
//                            .getSupportFragmentManager()
//                            .beginTransaction()
//                            //.addToBackStack(null)
//                            .replace(R.id.fragment_surah, fragment, "ReadActvity")
//                            .commit();
                }
            });
        }
    }

    public class EmptyViewHolder extends BaseViewHolder {

        public EmptyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void clear() {

        }

    }
}
