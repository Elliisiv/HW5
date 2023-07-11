package org.example.dto.tablesDto;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.StringReader;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Projects {
    private int id;
    private Date startDate;
    private Date finishDate;

    public Projects(int id, Date startDate, Date finishDate) {
        this.id = id;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + finishDate +
                '}';
    }
    }
