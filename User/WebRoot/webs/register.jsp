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
    
    <title>注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<c:url value='/webs/css/register.css'/>">
  </head>
 
<body>
	<h2 style="color:red; text-align:center;">${msg }</h2>
<div class="container">
<div class="register">
    <span id="title">注册账号</span>
    <p>我已有账号，可以直接 <a href="login.jsp"> 登陆</a></p>
    <div class="register_body">
               <form name="form" id="regUser" action="<c:url value='/servlet/Register'/>" method="post">
                    
                              <div class="item">
                                   <input type="text"  maxlength="16" class="inputstyle" style="display: none"/>
                              </div>
                   
                              <div class="item">
                                   <input type="text" id="username" name="user" maxlength="16" class="inputstyle" 
                                   placeholder="用户名"/ value="${form.username }">
                                   <span  style="color:red;">${errors.username }</span>
                              </div>
                    
                        
                              <div class="item">
                                   <input type="password" id="password" name="pwd" maxlength="16" class="inputstyle" 
                                   placeholder="密码" value="${form.password }"/>
                                   <span  style="color:red;">${errors.password }</span>
                              </div>
                             
                        
                           <div class="item">
                                   <input type="password" id="_password" name="pwd2" maxlength="16" class="inputstyle"  
                                   placeholder="密码确认"/>
                                   <span  style="color:red;">${errors.password }</span>
                             </div>
                              <div class="item">
                                   <input type="text" id="mobile" name="phone" class="inputstyle" placeholder="手机" 
                                   value="${form.phone }"/>
                                   <span  style="color:red;">${errors.phone }</span>
                              </div>
                             <div class="item">
                             <input type="text" name="tell" placeholder="电话" maxlength="11">
                             </div>
                             <div class="item">
                             <input type="email" name="email" placeholder="邮箱" ><div id="email_hide">
                             </div>
                             <div class="item">
                              <label>&nbsp</label><input type="submit" value="提交注册" name="submit" id="submit">
                              </div>
                              
                  
               </form>
          </div>
     </div>
</div>
</body>
</html>