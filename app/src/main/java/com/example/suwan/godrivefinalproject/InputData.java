package com.example.suwan.godrivefinalproject;

/**
 * Created by Suwan on 19/06/2560.
 */

public class InputData {

    /**User**/
    private String username;
    private String place;
    private String date;
    private String time;
    /**Driver**/
    private String driverName;
    private String driverPhone;
    private int driverImage;

    public InputData() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public int getDriverImage() {
        return driverImage;
    }

    public void setDriverImage(int driverImage) {
        this.driverImage = driverImage;
    }
}
