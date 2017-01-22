<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
<title>Products</title>
</head>


<body>
<section>
<h1>Products</h1>
<p>Products in the Store</p>
</section>

<section>
<div>

<c:forEach items="${products}" var="product">

	<div>
		<h3>${product.name}</h3>
		<p>${product.description}</p>
		<p>
			<a href=" <spring:url value="/products/product?id=${product.productId}"/>"> Details </a>
		</p>	
		
		<p>
			<a href=" <spring:url value="/products/delete?id=${product.productId}"/>"> Delete </a>
		</p>
		
		<p>
			<a href=" <spring:url value="/products/edit?id=${product.productId}"/>"> Edit</a>
		</p>	
	</div>
</c:forEach>

</div>
</section>

</body>
</html>