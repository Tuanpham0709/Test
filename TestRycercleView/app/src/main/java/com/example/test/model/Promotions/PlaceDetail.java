package com.example.test.model.Promotions;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlaceDetail {

@SerializedName("placeID")
@Expose
private Integer placeID;
@SerializedName("placeName")
@Expose
private String placeName;
@SerializedName("urlLogoPlace")
@Expose
private String urlLogoPlace;
@SerializedName("categoryID")
@Expose
private Integer categoryID;
@SerializedName("address")
@Expose
private String address;
@SerializedName("phone")
@Expose
private String phone;
@SerializedName("urlWeb")
@Expose
private String urlWeb;
@SerializedName("description")
@Expose
private String description;
@SerializedName("urlBanner")
@Expose
private Object urlBanner;
@SerializedName("isMoreDetail")
@Expose
private Integer isMoreDetail;
@SerializedName("isPromotion")
@Expose
private Integer isPromotion;
@SerializedName("longitude")
@Expose
private Float longitude;
@SerializedName("latitude")
@Expose
private Float latitude;
@SerializedName("kakaoTalk")
@Expose
private String kakaoTalk;
@SerializedName("listMedia")
@Expose
private List<ListMedium> listMedia = null;

public Integer getPlaceID() {
return placeID;
}

public void setPlaceID(Integer placeID) {
this.placeID = placeID;
}

public String getPlaceName() {
return placeName;
}

public void setPlaceName(String placeName) {
this.placeName = placeName;
}

public String getUrlLogoPlace() {
return urlLogoPlace;
}

public void setUrlLogoPlace(String urlLogoPlace) {
this.urlLogoPlace = urlLogoPlace;
}

public Integer getCategoryID() {
return categoryID;
}

public void setCategoryID(Integer categoryID) {
this.categoryID = categoryID;
}

public String getAddress() {
return address;
}

public void setAddress(String address) {
this.address = address;
}

public String getPhone() {
return phone;
}

public void setPhone(String phone) {
this.phone = phone;
}

public String getUrlWeb() {
return urlWeb;
}

public void setUrlWeb(String urlWeb) {
this.urlWeb = urlWeb;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

public Object getUrlBanner() {
return urlBanner;
}

public void setUrlBanner(Object urlBanner) {
this.urlBanner = urlBanner;
}

public Integer getIsMoreDetail() {
return isMoreDetail;
}

public void setIsMoreDetail(Integer isMoreDetail) {
this.isMoreDetail = isMoreDetail;
}

public Integer getIsPromotion() {
return isPromotion;
}

public void setIsPromotion(Integer isPromotion) {
this.isPromotion = isPromotion;
}

public Float getLongitude() {
return longitude;
}

public void setLongitude(Float longitude) {
this.longitude = longitude;
}

public Float getLatitude() {
return latitude;
}

public void setLatitude(Float latitude) {
this.latitude = latitude;
}

public String getKakaoTalk() {
return kakaoTalk;
}

public void setKakaoTalk(String kakaoTalk) {
this.kakaoTalk = kakaoTalk;
}

public List<ListMedium> getListMedia() {
return listMedia;
}

public void setListMedia(List<ListMedium> listMedia) {
this.listMedia = listMedia;
}

}