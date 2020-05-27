<#import "parts/common.ftlh" as c>
<@c.page>
    <h3>Log In</h3>
    <br/><br/>
    <#if Session?? && Session.SPRING_SECURITY_LAST_EXCEPTION??>
        <div class="alert alert-danger role=alert">
            ${SPRING_SECURITY_LAST_EXCEPTION.message}
        </div>
    </#if>

    <form action="/login" method="post">
        <#include "parts/sign_input.ftlh">
        <input type="hidden" name="_csrf" value="${_csrf.token}"><br/>
        <a href="/registration">Registration</a><br/><br/>
        <button class="btn btn-primary" type="submit">Sign In</button>
    </form>
    <br/>
</@c.page>