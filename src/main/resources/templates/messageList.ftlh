<#import "parts/common.ftlh" as c>

<@c.page>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Text</th>
				<th>Tag</th>
				<th>File Name</th>
			</tr>
		</thead>
		<tbody>
			<#list messages as message>
				<tr>
					<td><a href="/message/${message.id}">${message.id}</a></td>
					<td>${message.text}</td>
					<td>${message.tag}</td>
					<#if message.filename??>
						<td>${message.filename}</td>
					</#if>
				</tr>
			</#list>
		</tbody>
	</table>
</@c.page>