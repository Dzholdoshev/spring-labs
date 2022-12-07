package com.cydeo.lab07ormqueries;

import com.cydeo.lab07ormqueries.entity.Category;
import com.cydeo.lab07ormqueries.enums.CartState;
import com.cydeo.lab07ormqueries.enums.DiscountType;
import com.cydeo.lab07ormqueries.enums.PaymentMethod;
import com.cydeo.lab07ormqueries.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class QueryDemo implements CommandLineRunner {

    private final AddressRepository addressRepository;
    private final BalanceRepository balanceRepository;
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private final CustomerRepository customerRepository;
    private final DiscountRepository discountRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public QueryDemo(AddressRepository addressRepository, BalanceRepository balanceRepository, CartItemRepository cartItemRepository, CartRepository cartRepository, CustomerRepository customerRepository, DiscountRepository discountRepository, OrderRepository orderRepository, ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.addressRepository = addressRepository;
        this.balanceRepository = balanceRepository;
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
        this.discountRepository = discountRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        /**______________AddressRepository________________*/
//        System.out.println("1. getAddressByCustomer_Id: " + addressRepository.getAddressByCustomer_Id(1L));
//        System.out.println("2. getAddressByStreet: " + addressRepository.getAddressByStreet("Pond"));
//        System.out.println("3. getTop3ByCustomer_Email: " + addressRepository.getTop3ByCustomer_Email("mbullivant3@behance.net"));
//        System.out.println("4. getAllByCustomer_LastName: " + addressRepository.getAllByCustomer_LastName("Bullivant"));
//        System.out.println("5. getAllByStreetStartingWith: " + addressRepository.getAllByStreetStartingWith("Pon"));
//        System.out.println("6. retrieveAllByCustomer_Id: " + addressRepository.retrieveAllByCustomer_Id(1L));
//        /**______________BalanceRepository________________*/
//        System.out.println("1. existsByCustomer_Id : " + balanceRepository.existsByCustomer_Id(1L));
//        System.out.println("2. getBalanceByCustomer_Id : " + balanceRepository.getBalanceByCustomer_Id(1L));
//        System.out.println("3. retrieveTop5maxBalance : " + balanceRepository.retrieveTop5MaxBalance());
//        System.out.println("4. getBalanceByAmountGreaterThanEqual: " + balanceRepository.getBalanceByAmountGreaterThanEqual(9700.00));
//        System.out.println("5. retrieveBalanceLessThan: " + balanceRepository.retrieveBalanceLessThan(10.00));
//        /**______________CartItemRepository________________*/
//        System.out.println("1. countByCart :" + cartItemRepository.countByIdIsNotNull());
//        System.out.println("2. getCartItemByCart_CartState:" + cartItemRepository.getCartItemByCart_CartState(CartState.SOLD));
//        System.out.println("3. retrieveCartsByCartStateAndProduct :" + cartItemRepository.retrieveCartsByCartStateAndProduct("Tomatoes", "CREATED"));
//        System.out.println("4. retrieveByStateAndDiscountNull :"+cartItemRepository.retrieveByStateAndDiscountNull("SOLD"));
//        System.out.println("5. retrieveByStateAndDiscount :"+cartItemRepository.retrieveByStateAndDiscount("SOLD","RATE_BASED"));
//        /**______________CartRepository____________________*/
//        System.out.println("1. getAllByDiscount: "+cartRepository.getAllByDiscount_Id(2L));
//        System.out.println("2. retrieveAllByCustomerId: "+cartRepository.retrieveAllByCustomerId(25L));
//        System.out.println("3. getAllByCustomer_IdAndCartState: "+cartRepository.getAllByCustomer_IdAndCartState(5L,CartState.SOLD));
//        System.out.println("4. getAllByCustomer_IdAndCartStateAndDiscountIsNull: "+cartRepository.getAllByCustomer_IdAndCartStateAndDiscount_IdIsNull( 25L,CartState.SOLD));
//        System.out.println("5. retrieveAllByCustomer_IdAndCartStateAndDiscountIsNotNull: "+cartRepository.retrieveAllByCustomer_IdAndCartStateAndDiscountIsNotNull(1L,"SOLD"));
//        /**______________CustomerRepository________________*/
//        System.out.println("1. getAllById: "+customerRepository.getAllById(6L));
//        System.out.println("2. retrieveAllByEmail: "+customerRepository.retrieveAllByEmail("bmaccaughey2@wufoo.com"));
//        /**______________DiscountRepository________________*/
//        System.out.println("1. findAllByName: "+discountRepository.findAllByName("50 dollar"));
//        System.out.println("2. findAllByDiscountGreaterThan: "+discountRepository.findAllByDiscountGreaterThan(30.00));
//        System.out.println("3. findAllByDiscountType: "+discountRepository.findAllByDiscountType(DiscountType.AMOUNT_BASED));
//        System.out.println("4.retrieveAllByBetweenAmountRange: "+discountRepository.retrieveAllByBetweenAmountRange(20.00,30.00));
        /**______________OrderRepository___________________*/
//        System.out.println("1. findTop5ByOrderByTotalPrice: "+orderRepository.findTop5ByOrderByTotalPrice());
//        System.out.println("2. getAllByCustomer_Email: "+orderRepository.getAllByCustomer_Email("bmaccaughey2@wufoo.com"));
//        System.out.println("3. getAllByPayment_Method: "+orderRepository.getAllByPayment_PaymentMethod(PaymentMethod.BUY_NOW_PAY_LATER));
//        System.out.println("4. getAllByPayment_Id: "+orderRepository.getAllByPayment_Id(1L));
//        System.out.println("5. getAllByCustomer_EmailContains: "+orderRepository.getAllByCustomer_EmailContains("bmaccaughey2@wufoo.com"));
//        System.out.println("6. existsByCustomer_Email: "+orderRepository.existsByCustomer_Email("bmaccaughey2@wufoo.com"));
//        System.out.println("7.retrieveAllByNameContains : "+orderRepository.retrieveAllByNameContains("Catfish - Fillets"));
  //      System.out.println("8.retrieveAllByCategoryId : "+orderRepository.retrieveAllByCategoryId(4L));
        System.out.println("9. getAllByTotalPriceAndPaidPriceEquals(): "+orderRepository.getAllByTotalPriceAndPaidPriceEquals(10.00, 10.00));
   //     System.out.println("10. "+orderRepository.);
//        /**______________ProductRepository________________*/
        System.out.println("1.getTop3ByPriceOrderByPrice() : "+productRepository.getTop3ByPriceOrderByPrice());
        System.out.println("2.getProductByName() : "+productRepository.getProductByName());
        System.out.println("3.getProductByCategoryListContaining : "+productRepository.getProductByCategoryListContaining(new Category()));
        System.out.println("4.countProductByPriceGreaterThan : "+productRepository.countProductByPriceGreaterThan(BigDecimal.ZERO));
        System.out.println("5.findAllByQuantityIsGreaterThanEqual : "+productRepository.findAllByQuantityIsGreaterThanEqual(20));
        System.out.println("6.retrieveProductListGreaterThanPriceAndLowerThanRemainingQuantity : "+productRepository.retrieveProductListGreaterThanPriceAndLowerThanRemainingQuantity(BigDecimal.TEN,10));
        System.out.println("7.retrieveProductListByCategory : "+productRepository.retrieveProductListByCategory(100L));
        System.out.println("8.retrieveProductListByCategory : "+productRepository.retrieveProductListByCategory(List.of(20L,30L),BigDecimal.TEN));
//        /**______________CategoryRepository________________*/
//        System.out.println("1. getCategoryByName: "+categoryRepository.getCategoryByName("Site Furnishings"));
//        System.out.println("2. getTop3ByOOrderByNameDesc: "+categoryRepository.getTop3ByOOrderByNameDesc());


    }
}
