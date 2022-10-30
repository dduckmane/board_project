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
</head>
<body>

<div class="mb-3" style="width: 50%; margin: 0 auto;">
  <label for="exampleFormControlTextarea1" class="form-label">News Content</label>
  <textarea class="form-control " name="freeboard_content" id="ckeditor" name="ckeditor" rows="6"></textarea>
</div>
<script type="text/javascript" src="/ckeditor/ckeditor.js"></script>

<script>
  CKEDITOR.replace('ckeditor', {  //해당 이름으로 된 textarea에 에디터를 적용
    width: '100%',
    height: '400px',
    filebrowserUploadUrl: "/upload"
  });
</script>
<input type="submit" value="글등록">
</body>

</html>