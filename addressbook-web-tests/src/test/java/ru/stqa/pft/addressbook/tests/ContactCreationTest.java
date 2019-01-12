package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() {
    List<ContactData> before = app.contact().scroll();
    ContactData contact = new ContactData().withFirstname("Арина").withLastname("Лесина").withAddress("г. Москва, ул. Дружбы, 2-3")
            .withHometelephone("54-67-89").withMobiletelephone("89214356789").withWorktelephone("54-45-12")
            .withEmail("rr1@moi-uni.ru").withEmail2("rr2@moi-uni.ru").withEmail3("rr3@moi-uni.ru");
    app.contact().create(contact);
    List<ContactData> after = app.contact().scroll();
    Assert.assertEquals(after.size(),before.size()+1);
    before.add(contact);

    Comparator<? super ContactData> byId = (k1, k2) -> Integer.compare(k1.getId(), k2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }

}
