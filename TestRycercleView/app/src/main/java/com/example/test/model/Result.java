package com.example.test.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

@SerializedName("contactID")
@Expose
private Integer contactID;
@SerializedName("name")
@Expose
private String name;
@SerializedName("phone")
@Expose
private String phone;
@SerializedName("description")
@Expose
private String description;

public Integer getContactID() {
return contactID;
}

public void setContactID(Integer contactID) {
this.contactID = contactID;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getPhone() {
return phone;
}

public void setPhone(String phone) {
this.phone = phone;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

}