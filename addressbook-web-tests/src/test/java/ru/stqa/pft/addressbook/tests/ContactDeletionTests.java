package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    if (app.contact().scroll().size()==0) {
      app.contact().create(new ContactData()
              .withFirstname("Дарина").withLastname("Абрамова").withAddress("г. Москва, ул. Дружбы, 2-3")
                      .withHometelephone("54-67-89").withMobiletelephone("89214356789").withWorktelephone("54-45-12")
                      .withEmail("rr1@moi-uni.ru").withEmail2("rr2@moi-uni.ru").withEmail3("rr3@moi-uni.ru"));
    }
  }

  @Test
  public void testContactDeletion() {
    List<ContactData> before = app.contact().scroll();
    int index = before.size()-1;
    app.contact().delete(index);
    List <ContactData> after = app.contact().scroll();
    Assert.assertEquals(after.size(),before.size()-1);
    before.remove(index);
    Assert.assertEquals(before,after);


  }




}
