<#import "parts/common.ftlh" as c>
<@c.page>
    <form action="/login" method="post">
        <div><label><input type="text" name="username" placeholder="username"/></label></div><br/>
        <div><label><input type="password" name="password" placeholder="password"></label></div><br/>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div><input type="submit" value="Sign In"></div>
    </form>
</@c.page>