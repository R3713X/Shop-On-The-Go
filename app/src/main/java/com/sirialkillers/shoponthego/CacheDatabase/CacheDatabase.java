package com.sirialkillers.shoponthego.CacheDatabase;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.sirialkillers.shoponthego.Dao.DiscountDao;
import com.sirialkillers.shoponthego.Dao.ShopDao;
import com.sirialkillers.shoponthego.Models.DiscountModel;
import com.sirialkillers.shoponthego.Models.ShopModel;

/**
 * Created by User on 24-Nov-17.
 */
@Database(version = 2, entities = {ShopModel.class, DiscountModel.class})
@TypeConverters({DateTypeConverters.class})
public abstract class CacheDatabase extends RoomDatabase {
    private static final String DATABASE_NAME="local-database";
    private static volatile CacheDatabase appDatabase;


    public static synchronized CacheDatabase getInstance(Context context){
        if (appDatabase == null) appDatabase = create(context);
        return appDatabase;
    }

    private static CacheDatabase create(final Context context){
        return Room.databaseBuilder(context,CacheDatabase.class,DATABASE_NAME).build();
    }

    public abstract ShopDao shopDao();
    public abstract DiscountDao discountDao();



    public static void destroyInstance() {

        appDatabase= null;
    }


    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }
}
