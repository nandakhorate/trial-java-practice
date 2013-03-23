
<tr>
	<c:if test="${command == 'update'}">
		<td><input class="styled-button-1" type="submit" value="Update"
			onclick="javaScript:isUpdate();return false;" />
		</td>
		<td><input type="button" class="styled-button-1" value="Cancel"
			onclick="cancel()">
		</td>
		<!-- <td><input class="styled-button-1" type="submit"
			value="Close all prompt"
			onclick="$.validationEngine.closePrompt('.formError',true)" />
		</td> -->
	</c:if>
	<c:if test="${command == 'delete'}">
		<td><input class="styled-button-1" type="submit" value="Delete"
			onclick="javaScript:deleteById(); return false;" />
		</td>
		<td><input type="button" class="styled-button-1" value="Cancel"
			onclick="cancel()">
		</td>
	</c:if>
	<c:if test="${command == 'add'}">
		<td><input class="styled-button-1" type="submit" value="ADD" />
		</td>
		<td><input type="button" class="styled-button-1" value="Cancel"
			onclick="cancel()">
		</td>
		<!-- <td><input class="styled-button-1" type="submit"
			value="Close all prompt"
			onclick="$.validationEngine.closePrompt('.formError',true)" />
		</td> -->
	</c:if>
</tr>