package com.laevatein.internal.ui;

import com.laevatein.R;
import com.laevatein.internal.ui.helper.SelectedCountViewHelper;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author KeithYokoma
 * @since 2014/04/03
 * @version 1.0.0
 * @hide
 */
public class SelectedCountFragment extends Fragment {
    private OnShowSelectedClickListener mListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mListener = (OnShowSelectedClickListener) activity;
        } catch (ClassCastException e) {
            throw new IllegalStateException("the host activity should implement OnShowSelectedClickListener.");
        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.l_fragment_selected_count, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SelectedCountViewHelper.setUpCountView(this);
        SelectedCountViewHelper.updateCountView((PhotoSelectionActivity) getActivity(), this);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        SelectedCountViewHelper.updateCountView((PhotoSelectionActivity) getActivity(), this); // bit hacky
    }

    public OnShowSelectedClickListener getListener() {
        return mListener;
    }

    public static interface OnShowSelectedClickListener {
        public void onClickSelectedView();
    }
}
