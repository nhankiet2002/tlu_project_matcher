<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta name="x-apple-disable-message-reformatting"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>

    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin/>
    <link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet"/>

    <style type="text/css">
        @media only screen and (min-width: 620px) {
            .container {
                width: 50% !important;
                display: block;
                margin-left: auto;
                margin-right: auto;
                padding-bottom: 2%;
            }
        }

        @media (max-width: 620px) {
            .container {
                width: 100% !important;
                display: block;
                margin-left: auto;
                margin-right: auto;
                padding-bottom: 2%;
            }
        }

        body {
            font-family: "Quicksand", sans-serif !important;
            font-size: 14px;
            font-weight: 600;
            margin: 0;
            -webkit-text-size-adjust: 100%;
            background-color: #f9f9f9 !important;
            color: #000000;
        }

        .detail-box > * {
            margin: 1% 5%;
        }

        .button-link {
            display: inline-block;
            max-width: 90%;
            width: 90%;
            line-height: 300%;
            background-color: #1d5193;
            border-radius: 10px;
            text-align: center;
            text-decoration: none;
            font-weight: 700;
            font-size: 16px;
            color: #ffffff !important;
        }
    </style>
</head>
<body>
<div class="container">
    <img src="cid:logo.png" width="100" height="100"/>
    <p>
        Bạn có cuộc khảo sát <span>${quiz}</span> cần làm
    </p>
    <div style="margin-bottom: 10%; text-align: center">
        <a target="_blank" href="${link}" class="button-link">Xem chi tiết</a>
    </div>
</div>
</body>
</html>
