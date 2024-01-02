import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.lang.Math;


public class App extends Application { 
  private Label medianLabel;
  private Label meanLabel;
  private Label maxLabel;
  private Label minLabel;
  private Label  data2inputlabel;
  private Label data2medianlabel;
  private Label data2meanlabel;
  private Label data2maxlabel;
  private Label data2minlabel;
  private Label data2deviationlabel;
  private Label SDLabel;
  private Label set1Label;
  private LineGraph Lgraph;
  private Scatterplot Sgraph;
  

  public double x;
  public String z;

  private TextField medianfield;
  private TextField averageField;
  private TextField maxField;
  private TextField minField;
  private TextField inputField;
  private TextField SDField;
  private TextField data2inputfield;
  private TextField data2meanfield;
  private TextField data2medianfield;
  private TextField data2maxfield;
  private TextField  data2minfield;
  private TextField data2SDfield;

  private Button convertButton;
  private Button resetButton;


  ArrayList<Number> arraylist = new ArrayList<>();
  ArrayList<Number> arraylist2 = new ArrayList<>();
  public String l;


  @Override
    public void start (Stage primaryStage){

      BorderPane all = new BorderPane();
      Scene scene = new Scene(all, 1370, 700);

      GridPane gridpane = new GridPane();
      
  
      set1Label = new Label("data set 1");
      medianLabel= new Label("median");
      meanLabel = new Label("mean"); 
      maxLabel= new Label("max");
      minLabel= new Label("min");
      SDLabel = new Label("S. Deviation");


      data2inputlabel = new Label("data set 2");
      data2medianlabel= new Label("median");
      data2meanlabel = new Label("mean"); 
      data2maxlabel= new Label("max");
      data2minlabel= new Label("min");
      data2deviationlabel = new Label("S. Deviation");

   
    data2inputfield = new TextField();
    data2inputfield.setEditable(true);

    data2meanfield = new TextField();
    data2meanfield.setEditable(false);

    data2medianfield = new TextField();
    data2medianfield.setEditable(false);

    data2maxfield = new TextField();
    data2maxfield.setEditable(false);

    data2minfield = new TextField();
    data2minfield.setEditable(false);

    data2SDfield = new TextField();
    data2SDfield.setEditable(false);
    

      medianfield = new TextField();
      medianfield.setEditable(false);
      

      averageField = new TextField();
      averageField.setEditable(false);
      

      inputField = new TextField();
      inputField.setEditable(true);
      inputField.setText("");

      maxField = new TextField();
      maxField.setEditable(false);
      

     minField = new TextField();
     minField.setEditable(false);
    

     SDField = new TextField();
     SDField.setEditable(false);
    

     Lgraph = new LineGraph(); //Graph
     Sgraph = new Scatterplot();

      convertButton = new Button("convert");
      resetButton = new Button("reset");
   

      gridpane.setPadding(new Insets (20, 20, 20, 20));
      gridpane.setHgap(5);
      gridpane.setVgap(5);
      gridpane.add(set1Label, 0, 0);
      gridpane.add(medianLabel, 0 , 1);
      gridpane.add(meanLabel, 0, 2);
      gridpane.add(maxLabel, 0, 3);
      gridpane.add(minLabel, 0 , 4);
      gridpane.add(SDLabel, 0 , 5);

      gridpane.add(inputField, 3, 0);
      gridpane.add(medianfield, 3 , 1);
      gridpane.add(averageField, 3, 2);
      gridpane.add(maxField, 3 , 3);
      gridpane.add(minField, 3, 4);
      gridpane.add(SDField, 3, 5);

      gridpane.add(convertButton, 0 , 15);
      gridpane.add(resetButton, 2, 15 );
     


      gridpane.add(data2inputlabel, 0, 9);
      gridpane.add(data2inputfield, 3, 9);
      gridpane.add(data2medianlabel, 0, 10);
      gridpane.add(data2medianfield, 3, 10);
      gridpane.add(data2meanlabel, 0, 11);
      gridpane.add(data2meanfield, 3, 11);
      gridpane.add(data2maxlabel, 0, 12);
      gridpane.add(data2maxfield, 3, 12);
      gridpane.add(data2minlabel, 0, 13);
      gridpane.add(data2minfield, 3, 13);
      gridpane.add(data2deviationlabel, 0, 14);
      gridpane.add(data2SDfield, 3, 14);
  
      all.setLeft(gridpane);
      all.setCenter(Lgraph.getLineChart());
      all.setRight(Sgraph.getScatterChart());
      

      convertButton.setOnAction(new EventHandler<ActionEvent>() {
        
        @Override
        public void handle(ActionEvent Event){
          
           String l = inputField.getText();
           String [] num = l.split(" "); 
            String data2String = data2inputfield.getText();
          String[] data2array = data2String.split(" ") ;
                 
  try{
    if(num.length>0){
    for(String m: num) {
        if(!m.isEmpty()){
          double x = Double.parseDouble(m);
          arraylist.add(x);
        }
    }
     average(arraylist, averageField);
     median(arraylist, medianfield);
     maximum(arraylist, maxField);
     min(arraylist, minField);
     SD(arraylist, SDField);
     Lgraph.lineChart(arraylist); 
     Sgraph.ScatterChart(arraylist);
     
    }
    else{
    inputField.setText("");
     }

    }catch(Exception e){
   String hi= "Invalid Input";
   inputField.setText(hi);
    }



try{
if(data2array.length>0)
     for(String m : data2array){
        if(!m.isEmpty()){
     double y = Double.parseDouble(m);
     arraylist2.add(y);}}
    average(arraylist2, data2meanfield);
    median(arraylist2, data2medianfield);
    maximum(arraylist2, data2maxfield);
    min(arraylist2, data2minfield);
    SD(arraylist2, data2SDfield);

if(data2array.length ==0){
    data2inputfield.setText("");
}}
    
  catch(Exception e){
   String F= "Invalid Input";
   data2inputfield.setText(F);
}

 Lgraph.lineChart2(arraylist2); 
 Sgraph.ScatterChart2(arraylist2);
    }



    public static void average(ArrayList<Number> meanarraylist, TextField averageField){
        if(!meanarraylist.isEmpty()){
            double sum = 0;
            double mean;
            ArrayList<Number> averagearray = new ArrayList<>(meanarraylist);
            for ( int i = 0; i< averagearray.size(); ++i){
                sum = sum + averagearray.get(i).doubleValue();
            }
        mean = sum / averagearray.size();
        averageField.setText(" " + mean);
        }else{averageField.setText("");}

    }

public void SD(ArrayList<Number> arraylist, TextField StandardField){
double SDeviation= 0;
double SD;

if(!arraylist.isEmpty()){

double sum = 0;
    double mean;
    ArrayList<Number> averagearray = new ArrayList<>(arraylist);
    for ( int i = 0; i< averagearray.size(); ++i){
        sum = sum + averagearray.get(i).doubleValue();
    }
mean = sum / averagearray.size();

   ArrayList<Number> SDarray = new ArrayList<>(arraylist);
   for(int i = 0; i<SDarray.size(); ++i){
SDeviation += Math.pow(SDarray.get(i).doubleValue() - mean, 2);
   }
if(SDarray.size() > 1){
   SD = Math.sqrt(SDeviation / (SDarray.size()-1));
   StandardField.setText(""  + SD);
}else{ SD=0;
StandardField.setText(""  + SD);}
}else{ 
    StandardField.setText("");
}
      

}

public void maximum(ArrayList<Number> arraylist, TextField maximumField){
 ArrayList<Number> maxArrayList = new ArrayList<>(arraylist);
 if(!maxArrayList.isEmpty()){
 bubbleSort(maxArrayList);
double max = maxArrayList.get(maxArrayList.size()- 1).doubleValue();
maximumField.setText("" +max);
 }else{maximumField.setText("");

 }
 
}
public void min(ArrayList<Number> arraylist, TextField miniField){

 ArrayList<Number> minArrayList = new ArrayList<>(arraylist);
 if(!minArrayList.isEmpty()){
bubbleSort(minArrayList);
double min = minArrayList.get(0).doubleValue();
miniField.setText("" + min);
 }else{miniField.setText("" );


 }

}
    public void median(ArrayList<Number> arraylist, TextField medianField){
    ArrayList<Number> medianArrayList = new ArrayList<>(arraylist);
    bubbleSort(medianArrayList);
    if(!medianArrayList.isEmpty()){
     if(medianArrayList.size() % 2 != 0){
     int middle = medianArrayList.size() /2;
     double median = medianArrayList.get(middle).doubleValue();
     medianField.setText("" + median);
    }
     
     else{ 
     int evenmiddle1 =  medianArrayList.size()/2; 
     double evenmedian1= medianArrayList.get(evenmiddle1 - 1).doubleValue();
     int evenmiddlenext = (medianArrayList.size()/2); //next index
     double evenmediannext = medianArrayList.get(evenmiddlenext).doubleValue();
     double evenmedian = (evenmedian1 + evenmediannext ) /2;
     medianField.setText("" + evenmedian);
    
    }


}else{ medianField.setText("");
} 
      }


      public static void bubbleSort(ArrayList<Number> medianArrayList){
        bubbleSort(medianArrayList, 0, medianArrayList.size());
}

    public static void sort(ArrayList<Number> medianArrayList, int i, int k){
        Number temp= medianArrayList.get(i);
        medianArrayList.set(i, medianArrayList.get(k));
        medianArrayList.set(k, temp);
}

public static void bubbleSort(ArrayList<Number> medianArrayList, int start, int end){
        if (end - start <= 1)
        return;
        for (int i = start; i < end -1; i++){
        if (medianArrayList.get(i).doubleValue() > medianArrayList.get(i+1).doubleValue()){
        sort(medianArrayList, i, i+1);

    }
  }
        bubbleSort(medianArrayList, start, end -1);


    }});


resetButton.setOnAction(new EventHandler<ActionEvent>() {
        @Override public void handle(ActionEvent resetEvActionEvent){
       arraylist.clear();
       arraylist2.clear();
       Lgraph.DeleteChart();
       Sgraph.DeleteChart();
    
       inputField.setText("");
       medianfield.setText("");
       averageField.setText("");
       minField.setText("");
       maxField.setText("");
       SDField.setText("");

       data2SDfield.setText("");
       data2meanfield.setText("");
       data2medianfield.setText("");
       data2inputfield.setText("");
       data2maxfield.setText("");
       data2minfield.setText("");
       Lgraph.DeleteChart();
       Sgraph.DeleteChart();

        }
      });


      primaryStage.setScene(scene);
      primaryStage.setTitle("Statistical Analysis");
      primaryStage.show();}


    public static void main(String[] args) throws Exception {
     launch(args);
    
}
}

