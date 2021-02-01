package com.netcom.netsmartapp.homePageFragments;

public class profile_model {
 private String about;
 private int logo;

    public profile_model(String about, int logo) {
        this.about = about;
        this.logo = logo;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }
}


