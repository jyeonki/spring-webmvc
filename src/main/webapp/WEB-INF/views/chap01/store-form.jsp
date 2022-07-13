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

    <div class="wrap">
        <h1>Toy Store</h1>

        <div class="menu">
            <form action="/store/result" method="post">
                <label>
                    # Order List
                    <br>
                    <select id="menu" name="menu">
                        <option value="robot">robot</option>
                        <option value="doll">doll</option>
                        <option value="puzzle">puzzle</option>
                    </select>
                </label>
                <label class="price"># price : $20</label>

                <label>
                    <button type="submit">order</button>
                </label>
            </form>
        </div>
    </div>

    <script>

        (function() {

            const toyPriceList = {
                robot: 20,
                doll: 15,
                puzzle: 10,
            }

            const $selectOpt = document.getElementById('menu');


        })();


    </script>
</body>

</html>