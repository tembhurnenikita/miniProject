package com.cybage.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cybage.dao.VideoDao;
import com.cybage.model.Video;

public class VideoServiceImpl implements VideoService {
	
	// public static final Logger log = LogManager.getLogger(VideoServiceImpl.class);
	

	private VideoDao videoDao;
	public VideoServiceImpl(VideoDao videoDao) {
		this.videoDao = videoDao;
	}

	public List<Video> findVideos() throws Exception {
		return videoDao.findVideos();
	}
}
