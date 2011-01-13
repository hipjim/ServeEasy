package com.serveeasy.model.bar;

import com.serveeasy.model.BarAware;

/**
 * User: elvis
 * Date: 11-Nov-2010
 * Time: 19:11:22
 */
public class BarDetails extends BarAware {

    private String imageName;
    private byte[] imageFileContent;
    private String imageFileMimeType;
    //todo: ar fi bine sa ne definim o clasa Email
    private String email;
    private String barName;
    private String country;
    private String city;
    private String state;
    private String zipCode;
    private String street;

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBarName() {
        return barName;
    }

    public void setBarName(String barName) {
        this.barName = barName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public byte[] getImageFileContent() {
        return imageFileContent;
    }

    public void setImageFileContent(byte[] imageFileContent) {
        this.imageFileContent = imageFileContent;
    }

    public String getImageFileMimeType() {
        return imageFileMimeType;
    }

    public void setImageFileMimeType(String imageFileMimeType) {
        this.imageFileMimeType = imageFileMimeType;
    }
}
