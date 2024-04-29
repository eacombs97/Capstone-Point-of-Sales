//
//  OrderDetailsView.swift
//  BitBuggyShop
//
//  Created by Emily Combs on 4/29/24.
//

import SwiftUI

struct OrderDetailsView: View {
    @EnvironmentObject var cartManager : CartManager
    @EnvironmentObject var orderManager : OrderManager
    
    let order: Order

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
                        .frame(maxWidth: .infinity, alignment: .center) //
                
                Spacer() // Pushes the buttons to the right
                
                NavigationLink(destination: CartView()){
                    CartButton(numberOfProducts: cartManager.products.count)
                }
                
                NavigationLink(destination: AccountView()) {
                    AccountButton() // Use the AccountButton to navigate to AccountView
                }
            }
            .frame(maxWidth: .infinity, alignment: .topLeading)
            .background(Color("Dark Green"))
            .padding(.top, UIApplication
                                .shared
                                .connectedScenes
                                .flatMap { ($0 as? UIWindowScene)?.windows ?? [] }
                                .first { $0.isKeyWindow }?.safeAreaInsets.top)
            Text("Order ID: \(order.orderID)")
            Text("Items:")
            ForEach(order.items) { item in
                Text("- \(item.name)")
            }
            Text("Shipping Address: \(order.shippingAddress)")
            Text("Payment Method: \(order.paymentMethod)")
            Text("Total Quantity: \(order.totalQuantity)")
            Text("Total Cost: \(order.total)")
            
            Spacer()
        }

        .navigationBarTitle("Order Details")
        .navigationBarBackButtonHidden(true)
        .edgesIgnoringSafeArea(.top)
    }
        
}

struct OrderDetailsView_Previews: PreviewProvider {
    static var previews: some View {
        // Create a sample order for preview
        let sampleOrder = Order(
            id: UUID(),
            items: [Product(name: "Sample Product", category_id: "Sample Category", product_image: "sample_image", product_description: "Sample description", price: 9.99, product_stock: 10, promotion_id: 0)],
            shippingAddress: "123 Sample St",
            paymentMethod: "Credit Card",
            orderID: 123,
            userID: 456,
            discountID: 789,
            shippingDetailsID: 101,
            taxID: 102,
            paymentID: 103,
            guestID: 0,
            totalQuantity: 1,
            total: 9.99
        )

        // Provide the sample order to the OrderDetailsView
        return OrderDetailsView(order: sampleOrder)
            .environmentObject(CartManager())
            .environmentObject(OrderManager())
    }
}
