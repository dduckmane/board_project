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

<div class="b-example-divider"></div>


<section id="top">
  <div class="section-content overlay d-flex justify-content-center align-items-center">
    <div class="container-xxl">
      <div class="row align-items-center">
        <div class="col-md-9 welcome">
          <h1 class="welcome-title fw-light">솔직한 리뷰, 믿을 수 있는 평점!</h1>
          <div class="divider"></div>
          <div class="row welcome-desc">
            <p class="col-col-sm-10 col-md-12 lead">믿고 보는 맛집 리스트, 지역별 인기 맛집, 세계음식 맛집 리스트 등</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

<section id="intro">
  <div class="section-content">
    <div class="container intro">
      <div class="row align-items-center">
        <div class="col-md-6 intro-first">
          <div class="row px-md-3">
            <div class="col-6">
              <div class="card card-body my-3 position-relative rounded-3 shadow-lg intro-first-card">
                <div
                        class="overlay d-flex justify-content-center align-items-center position-absolute h-100 w-100 shadow-lg">
                  <h3 class="fw-light">
                    <a href="/user/board/list/1" class="link-light text-decoration-none">한식</a>
                  </h3>
                </div>
              </div>
            </div>
            <div class="col-6">
              <div class="card card-body my-3 position-relative rounded-3 shadow-lg intro-first-card">
                <div
                        class="overlay d-flex justify-content-center align-items-center position-absolute h-100 w-100 shadow-lg">
                  <h3 class="fw-light">
                    <a href="/user/board/list/2" class="link-light text-decoration-none">양식</a>
                  </h3>
                </div>
              </div>
            </div>
            <div class="col-6">
              <div class="card card-body my-3 position-relative rounded-3 shadow-lg intro-first-card">
                <div
                        class="overlay d-flex justify-content-center align-items-center position-absolute h-100 w-100 shadow-lg">
                  <h3 class="fw-light">
                    <a href="/user/board/list/3" class="link-light text-decoration-none">중식</a>
                  </h3>
                </div>
              </div>
            </div>
            <div class="col-6">
              <div class="card card-body my-3 position-relative rounded-3 shadow-lg intro-first-card">
                <div
                        class="overlay d-flex justify-content-center align-items-center position-absolute h-100 w-100 shadow-lg">
                  <h3 class="fw-light">
                    <a href="/user/board/list/4" class="link-light text-decoration-none">일식</a>
                  </h3>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-6 intro-second">
          <h5 class="fw-light">Greetings!</h5>
          <h1 class="mb-4">세계음식 리스트</h1>
          <div class="intro-text">
            <p class="lead">Lorem ipsum dolor, sit amet consectetur adipisicing elit. Cum recusandae praesentium
              consectetur eum quis odit! Minima, eum non vero dolores adipisci quia sint voluptatem doloribus ullam
              cum voluptas deserunt nostrum!</p>
            <p class="lead">Lorem ipsum dolor sit amet consectetur adipisicing elit. Vitae expedita veniam error
              architecto est labore maiores distinctio, hic sint! Error.</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

