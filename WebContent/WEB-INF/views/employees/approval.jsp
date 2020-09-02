<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <h2>日報承認待ち一覧</h2>
        <table id="report_list">
            <tbody>
                <tr>
                    <th>氏名</th>
                    <th>タイトル</th>
                    <th>承認状態</th>

                </tr>
                <c:forEach var="approval" items="${approval}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td><c:out value="${approval.employee.name}" /></td>
                        <td><c:out value="${approval.title}" /></td>
                        <td>
                         <c:choose>
                                <c:when test="${approval.approval_flag == 5}">
                                    再申請依頼中
                                </c:when>
                                <c:otherwise>
                                    <a href="<c:url value='/employees/approvalEdit?id=${approval.id}' />">承認待ち 詳細を表示</a>
                                </c:otherwise>
                         </c:choose>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div id="pagination">
            （全 ${approvalCount} 件）<br />
            <c:forEach var="i" begin="1" end="${((approvalCount - 1) / 15) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/employees/index?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>

        <!-- 後で作成予定 -->
        <p><a href="<c:url value='/employees/' />">承認済み一覧</a></p>

    </c:param>
</c:import>