import java.util.ArrayList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class LineGraph extends App{

private LineChart<Number, Number> lineChart;

public LineGraph(){
CreateLineGraph();}

private void CreateLineGraph(){
NumberAxis XAxis = new NumberAxis();
NumberAxis YAxis = new NumberAxis();
lineChart = new LineChart<>(XAxis, YAxis);
lineChart.setTitle("Statistical Analysis");
XAxis.setLabel("Data Position");
YAxis.setLabel("Data entered");
lineChart.setPrefWidth(520);


}
public LineChart<Number, Number> getLineChart(){
    return lineChart;
}

public void lineChart(ArrayList<Number> arrayList){
XYChart.Series<Number, Number> dataset1 = new XYChart.Series<>();
dataset1.setName("data set 1");

for(int i = 1; i <=arrayList.size(); i++){
dataset1.getData().add(new XYChart.Data<>(i, arrayList.get(i-1).doubleValue()));
}
lineChart.getData().clear();
lineChart.getData().add(dataset1);}


public void lineChart2(ArrayList<Number> arraylist2){
XYChart.Series<Number, Number> dataset2 = new XYChart.Series<>();
dataset2.setName("data set 2");

for(int i = 1; i <=arraylist2.size(); i++){
dataset2.getData().add(new XYChart.Data<>(i, arraylist2.get(i-1).doubleValue()));
}
lineChart.getData().add(dataset2);
}

public void DeleteChart(){
lineChart.getData().clear();
}


}