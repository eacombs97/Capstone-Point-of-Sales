//
//  BitBuggyShopApp.swift
//  BitBuggyShop
//
//  Created by Emily Combs on 4/4/24.
//

import SwiftUI

@main
struct BitBuggyShopApp: App {
    @StateObject var cartManager = CartManager()
    @State var orderManager = OrderManager()
    @StateObject var viewModel = AuthViewModel()
    
    var body: some Scene {
        WindowGroup {
            ContentView()// Provide CartManager to ContentView
                .environmentObject(viewModel)
        }
    }
}
