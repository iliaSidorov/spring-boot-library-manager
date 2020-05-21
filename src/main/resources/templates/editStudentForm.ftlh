<#import "parts/common.ftlh" as c>
<@c.page>
    <div align="center">
        <h3>Edit Student</h3>
        <br/>
        <form name="book" action="/students/add" method="post">
            <table border="1" cellpadding="8">
                <tr>
                    <td>Id</td>
                    <td><input title="Id" type="text" name="id" value="${student.id}"></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input title="Name" type="text" name="name" value="${student.name}"/></td>
                </tr>
                <tr>
                    <td>Faculty</td>
                    <td><input title="Faculty" type="text" name="faculty" value="${student.faculty}"/></td>
                </tr>
                <tr>
                    <td>Year</td>
                    <td>
                        <select title="Year" name="year">
                            <#list years as year>
                                <option>${year}</option>
                            </#list>
                        </select>
                    </td>
                </tr>
            </table>
            <br/>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="submit" value="Save"/>
        </form>
    </div>
</@c.page>