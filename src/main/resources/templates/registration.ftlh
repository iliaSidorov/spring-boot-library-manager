<#import "parts/common.ftlh" as c>
<@c.page>
    Registration
    <br/>
        <#--if user exists, show message-->
        ${message?ifExists}
    <form action="/registration" method="post">
        <div><label><input type="text" name="username" placeholder="username"/></label></div><br/>
        <div><label><input type="password" name="password" placeholder="password"></label></div><br/>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div><input type="submit" value="Sign Up"></div>
    </form>
</@c.page>



