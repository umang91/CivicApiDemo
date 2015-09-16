package com.civic.civicapidemo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @author Umang Chamaria
 */
public class PoliticianModel implements Serializable {
    @SerializedName("id")
    private String mPoliticianId;
    @SerializedName("name")
    private String mPoliticianName;
    @SerializedName("constituencyName")
    private String mPoliticianConstituencyName;
    @SerializedName("partyName")
    private String mPartyName;
    @SerializedName("education")
    private String mPoliticianEducation;
    @SerializedName("criminalCasesPending")
    private String mPoliticianCriminalCasesPending;
    @SerializedName("totalAssets")
    private String mPoliticianTotalAssets;
    @SerializedName("liabilities")
    private String mPoliticianLiabilities;
    @SerializedName("area")
    private String mPoliticianArea;
    @SerializedName("ipc")
    private String mPoliticianCriminalRecord;
    @SerializedName("contact")
    private String  mPoliticianNumber;
    @SerializedName("email")
    private String mPoliticianEmailId;
    @SerializedName("address")
    private String mPoliticianAddress;

    public String getPoliticianAddress() {
        return mPoliticianAddress;
    }

    public void setPoliticianAddress(String mPoliticianAddress) {
        this.mPoliticianAddress = mPoliticianAddress;
    }

    public String getPoliticianId() {
        return mPoliticianId;
    }

    public void setPoliticianId(String mPoliticianId) {
        this.mPoliticianId = mPoliticianId;
    }

    public String getPoliticianName() {
        return mPoliticianName;
    }

    public void setPoliticianName(String mPoliticianName) {
        this.mPoliticianName = mPoliticianName;
    }

    public String getConstituencyName() {
        return mPoliticianConstituencyName;
    }

    public void setConstituencyName(String mConstituencyName) {
        this.mPoliticianConstituencyName = mConstituencyName;
    }

    public String getPartyName() {
        return mPartyName;
    }

    public void setPartyName(String mPartyName) {
        this.mPartyName = mPartyName;
    }

    public String getPoliticianEducation() {
        return mPoliticianEducation;
    }

    public void setPoliticianEducation(String mPoliticianEducation) {
        this.mPoliticianEducation = mPoliticianEducation;
    }

    public String getPoliticianCriminalCasesPending() {
        return mPoliticianCriminalCasesPending;
    }

    public void setPoliticianCriminalCasesPending(String mPoliticianCriminalCasesPending) {
        this.mPoliticianCriminalCasesPending = mPoliticianCriminalCasesPending;
    }

    public String getPoliticianTotalAssets() {
        return mPoliticianTotalAssets;
    }

    public void setPoliticianTotalAssets(String mPoliticianTotalAssets) {
        this.mPoliticianTotalAssets = mPoliticianTotalAssets;
    }

    public String getPoliticianLiabilities() {
        return mPoliticianLiabilities;
    }

    public void setPoliticianLiabilities(String mPoliticianLiabilities) {
        this.mPoliticianLiabilities = mPoliticianLiabilities;
    }

    public String getPoliticianArea() {
        return mPoliticianArea;
    }

    public void setPoliticianArea(String mPoliticianArea) {
        this.mPoliticianArea = mPoliticianArea;
    }

    public String getPoliticianCriminalRecord() {
        return mPoliticianCriminalRecord;
    }

    public void setPoliticianCriminalRecord(String mPoliticianCriminalRecord) {
        this.mPoliticianCriminalRecord = mPoliticianCriminalRecord;
    }


    public String getPoliticianEmailId() {
        return mPoliticianEmailId;
    }

    public void setPoliticianEmailId(String mPoliticianEmailId) {
        this.mPoliticianEmailId = mPoliticianEmailId;
    }

    public String getPoliticianNumber() {
        return mPoliticianNumber;
    }

    public void setPoliticianNumber(String mPoliticianNumber) {
        this.mPoliticianNumber = mPoliticianNumber;
    }
}
