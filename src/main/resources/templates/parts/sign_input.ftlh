
<#--username input-->
<div class="form-group row">
    <label class="col-sm-2 col-form-label">Username</label>
    <div class="col-sm-6">
        <input type="text" name="username" value="<#if user??>${user.username}</#if>"
               class="form-control ${(usernameError??)?string('is-invalid', '')}" placeholder="Username"/>
        <#if usernameError??>
            <div class="invalid-feedback">
                ${usernameError}
            </div>
        </#if>
    </div>
</div>
<#--password input-->
<div class="form-group row">
    <label class="col-sm-2 col-form-label">Password</label>
    <div class="col-sm-6">
        <input type="password" name="password" class="form-control ${(passwordError??)?string('is-invalid', '')}" placeholder="Password"/>
        <#if passwordError??>
            <div class="invalid-feedback">
                ${passwordError}
            </div>
        </#if>
    </div>
</div>