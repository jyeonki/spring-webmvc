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

        a.modify-btn,
        a.list-btn,
        a.delete-btn {
            border: 1px solid #000;
        }
    </style>
</head>

<body>
    <div class="main-content">
        <div class="board-container">
            <label>
                작성자
                <br>
                <input type="text" name="writer" value="${b.writer}" disabled>
            </label>
            <label>
                글제목
                <br>
                <input type="text" name="title" value="${b.title}" disabled>
            </label>
            <label>
                내용
                <br>
                <input type="text" name="content" value="${b.content}" disabled>
            </label>
        </div>
        <div class="btn-container">
            <label>
                <a class="modify-btn" href="/board/modify?boardNo=${b.boardNo}">수정</a>
            </label>
            
            <label>
                <a class="delete-btn" href="/board/delete?boardNo=${b.boardNo}">삭제</a>
            </label>

            <label>
                <a class="list-btn" href="/board/list">목록</a>
            </label>
        </div>
    </div>

    <script>

        const $boardContent = document.querySelector('.board-content');

        $boardContent.addEventListener('click', e => {
            
            if (!e.target.matches('a.delete-btn')) return;

            e.preventDefault();
            //console.log('클릭이벤트 발동!');

            if (confirm('정말로 삭제하시겠습니까?')) {
                // 삭제 진행
                location.href = e.target.getAttribute('href');
            } else {
                // 삭제 취소
                return;
            }
        });

    </script>


</body>

</html>