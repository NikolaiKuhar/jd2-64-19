<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>

<table>
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Price</td>
        <td>Count</td>
        <td>Rating</td>
    </tr>
    <c:forEach items="${productList}" var="product">
        <tr>

            <td><c:out value="${product.id}"/></td>
            <td><c:out value="${product.name}"/></td>
            <td><c:out value="${product.price}"/></td>
            <td><c:out value="${product.count}"/></td>
            <td><c:out value="${product.rating}"/></td>
            <form method="post" action="${pageContext.request.contextPath}/productDeleteServlet">
                <input name="id" hidden value='<c:out value="${product.id}"/>'/>

                <input type="submit" display="inline">
            </form>

        </tr>
    </c:forEach>
</table>
</body>
</html>