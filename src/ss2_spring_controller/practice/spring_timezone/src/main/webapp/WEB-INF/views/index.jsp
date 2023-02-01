<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>The World Clock</title>
    <style>
        select {
            width: 200px;
            height: 20px;
        }
    </style>
</head>
<body>
<h1>
    The World Clock
</h1>
<h2>Current Local Times Around the World</h2>
<br/>
<span>Current time in ${city}: <strong>${date}</strong> </span>
<form id="locale" action="world-clock" method="get">
    <select name="city" onchange="document.getElementById('locale').submit()">
        <option value="Asia/Ho_Chi_Minh" selected>Select a city</option>
        <option value="Asia/Hong_Kong" >Hong Kong</option>
        <option value="Singapore" >Singapore</option>
        <option value="Asia/Ho_Chi_Minh">Ho Chi Minh</option>
        <option value="America/New_York">New York</option>
    </select>
</form>
</body>
</html>