<#import "parts/common.ftlh" as c>
<@c.page>
    <div align="center">
        <h3>Student Info</h3>
        <br/>
        <table border="1" cellpadding="8">
            <tr>
                <td>Id</td>
                <td>${student.id}</td>
            </tr>
            <tr>
                <td>Name</td>
                <td>${student.name}</td>
            </tr>
            <tr>
                <td>Faculty</td>
                <td>${student.faculty}</td>
            </tr>
            <tr>
                <td>Year</td>
                <td>${student.year}</td>
            </tr>
        </table>
    </div>
</@c.page>