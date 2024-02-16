<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/bootstrap.css">
  <link rel="stylesheet" href="Login.css">
  <title>Document</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
  <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
  <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between border-bottom headerTag">
    <div class="LogoName">
      <i class='bx bxs-message-rounded InstaLogo'></i>
      <span class="InstaName">Messages</span>
    </div>
    <div class="col-md-3 mb-2 mb-md-0">
      <a
        href="/"
        class="d-inline-flex link-body-emphasis text-decoration-none"
      ></a>
    </div>
    <div class="col-md-3 text-end">
      <a
        href="Login.jsp"
        type="button"
        class="btn btn-outline-primary me-2"
      >
        Login
    </a>
      <a href="Signup.jsp" type="button" class="btn btn-primary signup">
        Sign-up
      </a>
    </div>
  </header>
  <div class="MainBox">
    <form class="formTag"action="signup"method="POST"enctype="multipart/form-data">
      <p class="LoginHeading">Login Page</p>
      <div class="inputBoxes">
        <input
          class="inputs"
          type="text"
          placeholder="Enter your Name"
          name="userName"
        />
        <br />
        <input
          class="inputs"
          type="text"
          placeholder="Enter Bio"
          name="userBio"
        />
        <br />
        <input
          class="inputs"
          type="text"
          placeholder="Enter Mobile Number"
          name="userNumber"
        />
        <br />
        <input
          class="inputs"
          type="password"
          placeholder="Enter Password"
          name="userPassword"
        />
        <br />
        <input
          class="inputs"
          type="password"
          placeholder="Confirm Password"
          name="userCnfPassword"
        />
        <br />
        <span class="nameImage">Upload Image</span>
        <label for="FileValue"><i class='bx bx-cloud-upload uploadImage'></i></label>
        <input type="file"name="userImage"id=""class="FileValue">
        <button class="btn btn-primary LoginBtn"href="Signup.jsp">
          Signup
        </button>
        <p class="dontHaveAcc">
          Already Have an Account?
          <a class="signUp" href="Login.jsp">
            Login
          </a>
        </p>
      </div>
    </form>
  </div>
  <script src="css/bootstrap.min.js"></script>
</body>
</html>