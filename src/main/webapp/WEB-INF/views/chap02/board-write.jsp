<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>

    <style>
        a {
            text-decoration: none;
            color: inherit;
        }

        label {
            display: block;
            margin-bottom: 15px;
        }

        a.list {
            border: 1px solid #000;
        }
    </style>
</head>

<body>
    <div class="board-write">
        <form action="/board/write" method="post">
            <label>
                작성자
                <br>
                <input type="text" name="writer" placeholder="이름">
            </label>
            <label>
                글제목
                <br>
                <input type="text" name="title" placeholder="제목">
            </label>
            <label>
                내용
                <br>
                <input type="text" name="content">
            </label>
            <label>
                <button type="submit">글 작성하기</button>
            </label>
        </form>
        
        <label>
            <a class="list" href="/board/list">목록으로</a>
        </label>
    </div>


</body>

</html>