<%--
  Created by IntelliJ IDEA.
  User: cwj
  Date: 17-5-23
  Time: 下午3:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Input</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<%--1.为什么需要使用form标签呢？
    可以更快速的开发出表单页面，而且可以更方便的进行表单值的回显
    2.表单通过modelAttribute属性指定绑定的模型属性，若没有指定该属性，默认从request对象中
    读取command的表单bean，如果该属性值也不存在，则报错。
--%>
<form:form action="${pageContext.request.contextPath}/emp" method="post" modelAttribute="employee">
    <%--path属性对应html表单标签的name属性值--%>

    <%--<form:errors path="*" />--%>
    <%--<br>--%>

    <c:if test="${employee.id == null }">
        LastName: <form:input path="lastName"/>
        <form:errors path="lastName" />

    </c:if>
    <c:if test="${employee.id != null }">
        <form:hidden path="id"/>
        <input type="hidden" name="_method" value="PUT"/>
    </c:if>
    <br>
    Email: <form:input path="email"/>
    <form:errors path="email" cssStyle="color: red"/>

    <br>
    Gender: <form:radiobuttons path="gender" items="${genders}"/>
    <br>
    Department: <form:select path="department.id" items="${departments}"
                             itemLabel="departmentName" itemValue="id"/>
    <br>

    <%--要加入一个新的属性birth，为Date类型
    经常会遇到三个问题
    1.数据类型转换
    2.数据类型格式化
    3.数据校验
        1）.如何校验？注解？
            1）.使用JSR303验证标准
            2）.加入hibernate validator验证框架的jar包
            3）.在springmvc配置文件中加入<mvc:annotation-driven />
            4）.需要在bean的类型前面加上对应的注解
            5）.在目标方法的bean前添加@valid注解
        2）.验证出错转向哪一个页面？
        3）.错误消息如何显示？如何把错误消息国际化？
            在form里加一个标签就行了
    --%>
    Birth: <form:input path="birth" />
    <form:errors path="birth" />
    <br>
    Salary: <form:input path="salary" />
    <input type="submit" value="submit"/>
</form:form>

<br><br>

<%--自定义类型转换器，将string转化为employee类型--%>
<form action="testConversionServiceConverter" method="post">

    <%-- lastName-email-gender-department.id
         例如：GG-gg@qq.com-male-105
    --%>
    Employee: <input type="text" name="employee"/>
    <input type="submit" value="submit"/>
</form>

</body>
</html>