package com.example.test;

import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Array;
import java.util.List;

public class InfoPlace implements Parcelable {
    private  int mPlaceID;
    private  String mPlaceName;
    private  String mUrlLogoPlace;
    private  int mCategoryId;
    private  String mAddress;
    private  String mPhone;
    private  String mUrlWeb;
    private  String mDescription;
    private  Object urlBanner;
    private  long mIsMoreDetail;
    private  long mIsMorePromotion;
    private  double mLongitude;
    private  double mLatitude;
    private  String mKakaoTalk;
    private List<Object> listMedia;

    public InfoPlace(int mPlaceID, String mPlaceName, String mUrlLogoPlace, int mCategoryId, String mAddress, String mPhone, String mUrlWeb, String mDescription, Object urlBanner, long mIsMoreDetail, long mIsMorePromotion, double mLongitude, double mLatitude, String mKakaoTalk, List<Object> listMedia) {
        this.mPlaceID = mPlaceID;
        this.mPlaceName = mPlaceName;
        this.mUrlLogoPlace = mUrlLogoPlace;
        this.mCategoryId = mCategoryId;
        this.mAddress = mAddress;
        this.mPhone = mPhone;
        this.mUrlWeb = mUrlWeb;
        this.mDescription = mDescription;
        this.urlBanner = urlBanner;
        this.mIsMoreDetail = mIsMoreDetail;
        this.mIsMorePromotion = mIsMorePromotion;
        this.mLongitude = mLongitude;
        this.mLatitude = mLatitude;
        this.mKakaoTalk = mKakaoTalk;
        this.listMedia = listMedia;
    }

    protected InfoPlace(Parcel in) {
        mPlaceID = in.readInt();
        mPlaceName = in.readString();
        mUrlLogoPlace = in.readString();
        mCategoryId = in.readInt();
        mAddress = in.readString();
        mPhone = in.readString();
        mUrlWeb = in.readString();
        mDescription = in.readString();
        mIsMoreDetail = in.readLong();
        mIsMorePromotion = in.readLong();
        mLongitude = in.readDouble();
        mLatitude = in.readDouble();
        mKakaoTalk = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mPlaceID);
        dest.writeString(mPlaceName);
        dest.writeString(mUrlLogoPlace);
        dest.writeInt(mCategoryId);
        dest.writeString(mAddress);
        dest.writeString(mPhone);
        dest.writeString(mUrlWeb);
        dest.writeString(mDescription);
        dest.writeLong(mIsMoreDetail);
        dest.writeLong(mIsMorePromotion);
        dest.writeDouble(mLongitude);
        dest.writeDouble(mLatitude);
        dest.writeString(mKakaoTalk);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<InfoPlace> CREATOR = new Creator<InfoPlace>() {
        @Override
        public InfoPlace createFromParcel(Parcel in) {
            return new InfoPlace(in);
        }

        @Override
        public InfoPlace[] newArray(int size) {
            return new InfoPlace[size];
        }
    };

    public int getmPlaceID() {
        return mPlaceID;
    }

    public String getmPlaceName() {
        return mPlaceName;
    }

    public String getmUrlLogoPlace() {
        return mUrlLogoPlace;
    }

    public int getmCategoryId() {
        return mCategoryId;
    }

    public String getmAddress() {
        return mAddress;
    }

    public String getmPhone() {
        return mPhone;
    }

    public String getmUrlWeb() {
        return mUrlWeb;
    }

    public String getmDescription() {
        return mDescription;
    }

    public Object getUrlBanner() {
        return urlBanner;
    }

    public long getmIsMoreDetail() {
        return mIsMoreDetail;
    }

    public long getmIsMorePromotion() {
        return mIsMorePromotion;
    }

    public double getmLongitude() {
        return mLongitude;
    }

    public double getmLatitude() {
        return mLatitude;
    }

    public String getmKakaoTalk() {
        return mKakaoTalk;
    }

    public List<Object> getListMedia() {
        return listMedia;
    }
}
