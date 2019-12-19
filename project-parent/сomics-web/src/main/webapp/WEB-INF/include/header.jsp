<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<c:if test="${param.lang != null}">
    <% session.setAttribute("comics_locale", request.getParameter("lang")); %>
</c:if>
<c:if test="${sessionScope.comics_locale != null}">
    <fmt:setLocale value="${sessionScope.comics_locale}"/>
</c:if>

<fmt:setBundle basename="messages"/>
<div style="background: #E0E0E0; height: 55px; padding: 5px;">
    <div style="float: left">
        <h1 style="margin-top: 10px"><fmt:message key="header.app.title"/></h1>
    </div>

    <div style="float: right; padding: 15px; text-align: right;">
        <c:if test="${user != null}"> Hello <b>${user.userName}</b>
            <a href="${pageContext.request.contextPath}/logout">logout</a>
        </c:if>
    </div>
    <div style="float: right; padding: 15px; text-align: right;">
        <a href="?lang=en">en</a> |
        <a href="?lang=ru">ru</a>
    </div>
</div>