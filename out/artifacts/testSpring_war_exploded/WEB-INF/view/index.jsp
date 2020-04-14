<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/WEB-INF/view/layouts/header.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-12 py-3 ">
            <h2 class="text-center">Users List</h2>
        </div>
        <div class="col-12 my-2">
            <c:url value="/add" var="create"/>
            <a class="btn btn-success fl" href="${create}">Prideti nauja augala</a>
        </div>
        <div class="col-12 ">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Pavadinimas</th>
                    <th scope="col">Kiekis</th>
                    <th scope="col">Kaina</th>
                    <th scope="col">Vienmatis / Daugametis</th>
                </tr>
                </thead>

                <tbody>
                <c:set value="${1}" var="iterator"/>
                <c:forEach items="${plants}" var="p">
                    <tr>
                        <th scope="row">${iterator}
                        </th>
                        <td><c:out value="${p.name}"/>
                        </td>
                        <td><c:out value="${p.amount}"/>
                        </td>
                        <td><c:out value="${p.price}"/>
                        </td>
                        <td><c:out value="${p.plantType}"/>
                        </td>
                        <td>

                            <c:url value="/remove/${p.id}" var="remove"/>
                            <c:url value="/edit/${p.id}" var="edit"/>
                            <a type="button" href="${edit}" class="btn btn-primary btn-sm btn-block mb-1">Edit</a>
                            <form method="post" action="${remove}">
                                <button type="submit" class="btn btn-danger btn-sm btn-block">Delete</button>
                            </form>
                            <c:url value="/desc/${p.id}/" var="desc"/>
                            <a href="${orders}" class="btn btn-warning btn-sm btn-block">Aprašymas</a>

                        </td>
                    </tr>
                    <c:set value="${iterator +1 }" var="iterator"/>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/view/layouts/footer.jsp" %>



