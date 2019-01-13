package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        if (app.contact().whole().size()==0) {
            app.contact().create(new ContactData()
                    .withFirstname("Арина").withLastname("Лесина").withAddress("г. Москва, ул. Дружбы, 2-3")
                    .withHometelephone("54-67-89").withMobiletelephone("89214356789").withWorktelephone("54-45-12")
                    .withEmail("rr1@moi-uni.ru").withEmail2("rr2@moi-uni.ru").withEmail3("rr3@moi-uni.ru"));
        }
    }

    @Test
    public void testContactModification(){
        Contacts before = app.contact().whole();
        ContactData modifiedContact=before.iterator().next();
        ContactData contact = new ContactData().
                withId(modifiedContact.getId()).
                withFirstname("Арина").withLastname("Лесина").withAddress("г. Москва, ул. Дружбы, 2-3")
                .withHometelephone("54-67-89").withMobiletelephone("89214356789").withWorktelephone("54-45-12")
                .withEmail("rr1@moi-uni.ru").withEmail2("rr2@moi-uni.ru").withEmail3("rr3@moi-uni.ru");
        app.contact().modify(contact);
        Contacts after = app.contact().whole();
        assertEquals(after.size(),before.size());
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

    }


}
