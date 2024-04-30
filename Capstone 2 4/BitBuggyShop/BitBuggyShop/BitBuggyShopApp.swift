//
//  BitBuggyShopApp.swift
//  BitBuggyShop
//
//  Created by Emily Combs
//

import SwiftUI

@main
struct BitBuggyShopApp: App {
    @StateObject var cartManager = CartManager()
    @StateObject var orderManager = OrderManager()
    @StateObject var accountManager = AccountManager()
    
    var body: some Scene {
        WindowGroup {
            LoginView()
                .environmentObject(CartManager())
                .environmentObject(OrderManager())
                .environmentObject(AccountManager())
        }
    }
}
