<#import "parts/common.ftlh" as c>
<@c.page>
    <div align="center">
        <h3>Registred Students</h3>
        <br/><br/>
        <form name="new" action="/students/add" method="get">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="submit" value="Add New Student">
        </form>
        <br>
        Total number of registred students: ${students?size}
        <br/><br/>
        <table border="1" cellpadding="8">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Faculty</th>
                <th>Year</th>
                <th>Debts</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <#list students as student>
                <tr>
                    <td><a href="/students/student/${student.id}">${student.id}</a></td>
                    <td>${student.name}</td>
                    <td>${student.faculty}</td>
                    <td>${student.year}</td>
                    <td><a href="/books/booksByStudent/${student.name}">See the debts</a></td>
                    <td><button><a href="/students/edit/${student.id}">Edit</a></button></td>
                    <td><button><a href="/students/delete/${student.id}">Delete</a></button></td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</@c.page>