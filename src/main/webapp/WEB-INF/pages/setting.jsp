<%-- 
    Document   : setting
    Created on : 23/10/2014, 4:13:35 PM
    Author     : scao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/tlds/settingTag" prefix="cc" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <table class="table table-striped">
                <tr><th>Key</th><th>Value</th><th></th><th></th></tr>
                        <cc:SettingTag>
                    <form action="${pageContext.request.contextPath}/update" method="post">
                        <tr>
                            <td>
                                [key]
                                <input type="hidden" value="[key]" name="key"/>
                            </td>
                            <td>
                                <input type="text" value="[value]" name="value"/>
                            </td>
                            <td>
                                <button value="update" name="submit">update</button>
                            </td>
                            <td>
                                <button value="delete" name="submit">delete</button>
                            </td>
                        </tr>
                    </form>
                </cc:SettingTag>
                <form action="${pageContext.request.contextPath}/update" method="post">
                    <tr>
                        <td><input type="text"  name="key"/></td>
                        <td><input type="text"  name="value"/></td>
                        <td>
                            <button value="insert" name="submit">insert</button>
                        </td>
                        <td>
                        </td>
                    </tr>
                </form>
            </table>
        </div>
        <script src="${pageContext.request.contextPath}/js/bootstrap.js" type="text/javascript"></script>
    </body>

</html>
