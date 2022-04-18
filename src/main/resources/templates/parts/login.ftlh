<#macro login path isRegisterForm>
<form action="${path}" method="post">
	<div class="form-group row">
		<label class="col-sm-2 col-form-label">User Name :</label>
		<div class="col-sm-6">
			<input class="form-control" placeholder="User Name" type="text" name="username"/>
		</div>
	</div>
	<div class="form-group row">
		<label class="col-sm-2 col-form-label">Password:</label>
		<div class="col-sm-6">
			<input class="form-control"  placeholder="Password" type="password" name="password"/>
		</div>
	</div>
	<#if isRegisterForm>
		<div class="form-group row">
			<label class="col-sm-2 col-form-label">Email:</label>
			<div class="col-sm-6">
				<input class="form-control"  placeholder="Email" type="email" name="email"/>
			</div>
		</div>
	</#if>
	<input type="hidden" name="_csrf"  value="${_csrf.token}"/>
	<#if !isRegisterForm>
		<div>
			<a href="/registration">Add new user</a>
		</div>
	</#if>
	<button class="btn btn-primary" type="submit">
		<#if isRegisterForm>Create
		<#else>Sign in
		</#if>
	</button>
</form>
</#macro>

<#macro logout>
	<form action="/logout" method="post">
		<input type="hidden" name="_csrf"  value="${_csrf.token}"/>
		<button class="btn btn-primary" type="submit">Sign Out</button>
	</form>
</#macro>