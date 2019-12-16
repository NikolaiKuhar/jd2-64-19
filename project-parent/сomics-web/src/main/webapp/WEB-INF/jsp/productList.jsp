<<%@ page language="java" contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="a" uri="/WEB-INF/taglib/auth.tld" %>

<jsp:include page="../include/header.jsp"/>
<%@include file="../include/menu.jsp" %>

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


        </tr>
    </c:forEach>
</table>
<%@include file="../include/footer.jsp" %>
