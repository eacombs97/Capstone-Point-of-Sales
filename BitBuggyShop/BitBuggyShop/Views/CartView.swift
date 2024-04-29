
//
//  CartView.swift
//  BitBuggyShop
//
//  Created by Emily Combs
//

import SwiftUI

struct CartView: View {
    //Add environment object modifier
    @EnvironmentObject var cartManager : CartManager
    @EnvironmentObject var orderManager : OrderManager
    
    
    var body: some View {
        VStack{
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
                
                CartButton(numberOfProducts: cartManager.products.count)
                
                NavigationLink(destination: LoginView()){
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
            
            ScrollView {
                if cartManager.products.count > 0 {
                    ForEach(cartManager.products, id: \.id){
                        product in ProductRow(product: product)
                    }
                    
                    
                    HStack {
                        Text("Your cart total is")
                        Spacer()
                        if let formattedTotal = formatPrice(cartManager.total) {
                            Text(formattedTotal)
                                .bold()
                        }
                    }
                }else {
                    Text("Your cart is empty.")
                }
                // Checkout button
                            NavigationLink(destination: PlaceOrderView()) {
                                Text("Checkout")
                                    .padding()
                                    .background(Color("Dark Gold"))
                                    .foregroundColor(Color("Dark Green"))
                                    .cornerRadius(8)
                                    .padding()
                            }
                            .disabled(cartManager.products.isEmpty) // Disable checkout button if cart is empty
            }
            .padding(.top)
        }
        .background(Color.white)
        .edgesIgnoringSafeArea(.top)
    }
    
    // Function to format price with two decimal places
    private func formatPrice(_ price: Float) -> String? {
        let formatter = NumberFormatter()
        formatter.numberStyle = .currency
        formatter.maximumFractionDigits = 2
        return formatter.string(from: NSNumber(value: price))
        
    }
}

struct CartView_Previews: PreviewProvider {
    static var previews: some View {
        CartView()
            .environmentObject(CartManager())
    }
}
