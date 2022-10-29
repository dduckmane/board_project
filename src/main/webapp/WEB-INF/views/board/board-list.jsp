<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Matjip-list</title>
  <link rel="stylesheet" href="CSS/common.css">
  <link rel="stylesheet" href="CSS/board.css">
</head>
<body>
<!--헤더 -->
<header class="header-wrap clearfix">
  <div class="container">
    <h1>
      <a href="index.html">🍴Matjip</a>
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
        <a href="#">로그인</a>
        <a href="#">회원가입</a>
      </div>
    </nav>
  </div>
</header>

<!--컨텐츠 상단-->
<div class="contents">
  <div class="basic-info-list">
    <div class="inner" style="padding-bottom: 10px">
      <p class="status">
        <time datetime="2022-10-25">
          2022-10-25
        </time>
      </p>
      <h1 class="title">이달의 맛집 베스트 10</h1>
    </div>
  </div>
</div>

<!--맛집 리스트-->
<div class="list-wrap">
  <ul class="list">
    <li>
        <div class="list-box">
        <div class="thumb">
          <a href="#"><img src="img/food01.png" alt=""></a>
        </div>
        <div class="text-box">
          <h2>1. ㅇㅇㅇㅇㅇ</h2>
          <h3>주소:ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ</h3>
          <p></p>
          <a href="#">더보기</a>
        </div>
      </div>
    </li>
    <li>
      <div class="list-box">
        <div class="thumb">
          <a href="#"><img src="img/food01.png" alt=""></a>
        </div>
        <div class="text-box">
          <h2>2. ㅇㅇㅇㅇㅇ</h2>
          <h3>주소:ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ</h3>
          <p></p>
          <a href="#">더보기</a>
        </div>
      </div>
    </li>
    <li>
      <div class="list-box">
        <div class="thumb">
          <a href="#"><img src="img/food01.png" alt=""></a>
        </div>
        <div class="text-box">
          <h2>3. ㅇㅇㅇㅇㅇ</h2>
          <h3>주소:ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ</h3>
          <p></p>
          <a href="#">더보기</a>
        </div>
      </div>
    </li>
    <li>
      <div class="list-box">
        <div class="thumb">
          <a href="#"><img src="img/food01.png" alt=""></a>
        </div>
        <div class="text-box">
          <h2>4. ㅇㅇㅇㅇㅇ</h2>
          <h3>주소:ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ</h3>
          <p></p>
          <a href="#">더보기</a>
        </div>
      </div>
    </li>
    <li>
      <div class="list-box">
        <div class="thumb">
          <a href="#"><img src="img/food01.png" alt=""></a>
        </div>
        <div class="text-box">
          <h2>5. ㅇㅇㅇㅇㅇ</h2>
          <h3>주소:ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ</h3>
          <p></p>
          <a href="#">더보기</a>
        </div>
      </div>
    </li>
    <li>
      <div class="list-box">
        <div class="thumb">
          <a href="#"><img src="img/food01.png" alt=""></a>
        </div>
        <div class="text-box">
          <h2>6. ㅇㅇㅇㅇㅇ</h2>
          <h3>주소:ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ</h3>
          <p></p>
          <a href="#">더보기</a>
        </div>
      </div>
    </li>
    <li>
      <div class="list-box">
        <div class="thumb">
          <a href="#"><img src="img/food01.png" alt=""></a>
        </div>
        <div class="text-box">
          <h2>7. ㅇㅇㅇㅇㅇ</h2>
          <h3>주소:ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ</h3>
          <p></p>
          <a href="#">더보기</a>
        </div>
      </div>
    </li>
    <li>
      <div class="list-box">
        <div class="thumb">
          <a href="#"><img src="img/food01.png" alt=""></a>
        </div>
        <div class="text-box">
          <h2>8. ㅇㅇㅇㅇㅇ</h2>
          <h3>주소:ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ</h3>
          <p></p>
          <a href="#">더보기</a>
        </div>
      </div>
    </li>
    <li>
      <div class="list-box">
        <div class="thumb">
          <a href="#"><img src="img/food01.png" alt=""></a>
        </div>
        <div class="text-box">
          <h2>9. ㅇㅇㅇㅇㅇ</h2>
          <h3>주소:ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ</h3>
          <p></p>
          <a href="#">더보기</a>
        </div>
      </div>
    </li>
    <li>
      <div class="list-box">
        <div class="thumb">
          <a href="#"><img src="img/food01.png" alt=""></a>
        </div>
        <div class="text-box">
          <h2>10. ㅇㅇㅇㅇㅇ</h2>
          <h3>주소:ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ</h3>
          <p></p>
          <a href="#">더보기</a>
        </div>
      </div>
    </li>
  </ul>
</div>

<!--footer-->
<footer>
  <address>
    &copy; foot
  </address>
</footer>
</body>
</html>