<#import "parts/common.ftlh" as c>
<@c.page>
    <div align="center">
        <br/><br/>
        <table border="1" cellpadding="8">
            <thead>
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Author</th>
                <th>Type</th>
                <th>Taken by</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <#list books as book>
                <tr>
                    <td><a href="/books/book/${book.id}">${book.id}</a></td>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td><a href="/listBooksByType/${book.type}">${book.type}</a></td>
                    <#if (book.student??)>
                        <td><a href="#">${book.student}</a></td>
                    <#else>
                        <td><a href="#">In storage</a></td>
                    </#if>
                    <td><button><a href="/books/edit/${book.id}">Edit</a></button></td>
                    <td><button><a href="/books/delete/${book.id}">Delete</a></button></td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</@c.page>