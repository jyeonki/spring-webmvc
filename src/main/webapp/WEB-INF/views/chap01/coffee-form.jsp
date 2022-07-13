<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        label {
            display: block;
            margin-bottom: 20px;
        }
        .wrap {
            width: 800px;
            margin: 100px auto;
            border: 1px dashed #000;
        }
        .wrap h1 {
            margin: 0 auto;
            padding-bottom: 20px;
            width: fit-content;
            border-bottom: 1px solid #000;
        }
        .wrap .menu {
            font-size: 24px;
            width: 80%;
            margin: 20px auto;
        }
        .wrap .menu select {
            width: 200px;
            height: 50px;
            font-size: 28px;
            margin-top: 10px;
        }
        .clearfix::after {
            content: '';
            display: block;
            clear: both;
        }
    </style>
</head>
<body>
    
    <div class="wrap">
        <h1>커피 주문서</h1>

        <div class="menu">
            <form action="/coffee/result" method="post"> 
                <label>
                    # 주문 목록 <br>
                    <select id="menu-sel" name="menu">
                        <option value="americano">아메리카노</option>
                        <option value="cafeLatte">카페라떼</option>
                        <option value="macchiato">카라멜 마끼아또</option>                        
                    </select>
                </label>
                <label class="price"># 가격: 3000원</label>

                <input id="price-tag" type="hidden" name="price" value="3000">
                <!-- 
                    hidden : input type 속성 중 하나,
                             보이지 않지만 서버로 전송할 내용,
                             value속성으로 값을 지정 
                -->

                <label>
                    <button type="submit">주문하기</button>
                </label>
            </form>
        </div>
    </div>

    <script>

        (function() {

            const coffeePriceList = {
                americano: 3000,
                cafeLatte: 4500,
                macchiato: 5000,
            };
            

            const $sel = document.getElementById('menu-sel');

            // 자바스크립트 onchange 용도는 select 박스의 값이 변경될때 자주 사용된다.
            // select 박스의 값이 변경될때 onchange() 이벤트에서 사용자가 지정한 함수를 호출하여 각각의 동작(스크립트)을 실행시킨다
            $sel.onchange = e => {
                console.log(e.target.value);
                const price = coffeePriceList[e.target.value]; 
                const $priceLabel = document.querySelector('.price');
                $priceLabel.textContent = '# 가격: ' + price + "원";
                
                const $priceTag = document.getElementById('price-tag');
                $priceTag.value = price;
            };
        })();
    </script>



</body>
</html>