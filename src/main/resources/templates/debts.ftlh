<#import "parts/common.ftlh" as c>
<@c.page>
    <div align="center">
        <br/><br/>
        <h3>Debts Of ${name}</h3>
        <table border="1" cellpadding="8">
            <thead>
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Author</th>
                <th>Type</th>
            </tr>
            </thead>
            <tbody>
            <#list books as book>
                <tr>
                    <td><a href="/books/book/${book.id}">${book.id}</a></td>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.type}</td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</@c.page>