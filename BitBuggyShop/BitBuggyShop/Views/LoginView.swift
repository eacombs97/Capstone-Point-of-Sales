//
//  LoginView.swift
//  BitBuggyShop
//
//  Created by Emily Combs
//

import SwiftUI

struct LoginView: View {
    @State private var username: String = ""
    @State private var password: String = ""
    @State private var isLoggedIn: Bool = false // You can replace this with your own logic for authentication
    
    var body: some View {
        VStack {
            Image(systemName: "person.circle")
                .resizable()
                .aspectRatio(contentMode: .fit)
                .frame(width: 100, height: 100)
                .padding(.bottom, 30)
            
            TextField("Username", text: $username)
                .padding()
                .background(Color(UIColor.systemGray6))
                .cornerRadius(8)
                .padding(.bottom, 20)
            
            SecureField("Password", text: $password)
                .padding()
                .background(Color(UIColor.systemGray6))
                .cornerRadius(8)
                .padding(.bottom, 20)
            
            Button(action: {
                // Here you can implement your authentication logic
                // For demonstration, I'm just checking if both fields are filled
                if !username.isEmpty && !password.isEmpty {
                    isLoggedIn = true
                }
            }) {
                Text("Login")
                    .foregroundColor(.white)
                    .padding()
                    .frame(maxWidth: .infinity)
                    .background(Color.blue)
                    .cornerRadius(8)
            }
            .padding(.horizontal, 20)
            
            Spacer()
        }
        .padding()
        .navigationTitle("Login")
        .alert(isPresented: $isLoggedIn) {
            Alert(title: Text("Success"), message: Text("You are logged in!"), dismissButton: .default(Text("OK")))
        }
    }
}

struct LoginView_Previews: PreviewProvider {
    static var previews: some View {
        LoginView()
    }
}
