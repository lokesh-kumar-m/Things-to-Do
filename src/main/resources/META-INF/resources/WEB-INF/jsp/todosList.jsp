<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
    <head>
        <title>Things To Do</title>
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
    </head>
    <body>
        <h1>My Things to do</h1>
        <hr>
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Do By</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                
                <c:forEach items="${Todos}" var="todo">
                    <tr>
                        <td>${todo.id}</td>
                        <td>${todo.userName}</td>
                        <td>${todo.description}</td>
                        <td>${todo.targetDate}</td>
                        <td>${todo.status}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    </body>
</html>