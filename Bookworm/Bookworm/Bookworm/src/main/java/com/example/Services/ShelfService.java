package com.example.Services;

import com.example.Repository.MyShelfRepository;
import com.example.models.Product;
import com.example.models.MyShelf;
import com.example.models.User;
import com.example.Repository.ProductRepository;
import com.example.Repository.MyShelfRepository;
import com.example.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ShelfService {

    private final MyShelfRepository shelfRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public ShelfService(MyShelfRepository shelfRepository,
                        UserRepository userRepository,
                        ProductRepository productRepository) {
        this.shelfRepository = shelfRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    // ✅ ADD TO SHELF AFTER TRANSACTION SUCCESS
    public MyShelf addToShelfAfterTransaction(Integer userId, Integer productId, Integer rentDays) {

        // duplicate check
        if (shelfRepository.existsByUser_UserIdAndProduct_ProductId(userId, productId)) {
            throw new RuntimeException("Already exists in shelf");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        MyShelf shelf = new MyShelf();
        shelf.setUser(user);
        shelf.setProduct(product);

        // rentDays => expiry date time set
       

        return shelfRepository.save(shelf);
    }
}
