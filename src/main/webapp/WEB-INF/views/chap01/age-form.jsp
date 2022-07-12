<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>

<body>

    <h1>나이 검사하기</h1>

    <form action="/model/age-check2">

        <label>
            # 나이를 입력하세요
            <input type="number" name="age">
            <!-- name 속성이 쿼리파라미터 키값이 된다 -->
        </label>
        <button type="submit">전송</button>
        <!-- 제출하면 form(action) 으로 전송된다 -->

    </form>

</body>

</html>