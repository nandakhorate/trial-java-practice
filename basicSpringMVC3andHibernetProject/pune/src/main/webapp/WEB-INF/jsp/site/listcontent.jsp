
<div id="content">
	<div id="column1">
		<form:form id="frm" class="formular">
			<h3>Site</h3>
			<h3>Site</h3>
			<a href="${requestController}/add">Add Site</a>
			<div id="container">
				<div class="demo_jui">
					<c:if test="${!empty list}">
						<table cellpadding="0" cellspacing="0" border="0" class="display" id="example">
							<thead>
								<tr>
									<th>Site Name</th>
									<th>Site Address</th>
									<th>Delete</th>
									<th>Update</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="site">
									<tr class="gradeX">
										<td><a href="${requestController}/find/get/${site.id}">${site.name}</a></td>
										<td>${site.address}</td>
										<td><a href="${requestController}/find/delete/${site.id}">DELETE</td>
										<td><a href="${requestController}/find/update/${site.id}">UPDATE</td>
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