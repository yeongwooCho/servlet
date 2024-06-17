<%@ page import="yeongwoo.servlet.domain.member.MemberRepository" %>
<%@ page import="yeongwoo.servlet.domain.member.Member" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: yeongwoo
  Date: 6/17/24
  Time: 2:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    // request, response 사용 가능
    MemberRepository memberRepository = MemberRepository.getInstance();
    List<Member> members = memberRepository.findAll();
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
    <thead>
    <th>id</th>
    <th>username</th>
    <th>age</th>
    </thead>
    <tbody>
    <%
        for (Member member : members) {
            out.println("<tr>");
            out.println("<td>" + member.getId() + "</td>");
            out.println("<td>" + member.getUsername() + "</td>");
            out.println("<td>" + member.getAge() + "</td>");
            out.println("</tr>");
        }
    %>
    </tbody>
</table>
</body>
</html>
