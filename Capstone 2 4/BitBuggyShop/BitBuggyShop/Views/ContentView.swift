//
//  ContentView.swift
//  BitBuggyShop
//
//  Created by Emily Combs
//

import SwiftUI

struct ContentView: View {
    @EnvironmentObject var cartManager : CartManager
    @EnvironmentObject var orderManager : OrderManager
    @EnvironmentObject var accountManager: AccountManager
    
    var columns = [GridItem(.adaptive(minimum: 160), spacing: 20)]
    
    var body: some View {
        NavigationView {
            VStack { // Use VStack as the main container
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
                .frame(height: 90)
                .frame(maxWidth: .infinity, alignment: .top)
                .background(Color("Dark Green"))
                .padding(.top, UIApplication
                                    .shared
                                    .connectedScenes
                                    .flatMap { ($0 as? UIWindowScene)?.windows ?? [] }
                                    .first { $0.isKeyWindow }?.safeAreaInsets.top)
                
                ScrollView { // Use ScrollView inside VStack
                    LazyVGrid(columns: columns, spacing: 20){
                        ForEach(productList, id: \.id) { product in
                            ProductCard(product: product)
                                .environmentObject(cartManager)
                        }
                    }
                    .padding()
                }
            }
            .background(Color.white)
            .edgesIgnoringSafeArea(.top) // Ignore safe area for the entire view
        }
        .navigationViewStyle(StackNavigationViewStyle())
        .edgesIgnoringSafeArea(.top)
    }
}
                

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
            .environmentObject(CartManager())
            .environmentObject(OrderManager())
            .environmentObject(AccountManager())
    }
}
