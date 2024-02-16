<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="Login.css">
  <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
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
    <form class="formTag"method="POST"action="login">
      <p class="LoginHeading">Login Page</p>
      <div class="inputBoxes">
        <input
          class="inputs"
          type="text"
          placeholder="Enter your UserName"
          name="UserName"
        />
        <br />
        <input
          class="inputs"
          type="text"
          placeholder="Enter your MobileNum"
          name="MobileNum"
        />
        <br />
        <input
          class="inputs"
          type="password"
          placeholder="Enter Password"
          name="loginPassword"
        />
        <br />
        <button href="Login.jsp"class="btn btn-primary LoginBtn">
          Login
        </button>
        <p class="dontHaveAcc">
          Dont Have an Account?
          <a class="signUp" href="Signup.jsp">
            Signup
          </a>
        </p>
      </div>
    </form>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
  <script type="text/javascript"src="MessageApp.js"></script>
</body>
</html>