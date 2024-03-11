<%@ include file="common/header.jspf" %>
    <%@ include file="common/navigation.jspf" %>
        <div class="container">
            <h1>My Things to do</h1>
            <hr>
            <table class="table table-striped-columns">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Person</th>
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
                            <td> <a href="/update-todo?id=${todo.id}" class="btn btn-success">Update</a></td>
                            <td> <a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#addItems">
                Add Item
            </button>

            <!-- Modal -->
            <div class="modal fade" id="addItems" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
                aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="staticBackdropLabel">New Item</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form method="post">
                                <div class="mb-3">
                                    <label for="itemname" class="form-label">Name</label>
                                    <input type="text" class="form-control" id="itemname" name="itemName">
                                </div>
                                <div class="mb-3">
                                    <label for="itemdescription" class="form-label">Item Description</label>
                                    <input type="text" class="form-control" id="itemdescription" name="itemDescription">
                                </div>
                                <div class="mb-3">
                                    <label for="targetdays" class="form-label">Days to complete</label>
                                    <input type="number" class="form-control" id="targetdays" name="days">
                                </div>
                                <button type="submit" class="btn btn-primary">Add</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

        </div>
<%@ include file="common/footer.jspf" %>