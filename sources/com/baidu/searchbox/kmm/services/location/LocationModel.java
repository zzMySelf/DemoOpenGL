package com.baidu.searchbox.kmm.services.location;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b \n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R(\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR(\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR(\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR(\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR(\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR(\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR$\u0010\"\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR(\u0010%\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR(\u0010(\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR$\u0010,\u001a\u00020+2\u0006\u0010\u0003\u001a\u00020+@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00101\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\r\"\u0004\b3\u0010\u000fR(\u00104\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0007\"\u0004\b6\u0010\tR$\u00107\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\r\"\u0004\b9\u0010\u000fR$\u0010;\u001a\u00020:2\u0006\u0010\u0003\u001a\u00020:@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R(\u0010@\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0007\"\u0004\bB\u0010\tR(\u0010C\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0007\"\u0004\bE\u0010\t¨\u0006F"}, d2 = {"Lcom/baidu/searchbox/kmm/services/location/LocationModel;", "", "()V", "<set-?>", "", "addressStr", "getAddressStr", "()Ljava/lang/String;", "setAddressStr$com_baidu_searchbox_kmm_services_location", "(Ljava/lang/String;)V", "", "altitude", "getAltitude", "()D", "setAltitude$com_baidu_searchbox_kmm_services_location", "(D)V", "city", "getCity", "setCity$com_baidu_searchbox_kmm_services_location", "cityCode", "getCityCode", "setCityCode$com_baidu_searchbox_kmm_services_location", "coorType", "getCoorType", "setCoorType$com_baidu_searchbox_kmm_services_location", "country", "getCountry", "setCountry$com_baidu_searchbox_kmm_services_location", "countryCode", "getCountryCode", "setCountryCode$com_baidu_searchbox_kmm_services_location", "district", "getDistrict", "setDistrict$com_baidu_searchbox_kmm_services_location", "latitude", "getLatitude", "setLatitude$com_baidu_searchbox_kmm_services_location", "locDescribe", "getLocDescribe", "setLocDescribe$com_baidu_searchbox_kmm_services_location", "location", "getLocation", "setLocation$com_baidu_searchbox_kmm_services_location", "", "locationType", "getLocationType", "()I", "setLocationType$com_baidu_searchbox_kmm_services_location", "(I)V", "longitude", "getLongitude", "setLongitude$com_baidu_searchbox_kmm_services_location", "province", "getProvince", "setProvince$com_baidu_searchbox_kmm_services_location", "radius", "getRadius", "setRadius$com_baidu_searchbox_kmm_services_location", "", "speed", "getSpeed", "()F", "setSpeed$com_baidu_searchbox_kmm_services_location", "(F)V", "street", "getStreet", "setStreet$com_baidu_searchbox_kmm_services_location", "streetNo", "getStreetNo", "setStreetNo$com_baidu_searchbox_kmm_services_location", "com.baidu.searchbox.kmm.services.location"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LocationModel.kt */
public final class LocationModel {
    private String addressStr;
    private double altitude;
    private String city;
    private String cityCode;
    private String coorType;
    private String country;
    private String countryCode;
    private String district;
    private double latitude;
    private String locDescribe;
    private String location;
    private int locationType = -1;
    private double longitude;
    private String province;
    private double radius;
    private float speed;
    private String street;
    private String streetNo;

    public final String getLocation() {
        return this.location;
    }

    public final void setLocation$com_baidu_searchbox_kmm_services_location(String str) {
        this.location = str;
    }

    public final int getLocationType() {
        return this.locationType;
    }

    public final void setLocationType$com_baidu_searchbox_kmm_services_location(int i2) {
        this.locationType = i2;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final void setLongitude$com_baidu_searchbox_kmm_services_location(double d2) {
        this.longitude = d2;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final void setLatitude$com_baidu_searchbox_kmm_services_location(double d2) {
        this.latitude = d2;
    }

    public final double getRadius() {
        return this.radius;
    }

    public final void setRadius$com_baidu_searchbox_kmm_services_location(double d2) {
        this.radius = d2;
    }

    public final double getAltitude() {
        return this.altitude;
    }

    public final void setAltitude$com_baidu_searchbox_kmm_services_location(double d2) {
        this.altitude = d2;
    }

    public final float getSpeed() {
        return this.speed;
    }

    public final void setSpeed$com_baidu_searchbox_kmm_services_location(float f2) {
        this.speed = f2;
    }

    public final String getAddressStr() {
        return this.addressStr;
    }

    public final void setAddressStr$com_baidu_searchbox_kmm_services_location(String str) {
        this.addressStr = str;
    }

    public final String getCountry() {
        return this.country;
    }

    public final void setCountry$com_baidu_searchbox_kmm_services_location(String str) {
        this.country = str;
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    public final void setCountryCode$com_baidu_searchbox_kmm_services_location(String str) {
        this.countryCode = str;
    }

    public final String getProvince() {
        return this.province;
    }

    public final void setProvince$com_baidu_searchbox_kmm_services_location(String str) {
        this.province = str;
    }

    public final String getCity() {
        return this.city;
    }

    public final void setCity$com_baidu_searchbox_kmm_services_location(String str) {
        this.city = str;
    }

    public final String getCityCode() {
        return this.cityCode;
    }

    public final void setCityCode$com_baidu_searchbox_kmm_services_location(String str) {
        this.cityCode = str;
    }

    public final String getDistrict() {
        return this.district;
    }

    public final void setDistrict$com_baidu_searchbox_kmm_services_location(String str) {
        this.district = str;
    }

    public final String getStreet() {
        return this.street;
    }

    public final void setStreet$com_baidu_searchbox_kmm_services_location(String str) {
        this.street = str;
    }

    public final String getStreetNo() {
        return this.streetNo;
    }

    public final void setStreetNo$com_baidu_searchbox_kmm_services_location(String str) {
        this.streetNo = str;
    }

    public final String getCoorType() {
        return this.coorType;
    }

    public final void setCoorType$com_baidu_searchbox_kmm_services_location(String str) {
        this.coorType = str;
    }

    public final String getLocDescribe() {
        return this.locDescribe;
    }

    public final void setLocDescribe$com_baidu_searchbox_kmm_services_location(String str) {
        this.locDescribe = str;
    }
}
