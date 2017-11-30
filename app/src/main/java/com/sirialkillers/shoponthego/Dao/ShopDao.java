package com.sirialkillers.shoponthego.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.sirialkillers.shoponthego.Models.ShopModel;

import java.util.List;

/**
 * Created by User on 24-Nov-17.
 */
@Dao
public interface ShopDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<ShopModel> shops);

    @Query("SELECT * FROM Shop")
    List<ShopModel> getAllShops();
}
