package com.hc.android.ottodemo.funcation.sqlite;

import android.os.Parcel;

import com.hc.android.ottodemo.model.Entity;

/**
 * Created by 99165 on 2016/4/6.
 */
public class GoldModel extends Entity {

    String gold_hoard_name;
    String gold_hoard_accessible_column;
    String gold_hoarded_column;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.gold_hoard_name);
        dest.writeString(this.gold_hoard_accessible_column);
        dest.writeString(this.gold_hoarded_column);
    }

    public GoldModel() {
    }

    protected GoldModel(Parcel in) {
        this.gold_hoard_name = in.readString();
        this.gold_hoard_accessible_column = in.readString();
        this.gold_hoarded_column = in.readString();
    }

    public static final Creator<GoldModel> CREATOR = new Creator<GoldModel>() {
        @Override
        public GoldModel createFromParcel(Parcel source) {
            return new GoldModel(source);
        }

        @Override
        public GoldModel[] newArray(int size) {
            return new GoldModel[size];
        }
    };
}
