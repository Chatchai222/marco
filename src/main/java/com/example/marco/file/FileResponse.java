package com.example.marco.file;

public class FileResponse {

    private Long fileId;
    private String name;
    private Long size;
    private String downloadUrl;
    private String viewUrl;
    private String contentType;
    private Integer pixelWidth;
    private Integer pixelHeight;

    public Long getFileId() {
        return fileId;
    }
    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getSize() {
        return size;
    }
    public void setSize(Long size) {
        this.size = size;
    }
    public String getDownloadUrl() {
        return downloadUrl;
    }
    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }
    public String getViewUrl() {
        return viewUrl;
    }
    public void setViewUrl(String viewUrl) {
        this.viewUrl = viewUrl;
    }
    public String getContentType() {
        return contentType;
    }
    public void setContentType(String contentType) {
        this.contentType = contentType;
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

}
