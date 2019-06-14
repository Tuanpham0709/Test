package com.example.test.model.Promotions;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListMedium {

@SerializedName("urlID")
@Expose
private String urlID;
@SerializedName("type")
@Expose
private Integer type;

public String getUrlID() {
return urlID;
}

public void setUrlID(String urlID) {
this.urlID = urlID;
}

public Integer getType() {
return type;
}

public void setType(Integer type) {
this.type = type;
}

}