package com.cybage.dao;

import java.sql.SQLException;
import java.util.List;

import com.cybage.model.User;
import com.cybage.model.Video;

public interface VideoDao {
	public List<Video> findVideos() throws Exception;
}
