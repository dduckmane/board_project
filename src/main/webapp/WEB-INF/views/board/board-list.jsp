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
<h2><a href="http://localhost:8080/user/board/save/${groupId}">글쓰기</a></h2>



<!--맛집 리스트-->
<div class="list-wrap">
  <ul class="list">
    <c:forEach var="item" items="${BoardDtoList}">
      <li>
        <div class="list-box">
          <div class="text-box">
            <a href="http://localhost:8080/user/board/${(item.id)}">  id: ${item.id} 제목: ${item.subTitle} 조회수: ${item.viewCnt} 작성자:  ${item.name} 신규글:  ${item.newArticle} </a>
          </div>
        </div>
      </li>
    </c:forEach>

  </ul>
<%--  누님 페이징 부탁해용 이 6가지 정보로 페이징을 충분히 하실꺼라 밑어요--%>
  ${pageMaker.startPage}
  ${pageMaker.endPage}
  ${pageMaker.nowPage}
  ${pageMaker.first}
  ${pageMaker.last}
  ${pageMaker.totalPages}

</div>

<!--footer-->
<footer>
  <address>
    &copy; foot
  </address>
</footer>
</body>
</html>