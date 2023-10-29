package com.example.demo.CourseAssessment.model;

import com.example.demo.Course.model.Course;
import com.example.demo.Periodo.model.Periodo;
import jakarta.persistence.*;

@Entity
@Table(name = "course_assessment")
public class CourseAssessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String tipoNota;

    private String numNota;

    private String nomenclatura;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "periodo_id")
    private Periodo periodo;

    public CourseAssessment() {
    }

    public CourseAssessment(String title, String tipoNota, String numNota, String nomenclatura, Course course, Periodo periodo) {
        this.title = title;
        this.tipoNota = tipoNota;
        this.numNota = numNota;
        this.nomenclatura = nomenclatura;
        this.course = course;
        this.periodo = periodo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTipoNota() {
        return tipoNota;
    }

    public void setTipoNota(String tipoNota) {
        this.tipoNota = tipoNota;
    }

    public String getNumNota() {
        return numNota;
    }

    public void setNumNota(String numNota) {
        this.numNota = numNota;
    }

    public String getNomenclatura() {
        return nomenclatura;
    }

    public void setNomenclatura(String nomenclatura) {
        this.nomenclatura = nomenclatura;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }
}
