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
    <c:forEach items="${comicbookList}" var="comicbook">
        <tr>

            <td><c:out value="${comicbook.id}"/></td>
            <td><c:out value="${comicbook.name}"/></td>
            <td><c:out value="${comicbook.price}"/></td>
            <td><c:out value="${comicbook.count}"/></td>
            <td><c:out value="${comicbook.rating}"/></td>
            <th>
                <a:auth path="/comicbookDelete">
                    <c:url value="comicbookDelete" var="delete_link" scope="page" >
                        <c:param name ="id" value="${comicbook.id}"/>
                    </c:url>
                    <a href="${delete_link}">Delete</a>
                </a:auth>
            </th>
        </tr>
    </c:forEach>
</table>
<%@include file="../include/footer.jsp" %>
