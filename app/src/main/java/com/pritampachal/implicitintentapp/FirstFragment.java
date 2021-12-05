package com.pritampachal.implicitintentapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.pritampachal.implicitintentapp.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {
    EditText editText; //my defined
    Button button; //my defined

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
        //my code start, EditText-write-URL-open-in-Chrome-Browser
        editText=view.findViewById(R.id.editTextTextPersonName);
        button=view.findViewById(R.id.buttonMy);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myURL=editText.getText().toString().trim();
                Uri uri=Uri.parse(myURL); //convert, myURL to Original-URL
                Intent intent=new Intent(Intent.ACTION_VIEW,uri); //here, implicit-intent
                if(intent.resolveActivity(getActivity().getPackageManager())!=null) {
                    startActivity(intent);
                }
            }
        });
        //my code end
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
