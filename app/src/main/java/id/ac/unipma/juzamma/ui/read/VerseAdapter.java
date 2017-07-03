package id.ac.unipma.juzamma.ui.read;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
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
import id.ac.unipma.juzamma.data.db.model.Verse;
import id.ac.unipma.juzamma.data.db.model.Verse;
import id.ac.unipma.juzamma.ui.base.BaseViewHolder;
import id.ac.unipma.juzamma.ui.helper.GlowingText;
import id.ac.unipma.juzamma.utils.AppConstants;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, June 2017
 */

public class VerseAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;

    private Callback mCallback;
    private List<Verse> mVerse;

    public VerseAdapter(List<Verse> verses) {
        mVerse = verses;
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
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.list_verse, parent, false));
            case VIEW_TYPE_EMPTY:
            default:
                return new EmptyViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.list_verse, parent, false));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mVerse != null && mVerse.size() > 0) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public int getItemCount() {
        if (mVerse != null && mVerse.size() > 0) {
            return mVerse.size();
        } else {
            return 1;
        }
    }

    public void addItems(List<Verse> list) {
        mVerse.addAll(list);
        notifyDataSetChanged();
    }


    public interface Callback {
        void onBlogEmptyViewRetryClick();
    }

    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.verse_arabic)
        TextView tvVerseName;

        @BindView(R.id.verse_text)
        TextView tvVerseDesc;
        GlowingText mGlow;
        float       startGlowRadius = 6f,         // Glowing starts with this Intensity
                minGlowRadius   = 3f,         // Minimum Glowing Intensity
                maxGlowRadius   = 15f;        // Maximum Glowing Intensity

        public ViewHolder(View itemView) {
            super(itemView);
            ReadActvity activity = (ReadActvity) itemView.getContext();
            ButterKnife.bind(this, itemView);
            mGlow = new GlowingText(
                    activity,           // Pass activity Object
                    itemView.getContext().getApplicationContext(),   // Context
                    tvVerseName,           // TextView
                    minGlowRadius,      // Minimum Glow Radius
                    maxGlowRadius,      // Maximum Glow Radius
                    startGlowRadius,    // Start Glow Radius - Increases to MaxGlowRadius then decreases to MinGlowRadius.
                    itemView.getContext().getResources().getColor(R.color.yellow),         // Glow Color (int)
                    10);                 // Glowing Transition Speed (Range of 1 to 10)  (fast ... slow)
        }

        protected void clear() {
            tvVerseName.setText("");
            tvVerseDesc.setText("");
        }

        public void onBind(int position) {
            super.onBind(position);

            final Verse verse = mVerse.get(position);

            if (verse.getVerseArabic() != null) {
                tvVerseName.setText(verse.getVerseArabic());
            }

            if (verse.getVerseText() != null) {
                tvVerseDesc.setText(verse.getVerseText());
            }


            itemView.setOnClickListener(v -> {


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
