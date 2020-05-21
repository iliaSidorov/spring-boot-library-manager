<#import "parts/common.ftlh" as c>
<@c.page>
<div align="center">
    <h4>Add New Book</h4>
    <br/>
    <form name="book" action="/books/add" method="post">
        <table border="1" cellpadding="8">
        <tr>
            <td>Title</td>
            <td><input title="Title" type="text" name="title"></td>
        </tr>
        <tr>
            <td>Author</td>
            <td><input title="Author" type="text" name="author"></td>
        </tr>
        <tr>
            <td>Type</td>
            <td>
                <select title="Type" name="type">
                    <#list types as type>
                    <option>${type}</option>
                    </#list>
                </select>
            </td>
        </tr>

        </table>
        <br/>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Add">
    </form>
</div>
</@c.page>