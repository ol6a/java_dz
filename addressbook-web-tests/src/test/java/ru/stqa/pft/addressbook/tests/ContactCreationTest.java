package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() {
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("Арина", "Лесина", "г. Москва, ул. Дружбы, 2-3", "54-67-89", "89214356789", "54-45-12", "rr1@moi-uni.ru", "rr2@moi-uni.ru", "rr3@moi-uni.ru");
    app.getContactHelper().createContact(contact);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(),before.size()+1);
    before.add(contact);

    Comparator<? super ContactData> byId = (k1, k2) -> Integer.compare(k1.getId(), k2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }

}
