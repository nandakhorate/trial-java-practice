<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<head>
<%@ include file="../common/pageHead.jsp"%>
<body>
	<div id="outer">
		<div id="outer2">
			<%@ include file="../common/header.jsp"%>
			<%@ include file="../common/menu.jsp"%>
			<div id="content">
				<div id="column1">
					<form:form id="frm" class="formular">
						<h3>Customers</h3>
						<a href="/pune/site/add">Add Site</a>

						<div id="container">

							<div class="demo_jui">
								<c:if test="${!empty list}">
									<table cellpadding="0" cellspacing="0" border="0"
										class="display" id="example">
										<thead>
											<tr>
												<th>Site Name</th>
												<th>Site Address</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${list}" var="site">
												<tr class="gradeX">
													<td><a href="/pune/site/find/${site.id}">${site.name}</a>
													</td>
													<td>${site.address}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</c:if>
							</div>
						</div>
					</form:form>
					
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../common/footer.jsp"%>
</body>
</html>
