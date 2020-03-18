package com.bubbledev.lovelypet.lovelypet.eventos;


public class ItemEventosAdapter {
    private String Title;
    private String Sub;
    private String Loc;
    private int Thumbnail;

    public ItemEventosAdapter(String title, String desc, String loca, int thumbnail) {
        Title = title;
        Sub = desc;
        Loc = loca;
        Thumbnail = thumbnail;
    }


    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Sub;
    }

    public String getLocals() {
        return Loc;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setLocals(String locals) {
        Loc = locals;
    }

    public void setDescription(String description) {
        Sub = description;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}
