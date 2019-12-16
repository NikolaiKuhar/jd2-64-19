<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="a" uri="/WEB-INF/taglib/auth.tld" %>


<%@include file="../include/header.jsp" %>
<form method="post" action="${pageContext.request.contextPath}/productCreate">
    <label> Name: <input type="text" name="name"/> </label>
    <br>
    <label> Price: <input type="number" name="price"/> </label>
    <br>
    <label> Count: <input type="number" name="count"/> </label>
    <br>
    <label> Rating: <input type="number" name="rating"/> </label>
    <br>

    <input type="submit">
</form>
<%@include file="../include/footer.jsp" %>
