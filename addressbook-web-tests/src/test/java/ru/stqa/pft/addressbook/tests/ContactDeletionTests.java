package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {



  @Test
  public void testContactDeletion() throws Exception {
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Дарина", "Абрамова", "г. Москва, ул. Дружбы, 2-3", "54-67-89", "89214356789", "54-45-12", "rr1@moi-uni.ru", "rr2@moi-uni.ru", "rr3@moi-uni.ru"));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().wd.switchTo().alert().accept();

  }


}
