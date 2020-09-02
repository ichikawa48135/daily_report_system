package controllers.reports;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Employee;
import models.Report;
import utils.DBUtil;

/**
 * Servlet implementation class ReportsShowServlet
 */
@WebServlet("/reports/show")
public class ReportsShowServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportsShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        Report r = em.find(Report.class, Integer.parseInt(request.getParameter("id")));
        List<Employee> myiineList = r.getIineEmployeeList();

        Employee login_employee = (Employee)request.getSession().getAttribute("login_employee");

        Long q = em.createNamedQuery("getiinesCount",Long.class).setParameter("report",r).getSingleResult();
        System.out.println(r.getEmployee());

        //mployee employee 過去に一致しているものがあるか
        System.out.println(r);
        Long Repo = em.createNamedQuery("getreport_employee",Long.class)
                .setParameter("report",r)
                .setParameter("employee" ,login_employee)
                .getSingleResult();
        System.out.println(q);
        System.out.println(Repo);
        System.out.println(myiineList);

        request.setAttribute("count", q);
        request.setAttribute("getreport_employee", Repo);
        request.setAttribute("myiine", myiineList);

        em.close();

        request.setAttribute("report", r);
        request.setAttribute("_token", request.getSession().getId());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/reports/show.jsp");
        rd.forward(request, response);
    }

}