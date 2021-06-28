package parallel;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountPageSteps {
	
	private LoginPage loginPage =  new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;
	private static String expectedAccountsTitle = "My account - My Store"; 

	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) {
	    
		List<Map<String, String>> credList = credTable.asMaps();
		String userName = credList.get(0).get("username");
		String password = credList.get(0).get("password");
		System.out.println("Username is "+userName);
		
		
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountsPage = loginPage.doLogin(userName, password);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
	   String actualAccountsTitle = accountsPage.getAccountsPageTitle();
	   System.out.println("Accounts page titles is "+actualAccountsTitle);
	   Assert.assertTrue(expectedAccountsTitle.equalsIgnoreCase(actualAccountsTitle));
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionsTable) {
	    
		List<String> expectedAccountSectionsList = sectionsTable.asList();
		System.out.println("Expected accounts section list is "+expectedAccountSectionsList);
		
		List<String> actualAccountSectionsList = accountsPage.getAccountsSectionsList();
		System.out.println("Actual accounts section list is "+actualAccountSectionsList);
		
		Assert.assertTrue(expectedAccountSectionsList.containsAll(actualAccountSectionsList));
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionCount) {
	    
		
		Assert.assertTrue(accountsPage.getAccountsSectionCount() == expectedSectionCount);
	}
	 
}
