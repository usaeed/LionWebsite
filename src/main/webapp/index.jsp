<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>

<html>
    <head>
        <!--Including CSS for different screen sizes-->
        <link rel="stylesheet" type="text/css" href="css/responsiveform.css">
        <link rel="stylesheet" media="screen and (max-width: 1200px) and (min-width: 601px)" href="css/responsiveform1.css" />
        <link rel="stylesheet" media="screen and (max-width: 600px) and (min-width: 351px)" href="css/responsiveform2.css" />
        <link rel="stylesheet" media="screen and (max-width: 350px)" href="css/responsiveform3.css" />
        <style>
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
            }
            th, td {
                padding: 15px;
                text-align: left;
            }
            table#t01 {
                width: 100%;    
                background-color: #f1f1c1;
            }
        </style>
        <title>SELECT Operation</title>
    </head>
    <body>
        <sql:setDataSource var="snapshot" driver="com.mysql.cj.jdbc.Driver"
                           url="jdbc:mysql://localhost/tesco" user="tesco" password="" />
        <sql:query dataSource="${snapshot}" var="result">
            SELECT * from tescoepping;
        </sql:query>
        <div id="envelope">
            <form action="UpdateDb" method="POST" >  
                <header>
                    <h2>Example of Responsive Form</h2>
                    <p>This is my form. Fill it out. It's Awesome.</p>
                </header><br>
                <label>Tesco Id</label>
                <input name="tescoId" placeholder="Tesco ID" type="text" style="width:100%;">
                <label>Tesco Name</label>
                <input name="tescoName" placeholder="Tesco Name" type="text">
                <label>Tesco Branch</label>
                <input name="tescoBranch" placeholder="Tesco Branch" type="text">
                <label>Tesco Location</label>
                <input name="tescoLoc" placeholder="Tesco Location" type="text">
                <input id="submit" type="submit" value="Send Message">
            </form>
        </div>
        <table style="width:100%">
            <tr>
                <th>Tesco ID</th>
                <th>Tesco Name</th>
                <th>Tesco Branch</th>
                <th>Tesco Location</th>
            </tr>
            <c:forEach var="row" items="${result.rows}">
                <tr>
                    <td><c:out value="${row.tescoId}" /></td>
                    <td><c:out value="${row.tescoName}" /></td>
                    <td><c:out value="${row.tescoBranch}" /></td>
                    <td><c:out value="${row.tescoLoc}" /></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>