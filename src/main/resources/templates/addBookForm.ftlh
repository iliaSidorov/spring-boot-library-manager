<#import "parts/common.ftlh" as c>
<@c.page>
    <h4>Add New Book</h4>
    <div class="form-group mt-3">
    <form action="/books/add" method="post">
        <div class="form-group">
            <input type="text" class="form-control ${(titleError??)?string('is-invalid', '')}"
            value="<#if book??>${book.title}</#if>" name="title" placeholder="Title">
            <#if titleError??>
                <div class="invalid-feedback">
                    ${titleError}
                </div>
            </#if>
        </div>
        <div class="form-group">
            <input type="text" class="form-control ${(authorError??)?string('is-invalid', '')}"
                   value="<#if book??>${book.author}</#if>" name="author" placeholder="Author">
            <#if authorError??>
                <div class="invalid-feedback">
                    ${authorError}
                </div>
            </#if>
        </div>
        <div class="form-group">
            <input type="text" class="form-control ${(typeError??)?string('is-invalid', '')}"
                   name="type" placeholder="Type">
            <#if typeError??>
                <div class="invalid-feedback">
                    ${typeError}
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