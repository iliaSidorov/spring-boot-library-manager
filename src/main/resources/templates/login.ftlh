<#import "parts/common.ftlh" as c>
<@c.page>
    <h3>Log In</h3>
    <br/><br/>
    ${message?ifExists}
    <form action="/login" method="post">
        <#include "parts/sign_input.ftlh">
        <input type="hidden" name="_csrf" value="${_csrf.token}"><br/>
        <a href="/registration">Registration</a><br/><br/>
        <button class="btn btn-primary" type="submit">Sign In</button>
    </form>
    <br/>
</@c.page>