package uz.fido.pcmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.fido.pcmarket.entity.Cart;
import uz.fido.pcmarket.entity.CartItem;
import uz.fido.pcmarket.entity.Product;
import uz.fido.pcmarket.payload.ApiResponce;
import uz.fido.pcmarket.payload.CartItemDto;
import uz.fido.pcmarket.repository.CartItemRepository;
import uz.fido.pcmarket.repository.CartRepository;
import uz.fido.pcmarket.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemService {
    @Autowired
    CartItemRepository cartItemRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CartRepository cartRepository;

    public ApiResponce addCartItem(CartItemDto cartItemDto) {
        CartItem cartItem = new CartItem();
        cartItem.setQuantity(cartItemDto.getQuantity());
        Optional<Product> optionalProduct = productRepository.findById(cartItemDto.getProduct_id());
        if (!optionalProduct.isPresent())
            return new ApiResponce("Bunday product topilmadi", false);

        Optional<Cart> optionalCart = cartRepository.findById(cartItemDto.getCart_id());
        if (!optionalCart.isPresent())
            return new ApiResponce("Bunday cart topilmadi", false);

        cartItem.setProduct(optionalProduct.get());
        cartItem.setCart(optionalCart.get());
        CartItem save = cartItemRepository.save(cartItem);
        return new ApiResponce("Added cartItem", true, save);

    }

    public ApiResponce getOneCartItem(Long id) {
        Optional<CartItem> optionalCartItem = cartItemRepository.findById(id);
        if (!optionalCartItem.isPresent())
            return new ApiResponce("Bunday cartItem topilmadi", false);
        CartItem cartItem = optionalCartItem.get();
        return new ApiResponce("CartItem topildi", true, cartItem);
    }

    public ApiResponce getAllCartItem() {
        List<CartItem> cartItems = cartItemRepository.findAll();
        return new ApiResponce("CartItems topildi", true, cartItems);
    }

    public ApiResponce updateCartItem(Long id, CartItemDto cartItemDto) {
        Optional<CartItem> optionalCartItem = cartItemRepository.findById(id);
        if (!optionalCartItem.isPresent())
            return new ApiResponce("Bunday cartItem topilmadi", false);
        CartItem cartItem = optionalCartItem.get();

        cartItem.setQuantity(cartItemDto.getQuantity());
        Optional<Product> optionalProduct = productRepository.findById(cartItemDto.getProduct_id());
        if (!optionalProduct.isPresent())
            return new ApiResponce("Bunday product topilmadi", false);

        Optional<Cart> optionalCart = cartRepository.findById(cartItemDto.getCart_id());
        if (!optionalCart.isPresent())
            return new ApiResponce("Bunday cart topilmadi", false);

        cartItem.setProduct(optionalProduct.get());
        cartItem.setCart(optionalCart.get());
        CartItem save = cartItemRepository.save(cartItem);
        return new ApiResponce("Added cartItem", true, save);
    }

    public ApiResponce deleteCartItem(Long id) {
        cartItemRepository.deleteById(id);
        return new ApiResponce("deleted cartItem", true);
    }
}
