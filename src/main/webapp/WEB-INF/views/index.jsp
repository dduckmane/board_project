<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>🍴Matjip</title>
  <link rel="stylesheet" href="CSS/common.css">
</head>

<body>
  <!--   1-->
  <header class="header-wrap clearfix">
    <div class="container">
      <h1>
        <a href="index.jsp">🍴Matjip</a>
      </h1>
      <div class="serch">
        <input type="text" class="serch_input" placeholder="지역, 식당 또는 음식">
        <button class="serch_button">검색</button>
      </div>
      <nav class="tnb">
        <div class="menu-btn">
          <a href="#">
            <img src="img/menu-btn.png" alt="">
          </a>
        </div>
        <div class="tnb-menu">
          <a href="login.jsp">로그인</a>
          <a href="signup.jsp">회원가입</a>
        </div>
      </nav>
    </div>
  </header>
  <!--   2-->
  <main class="main-wrap clearfix">
    <section>
      <div class="month">
        <div class="month-top cf">
          <h2>이달의 맛집</h2>
          <h3>콩나물 해장국</h3>
          <div class="more">
            <a href="#">더보기</a>
          </div>
        </div>
        <div class="month-bot">
          <div class="mon">
            <a href="#" >
              <img src="img/3.png" alt="1">
            </a>
          </div>
          <div class="mon">
            <a href="#" >
              <img src="img/3.png" alt="2">
            </a>
          </div>
          <div class="mon">
            <a href="#" >
              <img src="img/3.png" alt="3">
            </a>
          </div>
        </div>
      </div>
      <p>일단 임시로 2개만 만들었어요 그냥 테스트용이어서 지우세요</p>
      <h1><a href="http://localhost:8080/user/board/list/1">맛집리스트 1</a></h1>
      <h1><a href="http://localhost:8080/user/board/list/2">맛집리스트 2</a></h1>
      <div class="area">
        <div class="area-top cf">
         <h2>지역별 맛집</h2>
          <h3>위아래왼오</h3>
        </div>
        <div class="area-bot">
          <div class="area-con">
            <a href="#">
              <img src="img/4.png" alt="서울">
            </a>
            <p>서울</p>
          </div>
          <div class="area-con">
            <a href="#">
              <img src="img/4.png" alt="경기">
              <p>경기</p>
            </a>
          </div>
          <div class="area-con">
            <a href="#">
              <img src="img/4.png" alt="부산">
              <p>부산</p>
            </a>
          </div>
          <div class="area-con">
            <a href="#">
              <img src="img/4.png" alt="제주">
              <p>제주</p>
            </a>
          </div>
          
          </div>
        </div>
      <div class="world">
        <div class="world-top">
          <h2>카테고리별 맛집</h2>
          <h3>세계음식</h3>
        </div>
        <div class="world-bot">
          <div class="world-con">
            <a href="#">
              <img src="img/4.png" alt="1">
            </a>
            <p>한식</p>
          </div>
          <div class="world-con">
            <a href="#">
              <img src="img/4.png" alt="1">
            </a>
            <p>양식</p>
          </div>
          <div class="world-con">
            <a href="#">
              <img src="img/4.png" alt="1">
            </a>
            <p>중식</p>
          </div>
          <div class="world-con">
            <a href="#">
              <img src="img/4.png" alt="1">
            </a>
            <p>일식</p>
          </div>
          
        </div>
      </div>
    </section>
<!--    <aside>-->
<!--      <div class="login-box">로그인박스</div>-->
<!--      <div class="mini-banner"></div>-->
<!--    </aside>-->
  </main>
  <!--   3-->
  <footer>
    <address>
      &copy; foot
    </address>
  </footer>

</body>

</html>








