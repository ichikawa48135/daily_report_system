package models;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "reports")
@NamedQueries({
    @NamedQuery(
            name = "getAllReports",
            query = "SELECT r FROM Report AS r ORDER BY r.id DESC"
            ),
    @NamedQuery(
            name = "getReportsCount",
            query = "SELECT COUNT(r) FROM Report AS r"
            ),
    @NamedQuery(
            name = "getMyAllReports",
            query = "SELECT r FROM Report AS r WHERE r.employee = :employee ORDER BY r.id DESC"
            ),
    @NamedQuery(
            name = "getMyReportsCount",
            query = "SELECT COUNT(r) FROM Report AS r WHERE r.employee = :employee"
            ),
    @NamedQuery(
            name = "getAllapproval_flag",
            query = "SELECT r FROM Report AS r WHERE r.approval_flag = 1 OR r.approval_flag = 5"
            ),
    @NamedQuery(
            name = "getapprovalCount",
            query = "SELECT COUNT(r) FROM Report AS r WHERE r.approval_flag = 1 OR r.approval_flag = 5"
            ),
})
@Entity
public class Report {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "report_date", nullable = false)
    private Date report_date;

    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @Lob
    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "created_at", nullable = false)
    private Timestamp created_at;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updated_at;

    @Column(name = "work_st")
    private Time work_st;

    @Column(name = "work_end")
    private Time work_end;

    @Column(name = "approval_flag")
    private Integer approval_flag;

    @Column(name = "approval_updated")
    private Timestamp approval_updated;

    @Lob
    @Column(name = "approval_content", nullable = false)
    private String approval_content;

    @ManyToMany( mappedBy = "myIineList")
    private List<Employee> iineEmployeeList;


    public List<Employee> getIineEmployeeList() {
        return iineEmployeeList;
    }

    public void setIineEmployeeList(List<Employee> iineEmployeeList) {
        this.iineEmployeeList = iineEmployeeList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getReport_date() {
        return report_date;
    }

    public void setReport_date(Date report_date) {
        this.report_date = report_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public Time getWork_st() {
        return work_st;
    }

    public void setWork_st(Time work_st) {
        this.work_st = work_st;
    }

    public Time getWork_end() {
        return work_end;
    }

    public void setWork_end(Time work_end) {
        this.work_end = work_end;
    }

    public Integer getApproval_flag() {
        return approval_flag;
    }

    public void setApproval_flag(Integer approval_flag) {
        this.approval_flag = approval_flag;
    }

    public String getApproval_content() {
        return approval_content;
    }

    public void setApproval_content(String approval_content) {
        this.approval_content = approval_content;
    }

    public Timestamp getApproval_updated() {
        return approval_updated;
    }

    public void setApproval_updated(Timestamp approval_updated) {
        this.approval_updated = approval_updated;
    }






}
