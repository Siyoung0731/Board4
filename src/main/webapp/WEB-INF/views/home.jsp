<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link href="/img/favicon.ico" rel="shortcut icon" type="image/x-icon">
<link href="/css/common.css" rel="stylesheet" /> 
<style>
</style>
</head>
<body>
  <main>
    <h2>User .Info</h2>
    <div><a href="/Users/List">회원목록</a></div>  
    <div><a href="/Users/WriteForm">회원추가</a></div>  
    <div><a href="/Users/WriteForm2">사용자 등록</a></div>
    <div>&nbsp;</div>
    <div><a href="/Users/IdDupCheck2?userid=aaa" target="_blank">아이디 중복 테스트</a></div>
    <div>&nbsp;</div>
    <div><a href="/Board/List">게시글 목록</a></div>
    <div><a href="/Board/WriteForm?menu_id=${ menu_id }">게시글 추가</a></div>
    <div>&nbsp;</div>
  </main>
</body>
</html>