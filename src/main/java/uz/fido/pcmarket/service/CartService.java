package uz.fido.pcmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.fido.pcmarket.entity.Cart;
import uz.fido.pcmarket.entity.User;
import uz.fido.pcmarket.payload.ApiResponce;
import uz.fido.pcmarket.payload.CartDto;
import uz.fido.pcmarket.repository.CartRepository;
import uz.fido.pcmarket.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    UserRepository userRepository;

    public ApiResponce addCart(CartDto cartDto) {
        Cart cart = new Cart();
        Optional<User> optionalUser = userRepository.findById(cartDto.getUser_id());
        if (!optionalUser.isPresent())
            return new ApiResponce("bunday user topilmadi", false);
        User user = optionalUser.get();
        cart.setUser(user);
        Cart save = cartRepository.save(cart);
        return new ApiResponce("cart qo'shildi", true, save);

    }

    public ApiResponce getOneCart(Long id) {
        Optional<Cart> optionalCart = cartRepository.findById(id);
        if (!optionalCart.isPresent())
            return new ApiResponce("Bunday cart topilmaid", false);

        Cart cart = optionalCart.get();
        return new ApiResponce("cart topildi", true, cart);
    }

    public ApiResponce getAllCart() {
        List<Cart> carts = cartRepository.findAll();
        return new ApiResponce("Cart list topildi", true, carts);
    }

    public ApiResponce updateCart(Long id, CartDto cartDto) {
        Optional<Cart> optionalCart = cartRepository.findById(id);
        if (!optionalCart.isPresent())
            return new ApiResponce("Bunday cart topilmaid", false);

        Cart cart = optionalCart.get();
        Optional<User> optionalUser = userRepository.findById(cartDto.getUser_id());
        if (!optionalUser.isPresent())
            return new ApiResponce("bunday user topilmadi", false);
        User user = optionalUser.get();
        cart.setUser(user);
        Cart save = cartRepository.save(cart);
        return new ApiResponce("cart update qilindi", true, save);
    }


    public ApiResponce deleteCart(Long id) {
        cartRepository.deleteById(id);
        return new ApiResponce("cart deleted", true);
    }

}
