//
//  TitleBar.swift
//  BitBuggyShop
//
//  Created by Emily Combs on 4/25/24.
//

import SwiftUI

struct TitleBar: View {
    @StateObject var cartManager = CartManager()
    @State private var isLoggedIn = false // Example state for login status
    
    var body: some View {
        HStack {
            Text("BitBuggy")
                .font(.title)
                .foregroundColor(Color("Dark Gold"))
                .padding()
                .frame(maxWidth: .infinity, alignment: .leading) // Center the title
            
            Spacer() // Pushes the buttons to the right
            
            NavigationLink(destination: CartView().environmentObject(cartManager)) {
                CartButton(numberOfProducts: cartManager.products.count)
            }
            
            AccountButton() // Use the AccountButton to navigate to AccountView
        }
        .background(Color("Dark Green")) 
    }
}

struct TitleBar_Previews: PreviewProvider {
    static var previews: some View {
        TitleBar()
    }
}
