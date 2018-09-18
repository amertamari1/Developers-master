package com.developers.developers;

public class TeamName {
    String mName;
    String mLink;
    int mImage;
    public TeamName(String name, String link, int image){
        mName = name;
        mLink = link;
        mImage = image;
    }

    public String getName(){
        return mName;
    }

    public String getmLink() {
        return mLink;
    }

    public int getmImage() {
        return mImage;
    }
}
