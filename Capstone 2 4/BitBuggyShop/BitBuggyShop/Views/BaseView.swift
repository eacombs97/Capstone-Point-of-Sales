//
//  BaseView.swift
//  BitBuggyShop
//
//  Created by Emily Combs
//

import SwiftUI

struct BaseView<Content: View>: View {
    let content: Content
    @StateObject var cartManager = CartManager()
    
    init(@ViewBuilder content: () -> Content) {
        self.content = content()
    }
    
    var body: some View {
        NavigationView {
            content
                //.navigationBarTitle(Text(""), displayMode: .inline) // Empty text to make space for logo
                navigationBarItems(leading:
                    Image("AppIcon")
                        .resizable()
                        .aspectRatio(contentMode: .fit)
                        .frame(width: 30, height: 30) // Adjust size as needed
                )
                .toolbar {
                    ToolbarItem(placement: .navigationBarTrailing) {
                        NavigationLink(destination: CartView().environmentObject(cartManager)) {
                            CartButton(numberOfProducts: cartManager.products.count)
                        }
                    }
                    ToolbarItem(placement: .navigationBarTrailing) {
                        NavigationLink(destination: LoginView()) {
                            Text("Login")
                                .foregroundColor(Color("Dark Gold"))
                                .padding()
                                .cornerRadius(8)
                        }
                    }
                }
        }
        .background(Color("Dark Green"))
        .navigationViewStyle(StackNavigationViewStyle())
    }
}
