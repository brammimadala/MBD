package com.bonehub.app.mbd.roomdb;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface BankDetailsDao {
    @Insert
    void insert(BankDetails bankDetails);

    @Update
    void update(BankDetails bankDetails);

    @Delete
    void delete(BankDetails bankDetails);

    @Query("DELETE FROM BANK_DETAILS_TABLE")
    void deleteAllBankDetails();

    @Query("SELECT * FROM BANK_DETAILS_TABLE ORDER BY id DESC")
    LiveData<List<BankDetails>> getAllBankDetails();
}
