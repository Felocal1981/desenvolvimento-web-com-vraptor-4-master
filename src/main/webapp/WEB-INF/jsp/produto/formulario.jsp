<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="../base.css">
    <body>
        <div class="container">

		  <h1>Adicionar Produto</h1>
		
		  <form action="<c:url value='/produto/adiciona'/>" method="post">
		    Nome:
		    <input class="form-control" type="text" name="produto.nome" value="${produto.nome}"/>
		    Valor:
		    <input class="form-control" type="text" name="produto.valor" value="${produto.valor}"/>
		    Quantidade:
		    <input class="form-control" type="text" name="produto.quantidade" value="${produto.quantidade}"/>
		    <button type="submit" class="btn btn-primary">Adicionar</button>
		  </form>
		  
		  <c:if test="${not empty errors}">
            <div class="alert alert-danger">
                <c:forEach var="error" items="${errors}">
                    ${error.category} - ${error.message}<br />
                </c:forEach>
            </div>
          </c:if>
		
		</div>
    </body>
</html>