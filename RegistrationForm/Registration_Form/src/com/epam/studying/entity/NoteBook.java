package com.epam.studying.entity;

import java.util.Date;
import java.util.Objects;

public class NoteBook {
    private String surnameOfSubscriber;
    private String nameOfSubscriber;
    private String patronymicOfSubscriber;



    private String nickName;
    private String comment;

    private String homePhoneNumber;
    private String mobilePhoneNumber;

    private String email;
    private String skype;

    private Address address;

    private Date firstRecording;
    private Date lastRecording;


    public NoteBook(){

    }
    public NoteBook(String nameOfSubscriber, String nickName) {
        this.nameOfSubscriber = nameOfSubscriber;
        this.nickName = nickName;
    }

    public String fullName(){
        return String.format("%s %s.", surnameOfSubscriber, nameOfSubscriber.charAt(0));
    }

    public void setSurnameOfSubscriber(String surnameOfSubscriber) {
        this.surnameOfSubscriber = surnameOfSubscriber;
    }

    public void setNameOfSubscriber(String nameOfSubscriber) {
        this.nameOfSubscriber = nameOfSubscriber;
    }

    public void setPatronymicOfSubscriber(String patronymicOfSubscriber) {
        this.patronymicOfSubscriber = patronymicOfSubscriber;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getSurnameOfSubscriber() {
        return surnameOfSubscriber;
    }

    public String getNameOfSubscriber() {
        return nameOfSubscriber;
    }

    public String getPatronymicOfSubscriber() {
        return patronymicOfSubscriber;
    }

    public String getNickName() {
        return nickName;
    }

    public String getComment() {
        return comment;
    }

    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getSkype() {
        return skype;
    }

    public Address getAddress() {
        return address;
    }

    public Date getFirstRecording() {
        return firstRecording;
    }

    public Date getLastRecording() {
        return lastRecording;
    }
}
