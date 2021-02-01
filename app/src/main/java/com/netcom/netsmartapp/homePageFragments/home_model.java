package com.netcom.netsmartapp.homePageFragments;

public class home_model {

    int img;
    String img_name;
    String sub_card_bg;



    public home_model(int img, String img_name, String sub_card_bg) {
        this.img = img;
        this.img_name = img_name;
        this.sub_card_bg = sub_card_bg;
    }

    public int getImage() {
        return img;
    }

    public void setImage(int img) {
        this.img = img;
    }

    public String getImg_name() {
        return img_name;
    }

    public void setImg_name(String img_name) {
        this.img_name = img_name;
    }

    public String getSub_card_bg() { return sub_card_bg; }

    public void setSub_card_bg(String sub_card_bg) { this.sub_card_bg = sub_card_bg; }
}


