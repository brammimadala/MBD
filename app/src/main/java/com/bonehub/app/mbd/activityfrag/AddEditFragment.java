package com.bonehub.app.mbd.activityfrag;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bonehub.app.mbd.R;
import com.bonehub.app.mbd.roomdb.BankDetails;
import com.bonehub.app.mbd.viewmodel.BankDetailsViewModel;
import com.google.android.material.textfield.TextInputEditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddEditFragment extends Fragment implements View.OnClickListener {

    private BankDetailsViewModel bankDetailsViewModel;
    private Toolbar toolbar;
    private AppCompatImageView toolbar_iv;
    private AppCompatTextView toolbar_tv;
    private AppCompatButton save_btn;
    private TextInputEditText bankName, bankBranch, accountHolderNme, accountNumber, ifscCode;

    public AddEditFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_edit, container, false);

        toolbar = view.findViewById(R.id.tb);
        toolbar_iv = toolbar.findViewById(R.id.toolbar_image);
        toolbar_tv = toolbar.findViewById(R.id.toolbar_text);
        bankName = view.findViewById(R.id.bankName);
        bankBranch = view.findViewById(R.id.bankBranch);
        accountHolderNme = view.findViewById(R.id.bankAccountHolder);
        accountNumber = view.findViewById(R.id.bankAccountNumber);
        ifscCode = view.findViewById(R.id.bankIFSCCode);
        save_btn = view.findViewById(R.id.button);

        toolbar_tv.setText("Add Bank Details");
        toolbar_iv.setOnClickListener(this);
        save_btn.setOnClickListener(this);

        bankDetailsViewModel = ViewModelProviders.of(getActivity()).get(BankDetailsViewModel.class);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       /* try {
            if(getArguments() != null)
            {
                AddEditFragmentArgs args = AddEditFragmentArgs.fromBundle(getArguments());
                BankDetails bankDetails = args.getBankDeatails();
                Log.i("editData====>",""+bankDetails.getBankName()+"-"
                                                  +bankDetails.getBankBranch()+"-"
                                                  +bankDetails.getAccountHolderName()+"-"
                                                  +bankDetails.getIfscCode()+"-"
                                                  +bankDetails.getAccountNumber()+"-");

                bankName.setText(bankDetails.getBankName());
                bankBranch.setText(bankDetails.getBankBranch());
                accountHolderNme.setText(bankDetails.getAccountHolderName());
                accountNumber.setText(bankDetails.getAccountNumber());
                ifscCode.setText(bankDetails.getIfscCode());
                *//*bankDetails.getBankName();
                bankDetails.getBankBranch();
                bankDetails.getAccountHolderName();
                bankDetails.getIfscCode();
                bankDetails.getAccountNumber();*//*

                toolbar_tv.setText("Update Bank Details");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.toolbar_image: {
                getActivity().onBackPressed();
                break;
            }
            case R.id.button: {
                saveBankDetails();
                break;
            }
            default: {
                return;
            }
        }

    }

    private void saveBankDetails() {
        String bank_Name = bankName.getText().toString();
        String bank_Branch = bankBranch.getText().toString();
        String account_Holder_Name = accountHolderNme.getText().toString();
        String account_Number = accountNumber.getText().toString();
        String ifsc_Code = ifscCode.getText().toString();

        if (bank_Name.trim().isEmpty()) {
            Toast.makeText(getActivity(), "Please Enter Bank Name", Toast.LENGTH_SHORT).show();
        } else if (bank_Branch.trim().isEmpty()) {
            Toast.makeText(getActivity(), "Please Enter Bank Branch", Toast.LENGTH_SHORT).show();
        } else if (account_Holder_Name.trim().isEmpty()) {
            Toast.makeText(getActivity(), "Please Enter A/C Holder Name ", Toast.LENGTH_SHORT).show();
        } else if (account_Number.trim().isEmpty()) {
            Toast.makeText(getActivity(), "Please Enter A/C Number ", Toast.LENGTH_SHORT).show();
        } else if (ifsc_Code.trim().isEmpty()) {
            Toast.makeText(getActivity(), "Please Enter IFSCCode Name ", Toast.LENGTH_SHORT).show();
        } else {
            BankDetails bankDetails = new BankDetails(bank_Name, bank_Branch, account_Holder_Name, account_Number, ifsc_Code);
            bankDetailsViewModel.insert(bankDetails);
            //Toast.makeText(getActivity(), "Data Inserted", Toast.LENGTH_SHORT).show();
            getActivity().onBackPressed();
        }

    }
}
