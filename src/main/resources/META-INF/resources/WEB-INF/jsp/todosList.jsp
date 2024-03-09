<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
    <head></head>
    <body>
        <h1>${name} Things to do</h1>
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
                <tr>
                    <c:forEach items="${Todos}" var="todo">
                        <td>{todo.id}</td>
                        <td>{todo.userName}</td>
                        <td>{todo.description}</td>
                        <td>{todo.status}</td>
                    </c:forEach>
                </tr>
            </tbody>
        </table>
    </body>
</html>