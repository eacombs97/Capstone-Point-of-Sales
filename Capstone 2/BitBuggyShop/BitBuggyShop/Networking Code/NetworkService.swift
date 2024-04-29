//
//  NetworkService.swift
//  BitBuggyShop
//
//  Created by Emily Combs
//

import Foundation

class NetworkService {
    func fetchProducts(completion: @escaping ([Product]) -> Void) {
        guard let url = URL(string: "http://localhost:8080/api/items") else {
            completion([])
            return
        }
        
        URLSession.shared.dataTask(with: url) { data, _, error in
            guard let data = data else {
                completion([])
                return
            }
            
            do {
                let decoder = JSONDecoder()
                let products = try decoder.decode([Product].self, from: data)
                completion(products)
            } catch {
                print("Error decoding JSON: \(error)")
                completion([])
            }
        }.resume()
    }
}
