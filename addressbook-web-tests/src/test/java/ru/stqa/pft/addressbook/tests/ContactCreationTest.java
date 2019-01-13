package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() {
    Contacts before = app.contact().whole();
    ContactData contact = new ContactData().withFirstname("Арина").withLastname("Лесина").withAddress("г. Москва, ул. Дружбы, 2-3")
            .withHometelephone("54-67-89").withMobiletelephone("89214356789").withWorktelephone("54-45-12")
            .withEmail("rr1@moi-uni.ru").withEmail2("rr2@moi-uni.ru").withEmail3("rr3@moi-uni.ru");
    app.contact().create(contact);
    Contacts after = app.contact().whole();
    assertEquals(after.size(),before.size()+1);
    assertThat(after, equalTo
            (before.withAdded(contact.withId(after.stream().mapToInt((b)->b.getId()).max().getAsInt()))));
  }

}
