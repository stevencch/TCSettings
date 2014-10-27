<%-- 
    Document   : admin
    Created on : 26/10/2014, 10:51:21 PM
    Author     : Administrator
--%>

<%@page import="com.oracle.rsp.tcsettings.domain.Setting"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <c:url var="updateAction" value="/settingAction/update" ></c:url>
        <c:url var="deleteAction" value="/settingAction/delete" ></c:url>
        <c:url var="newAction" value="/settingAction/new" ></c:url>
        
        <div class="container">
            <table class="table">
                <tr><th>Key</th><th>Value</th><th></th><th></th></tr>
                        <c:forEach items="${settings}" var="setting">

                    <% Setting s = (Setting) pageContext.findAttribute("setting");
                        request.setAttribute("setting", s);
                    %>
                    <tr>
                        <form:form action="${updateAction}" commandName="setting">
                            <td><form:input path="key"></form:input> </td>
                            <td><form:input path="value"></form:input> </td>
                                <td>
                                    <button value="update" name="submit">update</button>
                                </td>
                        </form:form>
                        <form:form action="${deleteAction}" commandName="setting">
                            <td>
                                <form:hidden path="key"></form:hidden>
                                    <button value="delete" name="submit">delete</button>
                                </td>
                        </form:form>
                    </tr>

                </c:forEach>
                <form:form action="${newAction}" commandName="newsetting">
                    <tr>
                        <td><form:input path="key"></form:input></td>
                        <td><form:input path="value"></form:input></td>
                            <td>
                                <button value="insert" name="submit">insert</button>
                            </td>
                            <td>
                            </td>
                        </tr>
                </form:form>
            </table>

        </div>

        <script src="${pageContext.request.contextPath}/js/bootstrap.js" type="text/javascript"></script>
    </body>
</html>
