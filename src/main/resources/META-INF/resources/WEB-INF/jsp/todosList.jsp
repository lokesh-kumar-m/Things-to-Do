<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <html>

    <head>
        <title>TOD</title>
        <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    </head>

    <body>
        <div class="container">
            <h1>My Things to do</h1>
            <hr>
            <table class="table table-striped-columns">
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
                            <td> <button type="" class="btn btn-success">Update</button></td>
                            <td> <button type="" class="btn btn-warning">Delete</button></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                Add Item
            </button>

            <!-- Modal -->
            <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
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
                                  <label for="itemid" class="form-label">Item id</label>
                                  <input type="number" class="form-control" id="itemid" name="itemId">
                                </div>
                                <div class="mb-3">
                                  <label for="itemname" class="form-label">Item Name</label>
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
                                <div class="mb-3">
                                  <label for="itemstatus" class="form-label">Item Status</label>
                                  <input type="text" class="form-control" id="itemstatus" name="itemStatus">
                                </div>
                                  <button type="submit" class="btn btn-primary">Add</button>
                              </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    </body>

    </html>