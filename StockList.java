package fullapp.stockprojecttwo;

import javafx.scene.control.ListView;

public class StockList extends ListView {


    /*public Pane demoListView() {
        BorderPane bpane = new BorderPane();
        bpane.setStyle("-fx-background-color:rgba(255, 255, 255, 0.95);");
        bpane.setPadding(new Insets(20));
        Label lblTitle = new Label("Demo Listview");

        ListView<String> lv = new ListView();
        lv.setItems(list1);
        list1.add("ABCD");
        list1.add("CSMATH");
        list1.add("1356");

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(8, 0, 8, 10));
        hbox.setAlignment(Pos.CENTER_RIGHT);
        hbox.setSpacing(10);
        Button btnAdd = new Button("Add");
        Button btnRemove = new Button("Remove");
        hbox.getChildren().addAll(btnAdd, btnRemove);

        bpane.setTop(lblTitle);
        bpane.setCenter(lv);
        bpane.setBottom(hbox);

        btnAdd.setOnAction(e->{
            String s = "Item-" + (int)(Math.random()*100);
            list1.add(s);
        });

        btnRemove.setOnAction(e->{
            int size = list1.size();
            if (size > 0) {
                int idx = (int)(Math.random()*size);
                list1.remove(idx);
            }
        });

        return bpane;
    }*/
}
