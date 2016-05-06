package com.example.hiago.fivecountriestovisit;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.hiago.relatoriodeestudos.R;

public class TabCanada extends Fragment {

    private static Button button;
    private static TextView textView;
    private static RatingBar ratingBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_canada, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ListenerRating();
    }

    public void ListenerRating() {
        ratingBar = (RatingBar) getActivity().findViewById(R.id.ratingBarCanada);
        textView = (TextView) getActivity().findViewById(R.id.avaliacaoCanada);

        ratingBar.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean f) {
                        textView.setText(String.valueOf(rating));
                    }
                }
        );
    }
}