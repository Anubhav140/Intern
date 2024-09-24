<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>
        <% 
        if (request.getAttribute("title") == null) {
            out.print("Home");
        } else {
            out.print(request.getAttribute("title"));
        }
        %>
    </title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/idx.css">
</head>
<body>
    <header id="body-header">
        <div id="header-img">
            <img src="../img/Logo.jpg" alt="pnb logo">
        </div>
        <nav>
			<ul class="horizontal-list text-center">
				<li><a href="<%= request.getContextPath() %>/home?page=home">Home</a></li>
				<li><a href="<%= request.getContextPath() %>/home?page=listusers">Cases</a></li>
				<li><a href="#skills">Documents</a></li>
				<li><a href="#education">Tasks</a></li>
				<li><a href="#portfolio">Reports</a></li>
				<li><a href="<%= request.getContextPath() %>/login.jsp">Logout</a></li>
			</ul>
		</nav>
    </header>
    