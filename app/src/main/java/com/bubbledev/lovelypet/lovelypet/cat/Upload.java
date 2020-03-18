package com.bubbledev.lovelypet.lovelypet.cat;

public class Upload {
    private String imgName;
    private String imgUrl;
    private String catRaca;
    private String catIdade;
    private String catSub;
    private String catLocalizacao;

    public Upload() {
    }

    public Upload(String imgName, String imgUrl, String catSub, String catRaca, String catIdade, String catLocalizacao) {
        if(imgName.trim().equals(""))
        {
            imgName="Sem Nome";
        }
        this.imgName = imgName;
        this.imgUrl = imgUrl;
        this.catSub = catSub;
        this.catRaca = catRaca;
        this.catIdade = catIdade;
        this.catLocalizacao = catLocalizacao;
    }

    public String getCatIdade(){
        return catIdade;
    }
    public void setcatIdade(String catIdade){
        this.catIdade = catIdade;
    }

    public String getCatRaca(){
        return catRaca;
    }
    public void setCatRaca(String catRaca){
        this.catRaca = catRaca;
    }

    public String getCatSub(){
        return catSub;
    }

    public void setCatSub(String catSub){
        this.catSub = catSub;
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

    public void setCatIdade(String catIdade) {
        this.catIdade = catIdade;
    }

    public String getCatLocalizacao() {
        return catLocalizacao;
    }

    public void setCatLocalizacao(String catLocalizacao) {
        this.catLocalizacao = catLocalizacao;
    }
}