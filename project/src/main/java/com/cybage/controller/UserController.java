package com.cybage.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cybage.exception.UserException;
import com.cybage.model.User;
import com.cybage.model.Video;
import com.cybage.service.VideoService;




@ServletSecurity(value = @HttpConstraint(rolesAllowed = { "user" }))
public class UserController extends HttpServlet {
	public static final Logger log = LogManager.getLogger(UserController.class);

	private static final long serialVersionUID = 1L;

	public UserController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, UserException {

		PrintWriter pw = response.getWriter();
		String path = request.getPathInfo();
		int currentVideo= Integer.parseInt(path.substring(14));
		
		 VideoService videoService= null;
		if(path.substring(1, 13).equals("/start_video")) {
			System.out.println("vedio started....");
			
			List<Video> video= null;
			
			try {
				 video= videoService.findVideos();
				 request.getSession().setAttribute("video_count", video.size());
				 request.getSession().setAttribute("video_name", currentVideo);
				 
				 if(video.size()== 0) {
					 throw new UserException("No videos found in database..");
				 }
				 
				 request.getSession().setAttribute("video_id", video.get(currentVideo-1).getVideoId());
				 request.getSession().setAttribute("video_name", video.get(currentVideo-1).getVideoName());
				 request.getSession().setAttribute("video_url", video.get(currentVideo-1).getVideoUrl());
				 request.getSession().setAttribute("duration", video.get(currentVideo-1).getVideoDuration());
				 
				 response.sendRedirect(request.getContextPath()+ "/video-player.jsp");
			}catch(SQLException e) {
				log.error("could not get video : "+ e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (path.equals("/list")) {
			System.out.println("inside video method....");
			try {
				
				List<Video> videos = videoService.findVideos();
				request.setAttribute("videos", videos);

				request.getRequestDispatcher("/video-player.jsp").forward(request, response);

			} catch (Exception e) {
				System.out.println("error occurred: " + e.getMessage());
			}
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}