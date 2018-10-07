package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() throws Exception {

    app.initContactCreation();
    app.fillContactForm(new ContactData("Дарина", "Абрамова", "г. Москва, ул. Дружбы, 2-3", "54-67-89", "89214356789", "54-45-12", "rr1@moi-uni.ru", "rr2@moi-uni.ru", "rr3@moi-uni.ru"));
    app.submitContactCreation();
    app.returnToHomePage();

  }


}
