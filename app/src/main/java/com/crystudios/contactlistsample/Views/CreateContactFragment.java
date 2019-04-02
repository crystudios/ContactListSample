package com.crystudios.contactlistsample.Views;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crystudios.contactlistsample.R;
import com.crystudios.contactlistsample.ViewModels.CreateContactViewModel;

public class CreateContactFragment extends Fragment {

    private CreateContactViewModel mViewModel;

    public static CreateContactFragment newInstance() {
        return new CreateContactFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.create_contact_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(CreateContactViewModel.class);
        // TODO: Use the ViewModel
    }

}
