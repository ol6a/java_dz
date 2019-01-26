package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTest extends TestBase {


  @Test
  public void testContactCreation() {
    Contacts before = app.contact().whole();
    File photo = new File("src/test/resources/kartinka.png");
    ContactData contact = new ContactData().withFirstname("Арина").withLastname("Розина").withAddress("г. Москва, ул. Дружбы, 2-3")
            .withHomePhone("54-67-89").withMobilePhone("89214356789").withWorkPhone("54-45-12")
            .withEmail("rr1@moi-uni.ru").withEmail2("rr2@moi-uni.ru").withEmail3("rr3@moi-uni.ru").withPhoto(photo);
    app.contact().create(contact);
    assertEquals(app.contact().count(),before.size()+1);
    Contacts after = app.contact().whole();
    assertThat(after, equalTo
            (before.withAdded(contact.withId(after.stream().mapToInt((b)->b.getId()).max().getAsInt()))));
  }

}
