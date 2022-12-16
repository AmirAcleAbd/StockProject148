package fullapp.stockprojecttwo;

public class StockTable {

    /*public Pane demoTableView() {
        BorderPane bpane = new BorderPane();
        bpane.setStyle("-fx-background-color:rgba(255, 255, 255, 0.95);");
        bpane.setPadding(new Insets(20));
        Label lblTitle = new Label("Demo TableView");

        TableView<MyTableRow> tv = new TableView<>();
        tv.setEditable(true);

        TableColumn<MyTableRow, String> col1 = new TableColumn("Col-Name");
        col1.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<MyTableRow, String> col2 = new TableColumn("Col-Value");
        col2.setCellValueFactory(new PropertyValueFactory<>("value"));
        TableColumn<MyTableRow, String> col3 = new TableColumn("Col-Tag");
        col3.setCellValueFactory(new PropertyValueFactory<>("tag"));
        tv.getColumns().addAll(col1, col2, col3);

        tv.setItems(list2);

        list2.add(new MyTableRow("abcd", 1234, true));
        list2.add(new MyTableRow("xyzw", 9876, false));


        HBox hbox = new HBox();
        hbox.setPadding(new Insets(8, 0, 8, 10));
        hbox.setAlignment(Pos.CENTER_RIGHT);
        hbox.setSpacing(10);
        Button btnAdd = new Button("Add");
        Button btnRemove = new Button("Remove");
        hbox.getChildren().addAll(btnAdd, btnRemove);

        bpane.setTop(lblTitle);
        bpane.setCenter(tv);
        bpane.setBottom(hbox);

        btnAdd.setOnAction(e->{
            String name = "Record-" + (int)(Math.random()*100);
            MyTableRow record = new MyTableRow(name, (int)(Math.random()*20), true);
            list2.add(record);
            btnRemove.setDisable(false);
        });
        btnRemove.setOnAction(e->{
            if (list2.size()>0) {
                int idx = (int)(Math.random()*list2.size());
                list2.remove(idx);
            }
            if (list2.size()<1)
                btnRemove.setDisable(true);
        });
        return bpane;
    }*/
}
