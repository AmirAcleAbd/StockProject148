package fullapp.stockprojecttwo;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class StockGUI extends Application {
    Scene sceneMain = null;
    BorderPane rootHome = null;
    BorderPane rootStockCitadel = null;
    BorderPane rootAccountManagement = null;
    BorderPane rootPortfolio = null;
    Pane rootLogin = null;
    boolean signedIn = false;
    HBox hbox = null;
    MenuButton dropdownButton = null;
    Button btnSignIn = null;

    ObservableList<String> list1 = FXCollections.observableArrayList();
    ObservableList<MyTableRow> list2 = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage HomeStage) {

        rootLogin = loginGUI(HomeStage);
        rootHome = HomePageGUI(HomeStage);
        rootStockCitadel = StockCitadelGUI(HomeStage);
        rootAccountManagement = AccountManagementGUI(HomeStage);
        rootPortfolio = PortfolioGUI(HomeStage);
        sceneMain = new Scene(rootHome, 1000, 1000);
        sceneMain.getStylesheets().add("fullapp/stockprojecttwo/StyleSheets/myStyleSheet.css");


        HomeStage.setScene(sceneMain);
        HomeStage.setTitle("Home Page");
        HomeStage.setResizable(true);
        HomeStage.show();

    }

    public BorderPane HomePageGUI(Stage stage){
        BorderPane pane = new BorderPane();

        pane.setPadding(new Insets(20));
        PieChart pane4 = personalPiePortfolio();

        dropdownButton = new MenuButton();
        dropdownButton.setText("amir amir");
        //dropdownButton.setStyle("-fx-skin: none; -fx-background-color: lightblue; -fx-padding: 8px; -fx-font-size: 16px; -fx-arrow-visible: false;");
        MenuItem option1 = new MenuItem("Option 1");
        MenuItem option2 = new MenuItem("Option 2");
        MenuItem option3 = new MenuItem("Option 3");
        dropdownButton.getItems().addAll(option1, option2, option3);
        dropdownButton.getStyleClass().add("custom-dropdown-button");


        hbox = new HBox();
        hbox.setSpacing(100);
        hbox.setPadding(new Insets(50, 50, 50, 50));
        Button btnStockCitadel = new Button("Stock Room");
        Button btnPortfolioPage = new Button("Portfolio");
        Button btnAccountMang = new Button("Account Management");
        btnSignIn = new Button("Sign in");
        btnStockCitadel.setMinWidth(100);
        btnPortfolioPage.setMinWidth(100);
        btnAccountMang.setMinWidth(100);

        if(signedIn){
            rootHome.getChildren().remove(hbox);
            hbox.getChildren().remove(btnSignIn);
            hbox.getChildren().add(dropdownButton);
            rootHome.getChildren().add(hbox);

        }

        hbox.getChildren().addAll(btnStockCitadel, btnPortfolioPage, btnAccountMang, btnSignIn);
        hbox.setAlignment(Pos.CENTER);
        pane.setTop(hbox);
        pane.setLeft(pane4);
        hbox.setAlignment(Pos.CENTER);

        btnStockCitadel.setOnAction(e->{
            sceneMain.setRoot(rootStockCitadel);
        });
        btnPortfolioPage.setOnAction(e->{
            sceneMain.setRoot(rootPortfolio);
        });
        btnAccountMang.setOnAction(e->{
            sceneMain.setRoot(rootAccountManagement);
        });
        btnSignIn.setOnAction(e->{
            sceneMain.setRoot(rootLogin);
        });

        return pane;
    }

    public BorderPane StockCitadelGUI(Stage stage){
        BorderPane pane = new BorderPane();

        pane.setPadding(new Insets(20));

        StockLine nasdaqStock = new StockLine("Nasdaq", "NSDQ",
                "Nasdaq","USD", "/Users/amirabd/Downloads/^IXIC.csv" );


        LineChart<String, Number> lineChart = nasdaqStock.createChart();


        lineChart.getYAxis().setAutoRanging(false);
        Button btnHomePage = new Button("Home Page");
        Button btnPortfolioPage = new Button("Portfolio");
        Button btnAccountMang = new Button("Account Management");

        lineChart.setMaxHeight(300);
        lineChart.setTranslateY(-350);

        HBox hbox2 = new HBox();
        hbox2.setSpacing(100);
        hbox2.setPadding(new Insets(50, 50, 50, 50));
        hbox2.setAlignment(Pos.CENTER);
        hbox2.setTranslateY(-50);
        hbox2.getChildren().addAll(btnHomePage, btnPortfolioPage, btnAccountMang);

        pane.setTop(hbox2);
        pane.setCenter(lineChart);

        btnHomePage.setOnAction(e->{
            sceneMain.setRoot(rootHome);
        });
        btnPortfolioPage.setOnAction(e->{
            sceneMain.setRoot(rootPortfolio);
        });
        btnAccountMang.setOnAction(e->{
            sceneMain.setRoot(rootAccountManagement);
        });

        return pane;
    }

    public BorderPane AccountManagementGUI(Stage stage){
        BorderPane pane = new BorderPane();

        pane.setPadding(new Insets(20));

        Button btnStockCitadel = new Button("Stock Room");
        Button btnPortfolioPage = new Button("Portfolio");
        Button btnHomePage = new Button("Home Page");

        HBox hbox3 = new HBox();
        hbox3.setSpacing(100);
        hbox3.setPadding(new Insets(50, 50, 50, 50));
        hbox3.setAlignment(Pos.CENTER);
        hbox3.setTranslateY(-50);
        hbox3.getChildren().addAll(btnHomePage, btnPortfolioPage, btnStockCitadel);

        pane.setTop(hbox3);

        btnHomePage.setOnAction(e->{
            sceneMain.setRoot(rootHome);
        });
        btnPortfolioPage.setOnAction(e->{
            sceneMain.setRoot(rootPortfolio);
        });
        btnStockCitadel.setOnAction(e->{
            sceneMain.setRoot(rootStockCitadel);
        });

        return pane;
    }

    public BorderPane PortfolioGUI(Stage stage){
        BorderPane pane = new BorderPane();

        pane.setPadding(new Insets(20));

        Button btnStockCitadel = new Button("Stock Room");
        Button btnAccountMang = new Button("Account Management");
        Button btnHomePage = new Button("Home Page");

        HBox hbox4 = new HBox();
        hbox4.setSpacing(100);
        hbox4.setPadding(new Insets(50, 50, 50, 50));
        hbox4.setAlignment(Pos.CENTER);
        hbox4.setTranslateY(-50);
        hbox4.getChildren().addAll(btnHomePage, btnAccountMang, btnStockCitadel);

        pane.setTop(hbox4);

        btnHomePage.setOnAction(e->{
            sceneMain.setRoot(rootHome);
        });
        btnAccountMang.setOnAction(e->{
            sceneMain.setRoot(rootAccountManagement);
        });
        btnStockCitadel.setOnAction(e->{
            sceneMain.setRoot(rootStockCitadel);
        });

        return pane;
    }

    private Pane loginGUI(Stage stagePassThrough) {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblUsername = new Label("Username");
        Label lblPassword = new Label("Password");
        Label lblConfirmPass = new Label("Confirm Password");
        TextField tfUsername = new TextField();
        TextField tfPassword = new TextField();
        TextField tfConfirmPass = new TextField();

        pane.add(lblUsername, 0, 0);
        pane.add(lblPassword, 0, 1);
        pane.add(tfUsername, 1, 0, 2, 1);
        pane.add(tfPassword, 1, 1, 2, 1);

        HBox hbox1 = new HBox();
        hbox1.setSpacing(10);
        hbox1.setAlignment(Pos.CENTER_RIGHT);
        Button btnLogin = new Button("Login");
        Button btnSignUp = new Button("Sign up");
        btnLogin.setDisable(true);
        btnLogin.setPrefWidth(60);
        btnSignUp.setPrefWidth(60);
        hbox1.getChildren().addAll(btnLogin, btnSignUp);
        pane.add(hbox1, 1, 2, 2, 1);

        // register event handlers
        class MyKeyEventHanlder implements EventHandler<KeyEvent> {
            public void handle(KeyEvent e) {
                String username = tfUsername.getText();
                String password = tfPassword.getText();
                String confirmPassword = tfConfirmPass.getText();
                btnLogin.setDisable(!validateLogin(username, password));
            }
        }
        tfUsername.setOnKeyTyped(new MyKeyEventHanlder());

        // register event handler via anonymous class
        tfPassword.setOnKeyTyped(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                String username = tfUsername.getText();
                String password = tfPassword.getText();
                String confirmPassword = tfConfirmPass.getText();
                btnLogin.setDisable(!validateLogin(username, password));
            }
        });

        btnLogin.setOnAction(e->{
            User user = new User(tfUsername.getText(), tfPassword.getText());
            boolean b = DataCenter.getInstance().findUser(user);
            if (b) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("User login is validated");
                sceneMain.setRoot(rootHome);
                rootHome.getChildren().remove(hbox);
                hbox.getChildren().remove(btnSignIn);
                hbox.getChildren().add(dropdownButton);
                rootHome.getChildren().add(hbox);
                updateRoot(rootHome);
                signedIn = true;
                alert.showAndWait();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("error-header");
                alert.setContentText("Failed to validate user login");
                alert.showAndWait();
            }
        });

        btnSignUp.setOnAction(e->{
            pane.add(lblConfirmPass, 0, 2);
            pane.add(tfConfirmPass, 1, 2, 2, 1);
            pane.getChildren().remove(hbox);

            HBox hbox11 = new HBox();
            hbox11.setSpacing(10);
            hbox11.setAlignment(Pos.CENTER_RIGHT);
            Button btnCancel = new Button("Cancel");
            Button btnSignUp1 = new Button("Sign up");
            btnCancel.setPrefWidth(60);
            btnSignUp1.setPrefWidth(60);
            hbox11.getChildren().addAll(btnSignUp1, btnCancel);
            pane.add(hbox1, 1, 3, 2, 1);

            btnCancel.setOnAction(e1->{
                pane.getChildren().remove(lblConfirmPass);
                pane.getChildren().remove(tfConfirmPass);
                pane.getChildren().remove(hbox1);
                pane.add(hbox, 1, 2, 2, 1);
            });

            btnSignUp1.setOnAction(e1->{
                String username = tfUsername.getText();
                String password = tfPassword.getText();
                String confirmPassword = tfConfirmPass.getText();
                if(password.equals(confirmPassword)){
                    User user = new User(username, password);
                    DataCenter.getInstance().addUser(user);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("User sign up is validated");
                    alert.showAndWait();
                    sceneMain.setRoot(rootHome);
                    hbox.getChildren().remove(btnLogin);
                    hbox.getChildren().add(dropdownButton);
                    updateRoot(rootHome);
                    signedIn = true;
                }
                else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("error-header");
                    alert.setContentText("Failed to validate user sign up");
                    alert.showAndWait();
                }
            });
        });

        return pane;
    }

    public PieChart personalPiePortfolio(){
        PieChart pieChart = new PieChart();
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Apple", 13),
                        new PieChart.Data("Microsoft", 25),
                        new PieChart.Data("Google", 10),
                        new PieChart.Data("IBM", 22),
                        new PieChart.Data("Oracle", 30));

        pieChart.setData(pieChartData);
        pieChart.setTitle("Personal Portfolio");
        return pieChart;
    }

    private boolean validateLogin(String username, String password) {
        return (username.length()>=3 && password.length()>=3);
    }

    public void updateRoot(Pane root) {
        // Update the contents of the root node here

        // Update the contents of any child nodes
        for (Node child : root.getChildren()) {
            if (child instanceof Pane) {
                updateRoot((Pane) child);
            }
        }
    }
}