<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
        integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.css"
        integrity="sha512-yHknP1/AwR+yx26cB1y0cjvQUMvEa2PFzt1c9LlS4pRQ5NOTZFWbhBig+X9G9eYW/8m0/4OXNx8pxJ6z57x0dw=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick-theme.min.css"
        integrity="sha512-17EgCFERpgZKcm0j0fEq1YCJuyAWdz9KUtv1EjVuaOz8pDnh/0nZxmU6BBXwaaxqoi9PQXnRWqlcDB027hgv9A=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link rel="stylesheet" href="css/app.css">
  <title>🍴Matjip</title>




</head>

<body>
<nav class="py-2 bg-light border-bottom">
  <div class="container d-flex flex-wrap">
    <ul class="nav me-auto">
      <li class="nav-item"><a href="/" class="nav-link link-dark px-2 active" aria-current="page">Home</a></li>
      <li class="nav-item"><a href="/user/board/list/1" class="nav-link link-dark px-2">한식</a></li>
      <li class="nav-item"><a href="/user/board/list/2" class="nav-link link-dark px-2">양식</a></li>
      <li class="nav-item"><a href="/user/board/list/3" class="nav-link link-dark px-2">중식</a></li>
      <li class="nav-item"><a href="/user/board/list/4" class="nav-link link-dark px-2">일식</a></li>
    </ul>
    <ul class="nav">
      <li class="nav-item"><a href="#" class="nav-link link-dark px-2">로그인</a></li>
      <li class="nav-item"><a href="#" class="nav-link link-dark px-2">회원가입</a></li>
    </ul>
  </div>
</nav>

<header class="py-3 mb-4 border-bottom">
  <div class="container d-flex flex-wrap justify-content-center">
    <a href="#" class="d-flex align-items-center mb-3 mb-lg-0 me-lg-auto text-dark text-decoration-none">
      <!-- <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"></use></svg> -->
      <span class="fs-4">🍴Matjip</span>
    </a>
    <form class="col-12 col-lg-auto mb-3 mb-lg-0" role="search">
      <input type="search" class="form-control" placeholder="지역, 식당 또는 음식" aria-label="Search">
    </form>
  </div>
</header>
<body>
<h2><a href="/user/board/save/${groupId}">글쓰기</a></h2>



<!--맛집 리스트-->
<div class="list-wrap">
  <ul class="list">
    <c:forEach var="item" items="${BoardDtoList}">
      <li>
        <div class="list-box">
          <div class="text-box">
            <a href="/user/board/${(item.id)}">  id: ${item.id} 제목: ${item.subTitle} 조회수: ${item.viewCnt} 작성자:  ${item.name} 신규글:  ${item.newArticle} </a>
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

<footer id="footer">
  <div class="section-content">
    <div class="container">
      <div class="row">
        <div class="col-md-3 mb-4 text-center footer-1">
          <!-- <img src="./assets/images/bootstrap-big-logo.png" alt="Logo" class="img-fluid footer-logo"> -->
          <div class="sns mt-4">
            <a target="_blank" href="#" class="mx-1 text-decoration-none social">
              <img src="/img/icon-facebook.png" alt="Facebook" width="38px">
            </a>
            <a target="_blank" href="#" class="mx-1 text-decoration-none social">
              <img src="/img/icon-instagram.png" alt="Instagram" width="38px">
            </a>
            <a target="_blank" href="#" class="mx-1 text-decoration-none social">
              <img src="/img/icon-twitter.png" alt="Twitter" width="38px">
            </a>
            <a target="_blank" href="#" class="mx-1 text-decoration-none social">
              <img src="/img/icon-youtube.png" alt="Youtube" width="38px">
            </a>
            <a target="_blank" href="#" class="mx-1 text-decoration-none social">
              <img src="/img/icon-naver-block.png" alt="Naver blog" width="38px">
            </a>
            <a target="_blank" href="#" class="mx-1 text-decoration-none social">
              <img src="/img/icon-kakao-channel.png" alt="Kakao Channel" width="38px">
            </a>
          </div>
        </div>
        <div class="col-md-3 mb-4 footer-2">
          <h4 class="mb-4">Footer 2</h4>
          <ul>
            <li>Lorem ipsum dolor sit.</li>
            <li>Lorem ipsum dolor sit.</li>
            <li>Lorem ipsum dolor sit.</li>
            <li>Lorem ipsum dolor sit.</li>
          </ul>
        </div>
        <div class="col-md-3 mb-4 footer-3">
          <h4 class="mb-4">Footer 3</h4>
          <ul>
            <li>Lorem ipsum dolor sit.</li>
            <li>Lorem ipsum dolor sit.</li>
            <li>Lorem ipsum dolor sit.</li>
            <li>Lorem ipsum dolor sit.</li>
          </ul>
        </div>
        <div class="col-md-3 mb-4 footer-4">
          <h4 class="mb-4">Our Infos</h4>
          <div class="info-body">
            <p class="mb-2">
              <i class="fas fa-user"></i> CEO: Hong Gil-dong
            </p>
            <p class="mb-2">
              <i class="fas fa-map-marked-alt"></i> Address: 11-111 Jung-gu Gil-dong Seoul Korea
            </p>
            <p class="mb-2">
              <i class="fas fa-phone-square-alt"></i> Telephone: 02-111-1111
            </p>
            <p class="mb-2">
              <i class="fas fa-hospital"></i> Registered Business Number: 111-11-1111
            </p>
          </div>
        </div>
      </div>
    </div>
  </div>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.slim.min.js" integrity="sha512-6ORWJX/LrnSjBzwefdNUyLCMTIsGoNP6NftMy2UAm1JBm6PRZCO1d7OHBStWpVFZLO+RerTvqX/Z9mBFfCJZ4A==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.js"
        integrity="sha512-XtmMtDEcNz2j7ekrtHvOVR4iwwaD6o/FUJe6+Zq+HgcCsk3kj4uSQQR8weQ2QVj1o0Pk6PwYLohm206ZzNfubg=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="js/app.js"></script>
</body>
</html>