package com.sirialkillers.shoponthego.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.sirialkillers.shoponthego.Models.DiscountModel;
import com.sirialkillers.shoponthego.Models.ShopModel;

import java.util.List;

/**
 * Created by User on 30-Nov-17.
 */
@Dao
public interface DiscountDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllDiscounts(List<DiscountModel> discounts);

    @Query("SELECT * FROM Discount")
    List<DiscountModel> getAllDiscounts();

    @Query("SELECT * FROM Discount WHERE shopId==:shopId")
    List<DiscountModel> getShopDiscounts(String shopId);

    @Query("SELECT * FROM Discount WHERE discountid==:discountId")
    DiscountModel getSpecificDiscount(String discountId);
}
