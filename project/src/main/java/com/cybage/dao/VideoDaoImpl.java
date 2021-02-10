package com.cybage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cybage.model.Video;
import com.cybage.util.DbUtil;

public class VideoDaoImpl implements VideoDao {
	public List<Video> findVideos() throws Exception {
		System.out.println("This is dao");
		Connection con = DbUtil.getCon();

		String sql = "select video_id,video_name,duration,video_url from video";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		
		List<Video> videos = new ArrayList<Video>();
		while (rs.next()) {
			Video video= new Video();
			video.setVideoId(rs.getInt(1));
			video.setVideoName(rs.getString(3));
			video.setVideoDuration(rs.getInt(4));
			video.setVideoUrl(rs.getString(5));
		
			videos.add(video);
		}
		System.out.println(videos);
		return videos;
	}

}