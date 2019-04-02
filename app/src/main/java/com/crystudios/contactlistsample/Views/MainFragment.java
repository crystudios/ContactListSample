package com.crystudios.contactlistsample.Views;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crystudios.contactlistsample.Adapters.ContactListAdapter;
import com.crystudios.contactlistsample.R;
import com.crystudios.contactlistsample.ViewModels.MainViewModel;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private RecyclerView mRecyclerView;
    private ContactListAdapter mAdapter;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.main_fragment, container, false);
        mRecyclerView = root.findViewById(R.id.lstUsers );
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mViewModel.init();

        mAdapter = new ContactListAdapter(this.getActivity(), mViewModel.getUserList().getValue());
        mRecyclerView.setAdapter(mAdapter);

    }

}
