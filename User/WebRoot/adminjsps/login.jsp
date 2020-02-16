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

	<link rel="stylesheet" type="text/css" href="<c:url value='/adminjsps/login.css'/>">
  </head>
</head>
<body>

<div class="login">
     <div class="qlogin" id="qlogin">
          <div class="web_login">
               <form name="form" id="regUser" method="post" action="<c:url value='/servlet/AdminLoginServlet'/>">
                    <ul class="reg_form" id="reg-ul">
                         <li>
                              <div class="inputOuter">
                                   <input type="text"maxlength="16" class="inputstyle" style="display: none"/>
                                   <span  style="color:red;">${errors.msg }</span>
                              </div>

                         </li>
                         <li>
                              <div class="inputOuter">
                                   <input type="text" name="adminname" maxlength="16" class="inputstyle" 
                                   placeholder="管理员帐号" value="${errors.adminname }"/>
                                   <span  style="color:red;"></span>
                              </div>

                         </li>

                         <li>
                              <div class="inputOuter">
                                   <input type="password" name="password" maxlength="16" class="inputstyle" 
                                   placeholder="密码" value="${errors.password }"/>
                                    <span  style="color:red;"></span>
                              </div>

                         </li>

                           <li>
                              <input type="submit" id="reg" class="button_blue" value="管理员登录" name="submit" />
                              
                         </li>
                    </ul>
               </form>
          </div>
     </div>
</div>
</body>
</html>