package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactToGroup extends TestBase {


    @BeforeMethod
    public void ensurePreconditions(){
        if (app.db().contacts().size()==0) {
            app.contact().create(new ContactData()
                    .withFirstname("Арина").withLastname("Лесина").withAddress("г. Москва, ул. Дружбы, 2-3")
                    .withHomePhone("54-67-89").withMobilePhone("89214356789").withWorkPhone("54-45-12")
                    .withEmail("rr1@moi-uni.ru").withEmail2("rr2@moi-uni.ru").withEmail3("rr3@moi-uni.ru"));
        }
        if (app.db().groups().size()==0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1").withHeader("test2").withFooter("test3"));
        }
    }
    @Test
    public void testAddContactToGroup() {
        Groups groups = app.db().groups();
        app.contact().getContactNoGroup();
        Contacts contactsNoGroup = app.contact().whole();
        if(contactsNoGroup.size()==0){
            app.contact().create(new ContactData()
                    .withFirstname("Арина").withLastname("Лесина").withAddress("г. Москва, ул. Дружбы, 2-3"));
        }
        ContactData selectedContact = contactsNoGroup.iterator().next();
        int contId=selectedContact.getId();
        GroupData selectedGroup = groups.iterator().next();
        int groupId= selectedGroup.getId();
        Contacts contacts1= selectedGroup.getContacts();
        app.contact().addToGroup(contId, groupId);
        Contacts contacts2= selectedGroup.getContacts();
        assertThat(contacts2, equalTo
                (contacts1.withAdded(selectedContact)));
        }

}

