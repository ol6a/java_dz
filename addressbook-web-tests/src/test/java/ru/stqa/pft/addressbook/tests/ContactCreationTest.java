package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() {
    Set<ContactData> before = app.contact().whole();
    ContactData contact = new ContactData().withFirstname("Арина").withLastname("Лесина").withAddress("г. Москва, ул. Дружбы, 2-3")
            .withHometelephone("54-67-89").withMobiletelephone("89214356789").withWorktelephone("54-45-12")
            .withEmail("rr1@moi-uni.ru").withEmail2("rr2@moi-uni.ru").withEmail3("rr3@moi-uni.ru");
    app.contact().create(contact);
    Set<ContactData> after = app.contact().whole();
    Assert.assertEquals(after.size(),before.size()+1);
    contact.withId(after.stream().mapToInt((b)->b.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before,after);
  }

}
