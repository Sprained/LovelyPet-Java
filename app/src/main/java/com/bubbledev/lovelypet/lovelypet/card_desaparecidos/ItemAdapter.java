package com.bubbledev.lovelypet.lovelypet.card_desaparecidos;

public class ItemAdapter {
    private String Title;
    private String Sub ;
    private int Thumbnail ;
    private String SubChar;


    public ItemAdapter(String title, String desc, int thumbnail, String subChar) {
        Title = title;
        Sub = desc;
        Thumbnail = thumbnail;
        SubChar = subChar;
    }


    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Sub;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public String getSubChar(){
        return SubChar;
    }


    public void setTitle(String title) {
        Title = title;
    }


    public void setDescription(String description) {
        Sub = description;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }

    public void setSubChar(String subChar){
        SubChar = subChar;
    }
}
