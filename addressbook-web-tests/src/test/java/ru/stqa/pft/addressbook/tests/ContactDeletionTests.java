package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactDeletionTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    if (app.contact().whole().size()==0) {
      app.contact().create(new ContactData()
              .withFirstname("Дарина").withLastname("Абрамова").withAddress("г. Москва, ул. Дружбы, 2-3")
                      .withHometelephone("54-67-89").withMobiletelephone("89214356789").withWorktelephone("54-45-12")
                      .withEmail("rr1@moi-uni.ru").withEmail2("rr2@moi-uni.ru").withEmail3("rr3@moi-uni.ru"));
    }
  }

  @Test
  public void testContactDeletion() {
    Set<ContactData> before = app.contact().whole();
    ContactData deletedContact=before.iterator().next();
    app.contact().delete(deletedContact);
    Set <ContactData> after = app.contact().whole();
    Assert.assertEquals(after.size(),before.size()-1);
    before.remove(deletedContact);
    Assert.assertEquals(before,after);


  }




}
