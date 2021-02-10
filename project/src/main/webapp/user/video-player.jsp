
<body>
	<div class="content-holder">
	<H1>Course Video</H1>
	
	<video class="center" id="myVideo" width="800" height="550" controls>
		<source src= '1.mp4'
			type="video/mp4">
		Your browser does not support HTML5 video.
	</video>
	<br>
	
		<button class="back" type="button" onclick="back()">Back</button>
		<button class="next" type="button" onclick="next()">Next</button>
	</div>
	<script>
	 videolength='<%=session.getAttribute("video.length")%>';
	
	$(document).ready(function(){
		function next(){
			alert("gdftggbfg");
		    if (currentvideo == videolength - 1){
		         slideTo(0);
		    }
		    else{
		        slideTo(currentvideo + 1);
		    }       
		}
		
		function back(){
			alert("gdftggbfg");
		    if (currentvideo == 0){
		        slideTo(videolength - 1);
		    } 
		    else{
		        slideTo(currentvideo - 1);
		    }       
		   }
		});  
	
	</script>
	
<!-- <%=session.getAttribute("video_url")%> -->
</body>