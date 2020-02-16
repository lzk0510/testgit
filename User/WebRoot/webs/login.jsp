<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="<c:url value='/webs/css/login.css'/>">
  </head>
</head>
<body>

<div class="container">
<div class="login">
    <div class="login_title">登陆账号</div>
    <div class="login_body">
               <form name="form" id="regUser" method="post" action="<c:url value='/servlet/Login'/>">
                    
                       
                                <div class="item1">
                                   <input type="text" name="username" maxlength="16" class="inputstyle" 
                                   placeholder="用户名" value="${form.username }"/>
                                   <span  style="color:red;">${errors.username }</span>
                              </div>

                        
                              <div class="item1">
                                   <input type="password" name="password" maxlength="16" class="inputstyle" 
                                   placeholder="密码" value="${form.password }"/>
                                    <span  style="color:red;">${errors.password }</span>
                              </div>

                           <div class="item1">
                              <input type="submit" id="submit"  value="登录" name="submit" />
                            </div>
               </form>
                              <div class="register">没有账号？<a href="<c:url value='webs/register.jsp'/>">注册</a></div>
                             <div class="item"><label>&nbsp</label><p><?= $err_message?></p></div>
                              
          </div>
     </div>
 <div class="container">
</body>
</html>