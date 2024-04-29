//
//  OrderConfirmationView.swift
//  BitBuggyShop
//
//  Created by Emily Combs
//

import SwiftUI

struct OrderConfirmationView: View {
    @EnvironmentObject var cartManager: CartManager
    @EnvironmentObject var orderManager: OrderManager
    
    var body: some View {
        NavigationView {
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
                Spacer(minLength: 10)
                
                List {
                    ForEach(orderManager.orders) { order in
                        NavigationLink(destination: OrderDetailsView(order: order)) {
                            Text("Order ID: \(order.orderID)")
                        }
                    }
                }
            }
        }
        .navigationBarTitle("Orders")
    }
}

struct OrderConfirmationView_Previews: PreviewProvider {
    static var previews: some View {
        let orderManager = OrderManager.shared

        // Creating some sample orders for preview
        let sampleOrder1 = Order(id: UUID(),
                                 items: [Product(name:"Moleskin Notebook", category_id:"Office Supplies", product_image:"MoleskinNotebook", product_description:"8x11\" Office Notebooke by Moleskin", price: 14.99, product_stock: 12, promotion_id: 0000), Product(name:"Moleskin Notebook", category_id:"Office Supplies", product_image:"MoleskinNotebook", product_description:"8x11\" Office Notebooke by Moleskin", price: 14.99, product_stock: 12, promotion_id: 0000)],
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
                                 total: 10.0)

        let sampleOrder2 = Order(id: UUID(),
                                 items: [Product(name:"Moleskin Notebook", category_id:"Office Supplies", product_image:"MoleskinNotebook", product_description:"8x11\" Office Notebooke by Moleskin", price: 14.99, product_stock: 12, promotion_id: 0000)],
                                 shippingAddress: "456 Sample St",
                                 paymentMethod: "PayPal",
                                 orderID: 124,
                                 userID: 457,
                                 discountID: 790,
                                 shippingDetailsID: 102,
                                 taxID: 103,
                                 paymentID: 104,
                                 guestID: 0,
                                 totalQuantity: 1,
                                 total: 20.0)

        orderManager.addOrder(sampleOrder1)
        orderManager.addOrder(sampleOrder2)

        return OrderConfirmationView()
            .environmentObject(CartManager())
            .environmentObject(OrderManager())
    }
}
