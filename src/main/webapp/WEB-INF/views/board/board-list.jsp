<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

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
  <link rel="stylesheet" href="assets/css/app.css">
  <title>🍴Matjip</title>

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>


  <style>
    a {
      text-decoration: none;
    }
    .card {
      --bs-blue: #007bff;
      --bs-indigo: #6610f2;
      --bs-purple: #696cff;
      --bs-pink: #e83e8c;
      --bs-red: #ff3e1d;
      --bs-orange: #fd7e14;
      --bs-yellow: #ffab00;
      --bs-green: #71dd37;
      --bs-teal: #20c997;
      --bs-cyan: #03c3ec;
      --bs-white: #fff;
      --bs-gray-dark: rgba(67, 89, 113, 0.8);
      --bs-gray-25: rgba(67, 89, 113, 0.025);
      --bs-gray-50: rgba(67, 89, 113, 0.05);
      --bs-primary: #696cff;
      --bs-secondary: #8592a3;
      --bs-success: #71dd37;
      --bs-info: #03c3ec;
      --bs-warning: #ffab00;
      --bs-danger: #ff3e1d;
      --bs-light: #fcfdfd;
      --bs-dark: #233446;
      --bs-gray: rgba(67, 89, 113, 0.1);
      --bs-primary-rgb: 105, 108, 255;
      --bs-secondary-rgb: 133, 146, 163;
      --bs-success-rgb: 113, 221, 55;
      --bs-info-rgb: 3, 195, 236;
      --bs-warning-rgb: 255, 171, 0;
      --bs-danger-rgb: 255, 62, 29;
      --bs-light-rgb: 252, 253, 253;
      --bs-dark-rgb: 35, 52, 70;
      --bs-gray-rgb: 67, 89, 113;
      --bs-white-rgb: 255, 255, 255;
      --bs-black-rgb: 67, 89, 113;
      --bs-body-color-rgb: 105, 122, 141;
      --bs-body-bg-rgb: 245, 245, 249;
      --bs-font-sans-serif: "Public Sans", -apple-system, BlinkMacSystemFont, "Segoe UI", "Oxygen", "Ubuntu", "Cantarell", "Fira Sans", "Droid Sans", "Helvetica Neue", sans-serif;
      --bs-font-monospace: "SFMono-Regular", Menlo, Monaco, Consolas, "Liberation Mono", "Courier New", monospace;
      --bs-gradient: linear-gradient(180deg, rgba(255, 255, 255, 0.15), rgba(255, 255, 255, 0));
      --bs-root-font-size: 16px;
      --bs-body-font-family: var(--bs-font-sans-serif);
      --bs-body-font-size: 0.9375rem;
      --bs-body-font-weight: 400;
      --bs-body-line-height: 1.53;
      --bs-body-color: #697a8d;
      --bs-body-bg: #f5f5f9;
      color-scheme: light;
      font-family: var(--bs-body-font-family);
      font-size: var(--bs-body-font-size);
      font-weight: var(--bs-body-font-weight);
      line-height: var(--bs-body-line-height);
      color: var(--bs-body-color);
      text-align: var(--bs-body-text-align);
      -webkit-text-size-adjust: 100%;
      -webkit-tap-highlight-color: rgba(67,89,113,0);
      text-rendering: optimizeLegibility;
      -webkit-font-smoothing: antialiased;
      --bs-gutter-x: 1.625rem;
      --bs-gutter-y: 0;
      box-sizing: border-box;
      width: 80%;
      max-width: 80%;
      padding-right: calc(var(--bs-gutter-x)*.5);
      padding-left: calc(var(--bs-gutter-x)*.5);
      margin-top: var(--bs-gutter-y);
      flex: 1 0 0%;
      float: none;
      margin: 0 auto
    }



  </style>

</head>

<body>

<!-- header 시작 -->
<nav class="py-2 bg-light border-bottom">
  <div class="container d-flex flex-wrap">
    <ul class="nav me-auto">
      <li class="nav-item"><a href="#" class="nav-link link-dark px-2 active" aria-current="page">Home</a></li>
      <li class="nav-item"><a href="#" class="nav-link link-dark px-2">글쓰기</a></li>
      <li class="nav-item"><a href="#" class="nav-link link-dark px-2">리스트 보기</a></li>
      <li class="nav-item"><a href="#" class="nav-link link-dark px-2">FAQs</a></li>
      <li class="nav-item"><a href="#" class="nav-link link-dark px-2">About</a></li>
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
<!-- header 종료 -->



<div class="b-example-divider"></div>
<!-- 리스트 시작 -->
<a href="/user/board/save/${groupId}">글쓰기</a>
<div>
  <c:forEach var="item" varStatus="status" items="${BoardDtoList}">
    <a href="/user/board/${(item.id)}">
  <div class="col-md">
    <div class="card mb-3">
      <div class="row g-0">
        <div class="col-md-4">
          <img data-file-name="${item.attachFileName}" class="card-img card-img-left img-fluid" src="" alt="Card image">
        </div>
        <div class="col-md-8">
          <div class="card-body">
            <h5 class="card-title">${item.subTitle}</h5>
            <p class="card-text">
              This is a wider card with supporting text below as a natural lead-in to additional content. This content
              is a
              little bit longer.
            </p>
            <p class="card-text">
              작성자: ${item.name} 조회수: ${item.viewCnt} <c:if test="${item.newArticle}">NEW</c:if>

            </p>
          </div>
        </div>
      </div>
    </div>
  </div>
    </a>
  </c:forEach>
</div>

<div class="container mt-3">

  <ul class="pagination justify-content-center">

  <c:if test="${not pageMaker.first}">
    <li class="page-item"><a class="page-link" href="">이전</a></li>
  </c:if>

    <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">

          <li class="page-item ${pageMaker.nowPage == num ? 'active' : ''}"><a class="page-link" href="/user/board/list/1?page=${num-1}">${num}</a></li>

    </c:forEach>

  <c:if test="${not pageMaker.last}">
      <li class="page-item"><a class="page-link" href="">다음</a></li>
   </c:if>

  </ul>
</div>

<!-- pagination 종료 -->





<!-- footer 시작 -->
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

<!-- footer 종료 -->

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.slim.min.js"
        integrity="sha512-6ORWJX/LrnSjBzwefdNUyLCMTIsGoNP6NftMy2UAm1JBm6PRZCO1d7OHBStWpVFZLO+RerTvqX/Z9mBFfCJZ4A=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.min.js"
        integrity="sha512-XtmMtDEcNz2j7ekrtHvOVR4iwwaD6o/FUJe6+Zq+HgcCsk3kj4uSQQR8weQ2QVj1o0Pk6PwYLohm206ZzNfubg=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="/js/app.js"></script>

<script>

  function get(){

  }

  function showImage(){

    const $thumbList = document.querySelectorAll('img[data-file-name]');
    console.log($thumbList);
    for (let $thumb of [...$thumbList]) {
      let fileName = $thumb.dataset.fileName;
      console.log('f:',fileName);

      console.log('thumb:',$thumb);
      if (fileName !== '') {
        fetch('/images?filename=' + fileName)
                .then(res => res.blob())
                .then(img => {

                  console.log('blob:', img);

                  const url = URL.createObjectURL(img);
                  $thumb.src = url;
                });
      }
    }

  }

  (function (){
    showImage();


  })();
</script>

</body>

</html>