//
//  PlaceOrderView.swift
//  BitBuggyShop
//
//  Created by Emily Combs 
//

import SwiftUI

struct PlaceOrderView: View {
    @EnvironmentObject var cartManager : CartManager
    @EnvironmentObject var orderManager : OrderManager
    @EnvironmentObject var accountManager: AccountManager
    
    @State private var shippingAddress: String = ""
    @State private var paymentMethod: String = "Credit Card"
    @State private var cardNumber: String = ""
    @State private var showAlert = false
    @State private var alertMessage = ""
    @State private var orderPlaced = false
    
    @State private var orderID: Int = 1
    
    var body: some View {
        let paymentMethods = ["Credit Card", "Debit Card"]
        
        VStack {
            HStack {
                Image("logo")
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .frame(width: 30, height: 30)
                    .padding()
                
                Spacer()
                
                Text("BitBuggy")
                    .font(.title)
                    .bold()
                    .foregroundColor(Color("Dark Gold"))
                    .padding()
                    .frame(maxWidth: .infinity, alignment: .center)
                
                Spacer()
                
                NavigationLink(destination: CartView()) {
                    CartButton(numberOfProducts: cartManager.products.count)
                }
                
                NavigationLink(destination: AccountView()) {
                    AccountButton()
                }
            }
            .frame(height: 90)
            .frame(maxWidth: .infinity, alignment: .topLeading)
            .background(Color("Dark Green"))
            .padding(.top, UIApplication
                .shared
                .connectedScenes
                .flatMap { ($0 as? UIWindowScene)?.windows ?? [] }
                .first { $0.isKeyWindow }?.safeAreaInsets.top)
            
            Spacer()
            
            VStack {
                Text("Enter Shipping Address:")
                    .foregroundColor(Color("Light Gold"))
                
                TextField("Enter your address", text: $shippingAddress)
                    .padding()
                    .background(Color(UIColor.systemGray6))
                    .cornerRadius(8)
                    .padding(.bottom, 20)
                
                Text("Select Payment Method:")
                    .foregroundColor(Color("Light Gold"))
                
                Picker(selection: $paymentMethod, label: Text("Select Payment Method")) {
                    ForEach(paymentMethods, id: \.self) { method in
                        Text(method)
                    }
                }
                .pickerStyle(SegmentedPickerStyle())
                .padding()
                .background(Color(UIColor.systemGray6))
                .cornerRadius(8)
                .padding(.bottom, 20)
                
                Text("Enter Card Number:")
                    .foregroundColor(Color("Light Gold"))
                TextField("Card Number", text: $cardNumber)
                    .padding()
                    .background(Color(UIColor.systemGray6))
                    .cornerRadius(8)
                    .padding(.bottom, 20)
                
                Button("Place Order") {
                    validateFields()
                }
                .padding()
                .frame(maxWidth: .infinity)
                .background(Color("Dark Gold"))
                .cornerRadius(8)
                .foregroundColor(Color("Dark Green"))
                .padding()
                .alert(isPresented: $showAlert) {
                    // Define the alert
                    Alert(
                        title: Text("Error"),
                        message: Text(alertMessage),
                        dismissButton: .default(Text("OK"))
                    )
                }
                Spacer()
            }
            .padding()
            
            // Order Confirmation Navigation
            NavigationLink(
                destination: OrderConfirmationView(),
                isActive: $orderPlaced
            ) {
                EmptyView()
            }
        }
        .background(Color("Green"))
        .edgesIgnoringSafeArea(.top)
        .onAppear {
                    // Set the initial order ID by finding the maximum order ID in existing orders and incrementing it by 1
                    if let maxOrderID = orderManager.orders.map({ $0.orderID }).max() {
                        orderID = maxOrderID + 1
                    }
                }
    }
    
    private func validateFields() {
        guard !shippingAddress.isEmpty else {
            alertMessage = "Please enter shipping address"
            showAlert = true
            return
        }
        
        guard !cardNumber.isEmpty else {
            alertMessage = "Please enter card number"
            showAlert = true
            return
        }
        
        placeOrder()
    }
    
    private func placeOrder() {
        guard !shippingAddress.isEmpty && !cardNumber.isEmpty else {
            alertMessage = "Please fill in all fields before placing the order."
            showAlert = true
            return
        }
        
        let order = Order(
            id: UUID(), // Provide a unique ID for the order
            items: cartManager.products,
            shippingAddress: shippingAddress,
            paymentMethod: paymentMethod,
            orderID: orderID, // Example values, replace with actual data
            userID: 456,
            discountID: 789,
            shippingDetailsID: 101,
            taxID: 102,
            paymentID: 103,
            totalQuantity: cartManager.products.count,
            total: cartManager.total
        )
        
        // Add the order to the OrderManager
        orderManager.addOrder(order)
        
        // Now you can proceed with processing the order, e.g., sending it to the server, etc.
        
        // Optionally, you can clear the cart after placing the order
        cartManager.clearCart()
        
        // Additional logic for handling the order confirmation, navigation, etc.
        orderPlaced = true
    }
}

struct PlaceOrderView_Previews: PreviewProvider {
    static var previews: some View {
        PlaceOrderView()
            .environmentObject(CartManager())
            .environmentObject(OrderManager())
            .environmentObject(AccountManager())
    }
}
