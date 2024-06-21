/********************************************************************************************
 *   COPYRIGHT (C) 2024 CREVAVI TECHNOLOGIES PVT LTD
 *   The reproduction, transmission or use of this document/file or its
 *   contents is not permitted without written authorization.
 *   Offenders will be liable for damages. All rights reserved.
 *---------------------------------------------------------------------------
 *   Purpose:  MainController class file for the LineChart application.
 *   Project:  LineChart
 *   Platform: Cross-platform (Windows, macOS, Linux)
 *   Compiler: JDK-22
 *   IDE:      Eclipse IDE for Enterprise Java and Web Developers (includes Incubating components)
 *	           Version: 2024-03 (4.31.0)
 *             Build id: 20240307-1437
 ********************************************************************************************/

package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;

/**
 * MainController is the controller class for the LineChart application. It
 * handles user interactions and updates the LineChart based on user input.
 */
public class MainController {

	// FXML-injected LineChart component
	@FXML
	private LineChart<String, Number> lineChart;

	// FXML-injected Label component
	@FXML
	private Label lbl;

	/**
	 * Event handler for button click. Clears the existing chart data and populates
	 * it with new data series.
	 * 
	 * @param event ActionEvent triggered by button click
	 */
	public void btn(ActionEvent event) {
		lineChart.getData().clear();

		// Create and populate the first series
		XYChart.Series<String, Number> series = new XYChart.Series<>();
		series.getData().add(new XYChart.Data<>("Jan", 200));
		series.getData().add(new XYChart.Data<>("Feb", 150));
		series.getData().add(new XYChart.Data<>("Mar", 600));
		series.getData().add(new XYChart.Data<>("Apr", 50));
		series.setName("Month Pay1");

		// Create and populate the second series
		XYChart.Series<String, Number> series1 = new XYChart.Series<>();
		series1.getData().add(new XYChart.Data<>("Jan", 800));
		series1.getData().add(new XYChart.Data<>("Feb", 450));
		series1.getData().add(new XYChart.Data<>("Mar", 900));
		series1.getData().add(new XYChart.Data<>("Apr", 100));
		series1.setName("Month Pay2");

		// Add series to the LineChart
		lineChart.getData().addAll(series, series1);

		// Add mouse click event handler for each data point in the first series
		for (final XYChart.Data<String, Number> data : series.getData()) {
			data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					lbl.setText("X:" + data.getXValue() + "\nY:" + String.valueOf(data.getYValue()));
					Tooltip.install(data.getNode(),
							new Tooltip("X:" + data.getXValue() + "\nY:" + String.valueOf(data.getYValue())));
				}
			});
		}

		// Add mouse click event handler for each data point in the second series
		for (final XYChart.Data<String, Number> data : series1.getData()) {
			data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					lbl.setText("X:" + data.getXValue() + "\nY:" + String.valueOf(data.getYValue()));
					Tooltip.install(data.getNode(),
							new Tooltip("X:" + data.getXValue() + "\nY:" + String.valueOf(data.getYValue())));
				}
			});
		}
	}
}
