package com.example.androit2lessons1.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.androit2lessons1.R;
import com.example.androit2lessons1.databinding.FragmentAvatarBinding;
import com.example.androit2lessons1.databinding.FragmentProfileBinding;


public class AvatarFragment extends Fragment {
    private FragmentAvatarBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAvatarBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setimage();
    }

    private void setimage() {
        String uri = requireArguments().getString("image");
        Glide.with(binding.avatar).load(uri).into(binding.avatar);
    }
}