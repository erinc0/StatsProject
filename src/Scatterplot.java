import java.util.ArrayList;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.ScatterChart;

public class Scatterplot extends App{

public ScatterChart<Number, Number> scatterplot;

public Scatterplot(){
CreateScatterPlot();}

public void CreateScatterPlot(){
NumberAxis XAxis = new NumberAxis();
NumberAxis YAxis = new NumberAxis();
scatterplot= new ScatterChart<>(XAxis, YAxis);
scatterplot.setTitle("Statistical Analysis");
XAxis.setLabel("Data Position");
YAxis.setLabel("Data entered");
scatterplot.setPrefWidth(540);

}
public ScatterChart<Number, Number> getScatterChart(){
    return scatterplot;
}

public void ScatterChart(ArrayList<Number> arrayList){
XYChart.Series<Number, Number> dataset1 = new XYChart.Series<>();
dataset1.setName("data set 1");

for(int i = 1; i <=arrayList.size(); i++){
dataset1.getData().add(new XYChart.Data<>(i, arrayList.get(i-1).doubleValue()));
}
scatterplot.getData().clear();
scatterplot.getData().add(dataset1);}


public void ScatterChart2(ArrayList<Number> arraylist2){
XYChart.Series<Number, Number> dataset2 = new XYChart.Series<>();
dataset2.setName("data set 2");

for(int i = 1; i <=arraylist2.size(); i++){
dataset2.getData().add(new XYChart.Data<>(i, arraylist2.get(i-1).doubleValue()));
}
scatterplot.getData().add(dataset2);
}

public void DeleteChart(){
scatterplot.getData().clear();
}


}