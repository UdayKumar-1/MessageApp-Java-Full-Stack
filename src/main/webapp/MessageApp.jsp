<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%@ page import="com.org.MessageApp.User"%>
<%@ page import="com.org.MessageApp.Message" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Document</title>
    <link rel="stylesheet" href="MessageAppMainn.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
  </head>
  <body>
    <div class="MainSidebar">
      <div class="d-flex flex-column align-items-stretch flex-shrink-0 bg-body-tertiary sidebarSlider">
        <a href="/" class="d-flex align-items-center flex-shrink-0 p-3 link-body-emphasis text-decoration-none border-bottom">
          <svg class="bi pe-none me-2" width="30" height="24"><use xlink:href="#bootstrap"></use></svg>
          <%
            String UserName=(String)session.getAttribute("senderUserId");
          %>
          <span class="fs-5 fw-semibold"><%=UserName %></span>
        </a>
        <div class="list-group list-group-flush border-bottom scrollarea">
          <%
	      ArrayList<User>AllUsers=(ArrayList<User>)session.getAttribute("usersList");
          ArrayList<Message>AllMessage=(ArrayList<Message>)request.getAttribute("AllMsg");
          Integer SUserId=(Integer)session.getAttribute("sendUserId");
          System.out.println("All userList "+AllUsers);
          System.out.println("All Message List "+AllMessage);
	      if(AllUsers!=null&&!AllUsers.isEmpty()){
		      for(User u:AllUsers){
		      if(u.getId()!=SUserId){
	    	  byte[] imageData = u.getImage();
	    	  String encodedImage = Base64.getEncoder().encodeToString(imageData);%>
	            <div class="MessageSidebar"onclick="window.location.href='http://localhost:8080/MessageApp/rendermessages?user=<%=u.getId()%>'">           
	            <div>
	              <%
	              try {
					String base64Image = Base64.getEncoder().encodeToString(imageData);
					%>
					    <img src="data:image/jpeg;base64, <%=base64Image %>" class="MessageMainPic">
					<%
					} catch (Exception ex) {
					    ex.printStackTrace();
					} 
				  %>
	            </div>
	            <div class="MessageName">
	              <strong class="HeadingSidebar"><%=u.getName() %></strong>
	              <div class="MessageSubHead"><%=u.getDescr()%></div>
	            </div>
	          </div>
	      <%}}}else { 
            %>
            <div class="NoData">There is No Customer Transactions</div>
            <%} %>
        </div>
      </div>
      <p class="hrClass">______________________________________________________________________________________________________________________________________________________________</p>
      <div class="messages">
        <div class="pmessageMain">
          <div class="MessageHeadMainBar">
            <div class="MessageHead">
	           <%Integer RUserIds=(Integer)request.getAttribute("RUserId"); 
	            /* System.out.println("RUserId of Path after clicking "+RUserIds); */
	            ArrayList<Message>AllMessagess=(ArrayList<Message>)request.getAttribute("AllMsg");
	            ArrayList<User>AllUserRecord=(ArrayList<User>)request.getAttribute("AllUsersRecords");
	            /* System.out.println("RUserMessages of Path After Clicking "+AllMessagess); */
	            if(AllUserRecord!=null&&!AllUserRecord.isEmpty()){
	            for(User u:AllUserRecord){
	            if(u.getId()==RUserIds){
	            byte[]ImageOfRuserId=u.getImage();
	            String ImageEncode=Base64.getEncoder().encodeToString(ImageOfRuserId);
	            %>
	            	<img src="data:image/jpeg;base64, <%=ImageEncode %>"class="ImageNav">
	            	<span class="NameNav"><%=u.getName() %></span>
	            <%}
	            }}
	           %>
            </div>
          </div>
          <hr class="hrClass">
          <div class="messagemiddle">
            <div class="SingleMessage">
              <%
                Integer SenderUId = (Integer)session.getAttribute("sendUserId");
                System.out.println("SendUserId "+SenderUId);
                System.out.println("RUserId In MEssageAPp.jsp "+RUserIds);
		        if(AllMessagess!=null&&!AllMessagess.isEmpty()){
		          for(Message msg:AllMessagess){
	        		String encodeMsg= Base64.getEncoder().encodeToString(msg.getMimage());
	        	    if (msg.getRuserid()==RUserIds&&msg.getSuserid()==SenderUId) {%>
	        	    <%if(!msg.getMcontent().equalsIgnoreCase("")){%>
		        	    <div class="MessageFlexright">
		        	      <p class="onemessageright"><%=msg.getMcontent() %></p>
	                      <button class="btn btn-danger deleteButtonTagrightText"onclick="DeleteTextMessage('<%=msg.getMid()%>','<%=RUserIds%>')"><i class='bx bxs-trash-alt imgdeleteBtnright'></i></button>
	                    </div>
                    <%} %>
                    <%if(msg.getMimage().length!=0){ %>
	                <div class="MessageFlexright">
			          <img class="ImageRight"src="data:image/jpeg;base64,<%=encodeMsg %>">
			          <button class="btn btn-danger deleteButtonTagright"><i class='bx bxs-trash-alt imgdeleteBtnright'></i></button>
		            </div>
		           <%}}
                    else if(SenderUId==msg.getRuserid()&&msg.getSuserid()==RUserIds){System.out.println("Entered Else Block in MessageApp.jsp ");%>
	        	    <%if(!msg.getMcontent().equalsIgnoreCase("")){ %>
		        	    <div class="MessageFlexleft">
		             	  <span class="onemessageleft"><%=msg.getMcontent() %></span>
	                      <button class="btn btn-danger deleteButtonTagleft"><i class='bx bxs-trash-alt imgdeleteBtnleft'></i></button>
	                    </div>
                    <%} %>
                    <%if(msg.getMimage().length!=0){ %>
	                <div class="MessageFlexleft">
			          <img class="PostImageleft"src="data:image/jpeg;base64,<%=encodeMsg %>">
			          <button class="btn btn-danger deleteButtonTagleft"><i class='bx bxs-trash-alt imgdeleteBtnleft'></i></button>
		            </div>
		            <%}%>
		        <%}}}%>
		    </div>
          </div>
          <footer>
            <div class="MessageBody">
            <form action="sendmessage"method="POST"enctype="multipart/form-data">
	          <input type="hidden" name="userId"class="userIdClass"value='<%=RUserIds%>'>
	          <input type="text" class="footerInput" placeholder="Message...."name="messageType"/>
	          <label for="FileValue" class="custom-file-label">
	          <button class="btn btn-dark Gallery"><i class='bx bx-photo-album galleryIcon'></i></button>
	          </label>
	          <input id="FileValue" type="file"class="VideoUpload"name="ImageParse"/>
	          <button class="btn btn-primary sendbtn">
	            <i class='bx bx-send'></i>
	          </button>
	        </form>
            </div>
          </footer>
        </div>
      </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <script type="text/javascript">
    function DeleteTextMessage(TextMessage,RID){
        console.log(TextMessage,RID);
        let RUID = RID.toString();
        var formData = new FormData();
        formData.append("MessageData", TextMessage);
        formData.append("user",RUID);
        console.log("FormData Get User",formData.get("user"));
        // Make a Fetch POST request
        let url="http://localhost:8080/MessageApp/rendermessages";
        console.log(url);
        fetch(url, {
          method: 'POST',
          body: formData,
        })
        .then(response => {
          // Handle the response here if needed
          if (!response.ok) {
            throw new Error('Network response was not ok');
          }
          return response.text();
        })
        .then(data => {
          console.log(data);
        })
        .catch(error => {
          console.error('Error:', error);
        });
    }

    </script>
  </body>
</html>