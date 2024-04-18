//
//  ContentView.swift
//  BitBuggyShop
//
//  Created by Emily Combs
//

import SwiftUI

struct ContentView: View {
    //create instance of cart manager
    @StateObject var cartManager = CartManager()
    
    var columns = [GridItem(.adaptive(minimum: 160), spacing: 20)]
    
    var body: some View {
        NavigationView {
            ScrollView{
                LazyVGrid(columns: columns, spacing: 20){
                    ForEach(productList, id: \.id) { product in ProductCard(product:  product)
                            .environmentObject(cartManager)
                    }
                }
                .padding()
            }
            .navigationTitle(Text("BitBuggy"))
            .toolbar {
                NavigationLink{
                    CartView()
                        .environmentObject(cartManager)
                } label: {
                    CartButton(numberOfProducts: cartManager.products.count) //Counts the number of products in the array
                }
                NavigationLink{
                    LoginView()
                }
            }
            .background(Color(hex: "053426"))
        }
        .navigationViewStyle(StackNavigationViewStyle())
        
    }
}
                

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
