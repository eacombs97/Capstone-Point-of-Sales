//
//  CartView.swift
//  BitBuggyShop
//
//  Created by Emily Combs
//

import SwiftUI

struct CartView: View {
    //Add environment object modifier
    @EnvironmentObject var cartManager: CartManager
    
    var body: some View {
        BaseView{
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
            }
            .background(Color("Dark Green"))
        }
        .navigationTitle(Text("My Cart"))
        .padding(.top)
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
