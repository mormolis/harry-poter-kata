import java.util.List;

public class HarryPriceCalculator {

    private final int INITIAL_BOOK_COPIES_IN_BASKET = 0;


    public double getBasketPrice(List<Integer> basket) {
        if(basket.isEmpty()) return 0;

        int[] books = {
                INITIAL_BOOK_COPIES_IN_BASKET,
                INITIAL_BOOK_COPIES_IN_BASKET,
                INITIAL_BOOK_COPIES_IN_BASKET,
                INITIAL_BOOK_COPIES_IN_BASKET,
                INITIAL_BOOK_COPIES_IN_BASKET
        };

        for(int book:basket){
            if (book <= 5 && book >=1){
                books[book - 1] +=1;
            }
        }

        double subTotal = 0;
        double totalPrice = 0;
        int bookCounter = 0;

        while(!isAllPriced(books)){
            for (int i = 0; i < 5; i++){
                if(books[i] > 0){
                    subTotal+=8;
                    bookCounter++;
                    books[i] -= 1;
                }
            }
            totalPrice += subTotal - subTotal*getDiscount(bookCounter);
            subTotal = 0;
            bookCounter = 0;
        }
        return totalPrice;
    }

    private double getDiscount(int bookCounter){
        switch (bookCounter){
            case 2:
                return .05;
            case 3:
                return .10;
            case 4:
                return .20;
            case 5:
                return .25;
            default:
                return 0;
        }
    }

    private boolean isAllPriced(int[] books){
        for(int book:books){
            if(book != 0) return false;
        }
        return true;
    }
}
