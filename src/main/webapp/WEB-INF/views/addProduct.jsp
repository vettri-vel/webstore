<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE unspecified PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title><spring:message code="label.addProduct.titleHeading" /></title>
</head>

<body>
	
	<section>
	<a href="<c:url value="/logout" />">Logout</a> 
	<div class="jumbotron">
		    
		<div class="container">
			    
			<h1>
				<spring:message code="label.addProduct.titleHeading" />
			</h1>
			    
			<p>
				<spring:message code="label.addProduct.addProducts" />
			</p>
		</div>
	</div>
	</section>
	<section class="container"> <form:form method="POST"
		modelAttribute="newProduct" class="form-horizontal">
		<fieldset>
			<legend>
				<spring:message code="label.addProduct.addNewProduct" />
			</legend>
			<div class="form-group">
				     <label class="control-label col-lg-2 col-lg-2"  for="productId"><spring:message
						code="label.addProduct.productId" /></label>     
				<div class="col-lg-10">
					    
					<form:input id="productId" path="productId" type="text"
						class="form:input-large" />
					    
				</div>
				    
			</div>
			<div class="form-group">
				     <label class="control-label col-lg-2 col-lg-2"  for="productId"><spring:message
						code="label.addProduct.name" /></label>     
				<div class="col-lg-10">
					    
					<form:input id="name" path="name" type="text"
						class="form:input-large" />
					    
				</div>
				    
			</div>

			<div class="form-group">
				     <label class="control-label col-lg-2 col-lg-2"  for="productId"><spring:message
						code="label.addProduct.unitPrice" /></label>     
				<div class="col-lg-10">
					    
					<form:input id="unitPrice" path="unitPrice" type="text"
						class="form:input-large" />
					    
				</div>
				    
			</div>

			<div class="form-group">
				     <label class="control-label col-lg-2 col-lg-2"  for="productId"><spring:message code="label.addProduct.manufacturer"/></label>
				    
				<div class="col-lg-10">
					    
					<form:input id="manufacturer" path="manufacturer" type="text"
						class="form:input-large" />
					    
				</div>
				    
			</div>

			<div class="form-group">
				     <label class="control-label col-lg-2 col-lg-2"  for="productId"><spring:message code="label.addProduct.category"/></label>
				    
				<div class="col-lg-10">
					    
					<form:input id="category" path="category" type="text"
						class="form:input-large" />
					    
				</div>
				    
			</div>

			<div class="form-group">
				     <label class="control-label col-lg-2 col-lg-2"  for="productId"><spring:message code="label.addProduct.unitsInStock"/></label>     
				<div class="col-lg-10">
					    
					<form:input id="unitsInStock" path="unitsInStock" type="text"
						class="form:input-large" />
					    
				</div>
				    
			</div>

			<div class="form-group">
				     <label class="control-label col-lg-2 col-lg-2"  for="productId"><spring:message code="label.addProduct.unitsInOrder"/></label>     
				<div class="col-lg-10">
					    
					<form:input id="unitsInOrder" path="unitsInOrder" type="text"
						class="form:input-large" />
					    
				</div>
				    
			</div>

			<div class="form-group">
				     <label class="control-label col-lg-2" for="description"><spring:message code="label.addProduct.description"/></label>
				    
				<div class="col-lg-10">
					    
					<form:textarea id="description" path="description" rows="2" />
					    
				</div>
				    
			</div>

			<div class="form-group">
				     <label class="control-label col-lg-2" for="discontinued"><spring:message code="label.addProduct.discontinued"/></label>
				    
				<div class="col-lg-10">
					    
					<form:checkbox id="discontinued" path="discontinued" />
					    
				</div>
				    
			</div>

			<div class="form-group">
				     <label class="control-label col-lg-2"
					                      for="condition"><spring:message code="label.addProduct.condition"/></label>     
				<div class="col-lg-10">
					    
					<form:radiobutton path="condition" value="New" />
					<spring:message code="label.addProduct.radiobutton.new"/>     
					<form:radiobutton path="condition" value="Old" />
					<spring:message code="label.addProduct.radiobutton.old"/>          
					<form:radiobutton path="condition" value="Refurbished" />
					<spring:message code="label.addProduct.radiobutton.refurbished"/>          
				</div>
				    
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2" for="productImage"> <spring:message
						code="label.addProduct.form.productImage" />
				</label>
				<div class="col-lg-10">
					<form:input id="productImage" path="productImage" type="file"
						class="form:input-large" />
				</div>
			</div>

			<div class="form-group">
				    
				<div class="col-lg-offset-2 col-lg-10">
					     <input type="submit" id="btnAdd" class="btn btn-primary"
						value="Add" />     
				</div>
				    
			</div>

		</fieldset>
	</form:form> </section>
</body>
</html>