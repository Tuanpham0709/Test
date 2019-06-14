package com.example.test.model.Promotions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

@SerializedName("promotionID")
@Expose
private Integer promotionID;
@SerializedName("urlImage")
@Expose
private String urlImage;
@SerializedName("promotionName")
@Expose
private String promotionName;
@SerializedName("placeDetail")
@Expose
private PlaceDetail placeDetail;

public Integer getPromotionID() {
return promotionID;
}

public void setPromotionID(Integer promotionID) {
this.promotionID = promotionID;
}

public String getUrlImage() {
return urlImage;
}

public void setUrlImage(String urlImage) {
this.urlImage = urlImage;
}

public String getPromotionName() {
return promotionName;
}

public void setPromotionName(String promotionName) {
this.promotionName = promotionName;
}

public PlaceDetail getPlaceDetail() {
return placeDetail;
}

public void setPlaceDetail(PlaceDetail placeDetail) {
this.placeDetail = placeDetail;
}

}