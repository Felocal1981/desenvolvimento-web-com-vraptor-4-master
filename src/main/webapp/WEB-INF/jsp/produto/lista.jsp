<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.css">
    <head>
        <h1>Listagem de Produtos do ${usuarioLogado.usuario.nome}</h1>
    </head>
    <c:if test="${not empty mensagem}">
	    <div class="alert alert-success">${mensagem}</div>
	</c:if>
    <body>
		<table class="table table-stripped table-hover table-bordered">
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Valor</th>
                    <th>Quantidade</th>
                </tr>
            </thead>
            <tbody>
              <c:forEach items="${produtoList}" var="produto">
                <tr>
                    <td>${produto.nome}</td>
                    <td>${produto.valor}</td>
                    <td>${produto.quantidade}</td>
                    <td>
				        <a href="<c:url value='/produto/enviaPedidoDeNovosItens?
				            produto.nome=${produto.nome}'/>">Pedir mais itens!</a>
				    </td>
                </tr>
              </c:forEach>
            </tbody>
        </table>
        <a href="<c:url value='/produto/formulario'/>">
		    Adicionar mais produtos!
		</a>
		
		<a href="<c:url value='/produto/listaEmXml'/>">
		    Acessar lista em xml
		</a>
		
		<a href="<c:url value='/produto/listaEmJson'/>">
		    Acessar lista em json
		</a>
    </body>
</html>