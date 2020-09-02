<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${approval != null}">
                <h2>日報承認　編集ページ</h2>
                <form method="POST" action="<c:url value='/apporovalupdate'/>">
                    <table>
                      <tbody>
                        <tr>
                            <th>氏名</th>
                            <td><c:out value="${approval.employee.name}" /></td>
                        </tr>
                        <tr>
                            <th>日付</th>
                            <td><fmt:formatDate value="${approval.report_date}" pattern="yyyy-MM-dd" /></td>
                        </tr>
                        <tr>
                            <th>内容</th>
                            <td>
                                <pre><c:out value="${approval.content}" /></pre>
                            </td>
                        </tr>
                        <tr>
                            <th>登録日時</th>
                            <td>
                                <fmt:formatDate value="${approval.created_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                        </tr>
                        <tr>
                            <th>更新日時</th>
                            <td>
                                <fmt:formatDate value="${approval.updated_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                        </tr>
                        <tr>
                            <th>出勤時間</th>
                            <td>
                                <fmt:formatDate value="${approval.work_st}" pattern="HH:mm" />
                            </td>
                        </tr>
                        <tr>
                            <th>退勤日時</th>
                            <td>
                                <fmt:formatDate value="${approval.work_end}" pattern="HH:mm" />
                            </td>
                        </tr>
                        <tr>
                            <th>現在のステータス</th>
                            <td>
                                <c:choose>
                                    <c:when test="${approval.approval_flag == 1}">
                                        <c:out value="承認待ち"></c:out>
                                     </c:when>

                                    <c:when test="${approval.approval_flag == 4}">
                                        <c:out value="承認済み"></c:out>
                                    </c:when>

                                     <c:when test="${approval.approval_flag == 5}">
                                         <c:out value="再提出依頼中"></c:out>
                                     </c:when>
                                </c:choose>
                            </td>
                        </tr>
                      </tbody>
                   </table>
                   <br />

                    <label for="approval_judgment">承認判定</label><br />
                        <select name="approval_judgment">
                        <option value="4">承認</option>
                        <option value="5">差し戻し(再申請)</option>
                        </select><br /><br />

                    <label for="approval_content">承認者コメント</label><br />
                    <textarea name="approval_content" rows="10" cols="50">${approval.approval_content}</textarea>
                    <br /><br />

                    <input type="hidden" name="_token" value="${_token}" />
                    <button type="submit">更新</button>

                </form>


            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value='/employees/approval' />">一覧に戻る</a></p>
    </c:param>
</c:import>