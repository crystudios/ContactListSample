package com.crystudios.contactlistsample.Views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.crystudios.contactlistsample.R;
import com.crystudios.contactlistsample.ViewModels.CreateContactViewModel;

import java.io.IOException;

import static android.app.Activity.RESULT_OK;

public class CreateContactFragment extends Fragment{

    private static final int PICK_IMAGE_REQUEST = 1;

    private CreateContactViewModel mViewModel;

    private EditText mTxtFirstName;
    private EditText mTxtJob;
    private ImageButton mImgBtnAvatar;
    private Button btnAddUser;

    private Bitmap bmp;

    public static CreateContactFragment newInstance() {
        return new CreateContactFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.create_contact_fragment, container, false);

        mTxtFirstName = rootView.findViewById(R.id.txtFirstName);
        mTxtJob = rootView.findViewById(R.id.txtJob);
        btnAddUser = rootView.findViewById(R.id.btnAddUser);

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String firstName = mTxtFirstName.getText().toString();
                String job = mTxtJob.getText().toString();

                mViewModel.addUser(firstName, job);
            }
        });

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(CreateContactViewModel.class);
        mViewModel.init(this.getActivity());
        // TODO: Use the ViewModel
    }
}
