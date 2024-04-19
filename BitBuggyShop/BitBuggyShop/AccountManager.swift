//
//  AccountManager.swift
//  BitBuggyShop
//
//  Created by Emily Combs
//

import Foundation
import Combine

class AccountManager: ObservableObject {
    // Singleton instance
    static let shared = AccountManager()
        
    // Example user data structure
    struct User {
        let username: String
        let password: String
    }
        
    // Array to store registered users (in a real application, you'd use a database)
    @Published private var users: [User] = []
        
    // Function to register a new user
    func register(username: String, password: String) {
        let newUser = User(username: username, password: password)
        users.append(newUser)
    }
        
    // Function to check if a user with given credentials exists
    func login(username: String, password: String) -> Bool {
        return users.contains { $0.username == username && $0.password == password }
    }
        
    // Function to log out user (optional depending on your application)
    func logout() {
        // Implement logout functionality if needed
    }
        
    // Manual trigger for object change notifications
    private var objectWillChangeCancellable: AnyCancellable?
        
    
    init() {
        objectWillChangeCancellable = objectWillChange.sink { [weak self] _ in
            self?.objectWillChange.send()
        }
    }
}

