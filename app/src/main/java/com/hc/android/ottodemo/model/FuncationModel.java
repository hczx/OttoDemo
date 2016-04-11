package com.hc.android.ottodemo.model;

import android.os.Parcel;

/**
 * Created by 99165 on 2016/3/30.
 */
public class FuncationModel extends Entity {

    public String name;
    public int img;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.img);
    }

    public FuncationModel() {
    }

    protected FuncationModel(Parcel in) {
        this.name = in.readString();
        this.img = in.readInt();
    }

    public static final Creator<FuncationModel> CREATOR = new Creator<FuncationModel>() {
        @Override
        public FuncationModel createFromParcel(Parcel source) {
            return new FuncationModel(source);
        }

        @Override
        public FuncationModel[] newArray(int size) {
            return new FuncationModel[size];
        }
    };
}
