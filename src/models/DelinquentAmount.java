package models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "DelinquentAmount")
@NamedQueries({
        @NamedQuery(name = "getAllReports", query = "SELECT r FROM Report AS r ORDER BY r.id DESC"),
        @NamedQuery(name = "getReportsCount", query = "SELECT COUNT(r) FROM Report AS r"),
        @NamedQuery(name = "getMyAllReports", query = "SELECT r FROM Report AS r WHERE r.employee = :employee ORDER BY r.id DESC"),
        @NamedQuery(name = "getMyReportsCount", query = "SELECT COUNT(r) FROM Report AS r WHERE r.employee = :employee")
})
@Entity
public class DelinquentAmount {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //作成者
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    //いつの仕事の日報か
    @Column(name = "report_date", nullable = false)
    private Date report_date;

    @Column(name = "title", length = 255, nullable = false)
    private String title;


}