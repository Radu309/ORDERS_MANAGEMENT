package prezentation;

import dataAccess.InsertClient;
import dataAccess.InsertOrder;
import dataAccess.InsertProduct;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Client;
import model.Order;
import model.Product;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    //FROM FIRST WINDOW
    @FXML private Button showClients;
    @FXML private Button showProducts;
    @FXML private Button showOrders;
    @FXML private Button insertClient;
    @FXML private Button insertProduct;
    @FXML private Button insertOrder;
    @FXML private Button deleteClient;
    @FXML private Button deleteProduct;
    @FXML private Button editClient;
    @FXML private Button editProduct;
    //DISPLAY
    @FXML TextArea clientID = new TextArea();
    @FXML TextArea clientEmail = new TextArea();
    @FXML TextArea clientName = new TextArea();
    @FXML TextArea clientAge = new TextArea();
    @FXML TextArea productID = new TextArea();
    @FXML TextArea productName = new TextArea();
    @FXML TextArea productPrice = new TextArea();
    @FXML TextArea productNumber = new TextArea();
    @FXML TextArea orderID = new TextArea();
    @FXML TextArea orderClientID = new TextArea();
    @FXML TextArea orderProductID = new TextArea();
    @FXML TextArea orderNumberOfProducts = new TextArea();
    static TextArea clientIDStatic = new TextArea();
    static TextArea clientEmailStatic = new TextArea();
    static TextArea clientNameStatic = new TextArea();
    static TextArea clientAgeStatic = new TextArea();
    static TextArea productIDStatic = new TextArea();
    static TextArea productNameStatic = new TextArea();
    static TextArea productPriceStatic = new TextArea();
    static TextArea productNumberStatic = new TextArea();
    static TextArea orderIDStatic = new TextArea();
    static TextArea orderClientIDStatic = new TextArea();
    static TextArea orderProductIDStatic = new TextArea();
    static TextArea orderNumberOfProductsStatic = new TextArea();
    ///INSERT WINDOWS
    @FXML private Button insertOneClient;
    @FXML private TextField clientNameTextField;
    @FXML private TextField clientEmailTextField;
    @FXML private TextField clientAgeTextField;
    @FXML private Button insertOneProduct;
    @FXML private TextField productNameTextField;
    @FXML private TextField productPriceTextField;
    @FXML private TextField productNumberTextField;
    @FXML private Button insertOneOrder;
    @FXML private TextField orderIDClientIDTextField;
    @FXML private TextField orderIDProductIDTextField;
    @FXML private TextField orderIDNumberOfProductsTextField;
    ///DELETE WINDOWS
    @FXML private Button deleteOneClientButton;
    @FXML private Button deleteOneProductButton;
    @FXML private TextField deleteClientTextField;
    @FXML private TextField deleteProductTextField;
    ///EDIT WINDOWS
    @FXML private Button editOneClientButton;
    @FXML private Button editOneProductButton;
    @FXML private TextField editClientIDTextField;
    @FXML private TextField editClientNameTextField;
    @FXML private TextField editClientEmailTextField;
    @FXML private TextField editClientAgeTextField;
    @FXML private TextField editProductIDTextField;
    @FXML private TextField editProductNameTextField;
    @FXML private TextField editProductNumberTextField;
    @FXML private TextField editProductPriceTextField;
    //
    @FXML public void initialize(URL url, ResourceBundle rb) {
        clientID.setText(clientIDStatic.getText());
        clientName.setText(clientNameStatic.getText());
        clientEmail.setText(clientEmailStatic.getText());
        clientAge.setText(clientAgeStatic.getText());

        productID.setText(productIDStatic.getText());
        productName.setText(productNameStatic.getText());
        productNumber.setText(productNumberStatic.getText());
        productPrice.setText(productPriceStatic.getText());

        orderID.setText(orderIDStatic.getText());
        orderClientID.setText(orderClientIDStatic.getText());
        orderProductID.setText(orderProductIDStatic.getText());
        orderNumberOfProducts.setText(orderNumberOfProductsStatic.getText());
    }

    @FXML public void clickShowClients() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ClientsDesign.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        Stage stage2 = new Stage();
        stage2.setScene(scene);
        stage2.show();
    }
    @FXML public void clickShowProducts() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ProductsDesign.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        Stage stage3 = new Stage();
        stage3.setScene(scene);
        stage3.show();
    }
    @FXML public void clickShowOrder() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("OrderDesign.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        Stage stage8 = new Stage();
        stage8.setScene(scene);
        stage8.show();
    }

    @FXML public void clickInsertClientWindow() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("InsertClient.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 362, 250);
        Stage stage4 = new Stage();
        stage4.setScene(scene);
        stage4.show();
    }
    @FXML public void clickInsertProductWindow() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("InsertProduct.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 362, 250);
        Stage stage5 = new Stage();
        stage5.setScene(scene);
        stage5.show();
    }
    @FXML public void clickInsertOrderWindow() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("InsertOrder.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 362, 250);
        Stage stage9 = new Stage();
        stage9.setScene(scene);
        stage9.show();
    }

    @FXML public void clickInsertClientButton(){
        InsertClient insertClient = new InsertClient();
        String stringName = clientNameTextField.getText();
        String stringEmail = clientEmailTextField.getText();
        String stringAge = clientAgeTextField.getText();
        insertClient.insertOneClient(stringName,stringEmail,stringAge);
        Stage stage4 = (Stage) insertOneClient.getScene().getWindow();
        stage4.close();
    }
    @FXML public void clickInsertProductButton(){
        InsertProduct insertProduct = new InsertProduct();
        String stringName = productNameTextField.getText();
        String stringPrice = productPriceTextField.getText();
        String stringNumber = productNumberTextField.getText();
        insertProduct.insertOneProduct(stringName,stringNumber,stringPrice);
        Stage stage5 = (Stage) insertOneProduct.getScene().getWindow();
        stage5.close();
    }
    @FXML public void clickInsertOrderButton(){
        InsertOrder insertOrder = new InsertOrder();
        String stringClientID = orderIDClientIDTextField.getText();
        String stringProductID = orderIDProductIDTextField.getText();
        String stringNumberOfProducts = orderIDNumberOfProductsTextField.getText();
        insertOrder.insertOneOrder(stringClientID,stringProductID,stringNumberOfProducts);
        Stage stage9 = (Stage) insertOneOrder.getScene().getWindow();
        stage9.close();
    }

    @FXML public void clickDeleteOneClient() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("DeleteClient.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 362, 250);
        Stage stage6 = new Stage();
        stage6.setScene(scene);
        stage6.show();
    }
    @FXML public void clickDeleteButton(){
        String result = deleteClientTextField.getText();
        InsertClient insertClient = new InsertClient();
        insertClient.deleteOneClient(Integer.parseInt(result) - 1);

        Stage stage6 = (Stage) deleteOneClientButton.getScene().getWindow();
        stage6.close();
    }
    @FXML public void clickDeleteOneProduct() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("DeleteProduct.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 362, 250);
        Stage stage7 = new Stage();
        stage7.setScene(scene);
        stage7.show();
    }
    @FXML public void clickDeleteButtonProduct(){
        String result = deleteProductTextField.getText();
        InsertProduct insertProduct = new InsertProduct();
        insertProduct.deleteOneProduct(Integer.parseInt(result) - 1);
        Stage stage7 = (Stage) deleteOneProductButton.getScene().getWindow();
        stage7.close();
    }

    @FXML public void clickEditClient() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("EditClient.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 362, 250);
        Stage stage8 = new Stage();
        stage8.setScene(scene);
        stage8.show();
    }
    @FXML public void clickEditClientButton(){
        String ID = editClientIDTextField.getText();
        String Name = editClientNameTextField.getText();
        String Email = editClientEmailTextField.getText();
        String Age = editClientAgeTextField.getText();
        InsertClient insertClient = new InsertClient();
        insertClient.editOneClient(ID,Name,Email,Age);
        Stage stage8 = (Stage) editOneClientButton.getScene().getWindow();
        stage8.close();
    }
    @FXML public void clickEditProduct() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("EditProduct.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 362, 250);
        Stage stage9 = new Stage();
        stage9.setScene(scene);
        stage9.show();
    }
    @FXML public void clickEditProductButton(){
        String ID = editProductIDTextField.getText();
        String Name = editProductNameTextField.getText();
        String Email = editProductNumberTextField.getText();
        String Age = editProductPriceTextField.getText();
        InsertProduct insertProduct = new InsertProduct();
        insertProduct.editOneProduct(ID,Name,Email,Age);
        Stage stage9 = (Stage) editOneProductButton.getScene().getWindow();
        stage9.close();
    }

    public void writeClients(@NotNull List<Client> listClient){
        String stringID = "";
        String stringName = "";
        String stringEmail = "";
        String stringAge = "";
        for(Client it: listClient){
            stringID += it.getID() + "\n";
            stringName += it.getName() + "\n";
            stringEmail += it.getEmail() + "\n";
            stringAge += it.getAge() + "\n";
        }
        showClientsWindow(stringID,stringName,stringEmail,stringAge);
    }
    public void writeProducts(@NotNull List<Product> listProduct){
        String stringID = "";
        String stringName = "";
        String stringNumber = "";
        String stringPrice = "";
        for(Product it: listProduct){
            stringID += it.getID() + "\n";
            stringName += it.getName() + "\n";
            stringNumber += it.getNumber() + "\n";
            stringPrice += it.getPrice() + "\n";
        }
        showProductsWindow(stringID,stringName,stringNumber,stringPrice);
    }
    public void writeOrders(@NotNull List<Order> listOrder){
        String stringOrderID = "";
        String stringClientID = "";
        String stringProductID = "";
        String stringNumberOfProducts = "";
        for(Order it: listOrder){
            stringOrderID += it.getOrderID() + "\n";
            stringClientID += it.getClientID() + "\n";
            stringProductID += it.getProductID() + "\n";
            stringNumberOfProducts += it.getNumberOfProducts() + "\n";
        }
        showOrdersWindow(stringOrderID,stringClientID,stringProductID,stringNumberOfProducts);
    }

    public void showClientsWindow(String string1, String string2, String string3, String string4){
        clientIDStatic.setText(string1);
        clientNameStatic.setText(string2);
        clientEmailStatic.setText(string3);
        clientAgeStatic.setText(string4);
    }
    public void showProductsWindow(String string1, String string2, String string3, String string4){
        productIDStatic.setText(string1);
        productNameStatic.setText(string2);
        productNumberStatic.setText(string3);
        productPriceStatic.setText(string4);
    }
    public void showOrdersWindow(String string1, String string2, String string3, String string4){
        orderIDStatic.setText(string1);
        orderClientIDStatic.setText(string2);
        orderProductIDStatic.setText(string3);
        orderNumberOfProductsStatic.setText(string4);
    }

}