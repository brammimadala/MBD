package com.bonehub.app.mbd.activityfrag;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bonehub.app.mbd.R;
import com.bonehub.app.mbd.adapter.BankDetailsAdapter;
import com.bonehub.app.mbd.roomdb.BankDetails;
import com.bonehub.app.mbd.viewmodel.BankDetailsViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashBoardFragment extends Fragment implements View.OnClickListener, BankDetailsAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private Toolbar toolbar;
    private AppCompatImageView tb_ivBack;
    private AppCompatTextView tb_Text;
    NavController navController;
    private BankDetailsViewModel bankDetailsViewModel;
    private BankDetailsAdapter adapter;

    public DashBoardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dash_board, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        fab = view.findViewById(R.id.fab);
        toolbar = view.findViewById(R.id.tb);

        tb_ivBack = toolbar.findViewById(R.id.toolbar_image);
        tb_Text = toolbar.findViewById(R.id.toolbar_text);
        tb_Text.setText("Bank Details");
        tb_ivBack.setOnClickListener(this);

        adapter = new BankDetailsAdapter();
        adapter.setOnItemClickListener(this);
        fab.setOnClickListener(this);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(adapter);

        bankDetailsViewModel = ViewModelProviders.of(this).get(BankDetailsViewModel.class);
        bankDetailsViewModel.getAllBankDetails().observe(this, new Observer<List<BankDetails>>() {
            @Override
            public void onChanged(List<BankDetails> bankDetails) {
                Log.i("data=====>", "" + bankDetails.size());
                adapter.setNotes(bankDetails);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toolbar_image: {
                getActivity().onBackPressed();
                break;
            }
            case R.id.fab: {
                navController.navigate(R.id.action_addEditFragment);
                break;
            }
            default: {
                return;
            }
        }
    }

    @Override
    public void onItemClick(BankDetails bankDetails) {
    //Toast.makeText(getActivity(), ""+bankDetails.getBankName()+"\n"+bankDetails.getAccountNumber(), Toast.LENGTH_SHORT).show();
    DashBoardFragmentDirections.ActionAddEditFragment action = DashBoardFragmentDirections.actionAddEditFragment(bankDetails);
    action.setBankDeatails(null);
    navController.navigate(action);
    }
}
