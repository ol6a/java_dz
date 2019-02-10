package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    if (app.db().contacts().size()==0) {
      app.contact().create(new ContactData()
              .withFirstname("Дарина").withLastname("Абрамова").withAddress("г. Москва, ул. Дружбы, 2-3")
                      .withHomePhone("54-67-89").withMobilePhone("89214356789").withWorkPhone("54-45-12")
                      .withEmail("rr1@moi-uni.ru").withEmail2("rr2@moi-uni.ru").withEmail3("rr3@moi-uni.ru"));
    }
  }

  @Test
  public void testContactDeletion() {
    Contacts before = app.db().contacts();
    ContactData deletedContact=before.iterator().next();
    app.contact().delete(deletedContact);
    assertEquals(app.contact().count(),before.size()-1);
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(deletedContact)));
  }




}
