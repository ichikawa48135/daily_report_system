<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${report != null}">
                <h2>日報　詳細ページ</h2>

                <table>
                    <tbody>
                        <tr>
                            <th>氏名</th>
                            <td><c:out value="${report.employee.name}" /></td>
                        </tr>
                        <tr>
                            <th>日付</th>
                            <td><fmt:formatDate value="${report.report_date}" pattern="yyyy-MM-dd" /></td>
                        </tr>
                        <tr>
                            <th>内容</th>
                            <td>
                                <pre><c:out value="${report.content}" /></pre>
                            </td>
                        </tr>
                        <tr>
                            <th>登録日時</th>
                            <td>
                                <fmt:formatDate value="${report.created_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                        </tr>
                        <tr>
                            <th>日報更新日時</th>
                            <td>
                                <fmt:formatDate value="${report.updated_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                        </tr>
                        <tr>
                            <th>出勤時間</th>
                            <td>
                                <fmt:formatDate value="${report.work_st}" pattern="HH:mm" />
                            </td>
                        </tr>
                        <tr>
                            <th>退勤日時</th>
                            <td>
                                <fmt:formatDate value="${report.work_end}" pattern="HH:mm" />
                            </td>
                        </tr>
                        <tr>
                            <th>現在のステータス</th>
                            <td>
                                <c:choose>
                                    <c:when test="${report.approval_flag == 0}">
                                        <c:out value="承認不要"></c:out>
                                     </c:when>

                                    <c:when test="${report.approval_flag == 1}">
                                        <c:out value="承認待ち"></c:out>
                                     </c:when>

                                    <c:when test="${report.approval_flag == 4}">
                                        <c:out value="承認済み"></c:out>
                                    </c:when>

                                     <c:when test="${report.approval_flag == 5}">
                                         <c:out value="再提出依頼中"></c:out>
                                     </c:when>
                                </c:choose>
                            </td>
                        </tr>
                        <tr>
                            <th>承認日時</th>
                            <td>
                                <fmt:formatDate value="${report.approval_updated}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                        </tr>


                    </tbody>
                </table>


                <c:if test="${getreport_employee == 0}">
                <div class="Iinebotn">

                 <form method="POST" action="<c:url value='/IineServlet'/>">
                    <input type="hidden" name="report_id" value="${report.id}">
                    <input type ="submit" value="いいね:${count}">
                 </form>
                </div>


                </c:if>

                <c:out value ="いいね${count}"/>


                <c:if test="${sessionScope.login_employee.id == report.employee.id}">
                    <p><a href="<c:url value="/reports/edit?id=${report.id}" />">この日報を編集する</a></p>
                </c:if>

                <table border="1">
                     <thead>
                         <tr>
                           <th>氏名</th>

                        </tr>
                     </thead>
                      <tbody>
                  <c:forEach var="obj" items="${myiine}">
                         <tr>
                   <td><c:out value="${obj.name}"/></td>
                           </tr>
                   </c:forEach>
                     </tbody>
                      </table>



            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>
        <br />

        <p><a href="<c:url value="/reports/index" />">一覧に戻る</a></p>
      </c:param>

</c:import>