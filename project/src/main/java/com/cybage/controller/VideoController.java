package com.cybage.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybage.dao.VideoDao;
import com.cybage.dao.VideoDaoImpl;
import com.cybage.model.Video;
import com.cybage.service.VideoService;
import com.cybage.service.VideoServiceImpl;
import javax.sound.*;
import javax.swing.*;


public class VideoController extends HttpServlet {
	
	private VideoDao videoDao = new VideoDaoImpl();

	private VideoService videoService = new VideoServiceImpl(videoDao);
	
	private static final long serialVersionUID = 1L;

	public VideoController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();

		System.out.println("inside video controller");

		String path = request.getPathInfo();

		if (path.equals("/list")) {
			try {
				System.out.println("inside video method....");
				
				List<Video> videos = videoService.findVideos();
				request.setAttribute("videos", videos);

				request.getRequestDispatcher("/video-player.jsp").forward(request, response);

			} catch (Exception e) {
				System.out.println("In catch block");
				System.out.println("error occurred: " + e.getCause());
			}
		}
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
		

}
