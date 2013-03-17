<div id="content">
	<div id="column1">
		<h3>Site</h3>
		<form:form method="post" action="${action}" commandName="frmObject" name="frm" id="frm" class="formular">
			<%-- <form:errors path="*" cssClass="errorblock" element="div" /> --%>
			<table>
				<form:hidden path="id" />

				<tr>
					<td><form:label path="name">
							<spring:message code="label.siteName" />
						</form:label>
					</td>
					<td><form:input path="name" class="validate[required,custom[noSpecialCaracters],length[0,20]] text-input" />
					</td>
				</tr>
				<tr>
					<td><form:label path="address">
							<spring:message code="label.siteAddress" />
						</form:label>
					</td>
					<td><form:input path="address" class="validate[required,custom[noSpecialCaracters],length[0,20]] text-input" />
					</td>
				</tr>
				<!-- <tr>
								<td><input class="styled-button-1" type="submit"
									value="Submit" />
								</td>
								<td><input class="styled-button-1" type="submit" value="Close all prompt" onclick="$.validationEngine.closePrompt('.formError',true)" />
								</td>
							</tr> -->
				<tr>
					<c:choose>
						<c:when test="${empty find}">
							<td><input class="styled-button-1" type="submit"
								value="Submit" /></td>
							<td><input class="styled-button-1" type="submit"
								value="Close all prompt"
								onclick="$.validationEngine.closePrompt('.formError',true)" />
							</td>
						</c:when>
						<c:otherwise>
							<td><input class="styled-button-1" type="submit"
								value="Update"
								onclick="$.validationEngine.closePrompt('.formError',true)" />
							</td>
							<td><input class="styled-button-1" type="submit"
								value="Delete" onclick="deleteById()" />
							</td>
							<td><input type="button" class="styled-button-1"
								value="Cancel" onclick="cancel()"></td>
							<td><input class="styled-button-1" type="submit"
								value="Close all prompt"
								onclick="$.validationEngine.closePrompt('.formError',true)" />
							</td>
						</c:otherwise>
					</c:choose>
				</tr>
			</table>
		</form:form>
	</div>
</div>
