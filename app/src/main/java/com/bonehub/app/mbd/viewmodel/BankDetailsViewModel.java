package com.bonehub.app.mbd.viewmodel;

import android.app.Application;

import com.bonehub.app.mbd.roomdb.BankDetails;
import com.bonehub.app.mbd.roomdb.BankDetailsRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class BankDetailsViewModel extends AndroidViewModel {

    private BankDetailsRepository repository;
    private LiveData<List<BankDetails>> allBankDetails;

    public BankDetailsViewModel(@NonNull Application application) {
        super(application);
        repository = new BankDetailsRepository(application);
        allBankDetails = repository.getAllBankDetails();
    }

    public void insert(BankDetails bankDetails) {
        repository.insert(bankDetails);
    }

    public void update(BankDetails bankDetails) {
        repository.update(bankDetails);
    }

    public void delete(BankDetails bankDetails) {
        repository.delete(bankDetails);
    }

    public void deleteAllNotes() {
        repository.deleteAllNotes();
    }

    public LiveData<List<BankDetails>> getAllBankDetails() {
        return allBankDetails;
    }
}
