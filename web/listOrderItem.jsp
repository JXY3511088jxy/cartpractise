<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1 align="center" >购物车</h1>
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>商品名称</td>
        <td>单价</td>
        <td>数量</td>
        <td>小计</td>
    </tr>

    <c:forEach items="${ois}" var="oi" varStatus="st">
        <tr>
            <td>${oi.product.name}</td>
            <td>${oi.product.price}</td>
            <td>${oi.num}</td>
            <td>${oi.product.price*oi.num}</td>
        </tr>
    </c:forEach>

    <c:if test="${!empty ois}">
        <tr>
            <td colspan="4" align="right">
                <a href="createOrder">生成订单</a>
            </td>
        </tr>
    </c:if>
</table>