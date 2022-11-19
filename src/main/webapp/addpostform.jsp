<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <title>Contacts</title>

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
        #list {
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }
        #list td, #list th {
            border: 1px solid #ddd;
            padding: 8px;
            text-align:center;
        }
        #list tr:nth-child(even){background-color: #f2f2f2;}
        #list tr:hover {background-color: #ddd;}
        #list th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: center;
            background-color: #006bb3;
            color: white;
        }

        .mbg{
            background-color: gray;
        }

        .btn-sm:hover{
            background-color: #dddddd;
        }
    </style>
</head>
<body >

<header>
    <div class="navbar navbar-dark mbg box-shadow">
        <div class="container d-flex justify-content-between" onclick="location.href='posts.jsp';">
            <a href="#" class="navbar-brand d-flex align-items-center">
                <strong style="margin-left: 5px">Contacts</strong>
            </a>
        </div>
    </div>
</header>

<br>
<div align="center" class="album py-5 bg-light">
    <form action="addpost.jsp" enctype="multipart/form-data" method="post">
        <label for="photo" class="form-label">Profile Photo:</label>
        <input type="file" id="photo" name="photo"/>
        <br />
        <label for="name" class="form-label">Name:</label>
        <input type="text" id="name" name="name"/>
        <br />
        <label for="phoneNum" class="form-label">Phone Number:</label>
        <input type="text" id="phoneNum" name="phoneNum"/>
        <br />
        <label for="email" class="form-label">Email:</label>
        <input type="text" id="email" name="email"/>
        <br />
        <label for="birthDate" class="form-label">Birth Date:</label>
        <input id="birthDate" name="birthDate"/>
        <br />
        <button type="submit" class="btn btn-primary" value="Add Post">Add</button>
        <button type="button" class="btn btn-danger"><a href="posts.jsp" style="text-decoration: none; color: white;">Cancel</a></button>
    </form>
</div>

</body>
</html>