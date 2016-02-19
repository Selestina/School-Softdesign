package com.softdesign.school.data.storage.models;

import android.graphics.drawable.Drawable;

public class User {

    private int mId;
    private String mFirstName;
    private String mLastName;
    private String mEMail;
    private String mPhoneNumber;
    private Drawable mImage;
    private String mVkProfile;
    private String mGitRepo;
    private int mRate;
    private int mHometask;

    public User(String lastName, String firstName, Drawable image) {
        this.mFirstName = firstName;
        this.mLastName = lastName;
        this.mImage = image;
    }

    public String getmLastName() {
        return mLastName;
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public Drawable getmImage() {
        return mImage;
    }

    public int getmHometask() {
        return mHometask;
    }

    public String getmVkProfile() {
        return mVkProfile;
    }

    public String getmGitRepo() {
        return mGitRepo;
    }

    public int getmRate() {
        return mRate;
    }
}
