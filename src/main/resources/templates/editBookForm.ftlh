<#import "parts/common.ftlh" as c>
<@c.page>
    <div align="center">
        <h3>Edit Book</h3>
        <br/>
        <form name="book" action="/books/add" method="post">
            <table border="1" cellpadding="8">
                <tr>
                    <td>Id</td>
                    <td><input title="Id" type="text" name="id" value="${book.id}"></td>
                </tr>
                <tr>
                    <td>Title</td>
                    <td><input title="Title" type="text" name="title" value="${book.title}"/></td>
                </tr>
                <tr>
                    <td>Author</td>
                    <td><input title="Author" type="text" name="author" value="${book.author}"/></td>
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
                <tr>
                    <td>Student</td>
                    <#if (book.student??)>
                        <td><a href="#">${book.student}</a></td>
                    <#else>
                        <td><a href="#">In storage</a></td>
                    </#if>
                </tr>
            </table>
            <br/>
            <input type="submit" value="Save"/>
        </form>
    </div>
</@c.page>