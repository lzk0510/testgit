<%@ page language="java" import="java.util.*,com.sise.service.*,com.sise.domain.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>main</title>
   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/webs/css/main.css'/>">
	</head>
	 <script type="text/javascript">
		function outLogin(){
			var b = window.confirm("你确定要注销登录吗?");
			if(b){
				window.location.href="<c:url value='/servlet/OutLoginServlet'/>";
			}
		}
	</script>
<body>
	<div id="contanir">
		<div id="top">
		 <a id="head_image" href="javascript:void(0)"></a>
		</div>
		<div class="line">
			<ul>
				<li><a href="<c:url value='/webs/body.jsp'/>" target="body">商城首页</a></li>
			</ul>
		</div>
		<div id="log_reg">
			<ul>
			<c:choose>
				<c:when test="${empty sessionScope.usersession }">
					<li class="log_reg"><a href="<c:url value='/webs/login.jsp'/>" target="_top">登录</a></li>
					<li class="log_reg"><a href="<c:url value='/webs/register.jsp'/>"  target="_selt">注册</a></li>
				</c:when>
				<c:otherwise>
					<li class="log_reg">你好：${sessionScope.usersession.username }</li>
					<li class="log_reg"><a href="javascript:void(0)" onclick="outLogin()" >注销</a></li>
				</c:otherwise>
			</c:choose>
			</ul>
		</div>
<%-- 		<div id="left">
			<%
				//CategoryService cateservice = new CategoryService();
				/* List<Category> listcate = (List)bookservice.findAll(); */
				//request.setAttribute("listcate", cateservice.findAll());
				
			 %> --%>
			 <c:forEach var="category" items="${listcate }">
				<div class="type">
				<a href="<c:url value='/servlet/ListCategoryServlet?cid=${category.cid }'/> "
				 target="body">${category.cname }
				</a></div>
			</c:forEach>		
		</div>
		<div id="content">
			 <iframe src="body.jsp" width="100%" height="1200px" scrolling="no" frameborder="0" name="body">
			 </iframe>
		</div>
		<div id="right">
		<c:if test="${!empty(usersession) }">
			<div class="type"><a href="<c:url value='/servlet/MyOrderServlet'/>" target="body">我的订单</a></div>
			<div class="type"><a href="<c:url value='/servlet/AddCartServlet?bid=0'/>" target="body">购物车</a></div>
			
		</c:if>
		</div>
		<div class="foline"></div>
		<div id="footer">
			<p id="p_footer">地址：广州大学华软软件学院&nbsp;&nbsp;联系方式：13800138000</p>
		</div>
	</div>
</body>
</html>