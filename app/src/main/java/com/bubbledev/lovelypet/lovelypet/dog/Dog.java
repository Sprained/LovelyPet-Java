package com.bubbledev.lovelypet.lovelypet.dog;

public class Dog {
    private String imgName;
    private String imgUrl;
    private String dogRaca;
    private String dogIdade;
    private String dogSub;

    public Dog(){

    }

    public Dog(String imgName, String imgUrl, String dogSub, String dogRaca, String dogIdade){
        if(imgName.trim().equals("")){
            imgName = "Sem Nome";
        }

        this.imgName = imgName;
        this.imgUrl = imgUrl;
        this.dogSub = dogSub;
        this.dogRaca = dogRaca;
        this.dogIdade = dogIdade;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDogRaca() {
        return dogRaca;
    }

    public void setDogRaca(String dogRaca) {
        this.dogRaca = dogRaca;
    }

    public String getDogIdade() {
        return dogIdade;
    }

    public void setDogIdade(String dogIdade) {
        this.dogIdade = dogIdade;
    }

    public String getDogSub() {
        return dogSub;
    }

    public void setDogSub(String dogSub) {
        this.dogSub = dogSub;
    }
}
