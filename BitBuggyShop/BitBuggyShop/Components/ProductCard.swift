//
//  ProductCard.swift
//  BitBuggyShop
//
//  Created by Emily Combs
//

import SwiftUI

struct ProductCard: View {
    //Add environment object modifier
    @EnvironmentObject var cartManager: CartManager
    
    var product: Product
    
    var body: some View {
        ZStack(alignment: .topTrailing) {
            ZStack(alignment: .bottom){
                Image(product.productImage)
                    .resizable()
                    .cornerRadius(20)
                    .frame(width: 180)
                    .scaledToFit()
                
                VStack(alignment: .leading){
                    Text(product.productName)
                        .bold()
                    
                    // Format the price with two decimal places using NumberFormatter
                    if let formattedPrice = formatPrice(product.productPrice) {
                        Text(formattedPrice)
                            .font(.caption)
                            .padding()
                    }
                }
                .padding()
                .frame(width: 180, alignment: .leading)
                .background(.ultraThinMaterial)
                .cornerRadius(20)
            }
            .frame(width: 180, height: 250)
            .shadow(radius: 3)
            
            Button{
                cartManager.addToCart(product: product)
            } label: {
                Image(systemName:  "plus")
                    .padding(10)
                    .foregroundColor(Color(hex: "ad8d49"))
                    .background(Color(hex: "053426"))
                    .cornerRadius(50)
                    .padding()
            }
        }
    }
    // Function to format price with two decimal places
    private func formatPrice(_ price: Float) -> String? {
        let formatter = NumberFormatter()
        formatter.numberStyle = .currency
        formatter.maximumFractionDigits = 2
        return formatter.string(from: NSNumber(value: price))
    }
}

extension Color {
    init(hex: String) {
        let scanner = Scanner(string: hex)
        var rgbValue: UInt64 = 0
        
        scanner.scanHexInt64(&rgbValue)
        
        let red = Double((rgbValue & 0xFF0000) >> 16) / 255.0
        let green = Double((rgbValue & 0x00FF00) >> 8) / 255.0
        let blue = Double(rgbValue & 0x0000FF) / 255.0
        
        self.init(red: red, green: green, blue: blue)
    }
}

struct ProductCard_Previews: PreviewProvider {
    static var previews: some View {
        ProductCard(product: productList[0])
            .environmentObject(CartManager())
    }
    

}
