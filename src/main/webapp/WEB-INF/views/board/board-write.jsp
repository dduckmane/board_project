<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Matjip</title>
  <link rel="stylesheet" href="/css/common.css">
  <link rel="stylesheet" href="/css/board.css">
<!--  WYSIWYG edtier -->
  <script src="https://cdn.ckeditor.com/ckeditor5/35.2.0/classic/ckeditor.js"></script>
  <script src="https://cdn.ckeditor.com/ckeditor5/35.2.1/inline/ckeditor.js"></script>
  <script src="https://cdn.ckeditor.com/ckeditor5/35.2.1/balloon/ckeditor.js"></script>


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

<!--글쓰기 공간-->
<div id="board-write-wrap">
      <h1>리뷰를 작성해주세요</h1>
      <div id="editor">
        <p>This is some sample content.</p>
      </div>
      <script>
        ClassicEditor
                .create( document.querySelector( '#editor' ) )
                .catch( error => {
                  console.error( error );
                } );

        InlineEditor
                .create( document.querySelector( '#editor' ) )
                .catch( error => {
                  console.error( error );
                } );

        BalloonEditor
                .create( document.querySelector( '#editor' ) )
                .catch( error => {
                  console.error( error );
                } );
      </script>
  <input type="submit" value="글등록">
</div>

<!--footer-->
<footer>
  <address>
    &copy; foot
  </address>
</footer>

</body>
</html>