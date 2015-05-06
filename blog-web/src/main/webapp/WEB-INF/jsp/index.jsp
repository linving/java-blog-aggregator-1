<%@ page contentType="text/html;charset=UTF-8" language="java" %>

Hello from spring web mvc!
<br>

<%@ include file="../layout/taglib.jsp" %>

<h1>Latest news from the Java world:</h1>


<table class="table table-bordered table-hover table-striped">
    <thead>
    <tr>
        <th>date</th>
        <th>item</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${items}" var="item">
        <tr>
            <td>
                <c:out value="${item.publishedDate}"/>
                <br/>
                <b><i><c:out value="${item.blog.name}"/></i></b>
            </td>
            <td>
                <strong>
                    <a href="<c:out value="${item.link}" />" target="_blank">
                        <c:out value="${item.title}"/>
                    </a>
                </strong>
                <br/>
                    ${item.description}
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
