<%--
  Created by IntelliJ IDEA.
  User: nhand
  Date: 1/31/2023
  Time: 2:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <style>
        td {
            padding: 5px;
        }
    </style>
</head>
<body>
<h1>Convert Currency</h1>
<form action="convert" method="post">
      <table>
          <tr>
              <td>USD</td>
              <td><input name="usd" placeholder="enter usd.."/></td>
          </tr>
          <tr>
              <td colspan="2">
                 <button type="submit">
                     Submit
                 </button>
              </td>
          </tr>
      </table>
</form>
</body>
</html>
