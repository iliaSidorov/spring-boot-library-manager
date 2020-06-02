<#import "parts/common.ftlh" as c>
<@c.page>
        <h4>Add New Student</h4>
        <div class="form-group mt-3">
            <form action="/students/add" method="post">
            <div class="form-group">
            <input type="text" class="form-control ${(nameError??)?string('is-invalid', '')}"
                   value="<#if student??>${student.name}</#if>" name="name" placeholder="Name">
            <#if nameError??>
                <div class="invalid-feedback">
                    ${nameError}
                </div>
            </#if>
            </div>

            <div class="form-group">
            <input type="text" class="form-control ${(facultyError??)?string('is-invalid', '')}"
                   value="<#if student??>${student.faculty}</#if>" name="faculty" placeholder="Faculty">
            <#if facultyError??>
                <div class="invalid-feedback">
                    ${facultyError}
                </div>
            </#if>
            </div>

            <div class="form-group">
                <input type="text" class="form-control ${(yearError??)?string('is-invalid', '')}"
                       name="year" placeholder="Year">
                <#if yearError??>
                    <div class="invalid-feedback">
                        ${yearError}
                    </div>
                </#if>
            </div>

                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Add</button>
                </div>

            </form>
        </div>
</@c.page>