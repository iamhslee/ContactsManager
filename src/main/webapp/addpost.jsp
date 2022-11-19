<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.example.dao.BoardDAO, java.io.File, com.example.util.FileUpload"%>
<%@page import="com.oreilly.servlet.*" %>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="com.example.util.FileUpload" %>
<%@ page import="com.example.bean.BoardVO" %>

<% request.setCharacterEncoding("utf-8"); %>

<%
    BoardDAO boardDAO = new BoardDAO();
    FileUpload upload = new FileUpload();
    BoardVO u = upload.uploadPhoto(request);
    int i = boardDAO.insertContact(u);
    String msg = "[Success] Create new contact";
    if(i == 0) msg = "[Fail] Create new contact ";
%>

<script>
    alert('<%=msg%>');
    location.href='posts.jsp';
</script>