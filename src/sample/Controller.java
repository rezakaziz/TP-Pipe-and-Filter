package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import sample.manager.Client;
import sample.manager.RentedItem;
import sample.manager.StockItem;

import java.util.LinkedList;
import java.util.List;

public class Controller {

    @FXML private Button AddStockItemBtn;
    @FXML private Button AddCustBtn;
    @FXML private Button Find;
    @FXML private TextField FTitle;
    @FXML private TextField FActor;
    //tab view stock
    @FXML private TextField ID;
    @FXML private TextField Title;
    @FXML private TextField RP;
    @FXML private TableView<StockItem> Tbitems;
    @FXML private TableColumn<StockItem, Integer> SId;
    @FXML private TableColumn<StockItem, String> SName;
    @FXML private TableColumn<StockItem,Float> RentalPrice;

    //tab view client
    @FXML private TextField IDC;
    @FXML private TextField Name;
    @FXML private TextField B;
    @FXML private TableView<Client> TbCust;
    @FXML private TableColumn<Client, Integer> CId;
    @FXML private TableColumn<Client, String> CName;
    @FXML private TableColumn<Client,Float> CB;

    List<Client> clients=new LinkedList<Client>();
    List<StockItem> items=new LinkedList<StockItem>();
    List<RentedItem> rentedItems=new LinkedList<RentedItem>();


    // called by the FXML loader after the labels declared above are injected
    public void initialize()
    {
        StockItem item1=new StockItem((float)120.0,"Ahlil",0);
        items.add(item1);

        Client c1=new Client(20000,"Rezak",0);
        clients.add(c1);


        //init tab view stock propreties
        SId.setCellValueFactory(new PropertyValueFactory<StockItem, Integer>("itemID"));
        SName.setCellValueFactory(new PropertyValueFactory<StockItem, String>("title"));
        RentalPrice.setCellValueFactory(new PropertyValueFactory<StockItem, Float>("rentalPrice"));
        Tbitems.getItems().addAll(items);

        //init tab view stock propreties
        CId.setCellValueFactory(new PropertyValueFactory<Client, Integer>("customerID"));
        CName.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
        CB.setCellValueFactory(new PropertyValueFactory<Client, Float>("accountBalance"));
        TbCust.getItems().addAll(clients);





//AddstockItem
        AddStockItemBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {

               String name=Title.getText();
                float rp=Float.parseFloat( RP.getText());
                int id=Integer.parseInt(ID.getText());
                String req="1 "+ID.getText()+" "+Title.getText()+" "+RP.getText();


                



                           }
        });
// Find
        Find.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
               String Titre=FTitle.getText();
               String Actor=FActor.getText();
               if(!Titre.isEmpty())
               {
                   String req="5 "+Titre;
               }
               else
               {
                   if(!Actor.isEmpty())
                   {
                       String req="6 "+Actor;
                   }
                   else
                   {
                       Tbitems.getItems().addAll(items);
                   }
               }

                //merging the two results and change the resulted

            }
        });
//add client
        AddCustBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {

                String req="10 "+IDC.getText()+" "+Name.getText()+" "+B.getText();

            }
        });
//ischecked out
        Tbitems.setRowFactory(tv -> {
            TableRow<StockItem> row = new TableRow<>();
            Color clr;
            row.setOnMouseEntered ( event -> {
                        if (!row.isEmpty()) {
                            StockItem rowData = row.getItem();
                            String req = "3 " + String.valueOf(rowData.getItemID());
                            //clr=(Color)row.getBackground().getFills().get(0).getFill();

                            //row.setStyle("-fx-background-color: green;");
                            System.out.println("It'is : " + rowData.getTitle());
                        }
                    });
            row.setOnMouseExited( event -> {

                    //row.setStyle("-fx-background-color: white;");
                System.out.println("It'is : "    );


            });
             row.setOnMouseClicked ( ev-> {
                            if (!row.isEmpty()) {
                                StockItem rowData = row.getItem();
                                String req = "3 " + String.valueOf(rowData.getItemID());

                                System.out.println("It'is : " + rowData.getTitle());
                            }
            });

                    return row;
                });
    }


}