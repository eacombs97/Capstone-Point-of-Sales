//
//  ProductRow.swift
//  BitBuggyShop
//
//  Created by Emily Combs
//

import SwiftUI

struct ProductRow: View {
    //Add CartManager environment object
    @EnvironmentObject var cartManager: CartManager
    var product: Product
    
    var body: some View {
        HStack(spacing: 20){
            Image(product.product_image)
                .resizable()
                .aspectRatio(contentMode: .fit)
                .frame(width: 50)
                .cornerRadius(10)
            
            VStack(alignment: .leading, spacing:10){
                Text(product.name)
                    .bold()
                
                // Format the price with two decimal places using NumberFormatter
                if let formattedPrice = formatPrice(product.price) {
                    Text(formattedPrice)
                        .font(.caption)
                        .padding()
                }
            }
            
            Spacer()
            
            Image(systemName:"trash")
                .foregroundColor(Color(hex: "c2a25d"))
                .onTapGesture{
                    cartManager.removedFromCart(product: product)
                }
        }
        .padding(.horizontal)
        .frame(maxWidth: .infinity, alignment: .leading)
        .background(.ultraThinMaterial)
    }
    
    // Function to format price with two decimal places
    private func formatPrice(_ price: Float) -> String? {
            let formatter = NumberFormatter()
            formatter.numberStyle = .currency
            formatter.maximumFractionDigits = 2
            return formatter.string(from: NSNumber(value: price))
    }
}

struct ProductRow_Previews: PreviewProvider {
    static var previews: some View {
        ProductRow(product: productList[2])
            .environmentObject(CartManager()) //add modifier to preview
    }
}
