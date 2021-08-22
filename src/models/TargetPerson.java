package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "TargetPerson")
@NamedQueries({
        @NamedQuery(name = "getAllReports", query = "SELECT r FROM Report AS r ORDER BY r.id DESC"),
        @NamedQuery(name = "getReportsCount", query = "SELECT COUNT(r) FROM Report AS r"),
        @NamedQuery(name = "getMyAllReports", query = "SELECT r FROM Report AS r WHERE r.employee = :employee ORDER BY r.id DESC"),
        @NamedQuery(name = "getMyReportsCount", query = "SELECT COUNT(r) FROM Report AS r WHERE r.employee = :employee")
})
@Entity
public class TargetPerson {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @Column(name = "telefone", length = 20, nullable = false)
    private String telefone;

    @Column(name = "Property_Information", length = 200, nullable = false)
    private String Property_Information;

    @Column(name = " all_Confirmed_Payment", nullable = false)
    private Timestamp  all_Confirmed_Payment;
}

