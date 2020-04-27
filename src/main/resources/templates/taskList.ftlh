<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Lesson 64. Javascript 101</title>
	<link rel="stylesheet" href="/css/styles.css">
</head>
<body onload="addTaskElements()">
	<h1>To do list</h1>
	<form id="form-task" name="form-task" enctype="multipart/form-data">
	<input type="text" size="20" name="title"/>
	<button type="submit" class='change' id="save-task" >Add</button>
	</form>
	<label>List:</label>
	<ol></ol>
</body>
</html>
<script src="/js/script.js"></script>
