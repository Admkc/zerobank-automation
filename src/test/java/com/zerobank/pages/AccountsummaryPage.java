package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountsummaryPage extends BasePage{

    @FindBy(xpath = "//h2[@class='board-header']")
    public List<WebElement> accountOptions_loc;

    @FindBy(xpath = "(//table)[3]//th")
    public List<WebElement> creditAccountColumns_loc;


    public String  getAccountOptions(String tab){

        String accountTab="//h2[@class='"+tab+"']";

        WebElement tabs= Driver.get().findElement(By.xpath(accountTab));

        String actTitle=tabs.getText();

        return actTitle;
    }

    public List<String >  getAccountOptions2(){

        List<String >  account= BrowserUtils.getElementsText(accountOptions_loc);

        return account;


    }



}
