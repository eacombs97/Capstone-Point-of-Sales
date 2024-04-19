//
//  ContentView.swift
//  BitBuggyShop
//
//  Created by Emily Combs
//

import SwiftUI

struct ContentView: View {
    @StateObject var cartManager = CartManager()
    
    var columns = [GridItem(.adaptive(minimum: 160), spacing: 20)]
    
    var body: some View {
        BaseView {
            ScrollView {
                LazyVGrid(columns: columns, spacing: 20) {
                    ForEach(productList, id: \.id) { product in
                        ProductCard(product:  product)
                            .environmentObject(cartManager)
                    }
                }
                .padding()
            }
            .background(Color("Dark Green"))
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
