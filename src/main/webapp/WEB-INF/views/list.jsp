<%--
  Created by IntelliJ IDEA.
  User: cwj
  Date: 17-5-23
  Time: 下午3:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <script type="text/javascript">
        $(function () {
            $(".delete").click(function () {
                var href = $(this).attr("href");
                $("form").attr("action", href).submit();
                return false;
            })
        })
    </script>

</head>
<%--<div style="margin-left: 40px; margin-right: 40px">--%>
    <%--<img src="/image/bg.jpg" height="60%" width="100%">--%>
<%--</div>--%>
<h1 align="center">球员数据榜</h1>

<select class="selectpicker" multiple data-live-search="true" data-live-search-placeholder="大洲">
    　　　　<option selected>欧洲</option>
    　　　　<option>南美洲</option>
    　　　　<option>北美洲</option>
    　　　　<option>亚洲</option>
    　　　　<option>非洲</option>
</select>
<select class="selectpicker" multiple data-live-search="true" data-live-search-placeholder="国籍">
    　　<optgroup label="亚洲">
    　　　　<option>中国</option>
    　　　　<option selected>中国</option>
    　　　　<option>日本</option>
    　　</optgroup>
    　　<optgroup label="欧洲">
    　　　　<option>德国</option>
    　　　　<option>法国</option>
    　　　　<option>西班牙</option>
    　　　　<option>意大利</option>
    　　</optgroup>
    　　<optgroup label="南美洲">
    　　　　<option>巴西</option>
    　　　　<option>阿根廷</option>
    　　　　<option>智利</option>
    　　　　<option>乌拉圭</option>
    　　</optgroup>
</select>

<div style="margin-top: 30px; margin-left: 20px; margin-right: 20px" >
    <c:if test="${empty requestScope.users}">
        沒有任何员工信息
    </c:if>
    <c:if test="${!empty requestScope.users}">
        <table class="table table-hover" border="1" cellpadding="10" cellspacing="0">
            <tr class="active">
                <th>ID</th>
                <th>UserName</th>
                <th>Password</th>
                <th>Email</th>
                <th>Age</th>
                <th>Gender</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>

            <c:forEach items="${requestScope.users}" var="emp">
                <tr class="warning">
                    <td>${emp.id}</td>
                    <td>${emp.username}</td>
                    <td>${emp.password}</td>
                    <td>${emp.email}</td>
                    <td>${emp.age}</td>
                    <td>${emp.gender}</td>
                    <td><a href="emp/${emp.id}">EDIT</a></td>
                        <%--这里有点特殊，Delete操作只能是在POST请求，而普通的超链接只是GET请求
                            我们要借助js来实现它--%>
                    <td><a class="delete" href="emp/${emp.id}">DELETE</a></td>

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
