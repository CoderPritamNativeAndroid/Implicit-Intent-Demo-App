package com.pritampachal.implicitintentapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.pritampachal.implicitintentapp.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {
    EditText editText; //my defined
    Button button; //my defined

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
        //my code start, EditText-write-EMAIL-SUBJECT-open-in-Gmail-App
        editText=view.findViewById(R.id.editTextTextPersonName);
        button=view.findViewById(R.id.buttonMy);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myEmailExtraText=editText.getText().toString().trim();
                String[] emailAddress={"pritampachal2014@gmail.com","pritampachal1996@gmail.com"};
                /* Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this */
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("*/*");
                intent.putExtra(Intent.EXTRA_EMAIL,emailAddress);
                intent.putExtra(Intent.EXTRA_SUBJECT,"Pritam Subject");
                intent.putExtra(Intent.EXTRA_TEXT,myEmailExtraText);
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
