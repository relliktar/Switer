<#import "parts/common.ftlh" as c>

<@c.page>

	<form action="/message" method="post">
		<input type="text" name="text" value="${message.text}">
		<input type="text" name="tag" value="${message.tag}">
		<#if message.filename??>
			<input type="text" name="filename" value="${message.filename}">
		<#else><input type="text" name="filename" value="">
		</#if>
		<input type="hidden" name="messageId" value="${message.id}">
		<input type="hidden" name="_csrf" value="${_csrf.token}">
		<button class="btn btn-primary" type="submit">Save</button>
	</form>
</@c.page>