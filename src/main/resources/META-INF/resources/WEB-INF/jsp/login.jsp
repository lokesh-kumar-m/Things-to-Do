<html>

<head>
    <title>Login</title>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">  
</head>

<body>
    <div class="container justify-content-md-center" id="box">
        <h1>Login</h1>
        <pre>${ErrorMessage}</pre>
        <form method="post">
            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label">UserName</label>
                <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="NameHelp" name="name">
                <div id="NameHelp" class="form-text">Enter your user name</div>
            </div>
            <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label">Password</label>
                <input type="password" class="form-control" id="exampleInputPassword1" name="password">
            </div>
            <button type="submit" class="btn btn-primary">Login</button>
            <button type="" class="btn btn-primary">SignUp</button>
        </form>
    </div>
<%@ include file="common/footer.jspf" %>