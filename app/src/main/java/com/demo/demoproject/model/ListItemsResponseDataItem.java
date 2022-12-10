package com.demo.demoproject.model;

import com.google.gson.annotations.SerializedName;

public class ListItemsResponseDataItem{

	@SerializedName("author")
	private String author;

	@SerializedName("width")
	private int width;

	@SerializedName("download_url")
	private String downloadUrl;

	@SerializedName("id")
	private String id;

	@SerializedName("url")
	private String url;

	@SerializedName("height")
	private int height;
	public ListItemsResponseDataItem(){}
	public void setAuthor(String author){
		this.author = author;
	}

	public String getAuthor(){
		return author;
	}

	public void setWidth(int width){
		this.width = width;
	}

	public int getWidth(){
		return width;
	}

	public void setDownloadUrl(String downloadUrl){
		this.downloadUrl = downloadUrl;
	}

	public String getDownloadUrl(){
		return downloadUrl;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setHeight(int height){
		this.height = height;
	}

	public int getHeight(){
		return height;
	}
}