package d07_메소드_30_0708;

public class Product {
    String name;
    int stock;

    boolean sell( int x ){
        if( stock >= x ){
            stock -= x;

            return true;
        } else {
            System.out.println( "재고부족" );
            return false;
        }
    }

} // class end

