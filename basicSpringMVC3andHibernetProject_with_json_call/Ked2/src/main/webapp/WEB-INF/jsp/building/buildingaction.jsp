<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Spring 3 MVC Series - building Manager</title>
<style type="text/css" title="currentStyle">
@import "<%=request.getContextPath()%>/media/css/default.css";

@import "<%=request.getContextPath()%>/media/css/button.css";

@import
	"<%=request.getContextPath()%>/media/css/validationEngine.jquery.css";

@import "<%=request.getContextPath()%>/media/css/template.css";
</style>

<script type="text/javascript" language="javascript"
	src="<%=request.getContextPath()%>/media/js/jquery.min.js"></script>
<script type="text/javascript" language="javascript"
	src="<%=request.getContextPath()%>/media/js/jquery.validationEngine-en.js"></script>
<script type="text/javascript" language="javascript"
	src="<%=request.getContextPath()%>/media/js/jquery.validationEngine.js"></script>


<script>	
		$(document).ready(function() {
			$("#buildingfrm").validationEngine()
		});
		
		// JUST AN EXAMPLE OF VALIDATIN CUSTOM FUNCTIONS : funcCall[validate2fields]
		/* function validate2fields(){
			if($("#firstname").val() =="" || $("#lastname").val() == ""){
				return true;
			}else{
				return false;
			}
		} */

	function buildingDelete() {
		var checkFound = false;
		var conf = "";
		conf = confirm("Are you sure,you want to delete this Buildin?")
		if (conf == true) {
			document.buildingfrm.action = "<%=request.getContextPath()%>/building/deletebuilding/"+ document.buildingfrm.id.value;
			document.buildingfrm.submit();
		}
	}


	/* function CallCustomerBillAddView() {
		var checkFound = false;
		var conf = "";
		document.sitefrm.method=""
			document.sitefrm.action = "/Ked/customerbill/customerBillAddView/"+ document.customerfrm.id.value;
			document.sitefrm.submit();

	}
	 */
	function buildingCancel() {
			document.buildingfrm.method=""
			document.buildingfrm.action = "<%=request.getContextPath()%>/building/buildinglist";
			document.buildingfrm.submit();

	}
</script>
</head>
<body>
	<div id="outer">
		<div id="outer2">
			<div id="header">
				<h1>Ked</h1>
			</div>
			<div id="menu">
				<ul>
					<li><a href="http://www.free-css.com/">Home</a>
					</li>
					<li><a href="http://www.free-css.com/">Products</a>
					</li>
					<li><a href="http://www.free-css.com/">Services</a>
					</li>
					<li><a href="http://www.free-css.com/">About Us</a>
					</li>
					<li><a href="http://www.free-css.com/">Contact Us</a>
					</li>
				</ul>
			</div>
			<div id="content">
				<div id="column1">
					<h3>Site</h3>
					<form:form method="post" action="${action}" commandName="building" name="buildingfrm" id="buildingfrm" class="formular">
						<%-- <form:errors path="*" cssClass="errorblock" element="div" /> --%>
						<table>
							<form:hidden path="id" /> 
							<tr>
								<td><form:label path="siteId"><spring:message code="label.siteName"/></form:label></td>
								<td>
									<form:select path="siteId">
						 				<form:option value="0" label="--- Select ---"/>
						   				<form:options items="${siteMap}" />
									</form:select>
								</td>
							</tr>
							<tr>
								<td><form:label path="name">
										<spring:message code="label.buildingName" />
									</form:label>
								</td>
								<td><form:input path="name"
										class="validate[required,length[0,20]] text-input" />
								</td>
							</tr>
							<tr>
								<td><form:label path="address">
										<spring:message code="label.buildingAddress" />
									</form:label>
								</td>
								<td><form:input path="address"
										class="validate[required,length[0,20]] text-input" />
								</td>
							</tr>

							<tr>
								<c:choose>
									<c:when test="${empty view}">
										<td><input class="styled-button-1" type="submit" value="Submit" /></td>
										<td>
											<input class="styled-button-1" type="submit"  value="Close all prompt" onclick="$.validationEngine.closePrompt('.formError',true)" />
										</td>
									</c:when>
									<c:otherwise>
										<td>
										<input class="styled-button-1" type="submit"  value="Update" onclick="$.validationEngine.closePrompt('.formError',true)" />
										</td>
										<td>
										<input class="styled-button-1" type="submit"  value="Delete" onclick="buildingDelete()" />
										</td>
										<td><input type="button" class="styled-button-1" value="Cancel" onclick="buildingCancel()"></td>
										<td>
											<input class="styled-button-1" type="submit"  value="Close all prompt" onclick="$.validationEngine.closePrompt('.formError',true)" />
										</td>
									</c:otherwise>
								</c:choose>
							</tr>
						</table>
					</form:form>
				</div>
				<div id="footer">
					<p>
						Copyright &copy; 2012 Sitename.com. Design by <a href="#">Free CSS Templates</a>.
					</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>