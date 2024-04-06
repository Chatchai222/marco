package com.example.marco.file;

public class ImageDimension {
    
    private Integer pixelWidth;
    private Integer pixelHeight;

    public ImageDimension(Integer pixelWidth, Integer pixelHeight){
        this.pixelWidth = pixelWidth;
        this.pixelHeight = pixelHeight;
    }

    public Integer getPixelWidth() {
        return pixelWidth;
    }

    public void setPixelWidth(Integer pixelWidth) {
        this.pixelWidth = pixelWidth;
    }

    public Integer getPixelHeight() {
        return pixelHeight;
    }

    public void setPixelHeight(Integer pixelHeight) {
        this.pixelHeight = pixelHeight;
    }

    @Override
    public String toString() {
        return "ImageDimension [pixelWidth=" + pixelWidth + ", pixelHeight=" + pixelHeight + "]";
    }
}
