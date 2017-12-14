package com.sirialkillers.shoponthego.Models;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(tableName = "Discount")
@ForeignKey(entity = ShopModel.class,parentColumns="shopId", childColumns ="shopId")
public class DiscountModel extends ArrayList implements Parcelable{
    @ColumnInfo(name="shopId")
    private String shopId;
    @PrimaryKey
    @NonNull
    @ColumnInfo(name="discountid")
    private String discountId;
    @ColumnInfo(name="discountPercentage")
    private double percentage;
    @ColumnInfo(name="discountTitle")
    private String title;
    @ColumnInfo(name="discountDescription")
    private String description;
    //TODO typeConverter date-to-long
    @ColumnInfo(name="expirationDate")
    private Date expirationDate;
    @Ignore
    private List<CategoryModel> categories;
    @Ignore
    public DiscountModel(String shopId, String discountId, double percentage,
                         String title, String description, Date expirationDate,
                         List<CategoryModel> categories){
        this.shopId = shopId;
        this.discountId = discountId;
        this.percentage = percentage;
        this.title = title;
        this.description = description;
        this.expirationDate=expirationDate;
        this.categories = categories;
    }

    public DiscountModel(String shopId, String discountId, double percentage,
                         String title, String description, Date expirationDate){
        this.shopId = shopId;
        this.discountId = discountId;
        this.percentage = percentage;
        this.title = title;
        this.description = description;
        this.expirationDate=expirationDate;
    }

    @Ignore
    public DiscountModel(String discountId){
        this.discountId = discountId;
        this.shopId = "";
        this.percentage = 0;
        this.title = "";
        this.description = "";
    }

    protected DiscountModel(Parcel in) {
        shopId = in.readString();
        discountId = in.readString();
        percentage = in.readDouble();
        title = in.readString();
        description = in.readString();
        long tmpExpirationDate = in.readLong();
        expirationDate = tmpExpirationDate != -1 ? new Date(tmpExpirationDate) : null;
    }

    @Override
    public int describeContents() {

        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(shopId);
        dest.writeString(discountId);
        dest.writeDouble(percentage);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeLong(expirationDate != null ? expirationDate.getTime() : -1L);
    }

    public String getShopId() {

        return shopId;
    }

    public void setShopId(String shopId) {

        this.shopId = shopId;
    }

    @NonNull
    public String getDiscountId() {

        return discountId;
    }

    public void setDiscountId(@NonNull String discountId) {

        this.discountId = discountId;
    }

    public double getPercentage() {

        return percentage;
    }

    public void setPercentage(double percentage) {

        this.percentage = percentage;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public Date getExpirationDate() {

        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {

        this.expirationDate = expirationDate;
    }

    public List<CategoryModel> getCategories() {

        return categories;
    }

    public void setCategories(List<CategoryModel> categories) {

        this.categories = categories;
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<DiscountModel> CREATOR = new Parcelable.Creator<DiscountModel>() {
        @Override
        public DiscountModel createFromParcel(Parcel in) {
            return new DiscountModel(in);
        }

        @Override
        public DiscountModel[] newArray(int size) {
            return new DiscountModel[size];
        }
    };


}




