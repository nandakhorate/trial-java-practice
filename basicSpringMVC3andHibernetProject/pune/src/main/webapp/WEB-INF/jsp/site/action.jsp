<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<%@ include file="../common/commonHead.jsp"%>
<%@ include file="js.jsp"%>
<body>
	<div id="outer">
		<div id="outer2">
			<div id="header">
				<h1>Pune</h1>
			</div>
			<%@ include file="../common/menu.jsp"%>
			<%@ include file="content.jsp"%>
			<%@ include file="../common/footer.jsp"%>
		</div>
	</div>
</body>
</html>