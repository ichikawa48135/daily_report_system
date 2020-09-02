package controllers.reports;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Employee;
import models.Iine;
import models.Report;
import utils.DBUtil;

/**
 * Servlet implementation class IineServlet
 */
@WebServlet("/IineServlet")
public class IineServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public IineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String report_id = request.getParameter("report_id");
        EntityManager em = DBUtil.createEntityManager();
        Iine i = new Iine();

        Employee login_employee = (Employee)request.getSession().getAttribute("login_employee");

        Integer r_id = Integer.parseInt(report_id);
        Report Iines = em.find(Report.class, r_id);

        i.setReport(Iines);
        i.setEmployee(login_employee);

        System.out.println(Iines.getEmployee());

        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        i.setCreated_at(currentTime);
        i.setUpdated_at(currentTime);

            em.getTransaction().begin();
            em.persist(i);
            em.getTransaction().commit();
            em.close();
            response.sendRedirect(request.getContextPath() + "/reports/show?id=" + report_id);

    }

}
