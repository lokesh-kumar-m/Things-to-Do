<html>

<head>
    <title>Login</title>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <div class="container justify-content-md-center">
        <h1 class="justify-content-md-center">Update ${id} fields</h1>
        <form method="post">
            <div class="mb-3">
                <select class="form-select" name="updateField" aria-label="Default select example">
                    <option selected>Choose Field</option>
                    <option value="itemid">Id</option>
                    <option value="itemname">Person</option>
                    <option value="itemdescription">Description</option>
                    <option value="itemdays">Do By</option>
                    <option value="itemstatus">Status</option>
                </select>
                <br>
                <input type="text" class="form-control" name="updatedValue">
            </div>
            <button type="submit" class="btn btn-primary">update</button>
        </form>
    </div>
</body>

</html>