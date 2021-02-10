package com.cybage.model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Video  {
	private int videoId;
	private int courseId;
	private String videoName;
	private int videoDuration;
	private String videoUrl;
	
	
	public Video() {
		super();
	}
	public Video(int videoId, int courseId, String videoName, int videoDuration, String videoUrl) {
		super();
		this.videoId = videoId;
		this.courseId = courseId;
		this.videoName = videoName;
		this.videoDuration = videoDuration;
		this.videoUrl = videoUrl;
	}
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	public int getVideoDuration() {
		return videoDuration;
	}
	public void setVideoDuration(int videoDuration) {
		this.videoDuration = videoDuration;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	@Override
	public String toString() {
		return "Video [videoId=" + videoId + ", courseId=" + courseId + ", videoName=" + videoName + ", videoDuration="
				+ videoDuration + ", videoUrl=" + videoUrl + "]";
	}
	
	
	

}