<section id="services">
  <div class="section-content">
    <div class="container services">
      <div class="services-header text-center mb-5">
        <h1 class="display-5">올해의 맛집</h1>
        <div class="divider"></div>
        <p class="lead text-secondary">
          🍴Matjip이 선정한 2022년에 꼭 가봐야 할 인기맛집 순위
        </p>
        <div class="more">
          <a href="#">더보기</a>
        </div>
      </div>
      <div id="slick-slide" class="sercives-body">
        <div class="services-col mx-2 my-3">
          <div class="card">
            <a href="#">
              <img src="./assets/images/food/us/KakaoTalk_20221103_061413227_01.jpg" alt="" class="card-img-top">
            </a>
            <div class="card-body">
              <h4 class="card-title">Slide title</h4>
              <p class="card-text fw-light mb-4">
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Quod laboriosam quisquam totam voluptatibus. Dignissimos laudantium repellendus cum adipisci. Voluptates, eligendi!
              </p>
              <a href="#" class="btn btn-primary">바로가기</a>
            </div>
          </div>
        </div>
        <div class="services-col mx-2 my-3">
          <div class="card">
            <a href="#">
              <img src="./assets/images/food/us/KakaoTalk_20221103_061413227_01.jpg" alt="" class="card-img-top">
            </a>
            <div class="card-body">
              <h4 class="card-title">Slide title</h4>
              <p class="card-text fw-light mb-4">
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Quod laboriosam quisquam totam voluptatibus. Dignissimos laudantium repellendus cum adipisci. Voluptates, eligendi!
              </p>
              <a href="#" class="btn btn-primary">바로가기</a>
            </div>
          </div>
        </div>
        <div class="services-col mx-2 my-3">
          <div class="card">
            <a href="#">
              <img src="./assets/images/food/us/KakaoTalk_20221103_061413227_01.jpg" alt="" class="card-img-top">
            </a>
            <div class="card-body">
              <h4 class="card-title">Slide title</h4>
              <p class="card-text fw-light mb-4">
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Quod laboriosam quisquam totam voluptatibus. Dignissimos laudantium repellendus cum adipisci. Voluptates, eligendi!
              </p>
              <a href="#" class="btn btn-primary">바로가기</a>
            </div>
          </div>
        </div>
        <div class="services-col mx-2 my-3">
          <div class="card">
            <a href="#">
              <img src="./assets/images/food/us/KakaoTalk_20221103_061413227_01.jpg" alt="" class="card-img-top">
            </a>
            <div class="card-body">
              <h4 class="card-title">Slide title</h4>
              <p class="card-text fw-light mb-4">
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Quod laboriosam quisquam totam voluptatibus. Dignissimos laudantium repellendus cum adipisci. Voluptates, eligendi!
              </p>
              <a href="#" class="btn btn-primary">바로가기</a>
            </div>
          </div>
        </div>
        <div class="services-col mx-2 my-3">
          <div class="card">
            <a href="#">
              <img src="./assets/images/food/us/KakaoTalk_20221103_061413227_01.jpg" alt="" class="card-img-top">
            </a>
            <div class="card-body">
              <h4 class="card-title">Slide title</h4>
              <p class="card-text fw-light mb-4">
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Quod laboriosam quisquam totam voluptatibus. Dignissimos laudantium repellendus cum adipisci. Voluptates, eligendi!
              </p>
              <a href="#" class="btn btn-primary">바로가기</a>
            </div>
          </div>
        </div>
        <div class="services-col mx-2 my-3">
          <div class="card">
            <a href="#">
              <img src="./assets/images/food/us/KakaoTalk_20221103_061413227_01.jpg" alt="" class="card-img-top">
            </a>
            <div class="card-body">
              <h4 class="card-title">Slide title</h4>
              <p class="card-text fw-light mb-4">
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Quod laboriosam quisquam totam voluptatibus. Dignissimos laudantium repellendus cum adipisci. Voluptates, eligendi!
              </p>
              <a href="#" class="btn btn-primary">바로가기</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>



<section id="gallery">
  <div class="section-content">
    <div class="container gallery">
      <div class="gallery-header text-center mb-5">
        <h1 class="display-4">지역별 맛집</h1>
        <div class="divider"></div>
        <p class="lead text-secondary">Lorem, ipsum dolor sit amet consectetur adipisicing elit. Sequi, error. Veniam, deleniti ullam. Inventore esse ab, amet voluptatum corrupti suscipit.</p>
      </div>
      <div class="row gallery-body">
        <div class="col-md-4 col-sm-6 mb-4 gallery-item">
          <div class="card card-body border-0 p-0">
            <div class="overlay d-flex flex-column justify-content-center align-items-center h-100 w-100 border-2">
              <h2 class="gallery-title">서울</h2>
              <a class="link-warning text-decoration-none" href="#">서울 맛집 리스트</a>
            </div>
          </div>
        </div>
        <div class="col-md-4 col-sm-6 mb-4 gallery-item">
          <div class="card card-body border-0 p-0">
            <div class="overlay d-flex flex-column justify-content-center align-items-center h-100 w-100 border-2">
              <h2 class="gallery-title">경기</h2>
              <a class="link-warning text-decoration-none" href="#">경기 맛집 리스트</a>
            </div>
          </div>
        </div>
        <div class="col-md-4 col-sm-6 mb-4 gallery-item">
          <div class="card card-body border-0 p-0">
            <div class="overlay d-flex flex-column justify-content-center align-items-center h-100 w-100 border-2">
              <h2 class="gallery-title">제주</h2>
              <a class="link-warning text-decoration-none" href="#">제주 맛집 리스트</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>



<footer id="footer">
  <div class="section-content">
    <div class="container">
      <div class="row">
        <div class="col-md-3 mb-4 text-center footer-1">
          <!-- <img src="./assets/images/bootstrap-big-logo.png" alt="Logo" class="img-fluid footer-logo"> -->
          <div class="sns mt-4">
            <a target="_blank" href="#" class="mx-1 text-decoration-none social">
              <img src="img/icon-facebook.png" alt="Facebook" width="38px">
            </a>
            <a target="_blank" href="#" class="mx-1 text-decoration-none social">
              <img src="img/icon-instagram.png" alt="Instagram" width="38px">
            </a>
            <a target="_blank" href="#" class="mx-1 text-decoration-none social">
              <img src="img/icon-twitter.png" alt="Twitter" width="38px">
            </a>
            <a target="_blank" href="#" class="mx-1 text-decoration-none social">
              <img src="img/icon-youtube.png" alt="Youtube" width="38px">
            </a>
            <a target="_blank" href="#" class="mx-1 text-decoration-none social">
              <img src="img/icon-naver-block.png" alt="Naver blog" width="38px">
            </a>
            <a target="_blank" href="#" class="mx-1 text-decoration-none social">
              <img src="img/icon-kakao-channel.png" alt="Kakao Channel" width="38px">
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