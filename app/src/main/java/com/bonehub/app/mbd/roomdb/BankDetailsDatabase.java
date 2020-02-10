package com.bonehub.app.mbd.roomdb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {BankDetails.class}, version = 1)
public abstract class BankDetailsDatabase extends RoomDatabase {

    private static BankDetailsDatabase instance;
    public abstract BankDetailsDao bankDetailsDao();

    public static synchronized BankDetailsDatabase getInstance(Context context) {
        if (instance == null) {
            instance =
                    Room.databaseBuilder(context.getApplicationContext(),BankDetailsDatabase.class, "bankDetails_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
