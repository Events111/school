<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Light Share</h1>
<#list fileList as file>
    <a href="/v1/download?file=${file}" target="_blank">${file}</a><br>
</#list>
</body>
</html>