package com.zerobank.pages;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//button[@class='signin btn btn-info']")
    public WebElement signinButtpn_loc;

    @FindBy(css = "input#user_login")
    public WebElement loginBut_loc;

    @FindBy(css = "#user_password")
    public WebElement password_loc;

    @FindBy(xpath = "//input[@class='btn btn-primary']")
    public WebElement sign_loc;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement warning_loc;




    public void loginUser(){
        String usrNm= ConfigurationReader.get("userName");
        String passWrd=ConfigurationReader.get("passWord");

        loginBut_loc.sendKeys(usrNm);
        password_loc.sendKeys(passWrd);
        sign_loc.click();

    }
    public void loginWithParameters(String nam,String pass){

        loginBut_loc.sendKeys(nam);
        password_loc.sendKeys(pass);
    }

    public String getWarningText(){

        return Driver.get().findElement(By.xpath("//div[@class='alert alert-error']")).getText();
}
    }
