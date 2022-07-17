<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>

    <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>-->

    <style>
        a {
            text-decoration: none;
            color: inherit;
        }

        a.title-btn {
            display: block;
        }

        .clearfix::after {
            content: '';
            display: block;
            clear: both;
        }

        #table {
            width: 70%;
            margin: 100px auto;

            border-collapse: collapse;
            border: 1px solid #000;
            margin-bottom: 20px;
        }

        #table th,
        #table td {
            border-bottom: 1px solid rgb(209, 207, 207);
            padding: 20px;
            text-align: center;
            font-weight: 600;
        }

        #table th {
            font-size: 20px;
            background: rgb(250, 114, 24);
            color: #fff;
        }

        #table tr:first-child:hover {
            background: rgb(250, 114, 24);
        }
        #table tr:hover {
            background: rgb(228, 227, 227);
        }

        .write {
            width: 70%;
            margin: 0 auto;
        }

        .write .write-btn {
            border: 1px solid #000;
            padding: 5px;
        }
    </style>
</head>

<body>

    <div class="container">
        <div class="board-list">
            <table id="table">
                <tr>
                    <th>No</th>
                    <th>작성자</th>
                    <th>제목</th>
                    <th>조회수</th>
                    <th>작성시간</th>
                </tr>
                <c:forEach var="b" items="${boardList}">
                    <tr class="tr">
                        <td>${b.boardNo}</td>
                        <td>${b.writer}</td>
                        <td><a class="title-btn" href="/board/content?boardNo=${b.boardNo}">${b.title}</a></td>
                        <td>${b.viewCount}</td>
                        <td>${b.regDate}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="write">
            <a class="write-btn" href="/board/write">글쓰기</a>
        </div>
    </div>


    <script>

        // $(".tr").click(function(e){
            
        //     location.href = '/board/content?boardNo=' + $(this).index();

        // });

    </script>
</body>

</html>