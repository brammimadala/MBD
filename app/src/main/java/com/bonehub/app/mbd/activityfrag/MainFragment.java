package com.bonehub.app.mbd.activityfrag;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavAction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bonehub.app.mbd.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements View.OnClickListener {

    private Toolbar toolbar;
    private AppCompatTextView signUp;
    private AppCompatTextView forgotPassword;
    private AppCompatEditText userName;
    private AppCompatEditText password;
    private AppCompatTextView toolbarText;
    private AppCompatImageView toolbarIv;
    private AppCompatButton loginButton;

    NavController navController;


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        toolbar = view.findViewById(R.id.tb);
        userName = view.findViewById(R.id.userName);
        password = view.findViewById(R.id.password);
        loginButton = view.findViewById(R.id.button);
        signUp = view.findViewById(R.id.signUp);
        forgotPassword = view.findViewById(R.id.forgotPassword);
        toolbarIv = toolbar.findViewById(R.id.toolbar_image);
        toolbarText = toolbar.findViewById(R.id.toolbar_text);

        toolbarText.setText("Login");
        toolbarIv.setVisibility(View.INVISIBLE);

        loginButton.setOnClickListener(this);
        signUp.setOnClickListener(this);
        forgotPassword.setOnClickListener(this);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.signUp: {
                navController.navigate(R.id.action_signUpFragment);
                break;
            }
            case R.id.forgotPassword: {
                navController.navigate(R.id.action_forgotPasswordFragment);
                break;
            }
            case R.id.button: {
                if (userName.getText().toString().trim().isEmpty() || password.getText().toString().trim().isEmpty()) {
                    Toast.makeText(getActivity(), "Please Enter UserName and Password", Toast.LENGTH_SHORT).show();
                } else if (userName.getText().toString().trim().equalsIgnoreCase("123") && password.getText().toString().trim().equalsIgnoreCase("123")){
                    navController.navigate(R.id.action_dashBoardFragment);
                }else {
                    Toast.makeText(getActivity(), "Bad Credentials", Toast.LENGTH_SHORT).show();

                    /*if (userName.getText().toString().trim().equalsIgnoreCase("123") && password.getText().toString().trim().equalsIgnoreCase("123")) {
                        navController.navigate(R.id.action_dashBoardFragment);
                    } else {
                        Toast.makeText(getActivity(), "Bad Credentials", Toast.LENGTH_SHORT).show();
                    }*/
                }
            }
            default: {
                return;
            }
        }
    }
}
