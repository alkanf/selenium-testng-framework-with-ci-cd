package utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
@DataProvider(name = "validLoginData")
public Object[][] getValidLoginData() {
return new Object[][] { //two dimensional array as login and password
	{"standard_user", "secret_sauce"},
	{"problem_user", "secret_sauce"},
	{"performance_glitch_user", "secret_sauce"},
	{"error_user", "secret_sauce"},
	{"visual_user", "secret_sauce"},
};
}


@DataProvider(name = "invalidLoginData")
public Object[][] getInvalidLoginData() {
    return new Object[][] {
        {"invalid_user", "secret_sauce"},
        {"standard_user", "wrong_password"},
        {"00", "00005"}
    };
}
}
	
	
	
	
	
	
	
	
	
	
	
	
	

