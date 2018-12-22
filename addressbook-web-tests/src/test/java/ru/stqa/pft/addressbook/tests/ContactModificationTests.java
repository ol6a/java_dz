package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification(){
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Дарина", "Абрамова", "г. Москва, ул. Дружбы, 2-3", "54-67-89", "89214356789", "54-45-12", "rr1@moi-uni.ru", "rr2@moi-uni.ru", "rr3@moi-uni.ru"));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(0);
        app.getContactHelper().initContactModification();
        ContactData contact = new ContactData(before.get(0).getId(), "Елена", "Розова",
                "г. Москва, ул. Дружбы, 2-3", "54-67-89", "89214356789",
                "54-45-12", "rr1@moi-uni.ru", "rr2@moi-uni.ru", "rr3@moi-uni.ru");
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size());
        before.remove(0);
        before.add(contact);
        Comparator<? super ContactData> byId=(k1, k2)->Integer.compare(k1.getId(),k2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }
}
