package com.example.myrs;

public class DataModel {
    private String name;
    private String version;
    private int image;
    private String summery;

    public DataModel(String name, String version, int image, String summery) {
        this.name = name;
        this.version = version;
        this.image = image;
        this.summery=summery;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
    public String getSummery() { return summery; }

    public void setSummery(String summery) { this.summery = summery; }
}


