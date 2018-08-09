package com.example.komald.bootcamp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Customer implements Parcelable{

    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("address")
    @Expose
    private Object address;
    @SerializedName("company_id")
    @Expose
    private String companyId;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("job_title")
    @Expose
    private String jobTitle;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("time_zone")
    @Expose
    private String timeZone;
    @SerializedName("twitter_id")
    @Expose
    private Object twitterId;
    @SerializedName("facebook_id")
    @Expose
    private Object facebookId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("unique_external_id")
    @Expose
    private Object uniqueExternalId;

    public String imageUrl = "https://www.google.co.in/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png";

    protected Customer(Parcel in) {
        byte tmpActive = in.readByte();
        active = tmpActive == 0 ? null : tmpActive == 1;
        companyId = in.readString();
        email = in.readString();
        id = in.readLong();
        jobTitle = in.readString();
        language = in.readString();
        mobile = in.readString();
        name = in.readString();
        phone = in.readString();
        timeZone = in.readString();
        createdAt = in.readString();
        updatedAt = in.readString();
        imageUrl = in.readString();
    }

    public static final Creator<Customer> CREATOR = new Creator<Customer>() {
        @Override
        public Customer createFromParcel(Parcel in) {
            return new Customer(in);
        }

        @Override
        public Customer[] newArray(int size) {
            return new Customer[size];
        }
    };

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Object getAddress() {
        return address;
    }

    public void setAddress(Object address) {
        this.address = address;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public Object getTwitterId() {
        return twitterId;
    }

    public void setTwitterId(Object twitterId) {
        this.twitterId = twitterId;
    }

    public Object getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(Object facebookId) {
        this.facebookId = facebookId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object getUniqueExternalId() {
        return uniqueExternalId;
    }

    public void setUniqueExternalId(Object uniqueExternalId) {
        this.uniqueExternalId = uniqueExternalId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (active == null ? 0 : active ? 1 : 2));
        parcel.writeString(companyId);
        parcel.writeString(email);
        parcel.writeLong(id);
        parcel.writeString(jobTitle);
        parcel.writeString(language);
        parcel.writeString(mobile);
        parcel.writeString(name);
        parcel.writeString(phone);
        parcel.writeString(timeZone);
        parcel.writeString(createdAt);
        parcel.writeString(updatedAt);
        parcel.writeString(imageUrl);
    }
}
