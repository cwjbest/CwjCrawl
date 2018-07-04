<%--
  Created by IntelliJ IDEA.
  User: cwj
  Date: 17-5-23
  Time: 下午3:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page isELIgnored="false" %>

<%--很遗憾，spring并没有struts那样方便的遍历表单的标签，所以我们使用jstl--%>

<html>
<head>
    <title>List</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <%--这样引用是不会起作用的，spring如何处理静态资源？
        springDispatcherServlet会拦截所有请求，包括我们的静态资源请求
        但是，这些资源是不该被拦截的，应该直接给我们
        解决方法，再springmvc.xml中配置<mvc:default-servlet-handler />来筛查一些不需要拦截的请求--%>
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="/css/bootstrap-select.min.css" rel="stylesheet"/>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap-select.min.js"></script>

</head>
<h1 align="center">数据</h1>

<form action="/select" name="select" method="post">
<div style="margin-left: 20px;">
    <select name="season" class="selectpicker" multiple data-live-search="true" data-live-search-placeholder="当前赛季">
        <option>2000</option>
        <option>2001</option>
        <option>2002</option>
        <option>2003</option>
        <option>2004</option>
        <option>2005</option>
        <option>2006</option>
        <option>2007</option>
        <option>2008</option>
        <option>2009</option>
        <option>2010</option>
        <option>2011</option>
        <option>2012</option>
        <option>2013</option>
        <option>2014</option>
        <option>2015</option>
        <option>2016</option>
        <option>2017</option>
        <option>2018</option>
        <option>2019</option>
        <option>2020</option>
        <option>2021</option>
        <option>2022</option>
        <option>2023</option>
        <option>2024</option>
        <option>2025</option>
        <option>2026</option>
        <option>2027</option>
        <option>2028</option>
        <option>2029</option>
        <option>2030</option>
    </select>
    <select name="continent" class="selectpicker" multiple data-live-search="true" data-live-search-placeholder="大洲">
        <option>欧洲</option>
        <option>南美洲</option>
        <option>北美洲</option>
        <option>亚洲</option>
        <option>非洲</option>
    </select>
    <select name="country" class="selectpicker" multiple data-live-search="true" data-live-search-placeholder="国籍">
        <optgroup label="亚洲">
            <option>中国</option>
            <option>韩国</option>
            <option>日本</option>
        </optgroup>
        <optgroup label="欧洲">
            <option>德国</option>
            <option>法国</option>
            <option>西班牙</option>
            <option>意大利</option>
            <option>葡萄牙</option>
        </optgroup>
        <optgroup label="南美洲">
            <option>巴西</option>
            <option>阿根廷</option>
            <option>智利</option>
            <option>乌拉圭</option>
        </optgroup>
    </select>
    <input type="submit" class="btn btn-primary" value="筛选" />
</div>
</form>

<div style="margin-top: 30px; margin-left: 20px; margin-right: 20px">
    <c:if test="${empty requestScope.crawl}">
        沒有任何员工信息
    </c:if>
    <c:if test="${!empty requestScope.crawl}">
        <table class="table table-hover" border="1" cellpadding="10" cellspacing="0">
            <tr class="active">
                <th>Id</th>
                <th>TxHash</th>
                <th>Age</th>
                <th>From</th>
                <th>In_or_Out</th>
                <th>To</th>
                <th>Quantity</th>
            </tr>

            <c:forEach items="${requestScope.crawl}" var="player">
                <tr class="warning">
                    <td>${player.id}</td>
                    <td>${player.txHash}</td>
                    <td>${player.age}</td>
                    <td>${player.from}</td>
                    <td>${player.in_or_out}</td>
                    <td>${player.to}</td>
                    <td>${player.quantity}</td>

                    <%--<td><a href="/football">修改</a></td>--%>
                        <%--&lt;%&ndash;这里有点特殊，Delete操作只能是在POST请求，而普通的超链接只是GET请求--%>
                            <%--我们要借助js来实现它&ndash;%&gt;--%>
                    <%--<td><a class="delete" href="football/${player.id}">删除</a></td>--%>

                    <form action="" method="post">
                        <input type="hidden" name="_method" value="DELETE"/>
                    </form>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>

<br><br>
<a href="emp">Add New Employee</a>
</body>
</html>
