<script>
$(document).ready(function() {
	$("#frm").validationEngine()
});

function deleteById() {
	var checkFound = false;
	var conf = "";
	conf = confirm("Are you sure,you want to delete this Site?")
	if (conf == true) {
		document.frm.action = "<%=request.getContextPath()%>/site/deleteById/"+ document.frm.id.value;
		document.frm.submit();
	}
}
function cancel() {
	document.frm.method = ""
	document.frm.action = "<%=request.getContextPath()%>/site/list";
	document.frm.submit();

}
</script>