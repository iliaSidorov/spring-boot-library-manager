<#import "parts/common.ftlh" as c>
<@c.page>
    <div align="center">
        <h3>Book Info</h3>
        <br/>
        <table border="1" cellpadding="8">
            <tr>
                <td>ID</td>
                <td>${book.id}</td>
            </tr>
            <tr>
                <td>Title</td>
                <td>${book.title}</td>
            </tr>
            <tr>
                <td>Author</td>
                <td>${book.author}</td>
            </tr>
            <tr>
                <td>Type</td>
                <td>${book.type}</td>
            </tr>
        </table>
    </div>
</@c.page>