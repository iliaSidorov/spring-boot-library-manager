<#import "parts/common.ftlh" as c>
<@c.page>
    <h3>Registration</h3>
    <br/><br/>
        <#--if user exists, show message-->
        ${message?ifExists}
    <br/><br/>
    <form action="/registration" method="post">
        <#include "parts/sign_input.ftlh">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Email:</label>
            <div class="col-sm-6">
                <input type="email" name="email" class="form-control" placeholder="Email"/>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button class="btn btn-primary" type="submit">Sign Up</button>
    </form>
</@c.page>



