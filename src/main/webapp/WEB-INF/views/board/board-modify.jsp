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

        a.list-btn {
            border: 1px solid #000;
        }
    </style>
</head>

<body>
    <div class="main-content">
        <div class="board-container">
            <form action="/board/modify" method="POST">
                <!--<h1>${b.boardNo}번 게시물</h1>-->
                <input type="hidden" name="boardNo" value="${b.boardNo}">
                
                <label>
                    작성자
                    <br>
                    <input type="text" name="writer" value="${b.writer}">
                </label>
                <label>
                    글제목
                    <br>
                    <input type="text" name="title" value="${b.title}">
                </label>
                <label>
                    내용
                    <br>
                    <input type="text" name="content" value="${b.content}">
                </label>
                <label>
                    <button type="submit">수정완료</button>
                </label>
            </form>
        </div>

        <div class="btn-container">
            <label>
                <a class="list-btn" href="/board/list">목록</a>
            </label>
        </div>
    </div>

    <script>


    </script>


</body>

</html>