//
//  AccountView.swift
//  BitBuggyShop
//
//

import SwiftUI

struct AccountView: View {
    @EnvironmentObject var cartManager : CartManager
    @EnvironmentObject var orderManager : OrderManager
    
    var body: some View {
        
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
                        .frame(maxWidth: .infinity, alignment: .center) // Center the title
          
                
                Spacer() // Pushes the buttons to the right
                
                NavigationLink (destination: CartView()){
                    CartButton(numberOfProducts: cartManager.products.count)
                }
                
                AccountButton() // Use the AccountButton to navigate to AccountView
            }
            .frame(height: 90)
            .frame(maxWidth: .infinity, alignment: .topLeading)
            .background(Color("Dark Green"))
            .padding(.top, UIApplication
                                .shared
                                .connectedScenes
                                .flatMap { ($0 as? UIWindowScene)?.windows ?? [] }
                                .first { $0.isKeyWindow }?.safeAreaInsets.top)

            Text("My Account")
                .font(.title)
                .padding(.bottom, 10)
            
            Spacer()
            
            Section(header: Text("Orders")) {
                ForEach(orderManager.orders) { order in
                    VStack {
                        Text("Order ID: \(order.orderID)")
                            .font(.headline)
                            .padding(.bottom, 5)
                        Text("Shipping Address: \(order.shippingAddress)")
                            .font(.subheadline)
                            .padding(.bottom, 2)
                        Text("Total: $\(order.formattedTotal)")
                            .font(.subheadline)
                    }
                    .padding(.vertical, 5)
                }
            }
            .padding(.bottom, 20)
            
            Section(header: Text("Stored Addresses")) {
                // Display list of stored addresses
                Text("Address 1")
                Text("Address 2")
                Text("Address 3")
                // Add more address details as needed
            }
            .padding(.bottom, 20)
            
            Section(header: Text("Stored Card Information")) {
                // Display list of stored card information
                Text("Card ending in 1234")
                Text("Card ending in 5678")
                // Add more card details as needed
            }
            Spacer(minLength: 251) //play with spacer minLength if bar doesn't reach top
        }
        .edgesIgnoringSafeArea(.top)
    }
    
       
}

struct AccountView_Previews: PreviewProvider {
    static var previews: some View {
        AccountView()
            .environmentObject(CartManager())
            .environmentObject(OrderManager())
    }
}
