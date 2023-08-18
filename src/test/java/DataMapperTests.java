import data.mappers.CustomerDataClient;
import org.example.Customer;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataMapperTests {

    @Test
    public void verifyThatCustomerWithActiveItemsInCartIsSourcedCorrectly() {
        CustomerDataClient customerDataClient = new CustomerDataClient();
        Customer customerWithActiveItemsInCart = customerDataClient
                .getValidCustomerOfType("customerWithActiveItemsInCart");

        Assert.assertEquals(customerWithActiveItemsInCart.getEmail(), "abc@xyz.com");
        Assert.assertEquals(customerWithActiveItemsInCart.getPassword(), "abc1234");
    }

    @Test
    public void verifyThatCustomerWithSpringSaleCouponIsSourcedCorrectly() {
        CustomerDataClient customerDataClient = new CustomerDataClient();
        Customer customerWithSpringSaleCoupon = customerDataClient
                .getValidCustomerOfType("customerWithSpringSaleCoupon");

        Assert.assertEquals(customerWithSpringSaleCoupon.getEmail(), "def@ijk.com");
        Assert.assertEquals(customerWithSpringSaleCoupon.getPassword(), "def1234");


    }

}
