<#import "parts/common.ftlh" as c>
<@c.page>
    <div align="center">
        <h4>Register New Student</h4>
        <br/>
        <form name="book" action="/students/add" method="post">
            <table border="1" cellpadding="8">
                <tr>
                    <td>Name</td>
                    <td><input title="Name" type="text" name="name"></td>
                </tr>
                <tr>
                    <td>Faculty</td>
                    <td><input title="Faculty" type="text" name="faculty"></td>
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
            <input type="submit" value="Add">
        </form>
    </div>
</@c.page>