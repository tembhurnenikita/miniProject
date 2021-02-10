package com.cybage.service;

import java.sql.SQLException;
import java.util.List;

import com.cybage.model.Video;

public interface VideoService {
	public List<Video> findVideos() throws Exception;

}
