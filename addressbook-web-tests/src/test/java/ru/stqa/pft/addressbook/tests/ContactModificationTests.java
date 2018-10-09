package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification(){
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("Дарина", "Абрамова",
                "г. Москва, ул. Дружбы, 2-3", "54-67-89", "89214356789",
                "54-45-12", "rr1@moi-uni.ru", "rr2@moi-uni.ru", "rr3@moi-uni.ru"));
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
    }
}
