<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Form Submission</title>
</head>
<body>
    <h2>Submit Your Details</h2>
    <form action="" method="post">
        <label for="name">CaseID</label><br>
        <input type="text" id="name" name="name"><br>
        <label for="email">Description</label><br>
        <input type="email" id="email" name="email"><br>
        <label for="age">Number Of Files</label><br>
        <input type="number" id="age" name="age"><br><br>
        <label for="">Upload Files</label>
        <input type="file" id="files" name="files" multiple><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>