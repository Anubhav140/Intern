<jsp:include page="include/header.jsp"/>
<%@ page import="java.util.List" %>
<%@ page import="pnb.entity.User" %>

<h1>List User</h1>
<table>
<thead>
<th>CaseID</th>
<th>Decription</th>
<th>Number_Of_Files</th>

</thead>


<%

List<User> listusers=(List)request.getAttribute("listusers");
for(User _user: listusers){
	out.print("<tr>");
	out.print("<td>"+_user.getCaseID()+"</td>");
	out.print("<td>"+_user.getDescription()+"</td>");
	out.print("<td>"+_user.getNumber_Of_Files()+"</td>");
	out.print("</tr>");
}

%>
</table>
<jsp:include page="include/footer.jsp"></jsp:include>