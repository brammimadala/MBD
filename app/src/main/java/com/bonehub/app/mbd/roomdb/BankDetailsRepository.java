package com.bonehub.app.mbd.roomdb;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;

public class BankDetailsRepository {

    private BankDetailsDao bankDetailsDao;
    private LiveData<List<BankDetails>> allBankDetails;

    public BankDetailsRepository(Application application) {
        BankDetailsDatabase database = BankDetailsDatabase.getInstance(application);
        bankDetailsDao = database.bankDetailsDao();
        allBankDetails = bankDetailsDao.getAllBankDetails();
    }

    public void insert(BankDetails bankDetails) {
        new InsertBankDetailsAsyncTask(bankDetailsDao).execute(bankDetails);
    }

    public void update(BankDetails bankDetails) {
        new UpdateBankDetailsAsyncTask(bankDetailsDao).execute(bankDetails);
    }

    public void delete(BankDetails bankDetails) {
        new DeleteBankDetailsAsyncTask(bankDetailsDao).execute(bankDetails);
    }

    public void deleteAllNotes() {
        new DeleteAllBankDetailsAsyncTask(bankDetailsDao).execute();
    }

    public LiveData<List<BankDetails>> getAllBankDetails() {
        return allBankDetails;
    }

    private static class InsertBankDetailsAsyncTask extends AsyncTask<BankDetails, Void, Void> {
        private BankDetailsDao bankDetailsDao;

        private InsertBankDetailsAsyncTask(BankDetailsDao bankDetailsDao) {
            this.bankDetailsDao = bankDetailsDao;
        }

        @Override
        protected Void doInBackground(BankDetails... bankDetails) {
            bankDetailsDao.insert(bankDetails[0]);
            return null;
        }
    }

    private static class UpdateBankDetailsAsyncTask extends AsyncTask<BankDetails, Void, Void> {
        private BankDetailsDao bankDetailsDao;

        private UpdateBankDetailsAsyncTask(BankDetailsDao bankDetailsDao) {
            this.bankDetailsDao = bankDetailsDao;
        }

        @Override
        protected Void doInBackground(BankDetails... bankDetails) {
            bankDetailsDao.update(bankDetails[0]);
            return null;
        }
    }

    private static class DeleteBankDetailsAsyncTask extends AsyncTask<BankDetails, Void, Void> {
        private BankDetailsDao bankDetailsDao;

        private DeleteBankDetailsAsyncTask(BankDetailsDao bankDetailsDao) {
            this.bankDetailsDao = bankDetailsDao;
        }

        @Override
        protected Void doInBackground(BankDetails... bankDetails) {
            bankDetailsDao.delete(bankDetails[0]);
            return null;
        }
    }

    private static class DeleteAllBankDetailsAsyncTask extends AsyncTask<Void, Void, Void> {
        private BankDetailsDao bankDetailsDao;

        private DeleteAllBankDetailsAsyncTask(BankDetailsDao bankDetailsDao) {
            this.bankDetailsDao = bankDetailsDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            bankDetailsDao.deleteAllBankDetails();
            return null;
        }
    }
}
