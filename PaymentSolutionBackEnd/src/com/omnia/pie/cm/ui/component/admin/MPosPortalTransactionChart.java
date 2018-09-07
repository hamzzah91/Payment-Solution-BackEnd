package com.omnia.pie.cm.ui.component.admin;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 * 
 * @author M Louie
 * 
 */

@ManagedBean
public class MPosPortalTransactionChart implements Serializable {

	private static final long serialVersionUID = 2354885699453033891L;

	private LineChartModel dateModel;
	 
    @PostConstruct
    public void init() {
        createDateModel();
    }
 
    public LineChartModel getDataModel() {
        return dateModel;
    }
     
    private void createDateModel() {
        dateModel = new LineChartModel();
        LineChartSeries homeCenter = new LineChartSeries();
        homeCenter.setLabel("Home Center");
 
        homeCenter.set("January", 451);
        homeCenter.set("February", 311);
        homeCenter.set("March", 212);
        homeCenter.set("April", 265);
        homeCenter.set("May", 174);
        homeCenter.set("June", 624);
        homeCenter.set("July", 51);
 
        LineChartSeries mara = new LineChartSeries();
        mara.setLabel("Mara Express");
 
        mara.set("January", 173);
        mara.set("February", 323);
        mara.set("March", 123);
        mara.set("April", 29);
        mara.set("May", 51);
        mara.set("June", 389);
        mara.set("July", 251);
        
        LineChartSeries souq = new LineChartSeries();
        souq.setLabel("Souq");
 
        souq.set("January", 951);
        souq.set("February", 851);
        souq.set("March", 672);
        souq.set("April", 785);
        souq.set("May", 894);
        souq.set("June", 924);
        souq.set("July", 651);      
 
        dateModel.addSeries(homeCenter);
        dateModel.addSeries(mara);
        dateModel.addSeries(souq);
         
        dateModel.setTitle("Sales Chart");
        dateModel.setLegendPosition("e");
        dateModel.setShowPointLabels(true);
        dateModel.getAxes().put(AxisType.X, new CategoryAxis("Months"));
        Axis yAxis = dateModel.getAxis(AxisType.Y);
        yAxis.setLabel("In Thousand Dirhams");
        yAxis.setMin(0);
        yAxis.setMax(1000);
    }
}
